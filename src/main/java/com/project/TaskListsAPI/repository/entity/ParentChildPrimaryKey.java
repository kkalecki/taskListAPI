package com.project.TaskListsAPI.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentChildPrimaryKey implements Serializable {

    public long parent_id;
    public long child_id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentChildPrimaryKey that = (ParentChildPrimaryKey) o;
        return parent_id == that.parent_id && child_id == that.child_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent_id, child_id);
    }
}
