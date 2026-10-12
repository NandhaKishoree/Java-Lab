public class StudentView {
    public void display(StudentModel studentModel) {
        System.out.println("Student ID: " + studentModel.getStudentId());
        System.out.println("Student Name: " + studentModel.getStudentName());
        System.out.println("Course Name: " + studentModel.getCourseName());
    }
}
