// 4. Define an interface Printable with a method print(). Create classes Student and Teacher that implement the interface. Write a program to display the details of a student and a teacher using the print() method.
interface Printable {
    void print();
}

class Student implements Printable {
    String name = "Nandhu";
    int rollNo = 101;
    public void print() {
        System.out.println("Student Name: " + name + ", Roll No: " + rollNo);
    }
}

class Teacher implements Printable {
    String name = "Mr Kumar";
    String subject = "Java";
    public void print() {
        System.out.println("Teacher Name: " + name + ", Subject: " + subject);
    }
}

public class Interface {
    public static void main(String[] args) {
        Printable obj1 = new Student();
        Printable obj2 = new Teacher();

        obj1.print();
        obj2.print();
    }
}