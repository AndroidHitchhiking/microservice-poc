package microservice.concept.io.product.repository;

import microservice.concept.io.product.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findByProductName(String productName);
}
