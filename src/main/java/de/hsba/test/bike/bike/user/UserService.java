package de.hsba.test.bike.bike.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

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
        initUser("JAkob", "ja@mail.de", "test", "Customer");
        initUser("Bernd", "be@mail.de", "test", "Deliverer");
    }

    private void initUser(String name, String email, String password, String role) {
        userRepository.save(new User(name, email, password, role));
    }

    public User createUser(String name, String email, String password, String role){
        User user = new User(name,email,password,role);
        user.setName(name);
        return userRepository.save(user);
    }

}
