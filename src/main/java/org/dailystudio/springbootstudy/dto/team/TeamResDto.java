package org.dailystudio.springbootstudy.dto.team;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Team;

@Getter
public class TeamResDto {
    private String teamName;

    public TeamResDto(Team team) {
        this.teamName = team.getName();
    }
}
