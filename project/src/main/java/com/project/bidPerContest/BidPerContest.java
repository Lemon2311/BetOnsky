package com.project.bidPerContest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.Contest.Contest;
import com.project.Team.Team;
import com.project.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bidPerContest")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class BidPerContest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Team team;

    double bid;

    @ManyToOne
    private User user;

    @ManyToOne
    private Contest contest;


    public BidPerContest(Contest contest, double bid, Team team, User user) {
        this.contest=contest;
        this.bid=bid;
        this.team=team;
        this.user=user;
    }
}
