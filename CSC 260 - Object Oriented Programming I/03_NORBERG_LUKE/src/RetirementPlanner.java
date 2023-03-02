// Project designed to calculate one or more users retirement information by both texts and visual aids

import java.util.Scanner;

public class RetirementPlanner {
    public static void main(String[] args) {

        while (true) {
        Scanner input = new Scanner(System.in);

        // Grabs information from the user, name, salary, age, etc.
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("What is your monthly Salary?");
        int salary = input.nextInt();
        System.out.println("What is your age?");
        int age = input.nextInt();
        System.out.println("What is the current year?");
        int currentYear = input.nextInt();
        System.out.println("What percent of your monthly salary do you save?");
        int percentSaved = input.nextInt();

        // Calculates the dollar amount saved per year
        double dollarSaved = (double) (salary * percentSaved) * 0.01;
        System.out.println("How much money do you need to retire?");
        int readyToRetire = input.nextInt();

        // Calculates the number of years to retire and the user's retirement age
        double yearsLeft = (double) readyToRetire / dollarSaved;
        double retirementAge = yearsLeft + (double) age;

        // Outputs retirement information text
        border();
        System.out.println("RETIREMENT PLAN FOR: " + name);
        border();
        System.out.printf("You make $%d/month\n", salary);
        System.out.printf("You save %d percent of your monthly salary ($%.2f)\n", percentSaved, dollarSaved);
        System.out.printf("You plan to retire when you'll save $%d\n", readyToRetire);
        System.out.printf("You will have to work for %.1f more years\n", yearsLeft);
        System.out.printf("You will be %.1f when you will retire\n", retirementAge);
        border();

        // Graphically displays retirement savings by year
        int retirementYear = (int) (currentYear + yearsLeft);
        System.out.println("This is how your retirement fund");
        System.out.printf("will look from %d to year %d\n\n", currentYear, retirementYear);

        // Loops through the current year to the retirement year
        for (int i = currentYear; i <= retirementYear; i++) {
            String savingsVisual = "";

            // calculates the number of asterisks for the given year and loops through them
            double asteriskAmount = (((i - currentYear) * dollarSaved) / readyToRetire) * 30;
            for (int numOfStars = 0; numOfStars <= asteriskAmount; numOfStars++) {
                savingsVisual = savingsVisual + "*";
            }
            System.out.printf("%d: %s\n", i, savingsVisual);
        }

        // Checks if user would look to calculate a new plan
            border();
            System.out.println("Do you want to calculate a new retirement plan?");
            System.out.println("Y. Yes");
            System.out.println("N. No");
            border();
            char calcNewPlan = input.next().toLowerCase().charAt(0);
            // btw I learned this in my 260L class
            if (calcNewPlan == 'n') break;
        }
        System.out.println("GOOD LUCK by LUKE_NORBERG");
    }
    public static void border() {
        System.out.println("--------------------------------------------------");
    }
}