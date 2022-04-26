package com.aliaskar.EcommerceSpringBoot.service;

import com.aliaskar.EcommerceSpringBoot.model.AuthenticationToken;
import com.aliaskar.EcommerceSpringBoot.model.User;
import com.aliaskar.EcommerceSpringBoot.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 25.04.2022
 */
@Service
public class AuthenticationService {
    @Autowired
    TokenRepository tokenRepository;
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);

    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }
}
