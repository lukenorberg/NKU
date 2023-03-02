import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //initializes variables
        final String BORDER = "----------------------------------------------";
        final String RESTAURANT_NAME = "Money Pit";
        String dayOfTheWeek = "";
        String drinkOrder = "";
        String mealChoice1 = "";
        String mealChoice2 = "";
        String finalMealChoice = "";
        int drinkOrderPrice = 0;
        int mealChoice1Price = 0;
        int mealChoice2Price = 0;
        int finalMealChoicePrice = 0;
        int tipPercent = 0;
        double tipAmount;
        double finalPrice;

        // asks for name
        System.out.println("What is your name?");
        String name = scan.nextLine();

        // asks for the day of the week
        System.out.println(BORDER);
        System.out.printf("Hi %s,\n", name);
        System.out.printf("Welcome to %s!\n\n", RESTAURANT_NAME);
        System.out.println("To get you started, what day is today?");
        System.out.println("1. Monday");
        System.out.println("2. Tuesday");
        System.out.println("3. Wednesday");
        System.out.println("4. Thursday");
        System.out.println("5. Friday");
        System.out.println("6. Saturday");
        System.out.println("7. Sunday");
        System.out.println(BORDER);

        // assigns number with day of the week
        int intDayOfTheWeek = scan.nextInt();
        switch (intDayOfTheWeek) {
            case 1: dayOfTheWeek = "Monday";
            break;
            case 2: dayOfTheWeek = "Tuesday";
            break;
            case 3: dayOfTheWeek = "Wednesday";
            break;
            case 4: dayOfTheWeek = "Thursday";
            break;
            case 5: dayOfTheWeek = "Friday";
            break;
            case 6: dayOfTheWeek = "Saturday";
            break;
            case 7: dayOfTheWeek = "Sunday";
            break;
        }

        // checks if we are closed on the day of the week selected
        System.out.println(BORDER);
        if (dayOfTheWeek.equals("Saturday")) {
            System.out.printf("Sorry %s!\n", name);
            System.out.printf("We are closed on day %s\n", dayOfTheWeek);
            System.out.println(BORDER);

        // asks for their drink order
        } else {
            System.out.printf("Happy %s, %s!\n", dayOfTheWeek, name);
            System.out.println("What would you like to drink:");
            System.out.println("1. Water                       $15");
            System.out.println("2. Soda                        $50");
            System.out.println("3. Alcohol                    $200");
            System.out.println(BORDER);

        // assigns number with drink order
            int intDrinkOrder = scan.nextInt();
            switch (intDrinkOrder) {
                case 1:
                    drinkOrder = "Water";
                    drinkOrderPrice = 15;
                    break;
                case 2:
                    drinkOrder = "Soda";
                    drinkOrderPrice = 50;
                    break;
                case 3:
                    drinkOrder = "Alcohol";
                    drinkOrderPrice = 200;
                    break;
            }

        // asks for food preference
            System.out.println(BORDER);
            System.out.printf("While you enjoy your %s,\n", drinkOrder);
            System.out.println("what are your food preferences?");
            System.out.println("M = you eat meat");
            System.out.println("V - You are a vegetarian");
            System.out.println(BORDER);

        // assigns letter with food preference
            String foodPreference = scan.next().toUpperCase();
            switch (foodPreference) {
                case "M": foodPreference = "meat eater";
                break;
                case "V": foodPreference = "vegetarian";
                break;
            }

        // determines the food options based on day of the week and food preference
            // meat options
            if (foodPreference.equals("meat eater")) {
                switch (dayOfTheWeek) {
                    case "Monday":
                        mealChoice1 = "Fried Chicken";
                        mealChoice1Price = 100;
                        mealChoice2 = "Pork Chops";
                        mealChoice2Price = 150;
                        break;
                    case "Tuesday":
                        mealChoice1 = "Ribs";
                        mealChoice1Price = 125;
                        mealChoice2 = "Meatloaf";
                        mealChoice2Price = 75;
                        break;
                    case "Wednesday":
                        mealChoice1 = "Grilled Chicken";
                        mealChoice1Price = 80;
                        mealChoice2 = "Tendies";
                        mealChoice2Price = 10000;
                        break;
                    case "Thursday":
                        mealChoice1 = "Shrimp Pasta";
                        mealChoice1Price = 200;
                        mealChoice2 = "Chicken Pasta";
                        mealChoice2Price = 200;
                        break;
                    case "Friday":
                        mealChoice1 = "Salmon";
                        mealChoice1Price = 150;
                        mealChoice2 = "Lobster";
                        mealChoice2Price = 200;
                        break;
                    case "Sunday":
                        mealChoice1 = "Shrimp Platter";
                        mealChoice1Price = 400;
                        mealChoice2 = "Burger";
                        mealChoice2Price = 100;
                        break;
                    }
                } else {

                // vegetarian options
                    switch (dayOfTheWeek) {
                        case "Monday":
                            mealChoice1 = "Cobb Salad";
                            mealChoice1Price = 100;
                            mealChoice2 = "Caesar Salad";
                            mealChoice2Price = 75;
                            break;
                        case "Tuesday":
                            mealChoice1 = "Strawberry Salad";
                            mealChoice1Price = 75;
                            mealChoice2 = "Vegetable Soup";
                            mealChoice2Price = 200;
                            break;
                        case "Wednesday":
                            mealChoice1 = "Potato Soup";
                            mealChoice1Price = 150;
                            mealChoice2 = "French Onion Soup";
                            mealChoice2Price = 200;
                            break;
                        case "Thursday":
                            mealChoice1 = "Pasta";
                            mealChoice1Price = 125;
                            mealChoice2 = "Kale (gross)";
                            mealChoice2Price = 9999;
                            break;
                        case "Friday":
                            mealChoice1 = "Cheese Stick";
                            mealChoice1Price = 75;
                            mealChoice2 = "Cheese Pizza";
                            mealChoice2Price = 175;
                            break;
                        case "Sunday":
                            mealChoice1 = "Fried Onion";
                            mealChoice1Price = 150;
                            mealChoice2 = "Cheese Fries";
                            mealChoice2Price = 75;
                            break;
                }
            }

            // asks user for what food they want
            System.out.println(BORDER);
            System.out.printf("Perfect, %s!\n", name);
            System.out.printf("For a %s like you,\n", foodPreference);
            System.out.printf("on %s we have the following:\n", dayOfTheWeek);
            System.out.printf("1. %-25s $%d\n", mealChoice1, mealChoice1Price);
            System.out.printf("2. %-25s $%d\n", mealChoice2, mealChoice2Price);
            System.out.println(BORDER);

            // assigns number user picks for food item with the food item.
            int numOfFoodChoice = scan.nextInt();
            switch (numOfFoodChoice) {
                case 1:
                    finalMealChoice = mealChoice1;
                    finalMealChoicePrice = mealChoice1Price;
                    break;
                case 2:
                    finalMealChoice = mealChoice2;
                    finalMealChoicePrice = mealChoice2Price;
            }

            // asks how much they want to tip
            int totalBeforeTip = drinkOrderPrice + finalMealChoicePrice;
            System.out.println(BORDER);
            System.out.printf("Great, %s,\n", name);
            System.out.printf("Your total is going to be $%d.\n", totalBeforeTip);
            System.out.println("How much would you like to tip?");
            System.out.println("1. no tip");
            System.out.println("2. 5%");
            System.out.println("3. 10%");
            System.out.println("4. 15%");
            System.out.println("5. 20%");
            System.out.println(BORDER);

            // reads user input for tip percentage
            int tipPercentOption = scan.nextInt();
            switch (tipPercentOption) {
                case 1:
                     tipPercent = 0;
                    break;
                case 2:
                    tipPercent = 5;
                    break;
                case 3:
                    tipPercent = 10;
                    break;
                case 4:
                    tipPercent = 15;
                    break;
                case 5:
                    tipPercent = 20;
                    break;
            }

            // outputs the billing information
            tipAmount = (tipPercent / 100.0) * totalBeforeTip;
            finalPrice = tipAmount + totalBeforeTip;
            System.out.println(BORDER);
            System.out.printf("Thank you so much, %s\n", name);
            System.out.printf("you will be billed $%.2f.\n", finalPrice);
            System.out.printf("Thanks for visiting %s!\n", RESTAURANT_NAME);
            System.out.println(BORDER);
        }
    }
}

// I spent half an hour missing THAT .0 IN LINE 247 >:(
