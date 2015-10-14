package info.novatec.server;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.actuate.system.EmbeddedServerPortFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.novatec.server.person.entity.Person;
import info.novatec.server.person.repository.PersonRepository;

@EnableDiscoveryClient
@RestController
@EnableJpaRepositories
@SpringBootApplication
public class PersonServerLabApplication {

    public static void main(String[] args) {
    	SpringApplication springApplication = new SpringApplication(PersonServerLabApplication.class);
    	springApplication.addListeners(new ApplicationPidFileWriter(), new EmbeddedServerPortFileWriter());
    	springApplication.run(args);
    }
    
    @Bean
    CommandLineRunner runner(PersonRepository rr) {
        return args -> {
                Arrays.asList(new Person("Hans", "Mustermann", new Date()),new Person("Hubert", "Maier", new Date()))
                        .forEach(p -> rr.save(p));
        };
    }
    
    @RequestMapping("/")
    public String home() {
        return "Person Server";
    }
	
}
