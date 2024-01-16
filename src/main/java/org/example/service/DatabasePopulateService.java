package org.example.service;

import org.example.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.set.parameters.Parameters.setWorkerParameters;
import static org.example.set.parameters.Parameters.setClientParameters;
import static org.example.set.parameters.Parameters.setProjectParameters;
import static org.example.set.parameters.Parameters.setProjectWorkerParameters;

public class DatabasePopulateService {

    private static final String SQL_WORKER = "INSERT INTO worker (id, NAME, BIRTHDAY, LEVEL, SALARY) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_CLIENT = "INSERT INTO client(id, name) VALUES (?, ?)";

    private static final String SQL_PROJECT = "INSERT INTO project (id, client_id, start_date, finish_date) VALUES (?, ?, ?, ?)";

    private static final String SQL_PROJECT_WORKER = "INSERT INTO project_worker (project_id, worker_id)\n" +
            "VALUES (?, ?)";

    public static void main(String[] args) {
        try (Connection connection = Database.getConnection()) {
            workerInsert(connection);
            clientInsert(connection);
            projectInsert(connection);
            projectWorkerInsert(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void workerInsert(Connection connection) throws SQLException {
        PreparedStatement preparedWorker = connection.prepareStatement(SQL_WORKER);
        setWorkerParameters(preparedWorker, 1,"Ivan", "2004-01-16", "Trainee", 400);
        setWorkerParameters(preparedWorker,  2, "Vitaliy", "2003-04-21", "Junior", 600);
        preparedWorker.executeBatch();
    }

    private static void clientInsert(Connection connection) throws SQLException {
        PreparedStatement preparedClient = connection.prepareStatement(SQL_CLIENT);
        setClientParameters(preparedClient,1, "Nazar");
        setClientParameters(preparedClient, 2, "Andriy");
        preparedClient.executeBatch();
    }

    private static void projectInsert (Connection connection) throws SQLException {
        PreparedStatement preparedProject = connection.prepareStatement(SQL_PROJECT);
        setProjectParameters(preparedProject,1, 1, "2009-03-15", "2016-06-15");
        setProjectParameters(preparedProject, 2, 2, "2010-08-20", "2018-12-20");
        preparedProject.executeBatch();
    }
    private static void projectWorkerInsert (Connection connection) throws SQLException {
        PreparedStatement preparedProjectWorker = connection.prepareStatement(SQL_PROJECT_WORKER);
        setProjectWorkerParameters(preparedProjectWorker, 1, 1);
        setProjectWorkerParameters(preparedProjectWorker, 2, 2);
        preparedProjectWorker.executeBatch();
    }

}
