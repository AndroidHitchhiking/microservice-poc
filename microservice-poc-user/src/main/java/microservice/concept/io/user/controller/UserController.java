package microservice.concept.io.user.controller;

import microservice.concept.io.user.document.User;
import microservice.concept.io.user.model.UserResponse;
import microservice.concept.io.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    private User addNewUser(@RequestBody User user) {
        LOGGER.info("UserController addNewUser request = " + user.toString());
        return userService.addNewUser(user);
    }

    @PutMapping("/update")
    private User updateUser(@RequestBody User user) {
        LOGGER.info("UserController updateUser request = " + user.toString());
        return userService.updateUser(user);
    }

    @GetMapping("/all")
    private List<User> getAllUser() {
        LOGGER.info("UserController getAllUser");
        return userService.getAllUser();
    }

    @GetMapping("/email/{email}")
    private UserResponse getUserByEmail(@PathVariable String email) {
        LOGGER.info("UserController getUserByEmail email = "+email);
        return userService.getUserByEmail(email);
    }

    @GetMapping("/id/{id}")
    private User getUserById(@PathVariable String id) {
        LOGGER.info("UserController getUserById id = "+id);
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    private String deleteUser(@PathVariable String id) {
        LOGGER.info("UserController deleteUser id = "+id);
        userService.deleteUser(id);
        return "User " + id + " deleted successfully";
    }

}
