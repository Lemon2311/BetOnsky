package com.project.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    public Optional<Team> getTeam(@PathVariable(name = "id") Long id) {
        Optional<Team> team0 = teamService.getTeam(id);
        return team0;
    }

    @PostMapping
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @PutMapping("/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable(value = "id") Long id) {
        teamService.updateTeam(team);
    }

    @DeleteMapping
    public void deleteTeam(@RequestBody Team team) {
        teamService.deleteTeam(team);
    }
}
