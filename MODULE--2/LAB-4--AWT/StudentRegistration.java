import java.awt.*;
import java.awt.event.*;

class StudentRegistration extends Frame implements ActionListener {

    TextField name, regno;
    Choice course;
    Checkbox male, female;
    Checkbox java, python;
    Button submit, clear;
    Label result;

    StudentRegistration() {

        setTitle("Student Registration");
        setSize(400, 400);
        setLayout(new BorderLayout());

        Panel form = new Panel();
        form.setLayout(new FlowLayout());

        form.add(new Label("Name:"));
        name = new TextField(20);
        form.add(name);

        form.add(new Label("Register No:"));
        regno = new TextField(20);
        form.add(regno);

        form.add(new Label("Course:"));
        course = new Choice();
        course.add("BCS");
        course.add("BCA");
        course.add("BBA");
        form.add(course);

        form.add(new Label("Gender:"));

        male = new Checkbox("Male");
        female = new Checkbox("Female");

        form.add(male);
        form.add(female);

        form.add(new Label("Hobbies:"));

        java = new Checkbox("Java");
        python = new Checkbox("Python");

        form.add(java);
        form.add(python);

        submit = new Button("Submit");
        clear = new Button("Clear");

        form.add(submit);
        form.add(clear);

        result = new Label();

        add(form, BorderLayout.CENTER);
        add(result, BorderLayout.SOUTH);

        submit.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            result.setText(
                "Name: " + name.getText()
                + " Reg No: " + regno.getText()
            );
        }

        if (e.getSource() == clear) {

            name.setText("");
            regno.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}