package com.aliaskar.EcommerceSpringBoot.dto.user;

/**
 * Created by Admin on 26.04.2022
 */
public class SigninResponseDto {
    private String status;
    private String token;

    public SigninResponseDto(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
