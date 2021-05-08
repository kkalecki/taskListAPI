package com.project.TaskListsAPI.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(ParentChildPrimaryKey.class)
@Table(name = "parentchild")
public class ParentChild {
    @Id
    @Column(name = "parent_id")
    private long parent_id;
    @Id
    @Column(name = "child_id")
    private long child_id;

}
