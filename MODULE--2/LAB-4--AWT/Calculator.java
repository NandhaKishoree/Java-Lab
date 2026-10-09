import java.awt.*;
import java.awt.event.*;

class Calculator extends Frame implements ActionListener {

    TextField num1, num2, result;
    Button add, sub, mul, div;

    Calculator() {

        setLayout(new FlowLayout());

        add(new Label("Number 1:"));
        num1 = new TextField(10);
        add(num1);

        add(new Label("Number 2:"));
        num2 = new TextField(10);
        add(num2);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        add(add);
        add(sub);
        add(mul);
        add(div);

        result = new TextField(15);
        result.setEditable(false);
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setSize(400, 250);
        setTitle("Calculator");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double r = 0;

            if (e.getSource() == add)
                r = a + b;

            else if (e.getSource() == sub)
                r = a - b;

            else if (e.getSource() == mul)
                r = a * b;

            else if (e.getSource() == div) {

                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }

                r = a / b;
            }

            result.setText(String.valueOf(r));
        }

        catch (Exception ex) {
            result.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}