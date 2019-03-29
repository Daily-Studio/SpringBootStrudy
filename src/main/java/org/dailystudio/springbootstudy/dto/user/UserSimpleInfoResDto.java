package org.dailystudio.springbootstudy.dto.user;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.User;
import org.dailystudio.springbootstudy.domain.UserImg;

import java.util.List;

@Getter
public class UserSimpleInfoResDto {
    private String email;
    private String name;
    private List<UserImg> userImgs;

    public UserSimpleInfoResDto(User user) {
        this.email = user.getUserEmail();
        this.name = user.getUserName();
        this.userImgs = user.getUserImgs();
    }
}
