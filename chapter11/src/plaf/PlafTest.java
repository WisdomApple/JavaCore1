package plaf;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.32 2015-06-12
 */
public class PlafTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new PlafFrame();
            frame.setTitle("PlafTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
