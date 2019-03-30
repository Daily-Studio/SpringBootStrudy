package org.dailystudio.springbootstudy.dto.member;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.domain.Member;

@Getter
public class MemberSaveReqDto {
    private String userEmail;
    private String userName;
    private String userPass;

    public Member toEntity(Team team){
        return Member.builder()
                .team(team)
                .email(this.userEmail)
                .name(this.userName)
                .pass(this.userPass)
                .build();
    }
}
