package de.hsba.test.bike.bike.user;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


    public void saveUser(User user){
        userRepository.save(user);
    }

    //initiert User für die Verwändung der Anwendung
    @PostConstruct
    public void init(){
        createUser("bob", "pass", "bob@mail.de", "Customer");
        createUser("mark", "pass","mark@gmail.com", "Customer");
        createUser("john", "pass","john@yahoo.com", "Deliverer");

    }

    private void createUser(String username, String password, String email, String role) {
        userRepository.save(new User(username, passwordEncoder.encode(password), email, role));
    }

    //Erstellen eines neuen Users, welcher sich registriert hat
    public void createNewUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setRole(user.getRole());
        userRepository.save(user);

    }

    private List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findUsers() {
        return userRepository.findUsers();

    }

    //prüft ob der Username schon registriert ist
    public boolean isUserPresent(String name){
        List<User> users = this.findAll();
        for (User user: users){
            if (user.getName().equals(name)){
                return true;
            }
        }

        return false;

    }
}
