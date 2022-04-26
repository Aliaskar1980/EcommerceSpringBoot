package com.aliaskar.EcommerceSpringBoot.dto.user;

/**
 * Created by Admin on 25.04.2022
 */
public class SingnupResponseDto {
    private String status;
    private String message;

    public SingnupResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
