package org.dailystudio.springbootstudy.dto;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Clerk;

@Getter
public class ClerkNameDto {

    private String name;

    public ClerkNameDto(Clerk clerk){
        this.name = clerk.getName();
    }
}
