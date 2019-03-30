package org.dailystudio.springbootstudy.dto.team;

import org.dailystudio.springbootstudy.domain.Team;

public class TeamSaveReqDto {

    private String teamName;

    public Team toEntity(){
        return Team.builder()
                .name(this.teamName)
                .build();
    }
}
