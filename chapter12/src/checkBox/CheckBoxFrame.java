package checkBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A frame with a sample text label and check boxes for selecting font
 * attributes.
 */
public class CheckBoxFrame extends JFrame {
    private static final int FONT_SIZE = 24;
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;

    public CheckBoxFrame() {
        // add the sample text label

        label = new JLabel("The quick brow fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
        add(label, BorderLayout.CENTER);

        // this listener sets the font attribute of the label to check box state

        ActionListener listener = e -> {
            int mode = 0;
            if (bold.isSelected()) mode += Font.BOLD;
            if (italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode, FONT_SIZE));
        };

        // add the check boxes

        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
