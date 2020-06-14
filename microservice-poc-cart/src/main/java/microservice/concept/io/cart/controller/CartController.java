package microservice.concept.io.cart.controller;

import microservice.concept.io.cart.document.Cart;
import microservice.concept.io.cart.document.Selection;
import microservice.concept.io.cart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);


    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    private List<Cart> getAllCart() {
        LOGGER.info("CartController getAllCart");
        return cartService.getAllCart();
    }

    @GetMapping("/id/{id}")
    private Cart getCartById(@PathVariable String id) {
        LOGGER.info("CartController getCartById for id: "+id);
        return cartService.getCartById(id);
    }

    @GetMapping("/user/{userId}")
    private Cart getCartByUserId(@PathVariable String userId) {
        LOGGER.info("CartController getCartByUserId for userId: "+userId);
        return cartService.getCartByUser(userId);
    }

    @PostMapping("/add-to-cart/{userId}")
    private Cart addToCart(@PathVariable String userId, @RequestBody List<Selection> products) {
        LOGGER.info("CartController addToCart for userId: "+userId+" with products: " + products.toString());
        return cartService.addProductsInUserCart(userId, products);
    }

    @PutMapping("/update-cart/{userId}")
    private Cart updateCart(@PathVariable String userId, @RequestBody List<Selection> products) {
        LOGGER.info("CartController updateCart for userId: "+userId+" with products: " + products.toString());
        return cartService.updateCart(userId, products);
    }

    @DeleteMapping("/delete-cart/{userId}")
    private String deleteCartSelection(@PathVariable String userId, @RequestBody List<Selection> products) {
        LOGGER.info("CartController deleteCartSelection for userId: "+userId+" with products: " + products.toString());
        return cartService.deleteProductFromCart(userId, products);
    }

}
