package org.dailystudio.springbootstudy.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.dailystudio.springbootstudy.domain.User;

@Getter
public class UserSaveReqDto {
    private static final String USER_AUTH = "USER";

    @ApiModelProperty(example = "example@gmail.com", position = 1)
    private String email;

    @ApiModelProperty(example = "박찬인", position = 2)
    private String name;

    @ApiModelProperty(example = "q1w2e3r4!", position = 3)
    private String pass;

    @ApiModelProperty(example = "010-1234-1234", position = 4)
    private String phone;


    public User toEntity() {
        return User.builder()
                .userEmail(this.email)
                .userName(this.name)
                .userPass(this.pass)
                .userPhone(this.phone)
                .userAuth(USER_AUTH)
                .build();
    }
}
