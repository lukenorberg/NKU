/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 03/14/2023
    Assignment #7
    Instructor: Brian Sauer
 */


import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        // initializes variables
        Scanner input = new Scanner(System.in);
        String dimension, color;
        int height, width, length, numCans;
        double cost;

        // call getSize 3 times for "height", "width", "length"
        height = getSize("height", input);
        length = getSize("length", input);
        width = getSize("width", input);
        // call getColor to get the Color of the room
        color = getColor(input);
        // call numOfPaintCans to determine number of cans
        numCans = numOfPaintCans(height, width, length);
        // call finalCost to compute the cost of the paint cans
        cost = finalCost(numCans, color);
        // calls the output function – pass it the dimensions, color,
        // number of cans of paint, cost and df variables
        output(height, length, width, color, numCans, cost);
    }

    public static int getSize(String caption, Scanner input) {
        // asks for one dimension of the room
        System.out.println("Enter the " + caption + " of the room");
        int value = input.nextInt();
        return value;
    }
    public static String getColor(Scanner input) {
        System.out.println("Enter the color of the room");
        String value = input.next();
        return value;
    }

    public static int numOfPaintCans(int height, int width, int length) {
        final double PAINT_CAN_COVERAGE = 365;
        // calculates squareFootage needed to be painted
        int squareFootage = (2 * (width * height)) + (2 * (length * height)) + (width * length);
        // calculates the number of paint cans needed
        int paintCansNeeded = (int) Math.ceil(squareFootage / PAINT_CAN_COVERAGE);
        return paintCansNeeded;
    }

    public static double finalCost(int numCans, String color) {
        double costPerCan;
        // applies cost per can depending on the color
        switch (color) {
            case "Green":
                costPerCan = 3.68;
                break;
            case "Orange":
                costPerCan = 4.25;
                break;
            case "Mauve":
                costPerCan = 3.69;
                break;
            case "Eggshell":
                costPerCan = 4.25;
                break;
            case "White":
                costPerCan = 3.25;
                break;
            default:
                costPerCan = 6.00;
                break;
            }
        // checks for any discounts that can be applied
        if (numCans > 10) {
            costPerCan *= 0.9;
        } else if ((color.equals("Eggshell") || color.equals("White")) && numCans > 5) {
            costPerCan *= 0.94;
        } else if (numCans > 5) {
            costPerCan *= 0.96;
        }
        double finalPrice = costPerCan * numCans;
        return finalPrice;
    }

    public static void output(int height, int length, int width, String color, int numCans, double cost) {
        // returns info for the customer
        System.out.printf("Height: %d Length: %d Width: %d Color: %s Num Cans: %d Cost: $%.2f", height, length, width, color, numCans, cost);
    }
}

/*
Enter the height of the room
18
Enter the length of the room
20
Enter the width of the room
25
Enter the color of the room
Green
Height: 18 Length: 20 Width: 25 Color: Green Num Cans: 6 Cost: $21.20


Enter the height of the room
12
Enter the length of the room
16
Enter the width of the room
14
Enter the color of the room
Orange
Height: 12 Length: 16 Width: 14 Color: Orange Num Cans: 3 Cost: $12.75


Enter the height of the room
12
Enter the length of the room
22
Enter the width of the room
20
Enter the color of the room
White
Height: 12 Length: 22 Width: 20 Color: White Num Cans: 4 Cost: $13.00


Enter the height of the room
30
Enter the length of the room
85
Enter the width of the room
40
Enter the color of the room
Eggshell
Height: 30 Length: 85 Width: 40 Color: Eggshell Num Cans: 30 Cost: $114.75


Enter the height of the room
10
Enter the length of the room
19
Enter the width of the room
33
Enter the color of the room
Mauve
Height: 10 Length: 19 Width: 33 Color: Mauve Num Cans: 5 Cost: $18.45


Enter the height of the room
9
Enter the length of the room
66
Enter the width of the room
56
Enter the color of the room
Blue
Height: 9 Length: 66 Width: 56 Color: Blue Num Cans: 17 Cost: $91.80


Enter the height of the room
16
Enter the length of the room
28
Enter the width of the room
22
Enter the color of the room
White
Height: 16 Length: 28 Width: 22 Color: White Num Cans: 7 Cost: $21.38


Enter the height of the room
24
Enter the length of the room
35
Enter the width of the room
20
Enter the color of the room
Black
Height: 24 Length: 35 Width: 20 Color: Black Num Cans: 10 Cost: $57.60
 */
