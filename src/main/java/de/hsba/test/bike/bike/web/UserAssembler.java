package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;

public class UserAssembler {

    UserForm toForm(User user){
        UserForm form = new UserForm();
        form.setFromName(user.getName());
        form.setFromEmail(user.getEmail());
        form.setFromPassword(user.getPassword());
        return form;
    }

    User update(User user, UserForm form){
        user.setName(form.getFromName());
        user.setEmail(form.getFromEmail());
        user.setPassword(form.getFromPassword());
        user.setRole("Customer");
        return user;
    }
}
