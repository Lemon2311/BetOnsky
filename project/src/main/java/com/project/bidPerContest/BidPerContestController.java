package com.project.bidPerContest;

import com.project.Contest.Contest;
import com.project.Contest.ContestService;
import com.project.Team.Team;
import com.project.Team.TeamController;
import com.project.Team.TeamService;
import com.project.User.User;
import com.project.User.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/bidPerContest")
@CrossOrigin(origins = "http://localhost:4200")
public class BidPerContestController {

    @Autowired
    private BidPerContestService bidPerContestService;

    @Autowired
    private ContestService contestService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    @PostMapping
    public void postBid(@RequestBody BidPerContest bid){

       // if(!bidPerContestService.getBidPerContest(bid.getId()).isPresent())
        bidPerContestService.setBidPerContest(bid);


    }

    @PutMapping("/set/")
    public void setBid(@PathVariable(name = "contest") Contest contest,
                       @PathVariable(name = "bid") double bid,
                       @PathVariable(name = "team") Team team,
                       @PathVariable(name = "user") User user) {

        bidPerContestService.setBidPerContest(new BidPerContest(contest, bid, team, user));
    }

    @PatchMapping("/patch/{id}/{teamN}/{userN}/{contestN}")
    public void patchBid(@PathVariable(name = "contestN") String contestN,
                         @PathVariable(name = "id") long id,
                         @PathVariable(name = "teamN") String teamN,
                         @PathVariable(name = "userN") String userN) {


      Contest contest = contestService.getContestByName(contestN);
      Team team = teamService.getTeam(teamN);
      User user = userService.getUserByEmail(userN);

      bidPerContestService.patchBidOnContest(id,team,user,contest);

    }

    @GetMapping("/{contest}")
    public double getBidOfContest(@PathVariable(name = "contest") Contest contest) {
        return bidPerContestService.getBidOfContest(contest);
    }

    @GetMapping("/get")
    public List<BidPerContest> getBidsOfContest() {
        return bidPerContestService.getBidsOfContest();
    }

    @GetMapping("/last")
    public Object getLastBid()
    {
       return bidPerContestService.getBidsOfContest().toArray()[bidPerContestService.getBidsOfContest().toArray().length-1];
    }

}