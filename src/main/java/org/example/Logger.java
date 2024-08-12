package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "file_manager.log";

    public static void log(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(LocalDateTime.now() + ": " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
