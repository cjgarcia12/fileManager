package org.example;

import java.io.File;

public class DirectoryOperations {
    public void createDirectory(File parentDir, String newDirName) {
        File newDir = new File(parentDir, newDirName);
        if (newDir.mkdir()) {
            Logger.log("Created directory: " + newDir.getAbsolutePath());
        } else {
            Logger.log("Failed to create directory: " + newDir.getAbsolutePath());
        }
    }

    public void deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                deleteDirectory(file);
            }
        }
        if (dir.delete()) {
            Logger.log("Deleted directory: " + dir.getAbsolutePath());
        } else {
            Logger.log("Failed to delete directory: " + dir.getAbsolutePath());
        }
    }
}
