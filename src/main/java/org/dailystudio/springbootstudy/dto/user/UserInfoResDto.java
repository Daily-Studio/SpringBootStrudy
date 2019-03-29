package org.dailystudio.springbootstudy.dto.user;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.User;
import org.dailystudio.springbootstudy.domain.UserImg;
import org.dailystudio.springbootstudy.dto.team.TeamNameResDto;

import java.util.List;

@Getter
public class UserInfoResDto {
    private String email;
    private String name;
    private List<UserImg> userImgs;
    private TeamNameResDto teamNameResDto;

    public UserInfoResDto(User user) {
        this.email = user.getUserEmail();
        this.name = user.getUserName();
        this.userImgs = user.getUserImgs();
        this.teamNameResDto = new TeamNameResDto(user.getTeam());
    }
}