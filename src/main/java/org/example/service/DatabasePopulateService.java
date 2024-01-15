package org.example.service;

import org.example.db.Database;
import org.example.db.ReadSqlFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    private static final ReadSqlFile readSqlFile = new ReadSqlFile();
    private static final String POPULATE_DB_SQL = "sql/populate_db.sql";

    public static void main(String[] args) {
        String sql = readSqlFile.read(POPULATE_DB_SQL);
        try(Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
