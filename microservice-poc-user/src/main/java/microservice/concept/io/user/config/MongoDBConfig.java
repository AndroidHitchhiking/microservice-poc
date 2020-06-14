package microservice.concept.io.user.config;

import microservice.concept.io.user.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {UserRepository.class})
@Configuration
public class MongoDBConfig {

}
