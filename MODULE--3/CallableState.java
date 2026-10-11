// Question: Create a MySQL stored procedure and invoke it from Java using CallableStatement. Take a student id from the user and display the student's name and marks returned by the procedure.

import java.sql.*;
import java.util.Scanner;

public class CallableState {
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

            System.out.print("Enter student id : ");
            int id = sc.nextInt();

            CallableStatement cs = con.prepareCall("{call get_student(?, ?, ?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.INTEGER);

            cs.execute();

            String name = cs.getString(2);
            int marks = cs.getInt(3);

            if (name != null) {
                System.out.println("---- Student Details ----");
                System.out.println("ID    : " + id);
                System.out.println("Name  : " + name);
                System.out.println("Marks : " + marks);
            } else {
                System.out.println("No student found with id " + id);
            }

            cs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Operation error : " + e.getMessage());
        }
    }
}