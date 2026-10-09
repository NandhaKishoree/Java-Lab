import java.awt.*;
import java.awt.event.*;

class ColorSelection extends Frame implements ActionListener {

    Button red, green, blue;

    ColorSelection() {

        setLayout(new FlowLayout());

        red = new Button("Red");
        green = new Button("Green");
        blue = new Button("Blue");

        add(red);
        add(green);
        add(blue);

        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);

        setSize(400, 250);
        setTitle("Color Selection");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == red)
            setBackground(Color.RED);

        else if (e.getSource() == green)
            setBackground(Color.GREEN);

        else if (e.getSource() == blue)
            setBackground(Color.BLUE);
    }

    public static void main(String[] args) {
        new ColorSelection();
    }
}