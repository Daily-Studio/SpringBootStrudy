package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.User;
import org.dailystudio.springbootstudy.dto.user.UserInfoResDto;
import org.dailystudio.springbootstudy.dto.user.UserSaveReqDto;
import org.dailystudio.springbootstudy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(UserSaveReqDto userSaveReqDto) {
        User user = userSaveReqDto.toEntity();
        userRepository.save(user);
    }

    public List<UserInfoResDto> getAll() {
        //모든 유저 찾는 작업 -> DB에서 SELECT 해야겠지?
        List<User> users = userRepository.findAll();
        //반환 시킬 객체 준비
        List<UserInfoResDto> userInfoResDtos;
        //domain -> dto 변환
        userInfoResDtos = users.stream()
                .map(user -> new UserInfoResDto(user))
                .collect(Collectors.toList());
        //가공된 dto 반환
        return userInfoResDtos;
    }

    public UserInfoResDto findUserByIdx(String idx) {
        //DB에 userIdx는 보통 정수로 저장되어있으니까 String으로 받은 idx를 Long(int보다 큰 정수형)으로 변환하자.
        Long userIdx = Long.valueOf(idx);
        //반환시킬 객체 준비
        UserInfoResDto userInfoResDto;
        //디비에서 userIdx를 이용하여 User객체를 찾아온다.
        User user = userRepository.findByUserIdx(userIdx);
        //domain -> dto 변환
        userInfoResDto = new UserInfoResDto(user);
        //가공된 dto 반환
        return userInfoResDto;
    }

    @Transactional
    public void changeUserName(String idx, String name) {
        Long userIdx = Long.valueOf(idx);
        //유저 정보를 수정하는 과정
        User user = userRepository.findByUserIdx(userIdx);
        //쿼리를 작성하는 방법
        //userRepository.updateUserName(userIdx, name);

        //Setter를 이용한 방법
        user.setName(name);

        //더 나은 방법은 없을까?
    }

    @Transactional
    public void deleteUser(String idx) {
        Long userIdx = Long.valueOf(idx);
        //유저 정보를 제거하는 과정
        User user = userRepository.findByUserIdx(userIdx);
        userRepository.delete(user);
    }
}
