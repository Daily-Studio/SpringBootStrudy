package org.dailystudio.springbootstudy.dto.team;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Team;

@Getter
public class TeamNameResDto {
    private String teamName;

    public TeamNameResDto(Team team) {
        this.teamName = team.getTeamName();
    }
}
