package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.dto.team.TeamInfoResDto;
import org.dailystudio.springbootstudy.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<TeamInfoResDto> getAllTeam() {
        List<Team> teams = teamRepository.findAll();
        List<TeamInfoResDto> teamInfoResDtos = teams.stream()
                .map(team -> new TeamInfoResDto(team))
                .collect(Collectors.toList());
        return teamInfoResDtos;
    }
}
