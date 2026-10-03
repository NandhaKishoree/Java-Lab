// 5. Write a Java program to demonstrate the implementation of multiple interfaces. Define interfaces Sports and Academics, each containing one method. Create a class Student that implements both interfaces and displays the student's academic and sports information.
interface Sports {
    void showSports();
}

interface Academics {
    void showAcademics();
}

class Student implements Sports, Academics {
    String name = "Shibhu";
    public void showSports() {
        System.out.println(name + " plays Cricket");
    }
    public void showAcademics() {
        System.out.println(name + " scored 85 marks in Java");
    }
}

public class MultipleInterface {
    public static void main(String[] args) {
        Student s = new Student();
        s.showAcademics();
        s.showSports();
    }
}