package org.dailystudio.springbootstudy.controller;

import org.dailystudio.springbootstudy.dto.UserReqDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
public class TestController {

    @GetMapping
    public String test() {
        String str = "hello world";
        return str;
    }

    @GetMapping("/get")
    public String me() {
        return "me";
    }

    @GetMapping("/path/{parameter}")
    public String parameter(@PathVariable("parameter") String output) {
        return output;
    }

    @PostMapping("/post")
    public String postTest0() {
        return "post";
    }

    @PostMapping("/post/{name}")
    public String postTest1(@PathVariable("name") String output) {
        return output;
    }

    @PostMapping("/post/instance/user")
    public String postTest2(@RequestBody UserReqDto user) {
        String output = user.getName() + user.getNumber();
        return output;
    }

    @DeleteMapping("/delete")
    public String deleteTest() {
        return "delete";
    }

    @PutMapping
    public String putTest() {
        return "put";
    }
}
