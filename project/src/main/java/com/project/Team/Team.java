package com.project.Team;

import com.project.Contest.Contest;
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
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "team_contest",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn( name = "contest_id")
    )
    private List<Contest> contests;

    private String name;

    private int wins, looses;


}
