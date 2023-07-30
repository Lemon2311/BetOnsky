package com.project.Team;

import com.fasterxml.jackson.annotation.*;
import com.project.Contest.Contest;
import com.project.bidPerContest.BidPerContest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Team.class)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<BidPerContest> bidsPerContest;

    @ManyToMany(mappedBy = "teams", cascade = CascadeType.PERSIST)
    private List<Contest> contests;

    private String name;

    private int wins, losses;


}
