package com.project.bidPerContestEntity;

import com.project.Contest.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidPerContestService {

    @Autowired
    private BidPerContestRepository bidPerContestRepository;
    public void bidOnContest(double bid, Contest contest){
        bidPerContestRepository.findByContest(contest).setBid(bid);
    }

    public double getBidOfContest(Contest contest){
       return bidPerContestRepository.findByContest(contest).getBid();
    }
}
