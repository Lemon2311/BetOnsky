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

    public void patchBidOnContest( long bidId, Team team, User user, Contest contest){

        bidPerContestRepository.findById(bidId).setTeam(team);
        bidPerContestRepository.findById(bidId).setUser(user);
        bidPerContestRepository.findById(bidId).setContest(contest);

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

    public Optional<BidPerContest> getBidPerContest(long id) {
       return Optional.ofNullable(bidPerContestRepository.findById(id));

    }
}
