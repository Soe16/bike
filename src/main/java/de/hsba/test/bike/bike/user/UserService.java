package de.hsba.test.bike.bike.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    @PostConstruct
    public void init(){
        createUser("JAkob", "ja@mail.de", "test", "Customer");
        createUser("Bernd", "be@mail.de", "test", "Deliverer");
    }

    private void createUser(String name, String email, String password, String role) {
        userRepository.save(new User(name, email, password, role));
    }

}
