// Question: Display the column names, column count, data types and other properties of a table dynamically using ResultSetMetaData.

import java.sql.*;
import java.util.Scanner;

public class ResultSetMetaDataDemo{
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

            System.out.print("table name : ");
            String table = sc.nextLine();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table);

            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();

            System.out.println("\nTable name   : " + rsmd.getTableName(1));
            System.out.println("Column count : " + count);

            System.out.println("\n---- Column Details ----");
            for (int i = 1; i <= count; i++) {
                System.out.println("Column " + i);
                System.out.println("  Name      : " + rsmd.getColumnName(i));
                System.out.println("  Type      : " + rsmd.getColumnTypeName(i));
                System.out.println("  Size      : " + rsmd.getColumnDisplaySize(i));
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Operation error : " + e.getMessage());
        }
    }
}