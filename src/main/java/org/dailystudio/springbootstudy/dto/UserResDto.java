package org.dailystudio.springbootstudy.dto;

import lombok.Getter;

@Getter
public class UserResDto {
    private String name;

    public UserResDto(UserReqDto userReqDto) {
        this.name = userReqDto.getName();
    }

}
