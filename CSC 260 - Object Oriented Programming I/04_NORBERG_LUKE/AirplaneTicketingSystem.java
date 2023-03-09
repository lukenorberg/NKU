/*
AIRPLANE TICKETING SYSTEM:

This is an Airplane ticketing system designed to grab user wants for traveling such as the departure city, arrival city,
date of travel, etc. in order to provide the current price of travel given the customer's wants. The customer is given
the flexibility to change the travel date or restart the program to receive a full picture of their options.

 */

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class main {
    public static void main(String[] args) {
        boolean ticketNotPurchased = true;

        // the program runs until the customer purchases a ticket
        while (ticketNotPurchased) {
            Scanner input = new Scanner(System.in);

            // grabs and formats current date
            LocalDateTime current = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String formattedCurrentDate = current.format(formatter);
            boolean classNotChosen = true;


            // asks users for their departing city, arrival city, and departure date.
            System.out.println("Greetings! What is your departure city?");
            String departureCity = input.nextLine();
            System.out.println("What is your arrival city?");
            String arrivalCity = input.nextLine();

            // while the user haven't chosen the class, it offers them to pick the class, change the date, or start the program over
            while (classNotChosen) {
                String travelDate = changeDate();

                String travelMonth = travelDate.substring(0, 2);

                // assigns functions to calculate the cost for the customer
                int milesTraveled = priceByMiles(departureCity, arrivalCity);
                int priceOfGas = priceByGallon(travelMonth);
                double gallonsChargedPerPerson = gallonsChargedPerPerson(milesTraveled);
                int daysUntilTrip = daysUntilTrip(formattedCurrentDate, travelDate);
                double daysBetweenPrice = daysBetweenPrice(daysUntilTrip);

                //calculates the final price before the customer chooses their class
                double priceBeforeClass = gallonsChargedPerPerson * priceOfGas * daysBetweenPrice;

                double economyPrice = priceBeforeClass;
                double comfortPrice = priceBeforeClass * 1.25;
                double businessPrice = priceBeforeClass * 1.75;
                double luxuryPrice = priceBeforeClass * 2;

                // outputs the option for the user to choose their ticket, change the departure date, or reset the program
                border();
                System.out.println("There are four options for your ticket");
                System.out.printf("from %s to %s\n", departureCity, arrivalCity);
                System.out.printf("on %s\n", travelDate);
                System.out.printf("1. Economy: $%.2f\n", economyPrice);
                System.out.printf("2. Comfort: $%.2f\n", comfortPrice);
                System.out.printf("3. Business: $%.2f\n", businessPrice);
                System.out.printf("4. Luxury: $%.2f\n", luxuryPrice);
                border();
                System.out.println("Select one of the previous options to purchase the ticket.");
                System.out.println("Otherwise select:");
                System.out.println("C. Change date");
                System.out.println("R. Start Over");

                char userOption = input.next().charAt(0);
                double classPrice = 0;

                switch (userOption) {
                    case '1':
                        classPrice = economyPrice;
                        break;
                    case '2':
                        classPrice = comfortPrice;
                        break;
                    case '3':
                        classPrice = businessPrice;
                        break;
                    case '4':
                        classPrice = luxuryPrice;
                        break;
                    case 'C':
                        continue;
                    case 'R':
                        classNotChosen = false;
                        continue;
                }

                // once the customer chooses which class, they receive confirmation of their purchase
                border();
                System.out.printf("You have purchased your ticket for %.2f\n", classPrice);
                System.out.println("Thank you!");
                border();
                classNotChosen = false;
                ticketNotPurchased = false;

                // end of program
            }
        }
    }

// FUNCTIONS

    // displays a border for improved readability
    public static void border() {
        System.out.println("----------------------------------------");
    }

    // allows the user to change the date if requested
    public static String changeDate() {
        while (true) {
        // uses a regular expression to check the date the user entered
            String dateRegex = "\\d\\d(\\/|-)\\d\\d(\\/|-)\\d\\d\\d\\d";
            Scanner input = new Scanner(System.in);
            System.out.println("What is your travel date?");
            String travelDate = input.next();
            String formattedInputDate = "";
            if (travelDate.matches(dateRegex)) {
        // formats the date to dd-dd-dddd to be similar  to current date stored on line 12
                for (int i = 0; i < travelDate.length(); i++ ) {
                    if (i == 2 || i == 5 ) formattedInputDate += "-";
                    else formattedInputDate += travelDate.charAt(i);
                }
                return formattedInputDate;
            } else
                System.out.println("Please enter a valid date e.g. 01/01/2023");
        }
    }

    // calculates the distance between the two locations
    public static int priceByMiles(String startingLocation, String endingLocation) {
        int startingLocationMiles = removeWhiteSpace(startingLocation).length();
        int endingLocationMiles = removeWhiteSpace(endingLocation).length();
        return (startingLocationMiles + endingLocationMiles) * 100;
    }

    // removes white space within a string to compare the distance of two locations more accurately, e.g. New York -> NewYork
    public static String removeWhiteSpace(String givenString) {
        String formattedString = "";
        if (givenString.contains(" ")) {
            String[] givenStringWithoutSpaces = givenString.split(" ");
            for (String word : givenStringWithoutSpaces) {
                formattedString += word;
            }
            return formattedString;
        } else return givenString;
    }

    // calculates the price per gallon for the given month of travel
    public static int priceByGallon(String travelMonth) {
        int travelMonthInt = Integer.parseInt(travelMonth);

        if (travelMonthInt <= 3) return 4;
        else if (travelMonthInt <= 6) return 8;
        else if (travelMonthInt <= 9) return 15;
        else return 2;
    }

    // returns the number of gallons each passenger "owes" in their ticket price
    public static double gallonsChargedPerPerson(int distance) {
        if (distance <= 500) return distance / (10.0 * 60);
        else if (distance <= 1000) return distance / (12.0 * 100);
        else if (distance <= 2000) return distance / (15.0 * 150);
        else if (distance <= 5000) return distance / (22.0 * 180);
        else return distance / (25.0 * 200);

    }

    // calculates the difference between the booking date and the departure date
    public static int daysUntilTrip(String currentDate, String futureDate) {
        int daysBetween = 0;
        int monthsBetween = 0;
        int yearsBetween = 0;

        // splits the value of the date into month, day, and year. converts each value to integer for mathematical comparison
        int[] currentDateList = { Integer.parseInt(currentDate.substring(0, 2)),
                                  Integer.parseInt(currentDate.substring(3, 5)),
                                  Integer.parseInt(currentDate.substring(6, 10))
                                    };
        int[] futureDateList = { Integer.parseInt(futureDate.substring(0, 2)),
                                 Integer.parseInt(futureDate.substring(3, 5)),
                                 Integer.parseInt(futureDate.substring(6, 10))
                                    };

        // calculates the days of the month between the given dates
        if (futureDateList[1] < currentDateList[1]) {
            daysBetween = (30 - currentDateList[1]) + futureDateList[1];
            monthsBetween -= 1;
        } else {
            daysBetween += (futureDateList[1] - currentDateList[1]);
        }
        yearsBetween = futureDateList[2] - currentDateList[2];

        // calculates the months between the given dates and calculates the total days between the dates
        if (currentDateList[0] <= futureDateList[0]) {
            monthsBetween += futureDateList[0] - currentDateList[0];
            daysBetween += (monthsBetween * 30) + (yearsBetween * 365);
        } else {
            monthsBetween = (12 - currentDateList[0]) + futureDateList[0] - 1;
            daysBetween += (monthsBetween * 30) + (yearsBetween * 365) - 365;
        }
        return daysBetween;
    }

    // returns the multiplier of the cost of the ticket depending on how late the customer books
    public static double daysBetweenPrice(int daysBetween) {
        System.out.println(daysBetween);
        if (daysBetween >= 30) return 1;
        else if (daysBetween >= 20) return 1.25;
        else if (daysBetween >= 10) return 1.5;
        else return 2;
    }


}
