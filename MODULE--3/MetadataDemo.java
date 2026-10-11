// Question: Write a program to display database information such as database name, version, driver name, supported features and available tables using DatabaseMetaData.

import java.sql.*;
import java.util.Scanner;

public class MetadataDemo {
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

            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println("\n---- Database Information ----");
            System.out.println("Database name    : " + con.getCatalog());
            System.out.println("Product name     : " + dbmd.getDatabaseProductName());
            System.out.println("Version          : " + dbmd.getDatabaseProductVersion());
            System.out.println("URL              : " + dbmd.getURL());
            System.out.println("User             : " + dbmd.getUserName());

            System.out.println("\n---- Driver Information ----");
            System.out.println("Driver name      : " + dbmd.getDriverName());
            System.out.println("Driver version   : " + dbmd.getDriverVersion());

            System.out.println("\n---- Supported Features ----");
            System.out.println("Transactions     : " + dbmd.supportsTransactions());
            System.out.println("Batch updates    : " + dbmd.supportsBatchUpdates());
            System.out.println("Stored procedures: " + dbmd.supportsStoredProcedures());
            System.out.println("Outer joins      : " + dbmd.supportsOuterJoins());

            System.out.println("\n---- Available Tables ----");
            ResultSet rs = dbmd.getTables(database, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }

            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Operation error : " + e.getMessage());
        }
    }
}