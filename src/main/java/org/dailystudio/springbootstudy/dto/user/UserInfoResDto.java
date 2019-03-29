package org.dailystudio.springbootstudy.dto.user;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.User;

@Getter
public class UserInfoResDto {
    private String email;
    private String name;

    public UserInfoResDto(User user) {
        this.email = user.getUserEmail();
        this.name = user.getUserName();
    }
}
