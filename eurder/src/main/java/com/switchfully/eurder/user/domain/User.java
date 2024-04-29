package com.switchfully.eurder.user.domain;

public interface User {
    String getPassword();
    String getEmail();

    boolean passwordMatch(String password);
}
