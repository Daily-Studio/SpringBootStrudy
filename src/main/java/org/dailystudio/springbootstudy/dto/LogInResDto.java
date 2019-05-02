package org.dailystudio.springbootstudy.dto;


import lombok.Getter;

@Getter
public class LogInResDto {
    private String email;

    public LogInResDto(String email){
        this.email = email;
    }
}
