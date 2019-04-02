package org.dailystudio.springbootstudy.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.member.MemberSaveReqDto;
import org.dailystudio.springbootstudy.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "멤버 정보 저장하기",
            notes = "멤버 정보를 저장합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "멤버 저장 성공"),
            @ApiResponse(code = 500, message = "서버에러")
    })
    @PostMapping("/save")
    public ResponseEntity<Void> saveMember(@RequestBody MemberSaveReqDto memberSaveReqDto) {
        memberService.save(memberSaveReqDto);
        return ResponseEntity.ok().build();
    }

    /*
        요구사항
        1. 모든 멤버의 정보를 가져오기

        * 순환참조가 발생하지 않게 할 것
        * 멤버가 속한 팀의 이름을 포함할 것

        2. 멤버의 이름을 바꿀 것

        * setter를 사용하지 말 것

        3. 멤버의 정보를 삭제 할 것
     */


}
