package org.example.service;

import org.example.db.Database;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitService {

    private static final String INIT_DB_SQL = "INIT=RUNSCRIPT FROM 'sql/init_db.sql'";

    public static void main(String[] args) {
        try(Connection connection = Database.getConnection(INIT_DB_SQL)) {
            connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
