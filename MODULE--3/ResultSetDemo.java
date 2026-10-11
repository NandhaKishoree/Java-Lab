// Question: Retrieve student records and demonstrate ResultSet navigation methods such as next(), previous(), first(), last() and absolute().

import java.sql.*;
import java.util.Scanner;

public class ResultSetDemo {

    static void showRow(ResultSet rs) throws SQLException {
        System.out.println("Row " + rs.getRow() + " : "
                + rs.getInt("id") + " | "
                + rs.getString("name") + " | "
                + rs.getInt("marks"));
    }

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

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("\n--- next() : all rows forward ---");
            while (rs.next()) {
                showRow(rs);
            }

            System.out.println("\n--- first() ---");
            if (rs.first()) {
                showRow(rs);
            }

            System.out.println("\n--- last() ---");
            if (rs.last()) {
                showRow(rs);
            }

            System.out.println("\n--- previous() : move one row back from last ---");
            if (rs.previous()) {
                showRow(rs);
            }

            System.out.print("\nEnter row number for absolute() : ");
            int n = sc.nextInt();
            if (rs.absolute(n)) {
                System.out.println("--- absolute(" + n + ") ---");
                showRow(rs);
            } else {
                System.out.println("Row " + n + " does not exist.");
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Operation error : " + e.getMessage());
        }
    }
}