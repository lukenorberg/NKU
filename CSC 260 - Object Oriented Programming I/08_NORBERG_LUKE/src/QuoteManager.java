/*
QUOTE_MANAGER CLASS -----------------------------------------------------------------------------------
    class to manage the all the csvs and quotes. imports data and creates objects from storage.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteManager {

    // METHODS

    // grabs data from all the csvs and create the appropriate objects
    public static void initCsv() {
        // checks if the csv exists
        if (new File("quotes.csv").exists()) {
            try {
                // reads file and creates scanner
                File file = new File("quotes.csv");
                Scanner reader = new Scanner(file);

                // skips header line
                reader.nextLine();
                while (reader.hasNextLine()) {
                    // creates list of the csv line
                    String[] csvLine = reader.nextLine().split(";");
                    // checks if the csv line has all the necessary components and creates the appropriate object
                    if (csvLine.length == 4) {
                        User.quotes.add(new Quote(csvLine[0], csvLine[1], csvLine[2], csvLine[3]));
                    }
                }
                // closes reader
                reader.close();

            } catch (FileNotFoundException e) {
                // catches IO errors
                e.printStackTrace();
            }
        }

        // checks if the csv exists
        if (new File("users.csv").exists()) {
            try {
                // reads file and creates scanner
                File file = new File("users.csv");
                Scanner reader = new Scanner(file);

                // skips header line
                reader.nextLine();
                while (reader.hasNextLine()) {
                    // creates list of the csv line
                    String[] csvLine = reader.nextLine().split(";");
                    // checks if the csv line has all the necessary components and creates the appropriate object
                    if (csvLine.length == 3) {
                        User.users.add(new User(csvLine[0], csvLine[1], csvLine[2], true, "users.csv"));
                    }
                }
                // closes reader
                reader.close();

            } catch (FileNotFoundException e) {
                // catches IO errors
                e.printStackTrace();
            }
        }

        // checks if the csv exists
        if (new File("authors.csv").exists()) {
            try {
                // reads file and creates scanner
                File file = new File("authors.csv");
                Scanner reader = new Scanner(file);

                while (reader.hasNextLine()) {
                    // creates list of the csv line
                    String[] authorList = reader.nextLine().split(";");
                    // checks if the csv line has all the necessary components and creates the appropriate object
                    if (authorList.length == 2) {
                        Author author = new Author(authorList[0], authorList[1], true);
                        User.authors.add(author);
                    }

                }
                // closes reader
                reader.close();

            } catch (FileNotFoundException e) {
                // catches IO errors
                e.printStackTrace();
            }

            // checks if the csv exists
            if (new File("admin.csv").exists()) {
                try {
                    // reads file and creates scanner
                    File file = new File("admin.csv");
                    Scanner reader = new Scanner(file);

                    // skips header line
                    reader.nextLine();
                    while (reader.hasNextLine()) {
                        // creates list of the csv line
                        String[] csvLine = reader.nextLine().split(";");
                        // checks if the csv line has all the necessary components and creates the appropriate object
                        if (csvLine.length == 3) {
                            Admin.admins.add(new Admin(csvLine[0], csvLine[1], csvLine[2], true, "admin.csv"));
                        }
                    }
                    // closes reader
                    reader.close();

                } catch (FileNotFoundException e) {
                    // catches IO errors
                    e.printStackTrace();
                }
            }
        }
    }

    // writes or updates the quotes csv
    public static void writeQuotesCsv(ArrayList<Quote> quotes) {
        try {
            // creates a csv file
            FileWriter csvWriter = new FileWriter("quotes.csv");
            // writes the header in csv
            csvWriter.append("Author;text;addDate;Editor\n");
            // writes information to csv
            for (Quote quote : quotes) {
                csvWriter.append(String.format("%s;%s;%s;%s\n", quote.getAuthor(), quote.getText(), quote.getStringDate(), quote.getEditor()));
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
