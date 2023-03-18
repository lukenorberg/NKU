/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 02/07/2023
    Assignment #3
    Instructor: Brian Sauer
 */

import java.util.Scanner;
public class Program3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // grabs values from user
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter price per gallon: ");
        double pricePerGallon = input.nextDouble();
        System.out.println("Enter total price for fill up: ");
        double priceOfFillUp = input.nextDouble();
        System.out.println("Enter initial odometer value: ");
        int initOdometerVal = input.nextInt();
        System.out.println("Enter final odometer value: \n\n");
        int finalOdometerVal = input.nextInt();

        // uses user input for formulas
        int milesDriven = finalOdometerVal - initOdometerVal;
        double gallonsUsed = priceOfFillUp / pricePerGallon;
        double mpg = milesDriven / gallonsUsed;

        //feeds information about the car
        System.out.printf("%s, you drove %d miles using\n%.2f gallons with an mpg of %.2f", name, milesDriven, gallonsUsed, mpg);
    }
}

/*
TEST ONE ------------------------------------------------------------------------
    Enter your name:
    Luke
    Enter price per gallon:
    2.84
    Enter total price for fill up:
    20.25
    Enter initial odometer value:
    6144
    Enter final odometer value:
    6279
    

    Luke, you drove 135 miles using
    7.13 gallons with an mpg of 18.93

TEST TWO ------------------------------------------------------------------------
    Enter your name:
    Frank
    Enter price per gallon:
    1.72
    Enter total price for fill up:
    31.40
    Enter initial odometer value:
    21975
    Enter final odometer value:
    22496


    Frank, you drove 521 miles using
    18.26 gallons with an mpg of 28.54

TEST THREE ------------------------------------------------------------------------
    Enter your name:
    Ruth
    Enter price per gallon:
    3.75
    Enter total price for fill up:
    22.87
    Enter initial odometer value:
    89108
    Enter final odometer value:
    89183


    Ruth, you drove 75 miles using
    6.10 gallons with an mpg of 12.30

TEST FOUR ------------------------------------------------------------------------
    Enter your name:
    Gail
    Enter price per gallon:
    2.05
    Enter total price for fill up:
    20.50
    Enter initial odometer value:
    65380
    Enter final odometer value:
    65691


    Gail, you drove 311 miles using
    10.00 gallons with an mpg of 31.10
 */