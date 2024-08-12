package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    public void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public void moveFile(File source, File dest) throws IOException {
        Files.move(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public void deleteFile(File file) {
        if (file.delete()) {
            Logger.log("Deleted file: " + file.getAbsolutePath());
        } else {
            Logger.log("Failed to delete file: " + file.getAbsolutePath());
        }
    }
}
