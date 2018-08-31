package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;
import org.springframework.stereotype.Component;

@Component
public class RegistrationFormAssembler {

    User update (User user, RegistrationForm registrationForm){
        user.setName(registrationForm.getName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(registrationForm.getPassword());
        user.setRole("Customer");
        return user;
    }
}
