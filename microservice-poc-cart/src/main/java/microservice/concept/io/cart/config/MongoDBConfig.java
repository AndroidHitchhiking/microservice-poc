package microservice.concept.io.cart.config;

import microservice.concept.io.cart.repository.CartRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {CartRepository.class})
@Configuration
public class MongoDBConfig {

}
