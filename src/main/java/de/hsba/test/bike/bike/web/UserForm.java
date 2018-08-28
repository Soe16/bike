package de.hsba.test.bike.bike.web;

import javax.validation.constraints.NotNull;

public class UserForm {

    @NotNull(message="Bitte geben Sie einen Namen ein.")
    private String fromName;

    @NotNull(message = "Bitte geben Sie eine korrekte Email ein.")
    private String fromEmail;

    @NotNull(message = "Bitte geben Sie ein Passwort ein.")
    private String fromPassword;

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }
}
