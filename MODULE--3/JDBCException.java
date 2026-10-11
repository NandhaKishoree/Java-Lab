// Question: Develop a JDBC application that handles connection errors, invalid SQL queries, duplicate records and invalid input using appropriate exception handling.

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JDBCException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("username : ");
        String user = sc.nextLine();
        System.out.print("password : ");
        String password = sc.nextLine();
        System.out.print("database : ");
        String database = sc.nextLine();

        String url = "jdbc:mysql://localhost:3306/" + database;
        Connection con;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            System.out.println("Connection error : " + e.getMessage());
            return;
        }

        int choice = 0;
        while (choice != 3) {
            try {
                System.out.println("\n1.Insert student  2.Run a SELECT query  3.Exit");
                System.out.print("Enter choice : ");
                choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Student id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Student name : ");
                    String name = sc.nextLine();
                    System.out.print("Marks : ");
                    int marks = sc.nextInt();
                    sc.nextLine();

                    PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES (?, ?, ?)");
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, marks);
                    ps.executeUpdate();
                    System.out.println("Student inserted successfully!");
                    ps.close();

                } else if (choice == 2) {
                    System.out.print("Enter SELECT query : ");
                    String sql = sc.nextLine();

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    int count = rs.getMetaData().getColumnCount();
                    while (rs.next()) {
                        for (int i = 1; i <= count; i++) {
                            System.out.print(rs.getString(i) + " | ");
                        }
                        System.out.println();
                    }
                    rs.close();
                    st.close();

                } else if (choice == 3) {
                    System.out.println("Goodbye!");
                    con.close();

                } else {
                    System.out.println("Invalid choice, try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input : please type a number where a number is needed.");
                sc.nextLine();
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Duplicate record : that id already exists. Use a new id.");
            } catch (SQLSyntaxErrorException e) {
                System.out.println("Invalid SQL : " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Database error : " + e.getMessage());
            }
        }
    }
}