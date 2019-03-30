package org.dailystudio.springbootstudy.dto.member;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Member;
import org.dailystudio.springbootstudy.domain.Team;

@Getter
public class MemberSaveReqDto {

    @ApiModelProperty(example = "example@gmail.com", position = 1)
    private String userEmail;

    @ApiModelProperty(example = "박찬인", position = 2)
    private String userName;

    @ApiModelProperty(example = "q1w2e3", position = 3)
    private String userPass;

    public Member toEntity(Team team) {
        return Member.builder()
                .team(team)
                .email(this.userEmail)
                .name(this.userName)
                .pass(this.userPass)
                .team(team)
                .build();
    }
}
