package microservice.concept.io.cart.service;

import microservice.concept.io.cart.document.Cart;
import microservice.concept.io.cart.document.Selection;
import microservice.concept.io.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    public Cart getCartById(String id) {
        Optional<Cart> cartInfo = cartRepository.findById(id);
        return cartInfo.orElseGet(Cart::new);
    }

    public Cart getCartByUser(String userId) {
        Optional<Cart> cartInfo = cartRepository.findByUserId(userId);
        return cartInfo.orElseGet(Cart::new);
    }

    public Cart addProductsInUserCart(String userId, List<Selection> productId) {
        Optional<Cart> userCart = cartRepository.findByUserId(userId);
        if (userCart.isPresent()) {
            Cart userCartInfo = userCart.get();
            List<Selection> selectedProducts = new ArrayList<>();
            if (userCartInfo.getSelectedProduct() != null && userCartInfo.getSelectedProduct().size() > 0) {
                selectedProducts.addAll(userCartInfo.getSelectedProduct());
            }
            selectedProducts.addAll(productId);
            userCartInfo.setSelectedProduct(selectedProducts);

            return cartRepository.save(userCartInfo);
        }
        return new Cart();
    }

    public Cart updateCart(String userId, List<Selection> selectedProducts) {
        Optional<Cart> userCart = cartRepository.findByUserId(userId);
        Cart selection = userCart.get();
        selection.setSelectedProduct(selectedProducts);
        return cartRepository.save(selection);
    }

    public String deleteProductFromCart(String userId, List<Selection> productId) {
        Optional<Cart> userCart = cartRepository.findByUserId(userId);
        if (userCart.isPresent()) {
            Cart userCartInfo = userCart.get();
            if (userCartInfo.getSelectedProduct() != null && userCartInfo.getSelectedProduct().size() > 0) {

                List<Selection> selectedProducts = userCartInfo.getSelectedProduct();
                productId.forEach(prod -> {
                    selectedProducts.removeIf(item -> item.getProductId() == prod.getProductId());
                });
                userCartInfo.setSelectedProduct(selectedProducts);
                cartRepository.save(userCartInfo);
                return "Operation successful";
            } else {
                return "No product in cart";
            }


        } else {
            return "User does not exist";
        }
    }

}
