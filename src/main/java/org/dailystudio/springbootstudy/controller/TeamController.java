package org.dailystudio.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Team;
import org.dailystudio.springbootstudy.dto.team.TeamDeleteReqDto;
import org.dailystudio.springbootstudy.dto.team.TeamNameChangeReqDto;
import org.dailystudio.springbootstudy.dto.team.TeamResDto;
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

    @GetMapping("/dont")
    public ResponseEntity<List<Team>> dontGetAll(){
        List<Team> teams = teamService.dontGetTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping
    public ResponseEntity<List<TeamResDto>> getAll(){
        List<TeamResDto> teamResDtos = teamService.getTeams();
        return ResponseEntity.ok(teamResDtos);
    }

    /*
        요구사항
        1. 한 개의 팀의 정보만 불러오도록 할것

        2. 팀에 속한 멤버의 정보를 포함할 것.

        * 순환참조가 발생하지 않도록 할 것.
        * 멤버의 정보중 비밀번호를 제외한 정보를 포함할 것
     */

    @PutMapping
    public ResponseEntity<Void> changeTeamName(@RequestBody TeamNameChangeReqDto teamNameChangeReqDto){
            teamService.changeTeamName(teamNameChangeReqDto);

            return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> DeleteTeam(@RequestBody TeamDeleteReqDto teamDeleteReqDto){
        teamService.deleteTeam(teamDeleteReqDto);

        return ResponseEntity.ok().build();
    }
}
