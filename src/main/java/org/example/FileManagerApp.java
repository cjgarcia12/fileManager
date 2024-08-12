package org.example;

import javax.swing.SwingUtilities;

public class FileManagerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FileManagerGUI fileManagerGUI = new FileManagerGUI();
            fileManagerGUI.setVisible(true);
        });
    }
}
