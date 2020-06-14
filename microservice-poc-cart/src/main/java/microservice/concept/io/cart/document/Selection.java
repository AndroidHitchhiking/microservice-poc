package microservice.concept.io.cart.document;

public class Selection {
    private String productId;
    private int count;

    public Selection(){

    }

    public Selection(String productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "selection{" +
                "productId='" + productId + '\'' +
                ", count=" + count +
                '}';
    }
}
