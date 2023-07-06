package com.project.bidPerContestEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.Contest.Contest;
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
@Table(name = "bidPerContestEntity")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class BidPerContest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    double bid;

    @ManyToMany
    private User user;

    @OneToMany
    private Contest contest;


}
