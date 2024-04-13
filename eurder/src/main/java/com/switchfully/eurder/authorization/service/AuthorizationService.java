package com.switchfully.eurder.authorization.service;

import com.switchfully.eurder.exception.AccessForbiddenException;
import com.switchfully.eurder.exception.NotFoundException;
import com.switchfully.eurder.exception.PasswordNotMatchException;
import com.switchfully.eurder.user.domain.User;
import com.switchfully.eurder.user.domain.UserRepository;
import com.switchfully.eurder.user.domain.attributes.EmailPassword;
import com.switchfully.eurder.user.domain.attributes.Right;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void hasRight(Right right, String authorization){
        EmailPassword emailPassword = getEmailPassword(authorization);
        User user = getUserByEmailPassword(emailPassword);

        if (!user.passwordMatch(emailPassword.getPassword())) {
            throw new PasswordNotMatchException("Email/password in authorization header doesn't match");
        }

        if (!user.hasRight(right)) {
            throw new AccessForbiddenException("Authenticated user have no access to this feature");
        }
    }

    private EmailPassword getEmailPassword(String authorization) {
        String decodedEmailAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String email = decodedEmailAndPassword.substring(0, decodedEmailAndPassword.indexOf(":"));
        String password = decodedEmailAndPassword.substring(decodedEmailAndPassword.indexOf(":") + 1);
        return new EmailPassword(email, password);
    }

    private User getUserByEmailPassword(EmailPassword emailPassword) {
        return userRepository.getUserByEmail(emailPassword.getEmail())
                .orElseThrow(() -> new NotFoundException("Email in authorization header not found"));
    }
}
