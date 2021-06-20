package colorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserPanel extends JPanel {
    public ColorChooserPanel() {
        JButton modalButton = new JButton("modal");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        JButton modelessButton = new JButton("Modeless");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);

        JButton immediateButton = new JButton("Immediate");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }

    /**
     * This listener pops up a modal color chooser
     */
    private class ModalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color defaultColor = getBackground();
            Color selectedColor = JColorChooser.showDialog(ColorChooserPanel.this,
                    "Set background", defaultColor);
            if (selectedColor != null) setBackground(selectedColor);
        }
    }


    /**
     * This listener pops up a modeless color chooser. The panel color is changed when the user
     * clicks the OK button.
     */
    private class ModelessListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ModelessListener() {
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color",
                    false /* not modal */, chooser,
                    e -> setBackground(chooser.getColor()),
                    null /* no Cancel button listener */);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }

    /**
     * This listener pops up a modeless color chooser. The panel color is changed immediately when
     * the user picks a new color.
     */
    private class ImmediateListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ImmediateListener() {
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(
                    e -> setBackground(chooser.getColor()));
            dialog = new JDialog((Frame) null, false /* no, modal */);
            dialog.add(chooser);
            dialog.pack();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
}
