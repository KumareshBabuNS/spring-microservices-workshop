package info.novatec.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@EnableZuulServer
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayLabApplication.class, args);
	}
}
