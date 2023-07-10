package com.project.User;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.Contest.Contest;
import com.project.bidPerContest.BidPerContest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String password;

    private boolean loggedIn;

    private Boolean isAdmin;

    @OneToMany
    private List<BidPerContest> bidPerContest;

    @ManyToMany(mappedBy = "users",cascade = CascadeType.PERSIST)
    private List<Contest> contests;


}
