import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // collection of library books
        ArrayList<Books> bookCollection = new ArrayList<Books>();
        // collection of library members
        ArrayList<Users> userCollection = new ArrayList<Users>();
        System.out.println("Welcome to the Library\n");
        // runs until person decides to exit
        while (true) {
            // home menu
            System.out.println("What would you like to do? Enter 0 to quit");
            System.out.println("1. Manage books");
            System.out.println("2. Manage users");
            int menuSelect = input.nextInt();
            // ends program if user enters 0
            if (menuSelect == 0) {
                break;
            }
            // book menu
            else if (menuSelect == 1) {
                // outputs options to the screen
                System.out.println("What would you like to do? Enter 0 to go back");
                System.out.println("1. Add a new book to the library collection");
                System.out.println("2. List all the books");
                System.out.println("3. Search for a book");
                System.out.println("4. Lend a book");
                System.out.println("5. Process a book return");
                // lets user decide what option to decide
                menuSelect = input.nextInt();
                switch (menuSelect) {
                    case 0:
                        continue;
                    case 1:
                        addBook(bookCollection);
                        break;
                    case 2:
                        listBooks(bookCollection);
                        break;
                    case 3:
                        searchBook(bookCollection);
                        break;
                    case 4:
                        lendBook(bookCollection, userCollection);
                        break;
                    case 5:
                        returnBook(bookCollection, userCollection);
                }
            }
            // user menu
            else if (menuSelect == 2) {
                // outputs options to the screen
                System.out.println("What would you like to do? Enter 0 to go back");
                System.out.println("1. Register a new user");
                System.out.println("2. Find overdue users");
                System.out.println("3. Ban a user");
                // lets user decide what option to decide
                menuSelect = input.nextInt();
                switch (menuSelect) {
                    case 0:
                        continue;
                    case 1:
                        registerUser(userCollection);
                        break;
                    case 2:
                        fineUsers(bookCollection, userCollection);
                        break;
                    case 3:
                        banUser(userCollection);
                        break;
                }
            }
            // if user enters an option not provide, error message appears
            else {
                System.out.println("Please enter only 1 for book options, 2 user options, or 0 to quit.\n");
            }
        }
    }

// --------------------- BOOK METHODS ---------------------

    // adds a new book to the library
    public static void addBook(ArrayList<Books> bookCollection) {
        Scanner input = new Scanner(System.in);
        // gets book name from user
        System.out.println("Enter book name:");
        String bookName = input.nextLine();
        // gets author(s) from user
        System.out.println("Enter the author(s). if multiple, separate by a comma, no space:");
        String[] authors = input.nextLine().split(",");
        // creates book object and adds it to the library collection
        Books newBook = new Books(bookName, authors);
        bookCollection.add(newBook);
        // confirmation that the book was added
        System.out.println("Book successfully added\n");
    }

    // lists the library books and relevant information
    public static void listBooks(ArrayList<Books> bookCollection) {
        for (int i = 0; i < bookCollection.size(); i++) {
            // prints a relative number, Book 1, Book2, ... BookN
            System.out.println("-------- Book " + (i + 1) + " --------");
            System.out.println(bookCollection.get(i).getBookInfo());
            System.out.println();
        }
    }

    // lets the user see if a book is in the system
    public static void searchBook(ArrayList<Books> bookCollection) {
        Scanner input = new Scanner(System.in);
        // user enters book title
        System.out.println("Enter book title to search for:");
        String bookTitle = input.nextLine();
        boolean bookFound = false;
        for (Books book : bookCollection) {
            // compares each book in the library with the user input
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                // if found, gives more information on the book
                System.out.println("Book found. Here's more information on " + bookTitle + ":");
                System.out.println(book.getBookInfo() + "\n");
                bookFound = true;
                break;
            }
        }
        // if book isn't found, user is made aware
        if (!bookFound) {
            System.out.println("Book not found\n");
        }
    }

    // lets the user lends a library book to someone in the library system
    public static void lendBook(ArrayList<Books> bookCollection, ArrayList<Users> userCollection) {
        Scanner input = new Scanner(System.in);
        // displays all the library books
        System.out.println("Which user would Like a book?");
        for (int i = 0; i < userCollection.size(); i++) {
            System.out.println((i + 1) + ". " + userCollection.get(i).getName());
        }
        // user selects the book to lend
        int userIndex = input.nextInt() - 1;
        Users user = userCollection.get(userIndex);
        // displays all the library users
        System.out.println("What book does " + user.getName() + " want?");
        for (int i = 0; i < bookCollection.size(); i++) {
            System.out.println((i + 1) + ". " + bookCollection.get(i).getTitle());
        }
        // user selects the borrower
        int bookIndex = input.nextInt() - 1;
        Books book = bookCollection.get(bookIndex);
        // checks if the book is already borrowed
        if (book.getBorrowed()) {
            System.out.println("This book is already borrowed by " + book.getUserBorrowed().getName() + "\n");
        } else {
           book.setUserBorrowed(user);
            System.out.println(user.getName() + " is now borrowing " + book.getTitle() + "\n");
        }
    }

    // lets the user return a book
    public static void returnBook(ArrayList<Books> bookCollection, ArrayList<Users> userCollection) {
        // displays all the library users
        Scanner input = new Scanner(System.in);
        System.out.println("Which user is returning a book:");
        for (int i = 0; i < userCollection.size(); i++) {
            System.out.println((i + 1) + ". " + userCollection.get(i).getName());
        }
        // user selects the borrower returning the book
        int userIndex = input.nextInt() - 1;
        Users user = userCollection.get(userIndex);
        // if the user doesn't have any books borrowed, throws an error
        if (user.getBooksBorrowed().size() == 0) {
            System.out.println("Sorry, " + user.getName() + " doesn't have any books borrowed");
        } else {
            // displays all the borrower's books
            System.out.println("What book is " + user.getName() + " returning?");
            for (int i = 0; i < user.getBooksBorrowed().size(); i++) {
                System.out.println((i + 1) + ". " + user.getBooksBorrowed().get(i).getTitle());
            }
            // user selects the book to returned
            int bookIndex = input.nextInt() - 1;
            Books book = user.getBooksBorrowed().get(bookIndex);
            book.setUserBorrowed();
            // confirmation
            System.out.println(user.getName() + " is has returned " + book.getTitle() + "\n");
        }

    }
    // --------------------- USER METHODS ---------------------

    // creates a new user
    public static void registerUser(ArrayList<Users> newUser) {
        Scanner input = new Scanner(System.in);
        // grabs user's name
        System.out.println("Enter user's name:");
        String usersName = input.nextLine();
        // creates new user objects
        Users user = new Users(usersName);
        newUser.add(user);
        // confirmation
        System.out.println("User successfully added\n");
    }

    // checks to see if any user's books are overdue and fines them
    public static void fineUsers(ArrayList<Books> bookCollection, ArrayList<Users> userCollection) {
        Date date = new Date();
        boolean userFined = false;
        long currentDate = date.getTime();
        // calculates two weeks in milliseconds
        final int TWO_WEEKS_IN_MILLIS = 2 * 7 * 24 * 60 * 60 * 1000;
        // checks each user
        for (Users user : userCollection) {
            int fineAmount = 0;
            // checks each user's book
            for (Books book : user.getBooksBorrowed()) {
                // checks if the user has had the book for more than two weeks
                if ((currentDate - book.getDateBorrowed()) > TWO_WEEKS_IN_MILLIS) {
                    userFined = true;
                    // uses the ratio of borrow to returned books to calculate late fees
                    int booksBorrowed = user.getBooksBorrowed().size();
                    int booksReturned = user.getBooksReturned().size();
                    double borrowedVsReturned = ((double) booksBorrowed / booksReturned);
                    // if the denominator is 0 or the ratio is above 10%, the user owes $100
                    if (booksReturned == 0 || borrowedVsReturned > 0.1) {
                        fineAmount += 100;
                    }
                    // if the ratio is between 1% - 10%, the user owes $50
                    else if (borrowedVsReturned > 0.01) {
                        fineAmount += 50;
                    }
                    // if the ratio is less than 1%, the user owes $10
                    else {
                        fineAmount += 10;
                    }
                    // outputs the amount the user owes
                    System.out.println(user.getName() + " is fined $" + fineAmount + ".");
                }
            }
        }
        // if no users have overdue books, displays appropriate message
        if (!userFined) {
            System.out.println("There are no overdue users.");
        }
        System.out.println();
    }

    // allows the user to ban someone
    public static void banUser(ArrayList<Users> userCollection) {
        Scanner input = new Scanner(System.in);
        // displays the users that can be banned
        System.out.println("Which user do you want to ban?");
        for (int i = 0; i < userCollection.size(); i++) {
            System.out.println((i + 1) + " " + userCollection.get(i));
        }
        // lets the user select the person to be banned
        int userIndex = input.nextInt() - 1;
        Users user = userCollection.get(userIndex);
        // if the person had any books, they are returned
        for (Books book : user.getBooksBorrowed()) {
            book.setUserBorrowed();
        }
        // sets the user to inactive
        user.setActive(false);
        // confirmation
        System.out.println(user.getName() + " is banned. They are still in the system but cannot borrow books.\n");
    }
}