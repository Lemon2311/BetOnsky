package com.project.Contest;

import com.project.Team.Team;
import com.project.User.User;
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
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "contests",cascade = CascadeType.ALL)
    private List<Team> teams;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "contest_user",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn( name = "user_id")
    )
    private List<User> users;


}
