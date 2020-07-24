package org.dailystudio.springbootstudy.dto.child;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Child;

@Getter
public class ChildResDto {
    private String name;

    public ChildResDto(Child child) {
        this.name = child.getName();
    }
}
