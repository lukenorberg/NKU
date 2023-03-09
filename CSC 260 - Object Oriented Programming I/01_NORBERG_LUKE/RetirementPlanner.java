/*Program requesting info from a user to determine how long until they retire and
    when they retire.
 */

import java.util.Scanner;
public class RetirementPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // assigns user inputs to variables that will be used for calculations
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("What is your monthly Salary?");
        int salary = input.nextInt();
        System.out.println("What is your age?");
        int age = input.nextInt();
        System.out.println("What percent of your monthly salary do you save?");
        int percentSaved = input.nextInt();
        System.out.println("How much money do you need to retire?");
        int readyToRetire = input.nextInt();

        //additional calculations based on user input
        double dollarSaved = salary * percentSaved * 0.01;
        double yearsLeft = readyToRetire / (dollarSaved * 12);
        double retirementAge = yearsLeft + age;

        //outputs the final program
        System.out.println("----------------------------------------------");
        System.out.println("RETIREMENT PLAN FOR: " + name);
        System.out.println("----------------------------------------------");
        System.out.println("You make $" + salary + "/month");
        System.out.println("You save " + percentSaved + "% of your monthly salary ($" + dollarSaved + ")");
        System.out.println("You plan to retire when you'll save $" + readyToRetire);
        System.out.println("You will have to work for " + yearsLeft + " more years");
        System.out.println("You will be " + retirementAge + " when you will retire");
        System.out.println("----------------------------------------------");
        System.out.println("GOOD LUCK by LUKE_NORBERG");

    }
}
