package studentapp;

public class Student {
    private String name;
    private String course;

    public Student() {
        this.name = "Student";
        this.course = "Java";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
