package com.project.bidPerContest;

import com.project.Contest.Contest;
import com.project.Team.Team;
import com.project.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bidPerContest")
@CrossOrigin(origins = "http://localhost:4200")
public class BidPerContestController {

    @Autowired
    private BidPerContestService bidPerContestService;

    @PutMapping("/bidPerContest/set/")
    public void setBid(@PathVariable(name = "contest") Contest contest,
                       @PathVariable(name = "bid") double bid,
                       @PathVariable(name = "team") Team team,
                       @PathVariable(name = "user") User user) {

        bidPerContestService.setBidPerContest(new BidPerContest(contest, bid, team, user));
    }

    @PatchMapping("/bidPerContest/patch/{contest}/{team}/{user}/{bid}")
    public void patchBid(@PathVariable(name = "contest") Contest contest,
                         @PathVariable(name = "bid") double bid,
                         @PathVariable(name = "team") Team team,
                         @PathVariable(name = "user") User user) {
        bidPerContestService.patchBidOnContest(bid, contest, team, user);

    }

    @GetMapping("/bidPerContest/{contest}")
    public double getBidOfContest(@PathVariable(name = "contest") Contest contest) {
        return bidPerContestService.getBidOfContest(contest);
    }

}