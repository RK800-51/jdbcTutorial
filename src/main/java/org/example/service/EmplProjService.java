package org.example.service;

import org.example.businesslogic.Util;
import org.example.dao.EmplProjDAO;
import org.example.entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {

    Connection connection = getConnection();

    public EmplProjService() throws SQLException {
    }

    @Override
    public void add(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "insert into empl_proj (employee_id, project_id) values(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public List<EmplProj> getAll() throws SQLException {
        List<EmplProj> emplprojList = new ArrayList<>();
        String sql = "SELECT * FROM empl_proj;";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmplProj empl_proj = new EmplProj();
                empl_proj.setEmployeeId(resultSet.getLong("employee_id"));
                empl_proj.setProjectId(resultSet.getLong("project_id"));


                emplprojList.add(empl_proj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return emplprojList;
    }

    @Override
    public EmplProj getById(Long employeeId, Long projectId) throws SQLException {
        PreparedStatement preparedStatement = null;
        EmplProj emplproj = new EmplProj();
        String sql = "select * from empl_proj where employee_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employeeId);

            ResultSet resultSet = preparedStatement.executeQuery();
            emplproj.setProjectId(resultSet.getLong("project_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return emplproj;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "update empl_proj set project_id = ? where employee_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplProj.getProjectId());
            preparedStatement.setLong(2, emplProj.getEmployeeId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public void remove(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "delete from empl_proj where employee_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplProj.getEmployeeId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}
