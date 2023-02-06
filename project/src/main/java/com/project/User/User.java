package com.project.User;

import com.project.Contest.Contest;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String password;

    private Boolean isAdmin;

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Contest> contests;


}
