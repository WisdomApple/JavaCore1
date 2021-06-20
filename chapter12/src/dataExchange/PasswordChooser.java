package dataExchange;

import javax.swing.*;
import java.awt.*;

/**
 * A password chooser that is shown inside a dialog
 */
public class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okBtn;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser() {
        setLayout(new BorderLayout());

        // construct a panel with user name and password fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("User name:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Password"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        // create Ok and Cancel buttons that terminate the dialog

        okBtn = new JButton("OK");
        okBtn.addActionListener(e -> {
            ok = true;
            dialog.setVisible(false);
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dialog.setVisible(false));

        // add buttons to southern border

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okBtn);
        buttonPanel.add(cancelBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Gets the dialog entries.
     *
     * @return a user object whose state represents the dialog entries
     */
    public User getUser() {
        return new User(username.getText(), password.getPassword());
    }

    /**
     * Sets the dialog default.
     *
     * @param user the default user information
     */
    public void setUser(User user) {
        username.setText(user.getName());
    }

    /**
     * Show the chooser panel in a dialog
     *
     * @param parent a component in the owner frame or null
     * @param title  the dialog window title
     */
    public boolean showDialog(Component parent, String title) {
        ok = false;

        // locate the owner frame
        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame) parent;
        else
            SwingUtilities.getAncestorOfClass(Frame.class, owner);

        // if first time, or if owner has changed, make new dialog

        if (dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okBtn);
            dialog.pack();
        }

        // set title and show dialog

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}
