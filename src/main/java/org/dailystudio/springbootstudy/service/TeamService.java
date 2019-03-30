package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.dto.team.TeamDeleteReqDto;
import org.dailystudio.springbootstudy.dto.team.TeamNameChangeReqDto;
import org.dailystudio.springbootstudy.dto.team.TeamSaveReqDto;
import org.dailystudio.springbootstudy.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void save(TeamSaveReqDto teamSaveReqDto){
        Team team = teamSaveReqDto.toEntity();
        teamRepository.save(team);
    }

    @Transactional(readOnly = true)
    public List<Team> getTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams;
    }

    @Transactional
    public void changeTeamName(TeamNameChangeReqDto teamNameChangeReqDto) {
        Team team = teamRepository.getOne(teamNameChangeReqDto.getId());
        team.changeName(teamNameChangeReqDto);
    }

    @Transactional
    public void deleteTeam(TeamDeleteReqDto teamDeleteReqDto) {
        Team team = teamRepository.getOne(teamDeleteReqDto.getId());
        teamRepository.delete(team);
    }
}
