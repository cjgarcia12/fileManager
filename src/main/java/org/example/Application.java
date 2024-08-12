package org.example;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();

        while (true) {
            System.out.println("\nFile Manager Menu:");
            System.out.println("1. Display directory contents");
            System.out.println("2. Copy file");
            System.out.println("3. Move file");
            System.out.println("4. Delete file");
            System.out.println("5. Create directory");
            System.out.println("6. Delete directory");
            System.out.println("7. Search files");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Display directory contents");
                    break;
                case 2:
                    System.out.println("Copy file");
                    break;
                case 3:
                    System.out.println("Move file");
                    break;
                case 4:
                    System.out.println("Delete file");
                    break;
                case 5:
                    System.out.println("Create directory");
                    break;
                case 6:
                    System.out.println("Delete directory");
                    break;
                case 7:
                    System.out.println("Search files");
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
