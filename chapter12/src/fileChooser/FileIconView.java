package fileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.io.File;

/**
 * A file view that displays an icon for all files that match a file filter.
 */
public class FileIconView extends FileView {
    private FileFilter filter;
    private Icon icon;

    /**
     * Constructs a FileIconView.
     *
     * @param filter a file filter--all files that this filter accepts
     *               will be shown with the icon.
     * @param icon   the icon shown with all accepted files.
     */
    public FileIconView(FileFilter filter, Icon icon) {
        this.filter = filter;
        this.icon = icon;
    }

    public Icon getIcon(File file) {
        if (!file.isDirectory() && filter.accept(file)) return icon;
        else return null;
    }
}
