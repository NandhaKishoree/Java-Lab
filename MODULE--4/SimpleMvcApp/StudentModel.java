public class StudentModel {
    private int studentId;
    private String studentName;
    private String courseName;

    public StudentModel(int studentId, String studentName, String courseName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getCourseName() {
        return this.courseName;
    }
}
