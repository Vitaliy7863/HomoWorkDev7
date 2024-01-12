package org.example.service;

import org.example.db.Database;
import org.example.db.ReadSqlFile;
import org.example.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseQueryService {

    private final ReadSqlFile readSqlFile = new ReadSqlFile();
    public List<FindLongestProject> findLongestProject() {
        List<FindLongestProject> findLongestProjectList = new ArrayList<>();
        String urlFile = "sql/find_longest_project.sql";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(readSqlFile.read(urlFile));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                FindLongestProject findLongestProject = new FindLongestProject();
                findLongestProject.setProjectId(resultSet.getInt("PROJECT_ID"));
                findLongestProject.setMouthCount(resultSet.getInt("MONTHS_COUNT"));
                findLongestProjectList.add(findLongestProject);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findLongestProjectList;
    }

    public List<FindMaxProjectsClient> findMaxProjectsClients() {
        List<FindMaxProjectsClient> findMaxProjectsClientList = new ArrayList<>();
        String urlFile = "sql/find_max_projects_client.sql";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(readSqlFile.read(urlFile));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                FindMaxProjectsClient findMaxProjectsClient = new FindMaxProjectsClient();
                findMaxProjectsClient.setName(resultSet.getString("NAME"));
                findMaxProjectsClient.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                findMaxProjectsClientList.add(findMaxProjectsClient);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findMaxProjectsClientList;
    }

    public List<FindMaxSalaryWorker> findMaxSalaryWorker() {
        List<FindMaxSalaryWorker> findMaxSalaryWorkerList = new ArrayList<>();
        String urlFile = "sql/find_max_salary_worker.sql";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(readSqlFile.read(urlFile));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                FindMaxSalaryWorker findMaxSalaryWorker = new FindMaxSalaryWorker();
                findMaxSalaryWorker.setName(resultSet.getString("NAME"));
                findMaxSalaryWorker.setSalary(resultSet.getInt("SALARY"));
                findMaxSalaryWorkerList.add(findMaxSalaryWorker);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findMaxSalaryWorkerList;
    }

    public List<FindYoungestEldestWorkers> findYoungestEldestWorkers() {
        List<FindYoungestEldestWorkers> findYoungestEldestWorkersList = new ArrayList<>();
        String urlFile = "sql/find_youngest_eldest_workers.sql";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(readSqlFile.read(urlFile));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FindYoungestEldestWorkers findYoungestEldestWorkers = new FindYoungestEldestWorkers();
                findYoungestEldestWorkers.setType(resultSet.getString("TYPE"));
                findYoungestEldestWorkers.setName(resultSet.getString("NAME"));
                findYoungestEldestWorkers.setBirthday(resultSet.getDate("BIRTHDAY"));
                findYoungestEldestWorkersList.add(findYoungestEldestWorkers);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findYoungestEldestWorkersList;
    }

    public List<PrintProjectPrices> printProjectPrices() {
        List<PrintProjectPrices> printProjectPricesList = new ArrayList<>();
        String urlFile = "sql/print_project_prices.sql";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(readSqlFile.read(urlFile));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PrintProjectPrices printProjectPrices = new PrintProjectPrices();

                printProjectPrices.setProjectId(resultSet.getInt("PROJECT_ID"));
                printProjectPrices.setPrice(resultSet.getInt("PRICE"));
                printProjectPricesList.add(printProjectPrices);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return printProjectPricesList;
    }
}
