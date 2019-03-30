package org.dailystudio.springbootstudy.dto.user;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.domain.User;

@Getter
public class UserSaveReqDto {
    private String userEmail;
    private String userName;
    private String userPass;

    public User toEntity(Team team){
        return User.builder()
                .team(team)
                .email(this.userEmail)
                .name(this.userName)
                .pass(this.userPass)
                .build();
    }
}
