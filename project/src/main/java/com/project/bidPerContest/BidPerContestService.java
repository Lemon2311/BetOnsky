package com.project.bidPerContest;

import com.project.Contest.Contest;
import com.project.Team.Team;
import com.project.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidPerContestService {

    @Autowired
    private BidPerContestRepository bidPerContestRepository;

    public void patchBidOnContest(double bid, Contest contest, Team team, User user){
        bidPerContestRepository.findByContest(contest).setBid(bid);
        bidPerContestRepository.findByContest(contest).setContest(contest);
        bidPerContestRepository.findByContest(contest).setTeam(team);
    }

    public double getBidOfContest(Contest contest){
       return bidPerContestRepository.findByContest(contest).getBid();
    }

    public void setBidPerContest(BidPerContest bidPerContest){
        bidPerContestRepository.save(bidPerContest);
    }

    public List<BidPerContest> getBidsOfContest(){
        return bidPerContestRepository.findAll();
    }
}
