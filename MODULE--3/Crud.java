// Question: Write a Java program that connects to a MySQL database using JDBC and shows a menu to insert, read, update and delete student records until the user chooses exit.

import java.sql.*;
import java.util.Scanner;

class Crud {
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
            Statement st = con.createStatement();

            int choice = 0;
            while (choice != 5) {
                System.out.println("\n1.Insert  2.Read  3.Update  4.Delete  5.Exit");
                System.out.print("Enter choice : ");
                choice = sc.nextInt();

                if (choice == 1) {
                    // INSERT
                    System.out.print("Student id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Student name : ");
                    String name = sc.nextLine();
                    System.out.print("Marks : ");
                    int marks = sc.nextInt();

                    String sql = "INSERT INTO students VALUES(" + id + ",'" + name + "'," + marks + ")";
                    int rows = st.executeUpdate(sql);
                    System.out.println(rows + " row inserted");

                } else if (choice == 2) {
                    // READ
                    ResultSet rs = st.executeQuery("SELECT * FROM students");
                    System.out.println("---- All Students ----");
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " | "
                                + rs.getString("name") + " | "
                                + rs.getInt("marks"));
                    }
                    rs.close();

                } else if (choice == 3) {
                    // UPDATE
                    System.out.print("Student id to update : ");
                    int id = sc.nextInt();
                    System.out.print("New marks : ");
                    int marks = sc.nextInt();

                    String sql = "UPDATE students SET marks = " + marks + " WHERE id = " + id;
                    int rows = st.executeUpdate(sql);
                    if (rows > 0) {
                        System.out.println(rows + " row updated");
                    } else {
                        System.out.println("No student found with id " + id);
                    }

                } else if (choice == 4) {
                    // DELETE
                    System.out.print("Student id to delete : ");
                    int id = sc.nextInt();

                    String sql = "DELETE FROM students WHERE id = " + id;
                    int rows = st.executeUpdate(sql);
                    if (rows > 0) {
                        System.out.println(rows + " row deleted");
                    } else {
                        System.out.println("No student found with id " + id);
                    }

                } else if (choice == 5) {
                    System.out.println("Goodbye!");

                } else {
                    System.out.println("Invalid choice, try again.");
                }
            }

            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Operation error : " + e.getMessage());
        }
    }
}