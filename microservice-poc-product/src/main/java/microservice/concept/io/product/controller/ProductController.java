package microservice.concept.io.product.controller;

import microservice.concept.io.product.document.Product;
import microservice.concept.io.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/name/{productName}")
    private Product getProductByName(@PathVariable String productName) {
        return productService.getProductByName(productName);
    }

    @GetMapping("/id/{id}")
    private Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    private Product addNewUser(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @PutMapping("/update")
    private Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }


    @DeleteMapping("/{id}")
    private String deleteUser(@PathVariable String id) {
        productService.deleteProduct(id);
        return "Product " + id + " deleted successfully";
    }
}
