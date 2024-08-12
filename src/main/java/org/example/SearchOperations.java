package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchOperations {
    public List<File> searchFiles(File dir, String searchTerm) {
        List<File> resultList = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (!file.isDirectory() && file.getName().contains(searchTerm)) {
                resultList.add(file);
            }
        }
        Logger.log("Search completed for: " + searchTerm + " in directory: " + dir.getAbsolutePath());
        return resultList;
    }
}
