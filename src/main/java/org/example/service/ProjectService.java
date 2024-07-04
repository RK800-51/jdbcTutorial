package org.example.service;

import java.sql.Connection;
import org.example.businesslogic.Util;
import org.example.dao.ProjectDAO;
import org.example.entity.Employee;
import org.example.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService extends Util implements ProjectDAO{

    Connection connection = getConnection();

    public ProjectService() throws SQLException {
    }

    @Override
    public void add(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "insert into project (id, title) values(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

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
    public List<Project> getAll() throws SQLException {
        List<Project> projectList = new ArrayList<>();
        String sql = "SELECT * FROM project;";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setTitle(resultSet.getString("title"));

                projectList.add(project);
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
        return projectList;
    }

    @Override
    public Project getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Project project = new Project();
        String sql = "select * from project where id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            project.setId(resultSet.getLong("id"));
            project.setTitle(resultSet.getString("title"));

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
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "update project set title = ? where id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());


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
    public void remove(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "delete from project where id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, project.getId());

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
