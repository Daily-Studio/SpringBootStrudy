package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.dto.team.TeamInfoResDto;
import org.dailystudio.springbootstudy.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamInfoResDto>> getAllTeam() {

        List<TeamInfoResDto> teamInfoResDtos = teamService.getAllTeam();

        return ResponseEntity.ok().body(teamInfoResDtos);
    }
}
