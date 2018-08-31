package de.hsba.test.bike.bike.user;


import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class User implements Comparable<User>{

    public static User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserAdapter) {
            return ((UserAdapter) principal).getUser();
        }
        return null;
    }

    @Id @GeneratedValue
    private Long id;

    @NotEmpty(message = "Bitte einen Username eingeben.")
    @Column(unique = true, nullable = false)
    private String name;

    @NotEmpty(message = "Bitte ein Passwort eingeben.")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "Bitte eine Email Adresse eingeben.")
    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String name, String password, String email, String role) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(){
    }

    @Override
    public String toString(){
        return "User{" +
                "name=" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User other){return this.name.compareTo(other.name);}

}

