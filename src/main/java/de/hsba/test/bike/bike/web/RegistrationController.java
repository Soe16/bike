package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String regestration(){
        return "registration";
    }

    /* @PostMapping
    public String createUser(String name, String email, String password, String role){
        User user = userService.createUser(name, email, password, role);
        return "redirect:/registration" + user.getId();
    }*/

}
