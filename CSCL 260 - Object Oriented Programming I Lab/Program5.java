/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 02/21/2023
    Assignment #5
    Instructor: Brian Sauer
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double amountOwed = 0;

        // checks if the customer is commercial or residential
        System.out.println("Enter the type of customer:");
        char customerType = scan.next().toLowerCase().charAt(0);
        if (customerType != 'r' && customerType != 'c' && customerType != 'e' && customerType != 'p') {
            System.out.println("Invalid client type");
            System.exit(0);
        }

        // Grabs the number of minutes used and checks if it's greater than 0
        System.out.println("Enter the number of minutes the customer used:");
        int minutesUsed = scan.nextInt();
        // 10080 is the # of minutes in a week or 7 * 24 * 60
            if (minutesUsed < 0 || minutesUsed > 10080) {
                System.out.println("Invalid number of minutes");
                System.exit(0);
            }

            // calculates the amount owed if the customer is residential
        if (customerType == 'r') {
            if (minutesUsed <= 60) {
                amountOwed = 5;
            } else {
                double addedCost = (minutesUsed - 60) * 0.10;
                amountOwed = 5 + addedCost;
            }
        // calculates the amount owed if the customer is educational
        } else if (customerType == 'e'){
            amountOwed = minutesUsed * 0.18;
        }
        // calculates the amount owed if the customer is preferred
        else if (customerType == 'p') {
            final int BASE_CHARGE = 10;
            if (minutesUsed <= 500) {
                amountOwed = BASE_CHARGE + (minutesUsed * 0.06);
            } else {
                amountOwed = BASE_CHARGE + (500 * 0.06) + ((minutesUsed - 500) * 0.04);
            }
        }

        // calculates the amount owed if the customer is commercial
        else {
            if (minutesUsed < 300) {
                amountOwed = minutesUsed * 0.2;
            } else {
            //checks the bonus status of the customer
                System.out.println("What is your bonus status");
                char bonus = scan.next().toLowerCase().charAt(0);
                double additionalRate = (minutesUsed - 300) * 0.15;
                amountOwed = 300 * 0.2 + additionalRate;
                if (bonus == 'y') {
                    amountOwed = amountOwed * 0.7;
                }
            }
        }
        // prints the final result
        System.out.printf("The customer's type is %c, the minutes used are %d, and the charge is $%.2f.", customerType, minutesUsed, amountOwed);
    }
}

/*
Enter the type of customer:
C
Enter the number of minutes the customer used:
150
The customer's type is c, the minutes used are 150, and the charge is $30.00.


Enter the type of customer:
e
Enter the number of minutes the customer used:
271
The customer's type is e, the minutes used are 271, and the charge is $48.78.


Enter the type of customer:
e
Enter the number of minutes the customer used:
0
The customer's type is e, the minutes used are 0, and the charge is $0.00.


Enter the type of customer:
p
Enter the number of minutes the customer used:
-10
Invalid number of minutes


Enter the type of customer:
P
Enter the number of minutes the customer used:
315
The customer's type is p, the minutes used are 315, and the charge is $28.90.


Enter the type of customer:
R
Enter the number of minutes the customer used:
28
The customer's type is r, the minutes used are 28, and the charge is $5.00.


Enter the type of customer:
r
Enter the number of minutes the customer used:
423
The customer's type is r, the minutes used are 423, and the charge is $41.30.


Enter the type of customer:
C
Enter the number of minutes the customer used:
301
What is your bonus status
y
The customer's type is c, the minutes used are 301, and the charge is $42.11.


Enter the type of customer:
T
Invalid client type


Enter the type of customer:
c
Enter the number of minutes the customer used:
205
The customer's type is c, the minutes used are 205, and the charge is $41.00.


Enter the type of customer:
C
Enter the number of minutes the customer used:
551
What is your bonus status
n
The customer's type is c, the minutes used are 551, and the charge is $97.65.


Enter the type of customer:
p
Enter the number of minutes the customer used:
626
The customer's type is p, the minutes used are 626, and the charge is $45.04.


Enter the type of customer:
E
Enter the number of minutes the customer used:
10583
Invalid number of minutes


Enter the type of customer:
p
Enter the number of minutes the customer used:
45
The customer's type is p, the minutes used are 45, and the charge is $12.70.


Enter the type of customer:
R
Enter the number of minutes the customer used:
8301
The customer's type is r, the minutes used are 8301, and the charge is $829.10.


Enter the type of customer:
c
Enter the number of minutes the customer used:
881
What is your bonus status
No
The customer's type is c, the minutes used are 881, and the charge is $147.15.


Enter the type of customer:
a
Invalid client type


Enter the type of customer:
C
Enter the number of minutes the customer used:
343
What is your bonus status
Yes
The customer's type is c, the minutes used are 343, and the charge is $46.52.

 */