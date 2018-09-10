package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;
import org.springframework.stereotype.Component;

@Component
public class RegistrationFormAssembler {

    // ordnet Werte des Formulas dem User Objekt zu
    User update (User user, RegistrationForm registrationForm){
        user.setName(registrationForm.getName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(registrationForm.getPassword());
        user.setRole("Customer");
        return user;
    }
}
