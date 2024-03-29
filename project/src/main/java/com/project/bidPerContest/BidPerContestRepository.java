package com.project.bidPerContest;

import com.project.Contest.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidPerContestRepository extends JpaRepository<BidPerContest, Long> {

  BidPerContest findByContest(Contest contest);

  BidPerContest findById(long id);


}
