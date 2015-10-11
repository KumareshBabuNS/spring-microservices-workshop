package info.novatec.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class PersonClientController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@LoadBalanced
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		StringBuilder stringBuilder = new StringBuilder();
		List<ServiceInstance> instances = discoveryClient.getInstances("PERSON-SERVICE");
		instances.stream().forEach((si) -> { stringBuilder.append(si.getHost() + ":" + si.getPort() + "//" + si.getServiceId() + "\n");} );
		
		String result = stringBuilder.toString();
		if (StringUtils.isNotBlank(result)) {
			return result;
		} else {
			return "No person services available";
		}
	}
	
	@RequestMapping(value="/personen", method=RequestMethod.GET)
	@ResponseBody
	@HystrixCommand(fallbackMethod = "getPersonenFallback")
	public Collection<Person> personen() {
		
		
		ParameterizedTypeReference<Resources<Person>> ptr =
                new ParameterizedTypeReference<Resources<Person>>() {
                };

        ResponseEntity<Resources<Person>> responseEntity =
                this.restTemplate.exchange("http://person-service/persons",
                        HttpMethod.GET, null, ptr);
				 
		 return responseEntity
				 .getBody()
				 .getContent()
				 .stream()	                
	                .collect(Collectors.toList());
		
	}
	
	public List<Person> getPersonenFallback() {
		return new ArrayList<>();
	}
	
	public static class Person {
		private String firstName;
		private String lastName;
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
	}

}
