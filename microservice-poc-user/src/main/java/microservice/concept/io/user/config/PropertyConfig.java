package microservice.concept.io.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="rest.endpoint")
public class PropertyConfig {

    private String cartByUserId;
    private String productInfoByProductIdList;

    public String getCartByUserId() {
        return cartByUserId;
    }

    public void setCartByUserId(String cartByUserId) {
        this.cartByUserId = cartByUserId;
    }

    public String getProductInfoByProductIdList() {
        return productInfoByProductIdList;
    }

    public void setProductInfoByProductIdList(String productInfoByProductIdList) {
        this.productInfoByProductIdList = productInfoByProductIdList;
    }
}
