package com.project.bidPerContestEntity;

import com.project.Contest.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bidPerContest")
@CrossOrigin(origins = "http://localhost:4200")
public class BidPerContestController {

    @Autowired
    private BidPerContestService bidPerContestService;

    @PatchMapping("/bidPerContest/{name}/{bid}")
    public void patchBid(@PathVariable(name = "contest") Contest contest,
                         @PathVariable(name = "bid") double bid) {
        bidPerContestService.bidOnContest(bid, contest);

    }

    @GetMapping("/bidPerContest/{Contest}")
    public double getBidOfContest(@PathVariable(name="contest") Contest contest){
       return bidPerContestService.getBidOfContest(contest);
    }

}