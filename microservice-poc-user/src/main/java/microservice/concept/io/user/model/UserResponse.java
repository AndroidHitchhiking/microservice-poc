package microservice.concept.io.user.model;

import microservice.concept.io.user.document.User;

public class UserResponse extends ProductListResponse{

    private User userInfo;
    private Cart cart;

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
