package org.dailystudio.springbootstudy.dto.team;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Team;

@Getter
public class TeamSaveReqDto {

    private String teamName;

    public Team toEntity(){
        return Team.builder()
                .name(this.teamName)
                .build();
    }
}
