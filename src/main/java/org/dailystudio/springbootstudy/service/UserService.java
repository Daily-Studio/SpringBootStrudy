package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.User;
import org.dailystudio.springbootstudy.domain.UserImg;
import org.dailystudio.springbootstudy.dto.user.UserInfoResDto;
import org.dailystudio.springbootstudy.dto.user.UserNameReqDto;
import org.dailystudio.springbootstudy.dto.user.UserSaveReqDto;
import org.dailystudio.springbootstudy.repository.UserImgRepository;
import org.dailystudio.springbootstudy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserImgRepository userImgRepository;

    @Transactional
    public void save(UserSaveReqDto userSaveReqDto) {
        User user = userSaveReqDto.toEntity();
        user = userRepository.save(user);
        UserImg userImg = new UserImg(user);
        userImgRepository.save(userImg);
    }

    public List<UserInfoResDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserInfoResDto> userInfoResDtos;
        userInfoResDtos = users.stream()
                .map(user -> new UserInfoResDto(user))
                .collect(Collectors.toList());
        return userInfoResDtos;
    }

    public UserInfoResDto findUserByIdx(String idx) {
        Long userIdx = Long.valueOf(idx);
        UserInfoResDto userInfoResDto;
        User user = userRepository.findByUserIdx(userIdx);
        userInfoResDto = new UserInfoResDto(user);
        return userInfoResDto;
    }

    @Transactional
    public void changeUserName(String idx, UserNameReqDto userNameReqDto) {
        Long userIdx = Long.valueOf(idx);
        User user = userRepository.findByUserIdx(userIdx);
        //유저 정보를 수정하는 과정
        user.updateName(userNameReqDto);
    }

    @Transactional
    public void deleteUser(String idx) {
        Long userIdx = Long.valueOf(idx);
        User user = userRepository.findByUserIdx(userIdx);
        userRepository.delete(user);
    }
}
