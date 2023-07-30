package com.project.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/teams")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/name/{name}")
    public Optional<Team> getTeamByName(@PathVariable(name = "name") String name){
        Team team = teamService.getTeam(name);
        return Optional.of(team);
    }

    @PostMapping
    public void addTeam(@RequestBody Team team) {

       // if(!teamService.getTeam(team.getId()).isPresent())
        teamService.addTeam(team);
    }

    @PutMapping("/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable(value = "id") Long id) {
        teamService.updateTeam(team);
    }

    @PatchMapping("/name")
    public void addBidderOnTeam(@PathVariable(name="name") String name) {
        //teamService.addBidderByTeamByName();

    }

    @DeleteMapping
    public void deleteTeam(@RequestBody Team team) {
        teamService.deleteTeam(team);
    }
}
