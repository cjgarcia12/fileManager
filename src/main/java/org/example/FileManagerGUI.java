package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileManagerGUI extends JFrame {
    private JButton deleteButton;
    private JButton copyButton;
    private JButton moveButton;
    private JButton createDirButton;
    private JButton searchButton;
    private JButton backButton;
    private JFileChooser jfc;
    private final FileOperations fileOperations;
    private final DirectoryOperations directoryOperations;
    private final SearchOperations searchOperations;

    public FileManagerGUI() {
        fileOperations = new FileOperations();
        directoryOperations = new DirectoryOperations();
        searchOperations = new SearchOperations();
        initializeGUI();
    }

    private void initializeGUI() {
        // Initialize the main JFrame
        setTitle("File Manager");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Initialize JFileChooser
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Add JFileChooser to the center of the frame
        add(jfc, BorderLayout.CENTER);

        // Initialize buttons
        deleteButton = new JButton("Delete");
        deleteButton.setEnabled(false);
        copyButton = new JButton("Copy");
        copyButton.setEnabled(false);
        moveButton = new JButton("Move");
        moveButton.setEnabled(false);
        createDirButton = new JButton("Create Directory");
        searchButton = new JButton("Search");
        backButton = new JButton("Back");

        // Add action listeners to buttons
        addDeleteButtonListener();
        addCopyButtonListener();
        addMoveButtonListener();
        addCreateDirButtonListener();
        addSearchButtonListener();
        addBackButtonListener();


        // Create a panel to hold buttons and set its layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(copyButton);
        buttonPanel.add(moveButton);
        buttonPanel.add(createDirButton);
        buttonPanel.add(searchButton);


        // Add the button panel to the top or bottom of the frame
        add(buttonPanel, BorderLayout.NORTH); // Or use BorderLayout.SOUTH to place at the bottom

        // Listener to enable/disable buttons based on selection
        jfc.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, evt -> {
            File selectedFile = jfc.getSelectedFile();
            boolean fileSelected = selectedFile != null;
            deleteButton.setEnabled(fileSelected);
            copyButton.setEnabled(fileSelected);
            moveButton.setEnabled(fileSelected);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addDeleteButtonListener() {
        deleteButton.addActionListener(e -> {
            File selectedFile = jfc.getSelectedFile();
            if (selectedFile != null) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete " + selectedFile.getName() + "?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (selectedFile.delete()) {
                        jfc.rescanCurrentDirectory();
                        jfc.setSelectedFile(null);
                        deleteButton.setEnabled(false);
                        Logger.log("Deleted " + selectedFile.getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Failed to delete the file.",
                                "Deletion Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void addBackButtonListener() {
        backButton.addActionListener(e -> {
            File currentDir = jfc.getCurrentDirectory();
            File parentDir = currentDir.getParentFile();
            if (parentDir != null) {
                jfc.setCurrentDirectory(parentDir);
            }
        });
    }
    private void addCopyButtonListener() {
        copyButton.addActionListener(e -> {
            File selectedFile = jfc.getSelectedFile();
            if (selectedFile != null) {
                JFileChooser destChooser = new JFileChooser();
                destChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = destChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File destDir = destChooser.getSelectedFile();
                    try {
                        fileOperations.copyFile(selectedFile, new File(destDir, selectedFile.getName()));
                        Logger.log("Copied " + selectedFile.getName() + " to " + destDir.getAbsolutePath());
                    } catch (IOException ex) {
                        Logger.log("Failed to copy " + selectedFile.getName() + ": " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void addMoveButtonListener() {
        moveButton.addActionListener(e -> {
            File selectedFile = jfc.getSelectedFile();
            if (selectedFile != null) {
                JFileChooser destChooser = new JFileChooser();
                destChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = destChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File destDir = destChooser.getSelectedFile();
                    try {
                        fileOperations.moveFile(selectedFile, new File(destDir, selectedFile.getName()));
                        jfc.rescanCurrentDirectory();
                        Logger.log("Moved " + selectedFile.getName() + " to " + destDir.getAbsolutePath());
                    } catch (IOException ex) {
                        Logger.log("Failed to move " + selectedFile.getName() + ": " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void addCreateDirButtonListener() {
        createDirButton.addActionListener(e -> {
            String dirName = JOptionPane.showInputDialog("Enter directory name:");
            if (dirName != null && !dirName.trim().isEmpty()) {
                File currentDir = jfc.getCurrentDirectory();
                directoryOperations.createDirectory(currentDir, dirName);
                jfc.rescanCurrentDirectory();
                Logger.log("Created directory " + dirName + " in " + currentDir.getAbsolutePath());
            }
        });
    }

    private void addSearchButtonListener() {
        searchButton.addActionListener(e -> {
            String searchTerm = JOptionPane.showInputDialog("Enter file name or extension to search:");
            if (searchTerm != null && !searchTerm.trim().isEmpty()) {
                File currentDir = jfc.getCurrentDirectory();
                List<File> results = searchOperations.searchFiles(currentDir, searchTerm);
                if (results.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No files found matching: " + searchTerm);
                } else {
                    StringBuilder resultMessage = new StringBuilder("Found files:\n");
                    for (File file : results) {
                        resultMessage.append(file.getAbsolutePath()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, resultMessage.toString());
                }
                Logger.log("Searched for " + searchTerm + " in " + currentDir.getAbsolutePath());
            }
        });
    }
}
