// Q2: Write a Java program that accepts a string from the user and writes it into a file named output.txt using FileOutputStream. If the file already exists, append the new content without deleting the existing data.
//FileOutputStream – Writing to a File
import java.io.*;
import java.util.Scanner;

class Write{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            FileOutputStream fs = new FileOutputStream("output.txt", true);
            fs.write(text.getBytes());

            fs.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        sc.close();
    }
}