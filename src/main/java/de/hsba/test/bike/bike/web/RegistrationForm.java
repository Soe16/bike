package de.hsba.test.bike.bike.web;

import javax.validation.constraints.*;

public class RegistrationForm {

    @NotEmpty(message = "Please enter a username.")
    private String name;

    @NotEmpty(message = "Please eneter a valid email.")
    private String email;

    @NotEmpty(message = "Please enter a password.")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
