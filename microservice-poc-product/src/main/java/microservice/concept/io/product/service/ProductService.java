package microservice.concept.io.product.service;

import microservice.concept.io.product.document.Product;
import microservice.concept.io.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addNewProduct(Product product) {
        return productRepository.insert(product);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductByName(String productName) {
        Optional<Product> productInfo = productRepository.findByProductName(productName);
        return productInfo.orElseGet(Product::new);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(String id) {
        Optional<Product> productInfo = productRepository.findById(id);
        return productInfo.orElseGet(Product::new);
    }
}
