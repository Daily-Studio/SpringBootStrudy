package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.MemberLoginReqDto;
import org.dailystudio.springbootstudy.dto.MemberSaveReqDto;
import org.dailystudio.springbootstudy.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody MemberSaveReqDto saveReq) {
        memberService.saveMember(saveReq);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberLoginReqDto loginReq){
        String result = memberService.loginMember(loginReq);
        return ResponseEntity.ok(result);
    }
}
