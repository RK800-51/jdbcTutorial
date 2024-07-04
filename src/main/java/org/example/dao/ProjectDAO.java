package org.example.dao;

import org.example.entity.Employee;
import org.example.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDAO {
    // create
    void add(Project project) throws SQLException;

    // read
    List<Project> getAll() throws SQLException;

    Project getById(int id) throws SQLException;

    // update
    void update(Project project) throws SQLException;

    // delete
    void remove(Project project) throws SQLException;
}
