package com.aliaskar.EcommerceSpringBoot.service;

import com.aliaskar.EcommerceSpringBoot.dto.user.SignUpDto;
import com.aliaskar.EcommerceSpringBoot.dto.user.SigninResponseDto;
import com.aliaskar.EcommerceSpringBoot.dto.user.SinginDto;
import com.aliaskar.EcommerceSpringBoot.dto.user.SingnupResponseDto;
import com.aliaskar.EcommerceSpringBoot.exception.AuthenticationFaildException;
import com.aliaskar.EcommerceSpringBoot.exception.CustomException;
import com.aliaskar.EcommerceSpringBoot.model.AuthenticationToken;
import com.aliaskar.EcommerceSpringBoot.model.User;
import com.aliaskar.EcommerceSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Created by Admin on 25.04.2022
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Transactional
    public SingnupResponseDto signup(SignUpDto signUpDto) {
//        check if user already present
        if (Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail()))) {
            throw new CustomException("user already present");
        }
//        hash the password
        String encryptedpassword = signUpDto.getPassword();
        try {
            encryptedpassword = hashPaswword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
//        save the user
        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setPassword(encryptedpassword);
        userRepository.save(user);

//        create the token

        AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);

        SingnupResponseDto singnupResponseDto = new SingnupResponseDto("sucess", "user created successfully");
        return singnupResponseDto;


    }

    private String hashPaswword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SigninResponseDto singin(SinginDto singinDto) {
//        find user by email
        User user = userRepository.findByEmail(singinDto.getEmail());
        if (Objects.isNull(user)) {
            throw new AuthenticationFaildException("User is not valid");

            //        hash the password
        }
        try {
            if (!user.getPassword().equals(hashPaswword(singinDto.getPassword()))) {
                throw new AuthenticationFaildException("wrong password");

            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        AuthenticationToken token = authenticationService.getToken(user);
        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }
        return new SigninResponseDto("success", token.getToken());


    }

}
