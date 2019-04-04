package org.dailystudio.springbootstudy.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.user.UserInfoResDto;
import org.dailystudio.springbootstudy.dto.user.UserSaveReqDto;
import org.dailystudio.springbootstudy.service.UserService;
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
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "유저 정보 저장하기",
            notes = "유저 정보를 저장합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "유저 저장 성공"),
            @ApiResponse(code = 500, message = "서버에러")
    })
    @PostMapping("/save")
    public ResponseEntity<Void> saveUser(@RequestBody UserSaveReqDto userSaveReqDto) {
        userService.save(userSaveReqDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserInfoResDto>> getAllUser() {
        List<UserInfoResDto> resDtos = userService.getAll();
        return ResponseEntity.ok().body(resDtos);
    }

    @GetMapping("/{idx}")
    public ResponseEntity<UserInfoResDto> getUserInfo(@PathVariable("idx") String idx) {
        UserInfoResDto userInfoResDto = userService.findUserByIdx(idx);
        return ResponseEntity.ok().body(userInfoResDto);
    }

    @PutMapping("/{idx}")
    public ResponseEntity<Void> changeUserName(@PathVariable("idx") String idx, final String name) {
        userService.changeUserName(idx, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<Void> deleteUser(@PathVariable("idx") String idx) {
        userService.deleteUser(idx);
        return ResponseEntity.ok().build();

    }
}