# Simple File Manager Application

## Overview

This project is a simple file manager application built using Java Swing. It allows users to perform various file operations such as copying, moving, deleting files, creating directories, and searching for files within a specified directory. The user interface is designed to be intuitive and easy to use, with a set of buttons for each operation.

## Features

- **Display Directory Contents**: View the files and directories in a specified directory.
- **Copy Files**: Copy selected files to a chosen directory.
- **Move Files**: Move selected files to a different directory.
- **Delete Files**: Delete selected files.
- **Create Directories**: Create a new directory within the current directory.
- **Search Files**: Search for files by name or extension within the current directory (excluding subdirectories).
- **User Interface**: Simple and clean GUI with buttons organized horizontally for ease of access.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or later
- An IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with Java support
- Git (optional, for cloning the repository)

### Steps to Run

1. **Clone the Repository** (if using Git):
   ```bash
   git clone https://github.com/yourusername/file-manager-app.git
   cd file-manager-app
   ```
   Compile and Run:

Open the project in your IDE.
Run the FileManagerApp.java file to start the application.
Alternatively, you can compile and run the project from the command line:

```bash
javac -d bin src/org/example/*.java
java -cp bin org.example.FileManagerApp
```

## Usage

- **Browse Files**: Use the file explorer to navigate through your directories.
- **Copy/Move/Delete Files**: Select a file and use the corresponding button to perform the operation.
- **Create Directory**: Use the "Create Directory" button to create a new folder in the current directory.
- **Search Files**: Click the "Search" button to search for files by name or extension in the current directory.

## Differences Across Operating Systems

The application should run consistently across different operating systems since it is built using Java Swing, which is designed to be platform-independent. However, there may be some visual and functional differences depending on the OS:

### Windows

- **File Paths**: Displayed with backslashes (`\`), e.g., `C:\Users\YourName\Documents`.
- **Look and Feel**: The default Swing look and feel may resemble the Windows classic theme. Button styles, fonts, and icons may differ slightly.

### macOS

- **File Paths**: Displayed with forward slashes (`/`), e.g., `/Users/YourName/Documents`.
- **Look and Feel**: macOS’s Aqua look and feel may be applied by default. The UI might look more polished, with different button shapes and colors.

### Linux

- **File Paths**: Displayed with forward slashes (`/`), e.g., `/home/yourname/Documents`.
- **Look and Feel**: Depending on the desktop environment (e.g., GNOME, KDE), the look and feel might vary. Button styles and font rendering may differ based on the system’s theme.

## Logging and Error Handling

The application logs all file operations and errors to a `file_manager.log` file located in the project directory. This file records actions such as file deletions, copies, moves, and any errors that occur during these operations.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.


### **Explanation:**

- **Overview**: Brief introduction to the project, highlighting its purpose and features.
- **Installation**: Instructions for setting up the project, including prerequisites and steps to run the application.
- **Usage**: Describes how to use the main features of the application.
- **Differences Across Operating Systems**: Notes on how the application might behave differently on Windows, macOS, and Linux.
- **Logging and Error Handling**: Information about how logging is handled in the application.
- **Contributing**: Encourages contributions and explains how to do so.
- **License**: Specifies the license under which the project is released.

This README should provide all the necessary information for users and developers to understand, set up, and work with the file manager application.
