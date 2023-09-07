package hw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NorbergLukeA1P1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = intChecker(input, "first");
        int num2 = intChecker(input, "second");
        System.out.printf("The sum is %d", num1 + num2);
    }

    // checks if an int is provided, imports scanner and the number's order
    public static int intChecker(Scanner input, String numOrder) {
        boolean numProvided = false;
        int num1 = 0;

        // loops until int is provided
        while (!numProvided) {
            try {
                System.out.printf("Enter %s integer: ", numOrder);
                num1 = input.nextInt();
                numProvided = true;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                input.nextLine();
            }
        }
        return num1;
    }
}
