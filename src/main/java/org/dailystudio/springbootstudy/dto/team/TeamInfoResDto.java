package org.dailystudio.springbootstudy.dto.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.dto.user.UserSimpleInfoResDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class TeamInfoResDto {
    private String teamName;

    private List<UserSimpleInfoResDto> userSimpleInfoResDtos;

    public TeamInfoResDto(Team team) {
        this.teamName = team.getTeamName();
        this.userSimpleInfoResDtos = team.getUsers().stream()
                .map(user -> new UserSimpleInfoResDto(user))
                .collect(Collectors.toList());
    }
}
