package microservice.concept.io.product.controller;

import microservice.concept.io.product.document.Product;
import microservice.concept.io.product.model.ProductListResponse;
import microservice.concept.io.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private List<Product> getAllProducts() {
        LOGGER.info("ProductController getAllProducts");
        return productService.getAllProduct();
    }

    @GetMapping("/name/{productName}")
    private Product getProductByName(@PathVariable String productName) {
        LOGGER.info("ProductController getProductByName productName = " + productName);
        return productService.getProductByName(productName);
    }

    @GetMapping("/id/{id}")
    private Product getProductById(@PathVariable String id) {
        LOGGER.info("ProductController getProductById id = " + id);
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    private Product addNewProduct(@RequestBody Product product) {
        LOGGER.info("ProductController addNewProduct request = " + product.toString());
        return productService.addNewProduct(product);
    }

    @PutMapping("/update")
    private Product updateProduct(@RequestBody Product product) {
        LOGGER.info("ProductController updateProduct request = " + product.toString());
        return productService.updateProduct(product);
    }


    @DeleteMapping("/{id}")
    private String deleteProductById(@PathVariable String id) {
        LOGGER.info("ProductController deleteProductById id = " + id);
        productService.deleteProduct(id);
        return "Product " + id + " deleted successfully";
    }

    @PostMapping("/product-info")
    private ProductListResponse getProductsInfo(@RequestBody List<String> productIds) {
        return productService.getProductByProductIdList(productIds);
    }
}
