package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.dto.team.TeamSaveReqDto;
import org.dailystudio.springbootstudy.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveTeam(@RequestBody TeamSaveReqDto teamSaveReqDto){
        teamService.save(teamSaveReqDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Team>> findAll(){
        List<Team> teams = teamService.getTeams();
        return ResponseEntity.ok(teams);
    }

}
