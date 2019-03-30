package org.dailystudio.springbootstudy.dto.team;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Team;

@Getter
public class TeamSaveReqDto {

    @ApiModelProperty(example = "팀 스부스", position = 1)
    private String teamName;

    public Team toEntity(){
        return Team.builder()
                .name(this.teamName)
                .build();
    }
}
