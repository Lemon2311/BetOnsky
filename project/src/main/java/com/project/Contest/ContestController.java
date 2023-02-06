package com.project.Contest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contests")
@CrossOrigin(origins = "http://localhost:4200")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @GetMapping
    public List<Contest> getContests() {
        return contestService.getContests();
    }

    @GetMapping("/{id}")
    public Optional<Contest> getContest(@PathVariable(name = "id") Long id) {
        Optional<Contest> contest0 = contestService.getContest(id);
        return contest0;
    }

    @PostMapping
    public void addContest(@RequestBody Contest contest) {
        contestService.addContest(contest);
    }

    @PutMapping("/{id}")
    public void updateContest(@RequestBody Contest contest, @PathVariable(value = "id") Long id) {
        contestService.updateContest(contest);
    }

    @DeleteMapping
    public void deleteContest(@RequestBody Contest contest) {
        contestService.deleteContest(contest);
    }
}
