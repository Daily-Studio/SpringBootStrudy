package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.user.UserSaveReqDto;
import org.dailystudio.springbootstudy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserSaveReqDto userSaveReqDto) {

    }
}
