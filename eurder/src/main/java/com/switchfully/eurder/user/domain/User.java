package com.switchfully.eurder.user.domain;

import com.switchfully.eurder.user.domain.attributes.Right;
import com.switchfully.eurder.user.domain.attributes.Role;

import java.util.Objects;

public class User {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;

    public User(String id, String firstname, String lastname, String email, String password, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public boolean hasRight(Right right){
        return this.role.getRights().contains(right);
    }

    public boolean passwordMatch(String pwd){
        return password.equals(pwd);
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password, role);
    }
}
