package studentactions;

public class StudentBean {
    private String name = "Student";
    private String course = "Java";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        if (course != null && !course.trim().isEmpty()) {
            this.course = course.trim();
        }
    }
}
