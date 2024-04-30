package com.switchfully.eurder.user.domain;

import java.util.UUID;

public interface User {
    String getPassword();
    String getEmail();

    boolean passwordMatch(String password);

    UUID getId();
}
