package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.dto.team.TeamSaveReqDto;
import org.dailystudio.springbootstudy.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public void save(TeamSaveReqDto teamSaveReqDto){
        Team team = teamSaveReqDto.toEntity();
        teamRepository.save(team);
    }

    public List<Team> getTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams;
    }
}
