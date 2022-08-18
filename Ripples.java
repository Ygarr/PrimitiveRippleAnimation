import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class Ripples extends JFrame {
public Ripples() {
    // window
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Ripples");
    setBounds(250, 250, 1000, 1000);
    setVisible(true);
    addMouseListener(new MouseListener() {

        public void mousePressed(MouseEvent e) {
            Animation animation = new Animation(e.getX(), e.getY());
            add(animation);
        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    });
}

public static void main(String[] args) {
    Ripples demo = new Ripples();
}

class Animation extends JPanel{
    private int radius;
    private int x;
    private int y;
    private Timer timer;

    Animation(int x, int y) {
        this.x = x;
        this.y = y;
        radius = 0;

        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (radius > 200) {
                    resetRadius();
                    timer.stop();
                }
                increaseRadius();
                revalidate();repaint();
            }
        });
        timer.start();
    }

    public void increaseRadius() {
        radius += 1;
    }

    public void resetRadius() {
        radius = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(x - (radius / 2), y - (radius / 2), radius, radius);
    }
}

}