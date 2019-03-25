package org.dailystudio.springbootstudy.service;

import org.dailystudio.springbootstudy.dto.UserReqDto;
import org.dailystudio.springbootstudy.dto.UserResDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResDto getUserInfo(UserReqDto userReqDto) {
        UserResDto userResDto = new UserResDto(userReqDto);
        return userResDto;
    }
    
}
