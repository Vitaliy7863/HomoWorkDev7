package org.example.service;

import org.example.db.Database;
import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitService {

    public static void main(String[] args) {
        try(Connection connection = Database.getConnection()) {
            RunScript.execute(connection, new FileReader("sql/init_db.sql"));
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
