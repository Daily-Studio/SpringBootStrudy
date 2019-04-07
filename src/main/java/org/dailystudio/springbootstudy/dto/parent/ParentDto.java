package org.dailystudio.springbootstudy.dto.parent;

import lombok.Getter;
import org.dailystudio.springbootstudy.domain.Parent;
import org.dailystudio.springbootstudy.dto.child.ChildResDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ParentDto {
    private Long id;
    private String name;

    private List<ChildResDto> children;

    public ParentDto(Parent parent) {
        this.id = parent.getId();
        this.name = parent.getName();
        this.children = parent.getChildren().stream()
                .map(child -> new ChildResDto(child))
                .collect(Collectors.toList());
    }
}
