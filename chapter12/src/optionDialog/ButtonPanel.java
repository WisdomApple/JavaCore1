package optionDialog;

import javax.swing.*;

/**
 * A panel with radio buttons inside a titled border.
 */
public class ButtonPanel extends JPanel {
    private ButtonGroup group;

    /**
     * Construct a button panel.
     *
     * @param title   the title shown in the button
     * @param options an array of radio button labels
     */
    public ButtonPanel(String title, String... options) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();

        // make one radio button for each option
        for (String option : options) {
            JRadioButton button = new JRadioButton(option);
            button.setActionCommand(option);
            add(button);
            group.add(button);
            button.setSelected(option == options[0]);
        }
    }

    /**
     * Gets the currently selected option.
     *
     * @return the label of the currently selected radio button.
     */
    public String getSelection() {
        return group.getSelection().getActionCommand();
    }
}
