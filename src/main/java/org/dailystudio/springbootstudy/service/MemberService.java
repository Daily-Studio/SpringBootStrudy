package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Member;
import org.dailystudio.springbootstudy.dto.MemberLoginReqDto;
import org.dailystudio.springbootstudy.dto.MemberSaveReqDto;
import org.dailystudio.springbootstudy.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveMember(final MemberSaveReqDto memberSaveReqDto) {
        Member member = memberSaveReqDto.toEntity(bCryptPasswordEncoder);
        memberRepository.save(member);
    }

    public String loginMember(final MemberLoginReqDto loginReqDto) {
        Member member = memberRepository.findMemberByEmail(loginReqDto.getEmail());

        if (bCryptPasswordEncoder.matches(loginReqDto.getPass(), member.getPass())) {
            return "success";
        }
        return "fail";
    }
}
