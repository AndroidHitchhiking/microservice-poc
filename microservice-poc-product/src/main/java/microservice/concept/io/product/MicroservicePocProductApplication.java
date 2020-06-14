package microservice.concept.io.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicePocProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePocProductApplication.class, args);
	}

}
