package org.example.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadSqlFile {

    public String read(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return stringBuilder.toString();
    }
}
