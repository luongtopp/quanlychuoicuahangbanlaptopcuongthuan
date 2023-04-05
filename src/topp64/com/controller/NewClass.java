/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topp64.com.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import static topp64.com.controller.DataController.getJDBCConnection;

/**
 *
 * @author luongtopp
 */
public class NewClass {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float a = 0;

        ArrayList<Float> ketSat = new ArrayList<Float>();

        Connection connection = getJDBCConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from KetSat");
            while (rs.next()) {
                ketSat.add(Float.parseFloat(rs.getString(1)));
                ketSat.add(Float.parseFloat(rs.getString(2)));
            }
           
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        float b = 0;
        System.out.println("Nhap so tien can rut: ");
        do {
            b = sc.nextFloat();
            if (b == 0) {
                System.out.println("Vui long nhap so tien can rut");
            }
        } while (b == 0);
        int i = 0;
        while (b != 0) {
            if (ketSat.get(i) < b && i % 2 == 0) {
                System.out.println("Menh gia: " + ketSat.get(i) + "So to: "
                        + "" + ketSat.get(i + 1));
                b = b - ketSat.get(i);
                continue;

            } else {
                 i++;
            }
            if(i>=9) {
                break;
            }
            System.out.println(b);
           
        }
        a = sc.nextFloat();
        System.out.println("So tien ban da rut la: ");
    }

}
