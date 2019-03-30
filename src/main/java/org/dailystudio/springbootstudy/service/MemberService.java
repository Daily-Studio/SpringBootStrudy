package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Member;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.dto.member.MemberSaveReqDto;
import org.dailystudio.springbootstudy.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberSaveReqDto memberSaveReqDto) {
        Team basicTeam = Team.getBasic();
        Member member = memberSaveReqDto.toEntity(basicTeam);
        memberRepository.save(member);
    }

}
