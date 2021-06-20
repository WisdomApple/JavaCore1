package fileChooser;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * A file chooser accessory that previews images.
 */
public class ImagePreviewer extends JLabel {
    /**
     * Constructs an ImagePreviewer.
     *
     * @param chooser the file chooser whose property changes
     *                trigger an image change in this previewer
     */
    public ImagePreviewer(JFileChooser chooser) {
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createEtchedBorder());

        chooser.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                File file = (File) evt.getNewValue();
                if (file == null) {
                    setIcon(null);
                    return;
                }

                // read the image into an icon
                ImageIcon icon = new ImageIcon(file.getPath());

                // if the icon is too large to fit, scale it
                if (icon.getIconWidth() > getWidth())
                    icon = new ImageIcon(icon.getImage().getScaledInstance(
                            getWidth(), -1, Image.SCALE_DEFAULT));

                setIcon(icon);
            }
        });
    }
}
