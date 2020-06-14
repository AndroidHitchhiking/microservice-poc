package microservice.concept.io.user.service;

import microservice.concept.io.user.config.PropertyConfig;
import microservice.concept.io.user.document.User;
import microservice.concept.io.user.model.*;
import microservice.concept.io.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PropertyConfig propertyConfig;


    public User addNewUser(User user) {
        return userRepository.insert(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public UserResponse getUserByEmail(String email) {
        UserResponse response = new UserResponse();
        try {
            Optional<User> userInfo = userRepository.findByEmail(email);
            LOGGER.info("UserService getUserByEmail db result = " + userInfo.toString());
            if (userInfo.isPresent()) {
                User user = userInfo.get();
                Cart cartForUser = restTemplate.getForObject(propertyConfig.getCartByUserId().replace("{userId}", user.getId()), Cart.class);
                LOGGER.info("UserService cartForUser = " + cartForUser.toString());
                response.setCart(cartForUser);
                response.setUserInfo(user);
                List<String> products = cartForUser.getSelectedProduct().stream().map(Selection::getProductId).collect(Collectors.toList());
                LOGGER.info("UserService products = " + products.toString());
                ProductListResponse productsDetails = getProductInfoByProductIdList(products);
                LOGGER.info("UserService productsDetails = " + productsDetails.toString());
                response.setProducts(productsDetails.getProducts());
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
        }

        //UserResponse
        return response;
    }

    public ProductListResponse getProductInfoByProductIdList(List<String> productIds) {
        ProductListResponse response = new ProductListResponse();
        try {
            HttpEntity<List<String>> entity = new HttpEntity<>(productIds);
            response = restTemplate.postForObject(propertyConfig.getProductInfoByProductIdList(), entity, ProductListResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
        }
        return response;
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User getUserById(String id) {
        Optional<User> userInfo = userRepository.findById(id);
        LOGGER.info("UserService getUserById db result = " + userInfo.toString());
        return userInfo.orElseGet(User::new);
    }
}
