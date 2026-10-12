/*
Custom MVC example for student profile display.
*/
public class StudentMvcApp {
    public static void main(String[] args) {
        StudentModel studentModel = new StudentModel(101, "Asha", "Computer Science");
        StudentView studentView = new StudentView();
        StudentController studentController =
                new StudentController(studentModel, studentView);
        studentController.showStudentProfile();
    }
}
