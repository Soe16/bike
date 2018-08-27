package de.hsba.test.bike.bike.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    @PostConstruct
    public void init(){

        createUser("bob", "pass", "bob@mail.de", "Customer");
        createUser("mark", "pass","mark@gmail.com", "Customer");
        createUser("john", "pass","john@yahoo.com", "Deliverer");
        createUser("admin", "admin","admin@admin.com", "ADMIN");
    }

    public void createUser(String username, String password, String email, String role) {
        userRepository.save(new User(username, passwordEncoder.encode(password), email, role));
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findUsers() {
        return userRepository.findUsers();

    }


}
