/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 01/24/2023
    Assignment #2
    Instructor: Brian Sauer

    Description: calculates the cost per square foot of two buildings for
    Black and Gold Construction Company. It also provides the date of the estimate
    and the average cost per square foot for both buildings.

 */

import java.util.Date;
import java.text.DecimalFormat;

public class Lab2 {
    public static void main(String[] args) {
        Date date = new Date();
        DecimalFormat df = new DecimalFormat("$#,###.00");

        int length1 = 200, width1 = 300, nStories1 = 3;
        int baseCost1 = 250000, totalCost1 = 2000000;
        double squareFootCost1 = (double) (totalCost1 - baseCost1) / (length1 * width1 * nStories1);

        int length2 = 251, width2 = 161, nStories2 = 1;
        int baseCost2 = 100000, totalCost2 = 281475;
        double squareFootCost2 = (double) (totalCost2 - baseCost2) / (length2 * width2 * nStories2);

        double average = (squareFootCost1 + squareFootCost2) / 2;

        System.out.println("Date of estimate: " + date + "\n\n");
        System.out.printf("The cost per square foot of floor space for a %d by %d building\n", length1, width1);
        System.out.printf("of %d stories with a base cost of %d and a total cost of %d is $%.2f.\n", nStories1, baseCost1, totalCost1, squareFootCost1);
        System.out.printf("The cost per square foot of floor space for a %d by %d building\n", length2, width2);
        System.out.printf("of %d stories with a base cost of %d and a total cost of %d is $%.2f.\n\n", nStories2, baseCost2, totalCost2, squareFootCost2);
        System.out.println("The average is " + df.format(average));
    }
}

/*
Date of estimate: Tue Jan 24 15:57:58 EST 2023


The cost per square foot of floor space for a 200 by 300 building
of 3 stories with a base cost of 250000 and a total cost of 2000000 is $9.72.
The cost per square foot of floor space for a 251 by 161 building
of 1 stories with a base cost of 100000 and a total cost of 281475 is $4.49.

The average is $7.11
 */
