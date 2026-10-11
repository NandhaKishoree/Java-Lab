// Question: Write a Java program to connect to a MySQL database using JDBC and display a successful connection message.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter database name: ");
        String dbName = sc.nextLine();
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        String url = "jdbc:mysql://localhost:3306/" + dbName;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            con.close();
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}