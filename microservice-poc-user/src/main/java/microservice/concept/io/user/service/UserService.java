package microservice.concept.io.user.service;

import microservice.concept.io.user.document.User;
import microservice.concept.io.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addNewUser(User user) {
        return userRepository.insert(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        Optional<User> userInfo = userRepository.findByEmail(email);
        return userInfo.orElseGet(User::new);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User getUserById(String id) {
        Optional<User> userInfo = userRepository.findById(id);
        return userInfo.orElseGet(User::new);
    }
}
