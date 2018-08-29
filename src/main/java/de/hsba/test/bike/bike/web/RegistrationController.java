package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
//@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/registration")
    public String registerUser(User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "registerForm";
        }
        if(userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist",true);

            return "registerForm";

        }
        userService.createNewUser(user);
        return "success";
    }
/*
    private UserService userService;
    private final UserAssembler userAssembler;

    public RegistrationController(UserService userService, UserAssembler userAssembler){
        this.userService = userService;
        this.userAssembler = userAssembler;
    }

    @PostMapping
    public String create(@ModelAttribute("userForm") @Valid UserForm form, BindingResult userBinding){
        if (userBinding.hasErrors()){
            return "registration";
        }
        userService.saveUser(userAssembler.update(new User(), form));
        return "redirect/";
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



}
