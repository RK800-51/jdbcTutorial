package org.example.dao;

import org.example.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    // create
    void add(Employee employee) throws SQLException;

    // read
    List<Employee> getAll() throws SQLException;
    Employee getById(int id) throws SQLException;

    // update
    void update(Employee employee) throws SQLException;

    // delete
    void remove(Employee employee) throws SQLException;
}
