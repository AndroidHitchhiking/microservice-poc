package microservice.concept.io.product.model;

import microservice.concept.io.product.document.Product;

import java.util.List;

public class ProductListResponse {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
