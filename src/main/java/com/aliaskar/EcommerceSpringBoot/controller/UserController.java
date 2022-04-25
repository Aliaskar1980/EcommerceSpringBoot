package com.aliaskar.EcommerceSpringBoot.controller;

import com.aliaskar.EcommerceSpringBoot.dto.user.ResponseDto;
import com.aliaskar.EcommerceSpringBoot.dto.user.SignUpDto;
import com.aliaskar.EcommerceSpringBoot.service.UserService;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 25.04.2022
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
//    two apis

//    sign up
    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignUpDto signUpDto){
        return userService.signup(signUpDto);

    }


//    sign in
}
