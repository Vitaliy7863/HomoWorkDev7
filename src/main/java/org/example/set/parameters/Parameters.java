package org.example.set.parameters;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Parameters {

    public static void setWorkerParameters(PreparedStatement preparedStatement, int id, String name, String birthday,
                                           String level, int salary) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setDate(3, java.sql.Date.valueOf(birthday));
        preparedStatement.setString(4, level);
        preparedStatement.setInt(5, salary);
        preparedStatement.addBatch();
    }

    public static void setClientParameters(PreparedStatement preparedStatement, int id, String name) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.addBatch();
    }

    public static void setProjectParameters(PreparedStatement preparedStatement, int id, int clientId, String startDate,
                                            String finishDate) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, clientId);
        preparedStatement.setDate(3, java.sql.Date.valueOf(startDate));
        preparedStatement.setDate(4, java.sql.Date.valueOf(finishDate));
        preparedStatement.addBatch();
    }

    public static void setProjectWorkerParameters(PreparedStatement preparedStatement, int projectId, int workerId)
            throws SQLException {
        preparedStatement.setInt(1, projectId);
        preparedStatement.setInt(2, workerId);
        preparedStatement.addBatch();
    }
}
