package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NorbergLukeA1P2 {
    public static void main(String[] args){
        // scanner for user input
        Scanner userInput = new Scanner(System.in);

        // grabs .txt file user request, creates file object
        System.out.println("Enter the file name: ");
        String fileName = userInput.nextLine();
        File file = new File(fileName);

        // if the file exists, fileAverage method runs
        try {
            Scanner textInput = new Scanner(file);
            fileAverage(textInput);
        }
        // if the file doesn't exist, the user is notified and the program terminates.
        catch (FileNotFoundException ex) {
            System.out.printf("Could not find file: %s", fileName);
            System.exit(1);
        }
    }

    // returns the average of the ints stored on each line along with the parsable and unparsable lines
    public static void fileAverage(Scanner textInput) {
        double sum = 0;
        int parsableLines = 0;
        int unparsableLines = 0;

        while (textInput.hasNext()) {
            String textLine = textInput.nextLine();
            // if int can be parsed, int is added to sum and parsable line increases
            try {
                int textInt = Integer.parseInt(textLine);
                sum += textInt;
                parsableLines++;
            }
            // if int can't be parsed, user is warned and unparsable line increases
            catch (NumberFormatException ex) {
                System.out.printf("Cannot parse %s as an integer.\n", textLine);
                unparsableLines++;
            }
        }
        // closes file
        textInput.close();

        System.out.printf("Number of parsable lines: %d\n", parsableLines);
        System.out.printf("Average value: %f\n", sum / parsableLines); // sum / parsableLines = average
        System.out.printf("Number of unparsable lines: %d\n", unparsableLines);
    }
}
