/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topp64.com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luongtopp
 */
public class DataController {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:3306/ATM";
        final String user = "root";
        final String password = "27112017";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String query = "SELECT * from KetSat";

        Connection connection = getJDBCConnection();

        if (connection != null) {
            System.out.println("Thành công");
        } else {
            System.out.println("Thất bại");

        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1) +" so to: " + rs.getString(2));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
