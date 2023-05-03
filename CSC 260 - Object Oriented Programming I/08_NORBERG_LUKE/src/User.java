/*
USER CLASS -----------------------------------------------------------------------------------
    class to create and save users including user info, quotes, authors, etc. Contains the
    display for the main menu including the methods for the user's options. updates csv's in
    real time.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class User {

    // PROPERTIES

    // initializes Arrays to save quotes, users, and authors
    public static ArrayList<Quote> quotes = new ArrayList<Quote>();
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Author> authors = new ArrayList<Author>();

    private String email;
    private String password;
    private String name;
    private boolean logged;
    public boolean admin;

    // header info for the csv file storing user data
    String[] headers = {"Email", "Password", "Name"};
    {
        // if no users file exist, creates one
        if (!new File("users.csv").exists()) {
            try {
                // creates a csv file
                FileWriter csvWriter = new FileWriter("users.csv");
                // writes the header in users.csv
                for (int i = 0; i < headers.length; i++) {
                    csvWriter.append(headers[i]);
                    // separates in a csv format with semicolons
                    if (i != headers.length - 1) {
                        csvWriter.append(";");
                    }
                }
                csvWriter.append("\n");
                // flushes and closes FileWriter
                csvWriter.flush();
                csvWriter.close();
                // confirmation message to console

            } catch (IOException e) {
                // catches IO errors
                e.printStackTrace();
            }
        }
    }

    // CONSTRUCTOR
    public User(String email, String password, String name, Boolean fromCsv, String filePath) {
        // instance variables
        this.email = email;
        this.password = password;
        this.name = name;
        this.logged = false;
        // checks whether to save as admin or non-admin
        if (filePath.equals("admin.csv")) {
            admin = true;
        } else {
            admin = false;
        }

        // if the user info isn't in a csv file, writes it
        if (!fromCsv) {
            String[] userInfo = {email, password, name};
            try {
                // appends user info to the csv file
                FileWriter csvWriter = new FileWriter(filePath, true);
                for (int i = 0; i < userInfo.length; i++) {
                    csvWriter.append(userInfo[i]);
                    // separates in a csv format with semicolons
                    if (i != userInfo.length - 1) {
                        csvWriter.append(";");
                    }
                }
                csvWriter.append("\n");
                // flushes and closes FileWriter
                csvWriter.flush();
                csvWriter.close();

            } catch (IOException e) {
                // catches IO errors
                e.printStackTrace();
            }
        }
    }

    // METHODS


    // main page once the user is logged in
    public static void userMain(User userSelected) {
        System.out.println("Welcome " + userSelected.getName() + ", What would you like to do?");
        // displays options for the user to choose
        while (userSelected.isLogged()) {
            System.out.println();
            System.out.println("1. List all the quotes");
            System.out.println("2. List all the authors");
            System.out.println("3. Add a quote");
            System.out.println("4. Add an Author");
            System.out.println("5. Search for an author");
            System.out.println("6. Get a random quote");
            System.out.println("7. Create an account");
            System.out.println("8. Log in into your account");
            System.out.println("9. Quit\n");

            // uses scanner to read user input
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            // switch user options in order
            switch (choice) {
                // brings up quote's menu
                case 1:
                    User.listQuotes(userSelected);
                    break;
                // brings up authors menu
                case 2:
                    User.listAuthors(userSelected);
                    break;
                // adds quote
                case 3:
                    User.addQuote(userSelected);
                    break;
                // adds user
                case 4:
                    User.addAuthor(userSelected);
                    break;
                // search for an author
                case 5:
                    User.searchForAuthor(userSelected);
                    break;
                // get a random quote
                case 6:
                    User.getRandomQuote(userSelected);
                    break;
                // sign up a new user
                case 7:
                    Main.signUp();
                    break;
                // signs another user in
                case 8:
                    userSelected = Main.signIn();
                    for (Admin admin : Admin.admins) {
                        if (userSelected.getName().equals(admin.getName())) {
                            Admin.userMain(userSelected);
                        }
                    }
                    User.userMain(userSelected);
                    break;
                // logs user out
                case 9:
                    userSelected.setLogged(false);
                    break;
            }
        }

    }

    // checks user login information for security purposes
    public boolean login(String email, String password, String filePath) {
        // reads users.csv file
        File file = new File(filePath);
        try {
            // scans users.csv file
            Scanner scanner = new Scanner(file);
            boolean nextLine = true;
            // for each line, checks if the email and password matches any given users email and password
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // creates array of email, password, and name of the line
                String[] lineArray = line.split(";");
                if (lineArray[0].equals(email) && lineArray[1].equals(password)) {
                    System.out.println("Logged in successfully");
                    scanner.close();
                    return true;
                }
            }
            // if no users found, the login fails
            if (nextLine) {
                System.out.println("The email and/or password did not match anyone we have on record.");
                scanner.close();
            }
            // closes scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            // catches error if file is not found
            System.out.println(e);
        }
        // login fails as a fallback
        return false;
    }

    // checks if the user is logged in
    public boolean isLogged() {
        return logged;
    }

    // logs in user
    public void setLogged(boolean trueOrFalse) {
        logged = trueOrFalse;
    }

    // logs the user out
    public void logout() {
        logged = false;
    }

    // returns the email of the user
    public String getEmail() {
        return email;
    }

    // returns the user's name
    public String getName() {
        return name;
    }

    // returns the user's password
    public String getPassword() {
        return password;
    }

    // brings up the quote menu for the user to choose what they want to do with the quotes
    public static void listQuotes(User user) {
        // checks if there are any quotes
        if (quotes.size() > 0) {
            // groups quotes in fives for better readability
            ArrayList<Quote> quoteSegment = new ArrayList<Quote>();
            // index of quotes list
            int index = 0;
            // calculates the number of pages
            int numPages = (quotes.size() / 5) + 1;
            int currentPage = 1;
            boolean loopOn = true;
            // runs while quotes are still available and the loop is on
            while (index < quotes.size() && loopOn) {
                // counter of quotes on page
                int counter = 1;
                // prints the current page
                System.out.printf("Page %d out of %d\n", currentPage, numPages);
                for (int i = index; i < Math.min(index + 5, quotes.size()); i++) {
                    // adds the displayed quotes to quoteSegment
                    quoteSegment.add(quotes.get(i));

                    // displays quote and relevant info
                    System.out.printf("%d. %s\n", counter, quotes.get(i).getText());
                    System.out.printf("- %s\n", quotes.get(i).getAuthor());
                    System.out.printf("Added by %s\n", quotes.get(i).getEditor());
                    System.out.println("----------------------------------------------------------------");

                    // updates the counter of the quote
                    counter++;
                }

                // user options on what to do with the provided quotes
                System.out.println("WHAT DO YOU WANT TO DO?");
                // if there's a next page, user can show more quotes
                if (numPages - currentPage > 0) {
                    System.out.println("M. Show more");
                }
                System.out.println("E. Edit quote");
                System.out.println("D. Delete quote");
                System.out.println("A. Add a quote");
                System.out.println("B. Back to previous menu");

                // Scanner and user choice
                Scanner input = new Scanner(System.in);
                char whatToDo = input.next().charAt(0);

                // switches the user choice
                switch (whatToDo) {
                    // goes to next page
                    case 'M':
                        // clears currently saved quotes
                        quoteSegment.clear();
                        break;
                    // edits quote
                    case 'E':
                        editQuote(user, quoteSegment, quotes);
                        loopOn = false;
                        break;
                    // deletes quote
                    case 'D':
                        deleteQuote(user, quoteSegment, quotes);
                        loopOn = false;
                        break;
                    // adds a new quote
                    case 'A':
                        addQuote(user);
                        loopOn = false;
                        break;
                    // ends quote menu
                    case 'B':
                        loopOn = false;
                        break;
                }
                // displays the next 5 quotes
                index += 5;
                // increases page number
                currentPage++;
            }
        }
    }


    // deletes quote
    private static void deleteQuote(User user, ArrayList<Quote> quoteSegment, ArrayList<Quote> quotes) {
        Quote quoteToRmv;
        // checks if there is more than 1 quote
        if (quoteSegment.size() > 1) {
            System.out.println("Which quote would you like to delete?");
            // lists quotes to delete
            for (int i = 0; i < quoteSegment.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, quoteSegment.get(i).getText());
                System.out.printf("- %s\n", quoteSegment.get(i).getAuthor());
                System.out.printf("Added by %s\n", quoteSegment.get(i).getEditor());
                System.out.println("----------------------------------------------------------------");
            }
            // user uses scanner to choose
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt() - 1;
            // selects quote to remove
            quoteToRmv = quoteSegment.get(choice);
        // if there's only one quote, chooses that quote to delete
        } else {
            quoteToRmv = quoteSegment.get(0);
        }
        // checks if the user is the creator or an admin
        if (quoteToRmv.getEditor().equals(user.getName()) || Admin.admins.contains(user)) {
            // deletes quote
            quotes.remove(quoteToRmv);
            // updates csv
            QuoteManager.writeQuotesCsv(quotes);
        }
        // outputs error if the user is not authorized to delete quotes
        else {
            System.out.println("You are not authorized to delete this quote");
        }
    }

    // edits quote
    private static void editQuote(User user, ArrayList<Quote> quoteSegment, ArrayList<Quote> quotes) {
        Quote quoteToEdit;
        // checks if there is more than 1 quote
        if (quoteSegment.size() > 1) {
            System.out.println("Which quote would you like to edit?");
            // lists quotes to edit
            for (int i = 0; i < quoteSegment.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, quoteSegment.get(i).getText());
                System.out.printf("- %s\n", quoteSegment.get(i).getAuthor());
                System.out.printf("Added by %s\n", quoteSegment.get(i).getEditor());
                System.out.println("----------------------------------------------------------------");
            }
            // user chooses through scanner
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt() - 1;
            quoteToEdit = quoteSegment.get(choice);
        // if there is only one quote to edit, chooses the one quote
        } else {
            quoteToEdit = quoteSegment.get(0);
        }

        // checks if the user is authorized to edit
        if (quoteToEdit.getEditor().equals(user.getName()) || Admin.admins.contains(user)) {
            // lets user enter new quote
            System.out.println("Please enter new text for the quote. Don't forget quotation marks: ");
            Scanner text = new Scanner(System.in);
            String textChoice = text.nextLine();
            // updates quote object
            quoteToEdit.setText(textChoice);

            // updates the csv
            try {
                // creates a csv file
                FileWriter csvWriter = new FileWriter("quotes.csv");
                // writes the header in the csv
                csvWriter.append("Author;text;addDate;Editor\n");
                for (Quote quote : quotes) {
                    csvWriter.append(String.format("%s;%s;%s;%s\n", quote.getAuthor(), quote.getText(), quote.getStringDate(), quote.getEditor()));
                }
                csvWriter.append("\n");
                // flushes and closes FileWriter
                csvWriter.flush();
                csvWriter.close();
                // confirmation message to console

            } catch (IOException e) {
                // catches IO errors
                e.printStackTrace();
            }
        }
        // error message if the user is not authorized
        else {
            System.out.println("You are not authorized to edit this quote");
        }
    }

    // lists authors
    public static void listAuthors(User user) {
        // checks if there are authors to list
        if (authors.size() > 0) {
            System.out.println("Here are the authors available:");
            // lists the authors
            for (int i = 0; i < authors.size(); i++) {
                System.out.printf("%d. %s\n", i + 1,authors.get(i).getName());
            }
            // menu option for choices
            System.out.println("\nWHAT DO YOU WANT TO DO");
            System.out.println("A. Add an author");
            System.out.println("D. Delete an author");
            System.out.println("B. Back to previous menu");
            // user chooses option
            Scanner input = new Scanner(System.in);
            char choice = input.next().charAt(0);
            // switches user's option
            switch (choice) {
                // adds new author
                case 'A':
                    addAuthor(user);
                    break;
                // deletes author
                case 'D':
                    deleteAuthor(user);
                    break;
                // exits author menu
                case 'B':
                    break;
            }
        }
        // provides no authors available error
        else {
            System.out.println("There are no authors available.");
        }
    }

    // deletes an author
    private static void deleteAuthor(User user) {
        // provides deleting warning
        System.out.println("WARNING: if you delete an author, all their quotes will disappear");
        System.out.println("Which author shall we delete?");
        // list through available authors
        for (int i = 0; i < authors.size(); i++) {
            System.out.printf("%d. %s\n", i + 1,authors.get(i).getName());
        }
        // grab user's choice
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt() - 1;
        // sets author to delete
        Author authorToDlt = authors.get(choice);
        // checks if the user is authorized
        if (authorToDlt.getEditor().equals(user.getName()) || Admin.admins.contains(user)) {
            // removes author from authors list
            authors.remove(authorToDlt);
            // updates author's csv file
            try {
                // creates a csv file
                FileWriter csvWriter = new FileWriter("authors.csv");
                // writes the header in csv
                for (Author author : authors) {
                    csvWriter.append(String.format("%s;%s\n", author.getName(), author.getEditor()));
                }
                csvWriter.append("\n");
                // flushes and closes FileWriter
                csvWriter.flush();
                csvWriter.close();

            } catch (IOException e) {
                // catches IO errors
                e.printStackTrace();
            }
            // checks through the quotes that have the author
            for (int i = 0; i < quotes.size(); i++) {
                // removes quote if the authors name is on the quote
                if (quotes.get(i).getAuthor().equals(authorToDlt.getName())) {
                    quotes.remove(quotes.get(i));
                    i--;
                }
            }
            // updates quotes csv
            QuoteManager.writeQuotesCsv(quotes);
        // provides an error if the user is not authorized
        } else {
            System.out.println("You are not authorized to delete this author.");
        }

    }

    // adds a quote
    public static void addQuote(User user) {
        // checks there are authors
        if (authors.size() > 0) {
            // inits scanner
            Scanner input = new Scanner(System.in);
            System.out.println("Provide the author:");
            // lists through the authors
            for (int i = 0; i < authors.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, authors.get(i).getName());
            }
            // lets user choose author
            int authorIndex = input.nextInt() - 1;
            String author = authors.get(authorIndex).getName();
            // asks user for the quote text
            System.out.println("provide the text:");
            Scanner textInput = new Scanner(System.in);
            String text = textInput.nextLine();
            // creates a quote object
            Quote quote = new Quote(author, text, user.getName());
            // confirmation message
            System.out.println("Quote successfully added.");
        }
        // if no authors available, brings user to the author menu
        else {
            addAuthor(user);
        }
    }

    // adds author
    public static void addAuthor(User user) {
        // inits scanner
        Scanner input = new Scanner(System.in);
        // gets authors name
        System.out.println("Provide author's name: ");
        String name = input.nextLine();
        // creates an author object
        authors.add(new Author(name, user.getName(), false));
        // confirmation message
        System.out.println("Author successfully added!");
    }

    // searches for an author
    public static void searchForAuthor(User user) {
        // inits scanner
        Scanner input = new Scanner(System.in);
        // gets author name to search for
        System.out.println("What author would you like to search For?");
        String author = input.nextLine();
        boolean authorFound = false;
        // iterates through authors
        for (int i = 0; i < authors.size(); i++) {
            // checks authors name with name provided
            if (authors.get(i).getName().equalsIgnoreCase(author)) {
                // prints author info
                System.out.printf("%s was found in the list of authors.\n", authors.get(i).getName());
                // gives user options
                System.out.println("\nWHAT DO YOU WANT TO DO");
                System.out.println("A. Add an author");
                System.out.println("D. Delete an author");
                System.out.println("B. Back to previous menu");
                // gets user input
                Scanner charInput = new Scanner(System.in);
                char choice = charInput.next().charAt(0);
                // switches through user input
                switch (choice) {
                    // adds author
                    case 'A':
                        addAuthor(user);
                        break;
                    // deletes author
                    case 'D':
                        deleteAuthor(user);
                        break;
                    // ends author menu
                    case 'B':
                        break;
                }
                authorFound = true;
            }
        }
        // lets user know if the author isn't found
        if (!authorFound) {
            System.out.printf("%s was not found.\n", author);
        }
    }

    // gets a random quote
    public static void getRandomQuote(User user) {
        // sets the number of quotes
        int numOfQuotes = quotes.size();
        // creates random object
        Random random = new Random();
        // grabs a random quote
        Quote quote = quotes.get(random.nextInt(numOfQuotes));

        // prints random quote
        System.out.println("Here is a random quote:");
        System.out.println();
        System.out.printf("%s.\n", quote.getText());
        System.out.printf("- %s\n", quote.getAuthor());
        System.out.printf("Added by %s\n", quote.getEditor());
        System.out.println("----------------------------------------------------------------");
        // provides user options with quote
        System.out.println("WHAT DO YOU WANT TO DO?");
        System.out.println("E. Edit quote");
        System.out.println("D. Delete quote");
        System.out.println("A. Add a quote");
        System.out.println("B. Back to previous menu");
        // grabs user input
        Scanner input = new Scanner(System.in);
        char whatToDo = input.next().charAt(0);
        // creates a array quote for upcoming methods
        ArrayList<Quote> quoteSegment = new ArrayList<Quote>();
        quoteSegment.add(quote);

        // switches user's choice
        switch (whatToDo) {
            // edits quote
            case 'E':
                editQuote(user, quoteSegment, quotes);
                break;
            case 'D':
            // deletes quote
                deleteQuote(user, quoteSegment, quotes);
                break;
            // adds quote
            case 'A':
                addQuote(user);
                break;
            // exits quote menu
            case 'B':
                break;
        }
    }
}
