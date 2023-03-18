/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 02/14/2023
    Assignment #4
    Instructor: Brian Sauer
 */

import java.util.Scanner;
public class Program4 {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);

        // establishes base ticket price and initializes the final ticket price
        final double BASE_TICKET_PRICE = 40.0;
        double ticketPrice;

        // asks for customers age and county and confirms if the age is greater than 0
        System.out.println("Please enter the customer's age: ");
        int age = scan.nextInt();
        if (age < 0) {
            System.out.println("Sorry but this is not a recognized age!");
            System.exit(0);

        // if customers are under 5, they have free admission
        } else if (age < 5) {
            ticketPrice = 0;
            System.out.printf("Ticket price is $%.2f", ticketPrice);
            System.exit(0);

        }
        System.out.println("Please enter the customer's county");
        String county = scan.next();

        // Warren county customers are charged $30 for a ticket
        if (county.equalsIgnoreCase("Warren")) {
            ticketPrice = 30.0;

        // Clermont customers under 14 get a 18% discount
        } else if (county.equalsIgnoreCase("Clermont") && age < 14) {
            ticketPrice = BASE_TICKET_PRICE * 0.82;

        // sets ticket price to the base price
        } else {
            ticketPrice = BASE_TICKET_PRICE;
        }

        // seniors get half off of what the ticket price was previously set to.
        if (age >= 65) {
            ticketPrice = ticketPrice * .5;
        }

        // if seniors are from Campbell, they receive a 7.5% discount on top of the senior discount
        if (county.equalsIgnoreCase("Campbell") && age >= 65) {
            ticketPrice = ticketPrice * 0.925;
        }

        // prints the final ticket price formatted
        System.out.printf("Ticket price is $%.2f", ticketPrice);
    }
}

/*
Please enter the customer's age:
12
Please enter the customer's county
Hamilton
Ticket price is $40.00


Please enter the customer's age:
72
Please enter the customer's county
Hamilton
Ticket price is $20.00


Please enter the customer's age:
2
Ticket price is $0.00


Please enter the customer's age:
0
Ticket price is $0.00


Please enter the customer's age:
35
Please enter the customer's county
Clermont
Ticket price is $40.00


Please enter the customer's age:
4
Ticket price is $0.00


Please enter the customer's age:
24
Please enter the customer's county
Warren
Ticket price is $30.00


Please enter the customer's age:
65
Please enter the customer's county
Campbell
Ticket price is $18.50


Please enter the customer's age:
10
Please enter the customer's county
Clermont
Ticket price is $32.80


Please enter the customer's age:
21
Please enter the customer's county
Campbell
Ticket price is $40.00


Please enter the customer's age:
-15
Sorry but this is not a recognized age!


Please enter the customer's age:
13
Please enter the customer's county
Kenton
Ticket price is $40.00
 */