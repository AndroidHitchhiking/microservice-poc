package microservice.concept.io.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicePocCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePocCartApplication.class, args);
	}

}
