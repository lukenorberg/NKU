/*
QUOTE CLASS -----------------------------------------------------------------------------------
    class to create and save quotes and relevant information. contains methods to update and
    save quotes to storage along with relative information such as the author, the editor, and
    the date.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.io.File;

public class Quote {
    // PROPERTIES
    private String author;
    private String text;
    private String editor;
    private Date date;
    private String stringDate;
    private String realStringDate;

    //file path for user data
    private final static String FILE_PATH = "quotes.csv";
    {
        if (!new File(FILE_PATH).exists()) {
            // header info for the csv file storing user data
            String[] headers = {"Author", "text", "addDate", "Editor"};
            try {
                // creates a csv file
                FileWriter csvWriter = new FileWriter(FILE_PATH);
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
    public Quote(String author, String text, String editor) {
        // constructor if read from user input
        this.author = author;
        this.text = text;
        this.editor = editor;
        this.date = new Date();
        realStringDate = this.date.toString();
        // quote data to write to csv
        String quoteData = author + ";" + text + ";" + date.toString() + ";" + editor + "\n";

        try {
            // writes data to csv
            FileWriter write = new FileWriter("quotes.csv", true);
            write.write(quoteData);
            // closes csv
            write.close();
        } catch (IOException e) {
            // catches errors
            e.printStackTrace();
        }
        // adds the new object to the quotes list
        User.quotes.add(this);
    }

    // CONSTRUCTOR
    public Quote(String author, String text, String date, String editor) {
        // constructor if read from csv
        this.author = author;
        this.text = text;
        this.editor = editor;
        this.stringDate = date;
        realStringDate = date;
    }

    // METHODS

    // shows information about the quote
    public void show() {

        try {
            // reads csv file
            BufferedReader br = new BufferedReader(new FileReader("quotes.csv"));
            String line;
            // prints the csv info
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            // closes buffered reader
            br.close();
        // catches IO error
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // gets text
    public String getText() {
        return text;
    }

    // gets author
    public String getAuthor() {
        return author;
    }

    // gets editor
    public String getEditor() {
        return editor;
    }

    // gets date
    public String getStringDate() {
        return realStringDate;
    }

    // sets text
    public void setText(String text) {
        this.text = text;
    }

    // sets author
    public void setAuthor(String author) {
        this.author = author;
    }
}
