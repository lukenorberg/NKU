/*
ADMIN CLASS -----------------------------------------------------------------------------------
    extension of User with admin access. Allows the admin to create and delete quotes, authors,
     and users.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    // PROPERTIES
    public boolean admin;
    static ArrayList<Admin> admins = new ArrayList<Admin>();

    // CONSTRUCTOR
    public Admin(String email, String password, String name, Boolean fromCsv, String filePath) {
        super(email, password, name, fromCsv, filePath);

        // creates admin csv if it doesn't exist
        if (!new File("admin.csv").exists()) {
            String[] headers = {"Email", "Password", "Name"};
            try {
                // creates a csv file
                FileWriter csvWriter = new FileWriter("admin.csv");
                // writes the header in admin csv
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

    // METHODS


    // displays the main menu for the admin
    // overrides userMain in superclass.
    public static void userMain(User userSelected) {
        // inits scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome " + userSelected.getName() + ", What would you like to do?");
        // main menu screen
        while (userSelected.isLogged()) {
            // prints user's options
            System.out.println();
            System.out.println("1. List all the quotes");
            System.out.println("2. List all the authors");
            System.out.println("3. List all the users");

            // lets user pick choice
            int choice = input.nextInt();
            // switches user's choice
            switch (choice) {
                // lists quotes
                case 1:
                    User.listQuotes(userSelected);
                    break;
                // lists authors
                case 2:
                    User.listAuthors(userSelected);
                    break;
                // lists users
                case 3:
                    listUsers(userSelected);
                    break;
            }
        }
    }

    // lists users
    private static void listUsers(User user) {
        // checks if users exist
        if (users.size() > 0) {
            System.out.println("Here are the users available:");
            // prints the available users
            for (int i = 0; i < users.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, users.get(i).getName());
            }
            // prints options for admin
            System.out.println("\nWHAT DO YOU WANT TO DO");
            System.out.println("A. Add a user");
            System.out.println("D. Delete a user");
            System.out.println("B. Back to previous menu");
            // admin picks what to do with scanner
            Scanner input = new Scanner(System.in);
            char choice = input.next().charAt(0);
            // switches admins choice
            switch (choice) {
                // creates new user
                case 'A':
                    Main.signUp();
                    break;
                // deletes a user
                case 'D':
                    deleteUser(user);
                    break;
                // exits user menu
                case 'B':
                    break;
            }
        }
    }

    // deletes user
    private static void deleteUser(User user) {
        // warning message for the admin
        System.out.println("WARNING: if you delete a user, all their quotes will disappear");
        System.out.println("Which user shall we delete?");
        // list users to delete
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%d. %s\n", i + 1,users.get(i).getName());
        }
        // admin chooses user to delete
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt() - 1;
        User userToDlt = User.users.get(choice);
        // removes user from the user list
        User.users.remove(userToDlt);

        // updates the csv
        try {
            // creates a csv file
            FileWriter csvWriter = new FileWriter("users.csv");
            // writes the header in csv
            csvWriter.append("Email;Password;Name\n");
            for (User deleteUser : User.users) {
                csvWriter.append(String.format("%s;%s;%s\n", deleteUser.getEmail(), deleteUser.getPassword(), deleteUser.getName()));
            }
            csvWriter.append("\n");
            // flushes and closes FileWriter
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            // catches IO errors
            e.printStackTrace();
        }
        // loops through quotes
        for (int i = 0; i < quotes.size(); i++) {
            // if the quote is written by the user, the quote's deleted
            if (quotes.get(i).getEditor().equals(userToDlt.getName())) {
                quotes.remove(quotes.get(i));
                i--;
            }
        }
        // updates the user's csv
        QuoteManager.writeQuotesCsv(quotes);

        // loops through authors
        for (int i = 0; i < authors.size(); i++) {
            // if the author is provided by the user, the quote's deleted
            if (authors.get(i).getEditor().equals(userToDlt.getName())) {
                authors.remove((authors.get(i)));
                i--;
            }
        }

        // updates the author's csv
        try {
            // creates a csv file
            FileWriter csvWriter = new FileWriter("authors.csv");
            // writes the header in csv
            for (Author author : User.authors) {
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

    }
}
