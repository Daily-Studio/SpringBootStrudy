package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Parent;
import org.dailystudio.springbootstudy.dto.parent.ParentDto;
import org.dailystudio.springbootstudy.service.FamilyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/family")
@RequiredArgsConstructor
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("/save/parent")
    public ResponseEntity<Void> saveParent(){
        familyService.saveParent();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/save/children")
    public ResponseEntity<Void> saveChildren(){
        familyService.saveChild();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/parent")
    public ResponseEntity<ParentDto> getParent(){
        Parent parent = familyService.getParent();
        ParentDto parentDto = new ParentDto(parent);
        return ResponseEntity.ok(parentDto);
    }
}
