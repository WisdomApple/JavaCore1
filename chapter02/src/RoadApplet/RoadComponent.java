package RoadApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RoadComponent extends JComponent {
    private Road freeway;
    private BufferedImage buffer;
    private int row;
    private int x_size;
    private int y_size;

    public RoadComponent() {
        freeway = new Road();
        row = 0;
    }

    public void update(double slowdown, double arrival) {
        freeway.update(slowdown, arrival);
        Graphics g;
        if (buffer == null) {
            x_size = getWidth();
            y_size = getHeight();
            if (x_size == 0 || y_size == 0) return;
            buffer = new BufferedImage(x_size, y_size, BufferedImage.TYPE_INT_ARGB);
            g = buffer.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, x_size, y_size);
        } else
            g = buffer.getGraphics();

        int DOT_SIZE = 2;
        if (row < y_size - 2 * DOT_SIZE)
            row += DOT_SIZE;
        else {
            g.copyArea(0, DOT_SIZE, x_size, y_size - DOT_SIZE, 0, -DOT_SIZE);
        }
        int x_DOT_DIST = 1;
        freeway.paint(g, row, x_DOT_DIST, DOT_SIZE);
        g.dispose();
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (buffer != null)
            g.drawImage(buffer, 0, 0, null);
    }
}

class Road {
    public static final int LENGTH = 400;
    public static final int MAX_SPEED = 5;

    private int[] speed;
    private Color[] colors;
    private int count;

    public Road() {
        speed = new int[LENGTH];
        colors = new Color[LENGTH];
        for (int i = 0; i < LENGTH; i++) speed[i] = -1;
    }

    public void update(double prob_slowdown, double prob_create) {
        int i = 0;
        while (i < LENGTH && speed[i] == -1)
            i++;
        while (i < LENGTH) {
            if (Math.random() <= prob_slowdown && speed[i] > 0)
                speed[i]--;
            else if (speed[i] < MAX_SPEED)
                speed[i]++;
            int i_next = i + 1;
            while (i_next < LENGTH && speed[i_next] == -1)
                i_next++;
            if (i_next < LENGTH) {
                if (speed[i] >= i_next - i)
                    speed[i] = i_next - i - 1;
            }
            if (speed[i] > 0) {
                if (i + speed[i] < LENGTH) {
                    int ni = i + speed[i];
                    speed[ni] = speed[i];
                    colors[ni] = colors[i];
                }
                speed[i] = -1;
            }
            i = i_next;
        }
        if (Math.random() <= prob_create && speed[0] == -1) {
            speed[0] = (int) (5.99 * Math.random());
            colors[0] = ++count % 10 == 0 ? Color.red : Color.black;
        }
    }

    public void paint(Graphics g, int row, int dotdist, int dotsize) {
        g.setColor(Color.WHITE);
        g.fillRect(0, row, LENGTH * dotsize, dotsize);
        for (int i = 0; i < LENGTH; i++) {
            if (speed[i] >= 0) {
                g.setColor(colors[i]);
                g.fillRect(i * dotdist, row, dotsize, dotsize);
            }
        }
    }
}

