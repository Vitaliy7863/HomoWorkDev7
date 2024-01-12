package org.example.service;

import org.example.db.Database;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePopulateService {

    private static final String POPULATE_DB_SQL = "INIT=RUNSCRIPT FROM 'sql/populate_db.sql'";

    public static void main(String[] args) {
        try(Connection connection = Database.getConnection(POPULATE_DB_SQL)) {
            connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
