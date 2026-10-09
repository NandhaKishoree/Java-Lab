import java.awt.*;
import java.awt.event.*;

class MouseKeyboard extends Frame {

    String message = "Move the mouse or press a key";

    MouseKeyboard() {

        setSize(500, 300);
        setTitle("Mouse and Keyboard Events");
        setVisible(true);

        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e) {

                message = "Mouse Position: X = "
                        + e.getX() + " Y = " + e.getY();

                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                message = "Mouse Clicked at X = "
                        + e.getX() + " Y = " + e.getY();

                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                message = "Key Pressed: " + e.getKeyChar();

                repaint();
            }
        });

        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 100);
    }

    public static void main(String[] args) {
        new MouseKeyboard();
    }
}