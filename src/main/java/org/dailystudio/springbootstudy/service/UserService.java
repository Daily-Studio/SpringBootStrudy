package org.dailystudio.springbootstudy.service;

import org.dailystudio.springbootstudy.domain.User;
import org.dailystudio.springbootstudy.dto.user.UserInfoResDto;
import org.dailystudio.springbootstudy.dto.user.UserSaveReqDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    public void save(UserSaveReqDto userSaveReqDto) {
        //유저 등록 작업 -> DB에 INSERT 해야 겠지?
    }


    public List<UserInfoResDto> getAll() {
        //모든 유저 찾는 작업 -> DB에서 SELECT 해야겠지?
        List<User> users = Arrays.asList();
        //반환 시킬 객체 준비
        List<UserInfoResDto> userInfoResDtos = new ArrayList<>();
        //domain -> dto 변환

        //가공된 dto 반환
        return userInfoResDtos;
    }

    public UserInfoResDto findUserByIdx(String idx) {
        //DB에 userIdx는 보통 정수로 저장되어있으니까 String으로 받은 idx를 Long(int보다 큰 정수형)으로 변환하자.
        Long userIdx = Long.valueOf(idx);
        //반환시킬 객체 준비
        UserInfoResDto userInfoResDto = null;
        //디비에서 userIdx를 이용하여 User객체를 찾아온다.

        //domain -> dto 변환

        //가공된 dto 반환
        return userInfoResDto;
    }

    public void changeUserName(String idx, String name) {
        Long userIdx = Long.valueOf(idx);
        //유저 정보를 수정하는 과정
    }

    public void deleteUser(String idx) {
        Long userIdx = Long.valueOf(idx);
        //유저 정보를 제거하는 과정
    }
}
