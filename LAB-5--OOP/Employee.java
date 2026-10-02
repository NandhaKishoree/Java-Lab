// Question 2: Employee Details
import java.util.Scanner;

class Details {

    String name;
    int id, salary;

    public void input(Scanner sc) {
        System.out.print("Enter Student name : ");
        name = sc.nextLine();
        System.out.print("Enter ID : ");
        id = sc.nextInt();
        System.out.print("Enter salary : ");
        salary = sc.nextInt();
        sc.nextLine();
    }

    public void show_methods() {
        System.out.println("-------------------");
        System.out.println("Student name : " + name);
        System.out.println("ID number : " + id);
        System.out.println("Salary : " + salary);
    }
}
    class Employee {

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            Details e1 = new Details();
            Details e2 = new Details();
            Details e3 = new Details();
            System.out.println("----Employee 1 details----");
            e1.input(sc);
            System.out.println("----Employee 2 details----");
            e2.input(sc);
            System.out.println("----Employee 3 details----");
            e3.input(sc);
            e1.show_methods();
            e2.show_methods();
            e3.show_methods();
        }
    }



