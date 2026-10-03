// Question 9: Combined Problem – Student Management
class Student {

    String name;
    int roll_No, marks;

    public Student() {
        name = "Raju";
        roll_No = 70;
        marks = 45;
    }

    public Student(String n, int r, int m) {
        name = n;
        roll_No = r;
        marks = m;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll no : " + roll_No);
        System.out.println("Marks : " + marks);
        System.out.println("-----------------");
    }

    void calculateGrade(int mark) {
        if (mark >= 80) {
            System.out.println("Grade A");
        } else if (mark >= 60) {
            System.out.println("Grade B");
        } else if (mark >= 40) {
            System.out.println("Grade C");
        } else {
            System.out.println("Failed");
        }
    }

    void calculateGrade(double mark) {
        if (mark >= 80.0) {
            System.out.println("Grade A");
        } else if (mark >= 60.0) {
            System.out.println("Grade B");
        } else if (mark >= 40.0) {
            System.out.println("Grade C");
        } else {
            System.out.println("Failed");
        }
    }
}

class Manage {

    public static void main(String args[]) {
        Student obj1 = new Student();
        Student obj2 = new Student("Shibhu", 19, 99);
        Student obj3 = new Student();
        Student obj4 = new Student();
        obj3 = null;
        obj4 = null;
        obj1.display();
        obj2.display();
        obj1.calculateGrade(45);
        obj2.calculateGrade(99.0);
        System.gc();

    }
}
