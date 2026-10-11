// Question: Implement a bank money-transfer system using JDBC transactions. Use commit() when successful and rollback() when an error occurs.

import java.sql.*;
import java.util.Scanner;

public class Transaction{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("username : ");
        String user = sc.nextLine();
        System.out.print("password : ");
        String password = sc.nextLine();
        System.out.print("database : ");
        String database = sc.nextLine();

        String url = "jdbc:mysql://localhost:3306/" + database;
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");

            System.out.print("From account no : ");
            int from = sc.nextInt();
            System.out.print("To account no : ");
            int to = sc.nextInt();
            System.out.print("Amount : ");
            int amount = sc.nextInt();

            con.setAutoCommit(false);

            PreparedStatement debit = con.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE acc_no = ?");
            debit.setInt(1, amount);
            debit.setInt(2, from);
            debit.executeUpdate();

            PreparedStatement credit = con.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?");
            credit.setInt(1, amount);
            credit.setInt(2, to);
            credit.executeUpdate();

            con.commit();
            System.out.println("Transfer successful!");

            con.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            try {
                con.rollback();
                System.out.println("Transfer cancelled (rolled back).");
            } catch (SQLException ex) {
                System.out.println("Rollback error : " + ex.getMessage());
            }
        }
    }
}