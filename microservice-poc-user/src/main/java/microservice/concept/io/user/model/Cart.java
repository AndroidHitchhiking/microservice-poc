package microservice.concept.io.user.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class Cart {

    private String id;
    private String userId;
    private List<Selection> selectedProduct;

    public Cart() {

    }

    public Cart(String userId, List<Selection> selectedProduct) {
        this.userId = userId;
        this.selectedProduct = selectedProduct;
    }
    public Cart(String id, String userId, List<Selection> selectedProduct) {
        this.id = id;
        this.userId = userId;
        this.selectedProduct = selectedProduct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Selection> getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(List<Selection> selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", selectedProduct=" + selectedProduct +
                '}';
    }
}
