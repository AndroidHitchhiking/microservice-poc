package microservice.concept.io.user.controller;

import microservice.concept.io.user.document.User;
import microservice.concept.io.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/add")
    private User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @PutMapping("/update")
    private User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/all")
    private List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/email/{email}")
    private User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/id/{id}")
    private User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    private String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User " + id + " deleted successfully";
    }

}
