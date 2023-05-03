/*
AUTHOR CLASS -----------------------------------------------------------------------------------
    class to create and save authors to connect the appropriate quotes to the appropriate
    authors.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Author {
    // PROPERTIES
    private String name;
    private String editor;
    private ArrayList<Quote> quotes;

    // CONSTRUCTOR
    public Author(String name, String editor, boolean fromCsv) {
        this.name = name;
        this.editor = editor;

        // writes data to csv if not written before
        if (!fromCsv) {

            try {
                // creates a csv file
                FileWriter csvWriter = new FileWriter("authors.csv", true);
                // writes the header in csv
                csvWriter.append(name);
                csvWriter.append(";");
                csvWriter.append(editor + "\n");
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

    // gets name
    public String getName() {
        return name;
    }

    // gets editor
    public String getEditor() {
        return editor;
    }

}
