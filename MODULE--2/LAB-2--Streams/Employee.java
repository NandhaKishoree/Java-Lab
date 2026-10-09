// Q5: Develop a Java program for a simple employee record system. Accept employee ID, name, and salary from the user and store the details in a file using DataOutputStream. Read and display all stored employee details using DataInputStream. Use appropriate exception handling and stream-closing mechanisms.
//Combined File and Data Stream Application
import java.io.*;
import java.util.Scanner;
class Employee{
    public static void main(String[] args) {
        int id,salary;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name : ");
        name=sc.nextLine();
        System.out.println("Enter employee ID : ");
        id=sc.nextInt();
        System.out.println("Salary : ");
        salary=sc.nextInt();  
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("Employee.txt"));
            dos.writeInt(id);
            dos.writeUTF(name);
            dos.writeInt(salary);
            DataInputStream fis = new DataInputStream(new FileInputStream("Employee.txt"));
            fis.readInt();
            fis.readUTF();
            fis.readInt();
            System.out.println("Employee ID : "+id);
            System.out.println("Employee name : "+name);
            System.out.println("Salary : "+salary);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}