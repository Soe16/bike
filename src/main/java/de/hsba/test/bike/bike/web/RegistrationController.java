package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.ui.Model;
import javax.annotation.PostConstruct;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;
    private final UserAssembler userAssembler;

    public RegistrationController(UserService userService, UserAssembler userAssembler){
        this.userService = userService;
        this.userAssembler = userAssembler;
    }

    @GetMapping
    public String regestration(Model model){
        model.addAttribute("userForm", new UserForm());
        return "registration";
    }

    /*
    @PostMapping
    public String createUser(String name, String email, String password, String role){
        //User user = userService.createUser(name, password, email, role);
        userService.saveUser(new User(name, password, email, role));

        return "redirect:/";
    }*/

    @PostMapping
    public String create(@ModelAttribute("userForm") @Valid UserForm form, BindingResult userBinding){
        if (userBinding.hasErrors()){
            return "registration";
        }
        userService.saveUser(userAssembler.update(new User(), form));
        return "redirect/";
    }

}
