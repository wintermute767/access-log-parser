package ru.kotov.autotests;

import lombok.SneakyThrows;
import ru.kotov.autotests.office.Department;
import ru.kotov.autotests.office.Option;
import ru.kotov.autotests.office.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.*;

public class Main {

    static String url = "jdbc:h2:.\\Office";

    @SneakyThrows
    public static void main(String[] args) {

        Option.CLEAR_DB.action();
        System.out.println("Сотрудники до удаления");
        Option.PRINT_EMPLOYEES.action();

        Option.DeleteDepartment.action();
        checkDeleteWasSuccessful();

        System.out.println("Сотрудники после удаления");
        Option.PRINT_EMPLOYEES.action();

    }

    static public void checkDeleteWasSuccessful() {
        System.out.println("Какой id у удаленного депортамента:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Service.removeDepartment(new Department(id, ""));
        List employeeWhoMastBeDelete = new ArrayList();
        try (Connection con = DriverManager.getConnection(url)) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select name from Employee WHERE departmentid=" +id);
            while (rs.next()) {
                employeeWhoMastBeDelete.add(rs.getString("Name"));
            }
            if(employeeWhoMastBeDelete.size()!=0){
                System.out.println("Удаление прошло ошибочно.\nСотрудники, которые должны были быть удалены но остались в БД: "+employeeWhoMastBeDelete.toString());
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
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
                System.out.println("Количество сотрудников в IT-отделе - " + rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}