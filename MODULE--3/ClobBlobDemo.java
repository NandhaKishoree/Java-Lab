// Question: Store and retrieve an image using BLOB and a large text/document using CLOB.

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ClobBlobDemo {
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
                System.out.println("\n1.Store files  2.Retrieve files  3.Exit");
                System.out.print("Enter choice : ");
                choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Record id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Image file path : ");
                    String imagePath = sc.nextLine();
                    System.out.print("Text file path : ");
                    String textPath = sc.nextLine();

                    FileInputStream imageStream = new FileInputStream(imagePath);
                    FileReader textReader = new FileReader(textPath);

                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO file_store VALUES (?, ?, ?)");
                    ps.setInt(1, id);
                    ps.setBinaryStream(2, imageStream);
                    ps.setCharacterStream(3, textReader);

                    int rows = ps.executeUpdate();
                    System.out.println(rows + " record stored successfully!");

                    ps.close();
                    imageStream.close();
                    textReader.close();

                } else if (choice == 2) {
                    System.out.print("Record id to retrieve : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    PreparedStatement ps = con.prepareStatement(
                            "SELECT * FROM file_store WHERE id = ?");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        InputStream in = rs.getBinaryStream("image_data");
                        FileOutputStream out = new FileOutputStream("output_image.jpg");
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                        out.close();
                        in.close();
                        System.out.println("Image saved as output_image.jpg");

                        Reader reader = rs.getCharacterStream("text_data");
                        FileWriter writer = new FileWriter("output_text.txt");
                        char[] chars = new char[4096];
                        int charsRead;
                        while ((charsRead = reader.read(chars)) != -1) {
                            writer.write(chars, 0, charsRead);
                        }
                        writer.close();
                        reader.close();
                        System.out.println("Text saved as output_text.txt");
                    } else {
                        System.out.println("No record found with id " + id);
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
        } catch (SQLException | IOException e) {
            System.out.println("Operation error : " + e.getMessage());
        }
    }
}