package org.dailystudio.springbootstudy.dto.parent;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Child;
import org.dailystudio.springbootstudy.domain.Parent;

import java.util.List;

@Getter
public class ParentDto {
    private Long id;
    private String name;

    private List<Child> children;

    public ParentDto(Parent parent){
        this.id=parent.getId();
        this.name=parent.getName();
        this.children=parent.getChildren();
    }
}
