package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Child;
import org.dailystudio.springbootstudy.domain.Parent;
import org.dailystudio.springbootstudy.dto.parent.ParentDto;
import org.dailystudio.springbootstudy.service.FamilyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/family")
@RequiredArgsConstructor
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("/mto")
    public ResponseEntity<List<Child>> manyToOne(){
        //부모저장
        familyService.saveParentForManyToOne();
        //자식저장
        familyService.saveChildForManyToOne();
        //자식 불러오기
        List<Child> children = familyService.getAllChild();

        return ResponseEntity.ok(children);
    }

//    @PostMapping("/otm")
//    public ResponseEntity<Void> oneToMany() {
//        //부모, 자식 저장
//        familyService.saveParentForOneToMany();
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/otm")
//    public ResponseEntity<ParentDto> oneToManyGet(Long id) {
//        Parent parent = familyService.getParent(id);
//        return ResponseEntity.ok(new ParentDto(parent));
//    }
}
