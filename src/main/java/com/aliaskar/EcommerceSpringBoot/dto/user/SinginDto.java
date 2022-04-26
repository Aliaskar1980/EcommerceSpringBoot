package com.aliaskar.EcommerceSpringBoot.dto.user;

/**
 * Created by Admin on 26.04.2022
 */
public class SinginDto {
    private String email;
    private String password;

    public SinginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
