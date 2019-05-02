package org.dailystudio.springbootstudy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/account")
public class AccountController {

    @PostMapping("/login")
    public HashMap<String, String> postLogin(@RequestBody HashMap<String,String> input){

        HashMap<String,String> result = new HashMap<>();
        result.put("name","holy");
        result.put("family","shit");

        result = input;

        return result;
    }

    @PostMapping("/signup")
    public HashMap<String, String> postSignup(){

        HashMap<String,String> result = new HashMap<>();
        result.put("name","holy");
        result.put("family","shit signup");

        return result;
    }
}
