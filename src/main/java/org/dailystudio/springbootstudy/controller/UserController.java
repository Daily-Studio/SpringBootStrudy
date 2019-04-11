package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dailystudio.springbootstudy.domain.User;
import org.dailystudio.springbootstudy.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<Void> testUser() {

        //저장할 User를 만든다.
        User user = new User();
        user.setName("이름");
        user.setEmail("example@gmail.com");
        user.setPass("1234");
        user.setPhone("010-0100-0101");

        //user를 저장한다. (영속상태로 만들고 flush한다.)
        userRepository.save(user);

        //모든 user 정보를 가져온다.
        List<User> users = userRepository.findAll();

        //그중 하나의 user정보를 확인해본다.
        User someOne = users.get(0);
        log.info("SomeOne email - " + someOne.getEmail());
        log.info("SomeOne name - " + someOne.getName());
        log.info("SomeOne pass - " + someOne.getPass());
        log.info("SomeOne phone - " + someOne.getPhone());

        //정보를 바꿔보자.
        someOne.setName("바뀐이름");
        log.info("SomeOne name - " +someOne.getName());

        //정보를 지워보자.
        userRepository.delete(someOne);

        return ResponseEntity.ok().build();
    }
}
