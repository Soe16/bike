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
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        if(userService.isUserPresent(user.getName())) {
            model.addAttribute("exist",true);

            return "registration";

        }
        userService.createNewUser(user);
        return "success";
    }




}
