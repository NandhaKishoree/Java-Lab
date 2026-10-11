// Question: Develop a student registration program using PreparedStatement to insert and search student records based on user input.

import java.sql.*;
import java.util.Scanner;

public class PreparedState {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("username : ");
        String user = sc.nextLine();
        System.out.print("password : ");
        String password = sc.nextLine();
        System.out.print("database : ");
        String database = sc.nextLine();

        String url = "jdbc:mysql://localhost:3306/" + database;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");

            int choice = 0;
            while (choice != 3) {
                System.out.println("\n1.Register student  2.Search student  3.Exit");
                System.out.print("Enter choice : ");
                choice = sc.nextInt();

                if (choice == 1) {
                    // INSERT using PreparedStatement
                    System.out.print("Student id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Student name : ");
                    String name = sc.nextLine();
                    System.out.print("Marks : ");
                    int marks = sc.nextInt();

                    String insertSql = "INSERT INTO students VALUES (?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(insertSql);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, marks);

                    int rows = ps.executeUpdate();
                    System.out.println(rows + " student registered successfully!");
                    ps.close();

                } else if (choice == 2) {
                    // SEARCH using PreparedStatement
                    System.out.print("Enter student id to search : ");
                    int searchId = sc.nextInt();

                    String searchSql = "SELECT * FROM students WHERE id = ?";
                    PreparedStatement ps = con.prepareStatement(searchSql);
                    ps.setInt(1, searchId);

                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        System.out.println("---- Student Found ----");
                        System.out.println("ID    : " + rs.getInt("id"));
                        System.out.println("Name  : " + rs.getString("name"));
                        System.out.println("Marks : " + rs.getInt("marks"));
                    } else {
                        System.out.println("No student found with id " + searchId);
                    }
                    rs.close();
                    ps.close();

                } else if (choice == 3) {
                    System.out.println("Goodbye!");

                } else {
                    System.out.println("Invalid choice, try again.");
                }
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Operation error : " + e.getMessage());
        }
    }
}