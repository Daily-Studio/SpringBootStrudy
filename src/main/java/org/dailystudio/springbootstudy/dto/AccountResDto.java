package org.dailystudio.springbootstudy.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class AccountResDto {
  //이메일이랑 패스만 !
   private String email;
   private String pass;


    public AccountResDto(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
}
