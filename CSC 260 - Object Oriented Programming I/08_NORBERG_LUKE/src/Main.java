/*
QUOTE MANAGER -----------------------------------------------------------------------------------

    CSC 260-002 Spring 2023
    created by Kidus Getachew, Chris Merida, & Luke Norberg

    Quote repository designed in Java which includes features such as authentication, file saving
    and loading, users and admins, quotes, and authors. Administers an Object-Oriented approach.

 */

import java.util.Scanner;

public class Main {
    public static User userSelected;
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome!");
        // uploads all saved data to the program
        QuoteManager.initCsv();
        // loops through log in menu until logged in
        while (true) {
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            // grabs user's choice
            int choice = input.nextInt();
            // signs user in
            if (choice == 1) {
                userSelected = signIn();
                // double-checks the sign in information was saved
                if (userSelected == null) continue;
                else break;
            // signs new user up
            } else userSelected = signUp();
        }
        // checks if the user logged in is an admin
        for (Admin admin : Admin.admins) {
            if (userSelected.getName().equals(admin.getName())) {
                Admin.userMain(userSelected);
            }
        }
        // logs user in
            User.userMain(userSelected);
    }

    // METHODS

    // sign's user in
    public static User signIn() {
        // gives error if no user exists
        if (User.users.size() == 0) {
            System.out.println("There are no users.");
        }
        else {
            // lists the current user
            System.out.println("Which user would you like to choose? to sign up, enter 0");
            for (int i = 0; i < User.users.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, User.users.get(i).getName());
            }
            // list the admin users
            for (int i = 0; i < Admin.admins.size(); i++) {
                System.out.printf("%d: %s\n", i + User.users.size() + 1, Admin.admins.get(i).getName());
            }
            User userSelected;
            String filePath;
            // grabs user selected
            int select = input.nextInt();
            // checks if person wants to sign new user up
            if (select == 0) {
                signUp();
            }
            // checks if user selected an admin
            if (select > User.users.size()) {
                // grabs index of the admin
                select -= User.users.size();
                // sets file path for admin
                filePath = "admin.csv";
                // selects admin
                userSelected = Admin.admins.get(select - 1);
            } else {
                // grabs non-admin
                userSelected = User.users.get(select - 1);
                // saves non-admin csv
                filePath = "users.csv";
            }
            if (select != 0) {
                // loops through until user gets the right info
                while (true) {
                    // inits scanner
                    Scanner input = new Scanner(System.in);
                    System.out.println("LOG IN");
                    // grabs email info
                    System.out.println("Email:");
                    String email = input.nextLine();
                    // grabs password info
                    System.out.println("Password:");
                    String password = input.nextLine();
                    // checks if the info is correct
                    if (userSelected.login(email, password, filePath)) {
                        // logs user in
                        userSelected.setLogged(true);
                        return userSelected;
                    }
                }

            }
        }
        // if no user is selected, null is returned
        return null;
    }

    // creates new user
    public static User signUp() {
        // inits scanner
        Scanner charInput = new Scanner(System.in);
        System.out.println("SIGN UP");
        // sees if new user is an admin
        System.out.println("Admin: y/n");
        char admin = charInput.next().charAt(0);
        // grabs user's name
        System.out.println("Name:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        // grabs user's email
        System.out.println("Email:");
        String email = input.nextLine();
        // grabs user's password
        System.out.println("Password:");
        String password = input.nextLine();
        User user = null;
        // if the user's an admin, an admin object is created
        if (admin == 'y') {
            Admin newAdmin = new Admin(email, password, name, false, "admin.csv");
            Admin.admins.add(newAdmin);
        // if not, a normal user is added
        } else {
            user = new User(email, password, name, false, "users.csv");
            User.users.add(user);
        }
        // confirmation
        System.out.println("User successfully added.");
        return user;
    }
}