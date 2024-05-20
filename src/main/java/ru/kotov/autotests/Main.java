package ru.kotov.autotests;

import ru.kotov.autotests.office.Option;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static String url = "jdbc:h2:.\\Office";

    public static void main(String[] args) {

        Option.CLEAR_DB.action();

        searchAnnAndSetDepartment();
        correctCapitalLetterInName();
        getCountEmployeeInITDepartment();
        
        Option.PRINT_EMPLOYEES.action();
    }

    static public void searchAnnAndSetDepartment() {
        try (Connection con = DriverManager.getConnection(url)) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Employee WHERE Name='Ann'");
            Map<Integer, String> employeeNameWithNameAnn = new HashMap<>();
            while (rs.next()) {
                employeeNameWithNameAnn.put(rs.getInt("Id"), rs.getString("Name"));
            }
            if (employeeNameWithNameAnn.size() == 1) {
                int employeeId = employeeNameWithNameAnn.keySet().stream().findFirst().get();
                statement.executeUpdate("UPDATE employee SET departmentid=(select id from department where name='HR') where name='Ann'");
                statement.executeUpdate("commit");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    static public void correctCapitalLetterInName() {
        int countNameWithError = 0;
        try (Connection con = DriverManager.getConnection(url)) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select id, name from Employee");
            while (rs.next()) {
                if (Character.isLowerCase(rs.getString("name").charAt(0))) {
                    String rightName = Character.toUpperCase(rs.getString("name").charAt(0)) + rs.getString("name").substring(1, rs.getString("name").length());
                    rs.updateString("name", rightName);
                    rs.updateRow();
                    countNameWithError++;
                }
            }
            System.out.println("количество исправленных имён - " + countNameWithError);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    static public void getCountEmployeeInITDepartment() {
        try (Connection con = DriverManager.getConnection(url)) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select count(*) cnt3 from Employee where departmentid = (select id from department where name = 'IT')");
            while (rs.next()) {
                System.out.println("Количество сотрудников в IT-отделе - "+rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}