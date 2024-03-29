package com.project.Contest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.Team.Team;
import com.project.User.User;
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
@Table(name = "contest")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Contest.class)
@JsonIdentityReference(alwaysAsId = true)
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany
    private List<BidPerContest> bidsPerContest;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "team_contest",
            inverseJoinColumns = @JoinColumn(name = "team_id"),
            joinColumns = @JoinColumn(name = "contest_id")
    )
    private List<Team> teams;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "contest_user",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;


}
