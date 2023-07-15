package com.project.bidPerContest;

import com.project.Contest.Contest;
import com.project.Team.Team;
import com.project.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bidPerContest")
@CrossOrigin(origins = "http://localhost:4200")
public class BidPerContestController {

    @Autowired
    private BidPerContestService bidPerContestService;

    @PostMapping
    public void postBid(@RequestBody BidPerContest bid){
        bidPerContestService.setBidPerContest(bid);
    }

    @PutMapping("/set/")
    public void setBid(@PathVariable(name = "contest") Contest contest,
                       @PathVariable(name = "bid") double bid,
                       @PathVariable(name = "team") Team team,
                       @PathVariable(name = "user") User user) {

        bidPerContestService.setBidPerContest(new BidPerContest(contest, bid, team, user));
    }

    @PatchMapping("/patch/{contest}/{team}/{user}/{bid}")
    public void patchBid(@PathVariable(name = "contest") Contest contest,
                         @PathVariable(name = "bid") double bid,
                         @PathVariable(name = "team") Team team,
                         @PathVariable(name = "user") User user) {
        bidPerContestService.patchBidOnContest(bid, contest, team, user);

    }

    @GetMapping("/{contest}")
    public double getBidOfContest(@PathVariable(name = "contest") Contest contest) {
        return bidPerContestService.getBidOfContest(contest);
    }

    @GetMapping("/get")
    public List<BidPerContest> getBidsOfContest() {
        return bidPerContestService.getBidsOfContest();
    }

}