import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        // scanner to read user input
        Scanner sc = new Scanner(System.in);

        //creating a library object
        Library library = new Library();

        //main loop to run the program menu
        while (true) {
            System.out.println(" ======= Library Management System ======== ");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3.Add User");
            System.out.println("4. View All Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            //taking user input for menu choice
            int choice = sc.nextInt();
            sc.nextLine();


            //switch case for menu choice
            switch (choice) {

                //case for adding book
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                //case for viewing all books    
                case 2:

                    library.getAllBooks();
                    break;

                //case for adding user    
                case 3:

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();
                    library.addUser(new User(userId, userName));
                    break;

                //case for viewing all users    
                case 4:

                    library.getAllUsers();
                    break;

                //case for issuing book
                case 5:

                    System.out.println("Enter Book Title.");
                    String bookTitleToIssue = sc.nextLine();
                    System.out.println("Enter User ID.");
                    int userToIssue = sc.nextInt();

                    library.issueBook(bookTitleToIssue, userToIssue);
                    break;

                //case for returning book
                case 6:
                    System.out.println("Enter Book Title.");
                    String bookTitleToReturn = sc.nextLine();
                    System.out.println("Enter User ID.");
                    int userToReturn = sc.nextInt();

                    library.returnBook(bookTitleToReturn, userToReturn);
                    break;

                //case for exiting the program
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                //default case for invalid choice
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }


        }

    }
}

//Book class
class Book {

    //Attributes of the book class
    private String title;
    private String author;
    private boolean isIssued;

    //Constructor for the book class
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    public void setBookIssued() {
        isIssued = true;
    }

    public void setBookReturned() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + " | Status: " + (isIssued ? "Issued" : "Available");
    }
}

//User class
class User {

    //Attributes of the user class
    private int userId;
    private String userName;
    private List<Book> booksBorrowed;

    //Constructor for the user class
    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.booksBorrowed = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }


    @Override
    public String toString() {
        return "User ID: " + userId + " | Name: " + userName + " | Books Borrowed: " + booksBorrowed.toString();
    }

}

class Library {

    //Attributes of the library class
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();

    //Add book methode
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added to the library.");
    }

    //Add user methode
    public void addUser(User user) {
        users.add(user);
        System.out.println("User '" + user.getUserName() + "' added to the library.");
    }

    //Get all books methode
    public void getAllBooks() {
        System.out.println("======== Books in the Library ========");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    //Get all users methode
    public void getAllUsers() {
        System.out.println("======== Users List ========");
        if (users.isEmpty()) {
            System.out.println("No users in the library.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }


    //Issue book methode
    public void issueBook(String title, int userId) {
        Book bookToIssue = null;
        User userToIssue = null;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookToIssue = book;
                break;
            }
        }

        for (User user : users) {
            if (user.getUserId() == (userId)) {
                userToIssue = user;
                break;
            }
        }

        if (bookToIssue == null) {
            System.out.println("Book '" + title + "' not found in the library.");
            return;
        }

        if (userToIssue == null) {
            System.out.println("User with ID '" + userId + "' not found in the library.");

            return;
        }

        if (bookToIssue.getIsIssued()) {
            System.out.println("Book '" + title + "' is already issued to someone else.");
            return;
        }

        bookToIssue.setBookIssued();
        userToIssue.getBooksBorrowed().add(bookToIssue);
        System.out.println("Book '" + title + "' issued to user ID: " + userId);
    }

    //Return book methode
    public void returnBook(String title, int userId) {

        Book bookToReturn = null;
        User userToReturn = null;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookToReturn = book;
                break;
            }
        }

        for (User user : users) {
            if (user.getUserId() == (userId)) {
                userToReturn = user;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("Book '" + title + "' not found in the library.");
            return;

        }

        if (userToReturn == null) {
            System.out.println("User with ID '" + userId + "' not found in the library.");

            return;
        }

        if (!bookToReturn.getIsIssued()) {
            System.out.println("Book '" + title + "' is not issued to user ID: " + userId);
            return;

        }

        bookToReturn.setBookReturned();
        userToReturn.getBooksBorrowed().remove(bookToReturn);
        System.out.println("Book '" + title + "' returned by user ID: " + userId);
    }

}