package com.switchfully.eurder.user.domain.attributes;

public class EmailPassword {
    private final String email;
    private final String password;

    public EmailPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
