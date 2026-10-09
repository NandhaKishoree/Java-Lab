// Q4: Write a Java program to copy the contents of one file into another using BufferedInputStream and BufferedOutputStream.
//BufferedInputStream and BufferedOutputStream
import java.io.*;
import java.util.Scanner;

class FileCopy{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter source file: ");
            String source = sc.nextLine();
            System.out.print("Enter destination file: ");
            String destination = sc.nextLine();

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination));

            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            bos.close();
            bis.close();
            System.out.println("File copied");
        }
        catch (IOException e) {
            System.out.println(e);
        }
        sc.close();
    }
}