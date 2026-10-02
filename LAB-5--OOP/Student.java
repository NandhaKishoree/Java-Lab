// Question 1: Student Details Using Class and Object
import java.util.Scanner;
class Details{
   String name ;
   int roll_no;
   double marks;
   public void info(){
    System.out.println("The student name is "+name+".His role number is "+roll_no+" and marks are "+marks);
   }
}
class Student{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Details d = new Details();
        System.out.print("Enter name: ");
        d.name = sc.nextLine();
        d.roll_no=sc.nextInt();
        d.marks = sc.nextDouble();
        d.info();

    }
}