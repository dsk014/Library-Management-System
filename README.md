# Library-Management-System

A simple command-line application to manage a library system using Java.  
This program allows users to add books, add users, issue and return book, and \
view all records — continuously without restarting the program.

# Features

➡ Add new books to the library  
➡ View all available books with their issue status  
➡ Add new users  
➡ View all registered users with their borrowed books  
➡ Issue a book to a specific user  
➡ Return a book from a specific user  
➡ Continuous menu-driven interface using loops  
➡ Simple and user-friendly console design  

# How to Run

1. Make sure you have **Java** installed on your computer
2. Save the code in a file called **`LibraryManagementSystem.java`** inside a folder named **`src`**
3. Open your **terminal** or **command prompt**
4. Navigate to the folder where you saved the file
5. Compile the program using the command:

 ```
   javac LibraryManagementSystem.java
   ```
6. Run the program using the command:

   ```
   java LibraryManagementSystem
   ```

# Program Description

This application uses **ArrayList** collections to store books and users in memory.

Each **Book** record contains:

* Book Title
* Author Name
* Issue Status

Each **User** record contains:

* User ID
* User Name
* List of Borrowed Books

The program continuously displays a menu and performs actions based on user input until the user chooses to exit.
