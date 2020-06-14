package microservice.concept.io.product.service;

import microservice.concept.io.product.document.Product;
import microservice.concept.io.product.model.ProductListResponse;
import microservice.concept.io.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

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
        LOGGER.info("Product Service getProductByName productInfo db result = " + productInfo.toString());
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
        LOGGER.info("Product Service getProductById productInfo db result = " + productInfo.toString());
        return productInfo.orElseGet(Product::new);
    }

    public ProductListResponse getProductByProductIdList(List<String> productIdList) {
        ProductListResponse response = new ProductListResponse();
        Optional<List<Product>> productInfo = productRepository.findByIdIn(productIdList);
        LOGGER.info("Product Service getProductByProductIdList productInfo db result = " + productInfo.toString());
        productInfo.ifPresent(response::setProducts);
        return response;
    }
}
