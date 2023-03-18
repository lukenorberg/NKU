/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 02/28/2023
    Assignment #3
    Instructor: Brian Sauer
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // grabs the number the base will go to
        System.out.println("Enter the largest base to calculate to exponent of");
        int largestNum = input.nextInt();

        // prints what exponent for n base
        System.out.println("n\tn^2\tn^3\tn^4");
        for (int i = 1; i <= largestNum; i++) {
            // outputs the digit given the base through a loop and the exponent
            System.out.printf("%d\t%d\t%d\t%d\n", (i), (i * i), (i * i * i), (i * i * i * i));
        }
    }
}

/*
Enter the largest base to calculate to exponent of
5
n	n^2	n^3	n^4
1	1	1	1
2	4	8	16
3	9	27	81
4	16	64	256
5	25	125	625
 */