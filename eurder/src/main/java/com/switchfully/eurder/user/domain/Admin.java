package com.switchfully.eurder.user.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;

import java.util.UUID;
@Entity
@Getter
@Table(name = "admin")
public class Admin implements User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "admin_id")
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public Admin(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Admin() {
    }

    public boolean passwordMatch(String pwd){
        return password.equals(pwd);
    }

}
