package org.dailystudio.springbootstudy.controller;

import org.dailystudio.springbootstudy.dto.UserReqDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
public class TestController {

    //"api/test"주소로 들어가면 그냥 바로 여기로 들어간다. @GetMapping에 ()아무것도 들어가지 않앗기떄문
    @GetMapping
    public String test() {
        String str = "Hello world!";
        return str;
    }

    @GetMapping("/get")
    public String me() {
        return "me";
    }

    @GetMapping("/path/{parameter}")
    public String pathVariable(@PathVariable("parameter") String output) {
        return output;
    }

    @GetMapping("/path")
    public String parameter(@RequestParam("no") String number) {
        return "번호는" + number;
    }

    @PostMapping("/post")
    public String postTest0() {
        return "post";
    }

    @PostMapping("/post/{name}")
    public String postTest1(@PathVariable("name") String output) {
        return output;
    }

    //get은 requestBody 쓰지못함
    @PostMapping("/post/instance/user")
    public String postTest2(@RequestBody UserReqDto user) {
        String output = user.getName() + user.getNumber();
        return output;
    }

    //post 매핑과 비슷한 방식을 따름.
    //get은 디비를 조회할때라는 의미를 가짐
    //post는 새로 생성하는 의미를 가짐
    //delete 는 삭제하는 의미
    //put 은 수정을 할때 의 의미
    //CRUD 라고 줄여쓴대
    @DeleteMapping("/delete")
    public String deleteTest() {
        return "delete";
    }

    @PutMapping
    public String putTest() {
        return "put";
    }
}
