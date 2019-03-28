package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.UserReqDto;
import org.dailystudio.springbootstudy.dto.UserResDto;
import org.dailystudio.springbootstudy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
RestFul한 API란 무엇인가?
하나의 URI는 반드시 그에 상응하는 데이터를 나타내는 구조이다.

예를 들어
/api/user/1/name 로 접근하는 경우
'1번' '유저'의 '이름' 대한 데이터를 나타낸다.

@RestController = @Controller + @ResponseBody 이다.
기존에 @Controller를 사용했을 때는 뷰를 반환하였지만
@RestController를 사용하면 데이터만 반환하게 된다.
이러한 데이터는 JSON형태로 반환된다.

우리는 RestFul API를 구현할 때 반환값으로 ResponseEntity를 이용할 것이다.
ResponseEntity를 이용하게 되면
서버에서 직접

1. 상태코드              --> OK(200), NOT_FOUND(404)...
2. HttpHeader           --> Content-type : JSON(application/json)...
3. 응답 메세지           --> 요청에 대한 응답 값

를 지정해서 클라이언트에게 보내줄 수 있다.
 */
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor //arg가 잇는 것들을 이용해서 생성자를 만든다
//@RequiredArgsConstructor이걸 안쓰면 밑에처럼 써도 생성해준다.
//public class UserController (UserSercice userService) { }
public class UserController {

    //@Autowired 써주면 객체 알아서 생성해준다
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResDto> getUserName(@RequestBody UserReqDto userReqDto) {
        //UserReqDto userReqDto = userService.getUserInfo(userReqDto);
        //return ResponseEntity.ok().body(userReqDto);
        return ResponseEntity.ok().body(userService.getUserInfo(userReqDto));
    }
}
