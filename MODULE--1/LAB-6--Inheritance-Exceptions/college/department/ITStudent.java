// 7. Create a package structure college.department. Define a class ITStudent inside the department sub-package with a method to display student information. Write another Java program to import and use this class.
package college.department;

public class ITStudent {
    String name = "Nandhu";
    int rollNo = 101;
    String department = "Information Technology";

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + department);
    }
}