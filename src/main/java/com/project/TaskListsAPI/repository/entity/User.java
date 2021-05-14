package com.project.TaskListsAPI.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USERS")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_role")
    private String role;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "parentchild",
//            joinColumns = @JoinColumn(name = "parent_id"),
//            inverseJoinColumns = @JoinColumn(name = "child_id")
//    )
//    private List<User> parents = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "parentchild",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<User> children=new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Task> tasks=new ArrayList<>();



}
