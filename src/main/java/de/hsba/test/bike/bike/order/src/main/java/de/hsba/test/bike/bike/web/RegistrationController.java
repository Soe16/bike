package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping
    public String regestration(){
        return "registration";
    }




}