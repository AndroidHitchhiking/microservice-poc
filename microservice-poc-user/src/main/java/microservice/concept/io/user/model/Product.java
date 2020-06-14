package microservice.concept.io.user.model;

import org.springframework.data.mongodb.core.mapping.Document;

public class Product {

    private String id;
    private String productName;
    private String productDescription;
    private String productDepartment;
    private double price;
    private String productImageUrl;

    public Product() {

    }

    public Product(String id, String productName,
                   String productDescription, String productDepartment, double price, String productImageUrl) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productDepartment = productDepartment;
        this.price = price;
        this.productImageUrl = productImageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDepartment() {
        return productDepartment;
    }

    public void setProductDepartment(String productDepartment) {
        this.productDepartment = productDepartment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productDepartment='" + productDepartment + '\'' +
                ", price=" + price +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }
}
