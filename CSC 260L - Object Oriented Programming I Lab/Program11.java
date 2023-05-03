/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 04/04/2023
    Assignment #11
    Instructor: Brian Sauer
 */

import java.util.Scanner;
import java.io.*;
import java.io.File;

public class Program11 {
    public static void main(String[] args) throws IOException{
        // runs methods
        String[][] data = input("input1.txt");
        process("input2.txt", data);
        output("test_output.txt", data);
    }

    public static String[][] input(String filename) throws IOException {
        // create file object
        File file = new File(filename);
        // create scanner for file object
        Scanner in = new Scanner(file);
        //read rows and cols with nextInt()
        int numOfRows = in.nextInt();
        int numOfCols = in.nextInt();
        // initialize 2d array
        String[][] array = new String[numOfRows][numOfCols];
        // nested for loop to populate array with next()
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = in.next();
            }
        }
        //close scanner
        in.close();
        // return array
        return array;
    }

    public static void process(String s, String[][] processArray) throws IOException {
        // create file object
        File file = new File(s);
        // create scanner for file object
        Scanner in = new Scanner(file);
        // initializes variables
        int lineCount = 0;
        int errorCount = 0;
        int row;
        int col;
        String str1;
        String str2;
        // while the file has a next line, set the rows, cols, str1 and str 2
        while (in.hasNext()) {
            row = in.nextInt();
            col = in.nextInt();
            str1 = in.next();
            str2 = in.next();
            // increase the line count
            lineCount = lineCount + 1;
            // if the rows and cols in the array equals str1, replace it with str2
            if (processArray[row][col].equals(str1)) {
                processArray[row][col] = str2;
            // if not, increase error count
            } else {
                errorCount = errorCount + 1;
            }
        }
        // outputs the report of the file name, lines read, and # of errors
        System.out.println("-----------------REPORT-----------------");
        System.out.printf("File name: %s\n", s);
        System.out.printf("Number of lines read: %d\n", lineCount);
        System.out.printf("Number of errors: %d\n", errorCount);
        // close file
        in.close();
    }

    public static void output(String b, String[][] outputArray) throws IOException {
        // create file object
        File file = new File(b);
        // create printwriter for file object
        PrintWriter out = new PrintWriter(file);
        // writes array to a new file
        for (int i = 0; i < outputArray.length; i++) {
            for (int j = 0; j < outputArray[i].length; j++) {
                out.print(outputArray[i][j] + "\t");
            }
            out.println();
        }
        // closes file
        out.close();
    }
}

/*
-----------------REPORT-----------------
File name: input2.txt
Number of lines read: 37
Number of errors: 7
 */