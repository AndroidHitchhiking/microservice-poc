package microservice.concept.io.product.config;

import microservice.concept.io.product.repository.ProductRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {ProductRepository.class})
@Configuration
public class MongoDBConfig {

}
