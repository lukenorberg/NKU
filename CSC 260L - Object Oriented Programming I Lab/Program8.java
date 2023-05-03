/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 03/21/2023
    Assignment #8
    Instructor: Brian Sauer
 */


import java.util.Scanner;
public class Lab8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // lets the user decide the length of the list
        System.out.println("Number of items:");
        int itemsInArray = input.nextInt();
        // If array isn't between 1 and 100, error message appears
        if (itemsInArray < 1 || 100 < itemsInArray) {
            System.out.println("ERROR: please enter an integer between 1 and 100");
            System.exit(0);
        }

        // assigns methods
        int[] intArray = createArray(itemsInArray, input);
        double averageOfArray = averageOfArray(intArray);
        double stdDevOfArray = stdDevOfArray(intArray, averageOfArray);
        if (stdDevOfArray == -1000) {
            System.out.println("ERROR: cannot calculate standard deviation with the given values");
        }
        int numsLessThanAverage = numsLessThanAverage(intArray, averageOfArray);
        boolean arrayInOrder = arrayInOrder(intArray);

        // returns and formats the average, standard deviation, the values less than average, and if the array is in sorted order
        System.out.printf("Average: %12.2f\n", averageOfArray);
        System.out.printf("Std Dev: %12.2f\n", stdDevOfArray);
        System.out.printf("Less than Avg: %2d\n", numsLessThanAverage);
        System.out.println(arrayInOrder ? "Array is in sorted order" : "Array is not in sorted order");

    }

    public static int[] createArray(int numItems, Scanner input) {
        // creates array and lets the user assign the values
        int[] intArray = new int[numItems];
        System.out.println("Items:");
        for (int i = 0; i < numItems; i++) {
            intArray[i] = input.nextInt();
        }
        return intArray;
    }
    public static double averageOfArray(int[] list) {
        // calculates the average of the values in the array
        double total = 0;
        int count = 0;
        for (int num : list) {
            total += num;
            count++;
        }
        return total / count;
    }

    public static double stdDevOfArray(int[] list, double average) {
        // calculates the standard deviation of the numbers in the array
        double stdDevNumerator = 0;
        int n = list.length;
        // since standard deviation cannot be calculated if the length of an array is less than 2, method returns -1000 as an error message
        if (n < 2) {
            return -1000;
        }
        for (int num : list) {
            stdDevNumerator += Math.pow((num - average), 2);
        }
        double stdDev = Math.sqrt((stdDevNumerator / (n - 1)));
        return stdDev;
    }

    public static int numsLessThanAverage(int[] list, double average) {
        // calculates the number of values that are less than average
        int lessThanAverage = 0;
        for (int num : list) {
            if (num < average) {
                lessThanAverage++;
            }
        }
        return lessThanAverage;
    }

    public static boolean arrayInOrder(int[] list) {
        // checks if the list is in numerical order
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

/*
Number of items:
5
Items:
16
25
81
80
24
Average:        45.20
Std Dev:        32.41
Less than Avg:  3
Array is not in sorted order


Number of items:
10
Items:
1000
1001
1111
1222
1775
1776
1777
1888
1997
1998
Average:      1554.50
Std Dev:       417.93
Less than Avg:  4
Array is in sorted order


Number of items:
1
Items:
1000
ERROR: cannot calculate standard deviation with the given values
Average:      1000.00
Std Dev:     -1000.00
Less than Avg:  0
Array is in sorted order


Number of items:
10
Items:
1
2
3
9
8
7
4
6
12
15
Average:         6.70
Std Dev:         4.47
Less than Avg:  5
Array is not in sorted order


Number of items:
0
ERROR: please enter an integer between 1 and 100


Number of items:
20
Items:
21
3
20
5
30
1
33
14
17
18
10
4
48
50
22
25
6
47
8
19
Average:        20.05
Std Dev:        15.10
Less than Avg: 12
Array is not in sorted order


Number of items:
10
Items:
8
7
8
7
8
7
9
8
9
7
Average:         7.80
Std Dev:         0.79
Less than Avg:  4
Array is not in sorted order
 */