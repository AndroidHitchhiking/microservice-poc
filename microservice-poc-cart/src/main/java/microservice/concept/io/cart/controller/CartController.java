package microservice.concept.io.cart.controller;

import microservice.concept.io.cart.document.Cart;
import microservice.concept.io.cart.document.Selection;
import microservice.concept.io.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    private List<Cart> getAllCart() {
        return cartService.getAllCart();
    }

    @GetMapping("/id/{id}")
    private Cart getCartById(@PathVariable String id) {
        return cartService.getCartById(id);
    }

    @GetMapping("/user/{userId}")
    private Cart getCartByUserId(@PathVariable String userId) {
        return cartService.getCartByUser(userId);
    }

    @PostMapping("/add-to-cart/{userId}")
    private Cart addToCart(@PathVariable String userId, @RequestBody List<Selection> products) {
        return cartService.addProductsInUserCart(userId, products);
    }

    @PutMapping("/update-cart/{userId}")
    private Cart updateCart(@PathVariable String userId, @RequestBody List<Selection> products) {
        return cartService.updateCart(userId, products);
    }

    @DeleteMapping("/delete-cart/{userId}")
    private String deleteCartSelection(@PathVariable String userId, @RequestBody List<Selection> products) {
        return cartService.deleteProductFromCart(userId, products);
    }

}
