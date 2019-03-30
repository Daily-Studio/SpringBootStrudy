package org.dailystudio.springbootstudy.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Member;
import org.dailystudio.springbootstudy.dto.member.MemberSaveReqDto;
import org.dailystudio.springbootstudy.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    UserService의 메소드는 현재 깡통이야.
    디비와 연결을 하지 않았기 때문에 실제로 불러오는 값이 존재하지않아.
    이번 소스코드에서는 swagger의 기능들을 살펴보고 넘어가자.
 */

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
     */


}
