package com.ochiengolanga.tuts.bootstandalone.web;

import com.ochiengolanga.tuts.bootstandalone.domains.Rider;
import com.ochiengolanga.tuts.bootstandalone.domains.Team;
import com.ochiengolanga.tuts.bootstandalone.repository.RiderRepository;
import com.ochiengolanga.tuts.bootstandalone.repository.TeamRepository;
import com.ochiengolanga.tuts.bootstandalone.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamsController {

    private final RiderRepository riderRepository;
    private final TeamRepository teamRepository;
    private final TeamService teamService;

    public TeamsController(RiderRepository riderRepository,
                           TeamRepository teamRepository,
                           TeamService teamService) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }

    @PostMapping
    public void createTeam(@RequestBody Team newTeam) {
        teamRepository.save(newTeam);
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.fetchTeams();
    }

    @GetMapping("/{teamId}")
    public Team getTeam(@PathVariable("teamId") Long teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }

    @GetMapping("/{teamId}/riders")
    public List<Rider> getTeamRiders(@PathVariable("teamId") Long teamId) {
        return riderRepository.findByTeamId(teamId);
    }

    @PatchMapping("/{teamId}")
    public Team updateTeam(@PathVariable("teamId") Long teamId,
                           @RequestBody Team updatedTeam) {
        return teamRepository.save(updatedTeam);
    }

    @DeleteMapping("/{teamId}")
    public void deleteTeam(@PathVariable("teamId") Long teamId) {
        teamRepository.deleteById(teamId);
    }
}
