// Q3: Write a Java program to store the details of a student (roll number, name, and marks) in a file using DataOutputStream. Then, read the same data from the file using DataInputStream and display the student details.
//DataInputStream and DataOutputStream
import java.io.*;
import java.util.Scanner;

class Student{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();

            DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"));
            dos.writeInt(roll);
            dos.writeUTF(name);
            dos.writeDouble(marks);
            dos.close();

            DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));
            System.out.println("Roll: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("Marks: " + dis.readDouble());
            dis.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        sc.close();
    }
}