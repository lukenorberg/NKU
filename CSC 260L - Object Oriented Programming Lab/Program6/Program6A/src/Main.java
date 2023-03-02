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
        // asks for next value
        Scanner input = new Scanner(System.in);
        System.out.println("Target value?");
        int targetValue = input.nextInt();
        System.out.println("Enter an integer value (0 to quit): ");
        int value = input.nextInt();
        int sum = 0;
        int count = 0;
        int oddCount = 0;
        int targetCount = 0;
        int maxValue = targetValue;
        // enters while loop and only exits when user is done
        while (value != 0) {
            if (value == targetValue) {
                targetCount++;
            }
            sum += value;
            count++;
        // increases odd count if number is odd
            if (count % 2 == 1) {
                oddCount++;
            }
            System.out.println("Enter next value (0 to quit): ");
            value = input.nextInt();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        double average = (double) sum / count;


        // outputs the calculations initialized above
        System.out.println("The sum of the entered values is " + sum);
        System.out.println("The number of values entered is " + count);
        if (count != 0) {
            System.out.println("The average of the entered values is " + average);
        } else {
            System.out.println("average undefined");
        }
        System.out.println("The number of odd values entered is " + oddCount);
        System.out.println("The target count was hit " + targetCount + " times");
        System.out.println("The max number was " + maxValue);
    }
}

/*
Target value?
5
Enter an integer value (0 to quit):
3
Enter next value (0 to quit):
5
Enter next value (0 to quit):
0
The sum of the entered values is 8
The number of values entered is 2
The average of the entered values is 4.0
The number of odd values entered is 1
The target count was hit 1 times
The max number was 5
 */