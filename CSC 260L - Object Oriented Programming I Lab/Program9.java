/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 03/28/2023
    Assignment #9
    Instructor: Brian Sauer
 */

import java.util.Scanner;

public class lab9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        int[] numArray = new int[20];
        // lets the user input the numbers they want in the list
        while (true) {
            System.out.println("Input a value. 0 to exit:");
            int userInput = input.nextInt();
            if (userInput == 0) {
                break;
            }
            // adds user input to array
            numArray[number] = userInput;
            number++;
            // breaks once array limit is hit
            if (number == 19) {
                System.out.println("Warning, only one more value allowed");
            }
            else if (number == 20) {
                break;
            }
        }
        // sorts and prints list
        bubbleSort(numArray, number);
        printList(numArray, number);

        // outputs the median,step size, and most occurring number
        System.out.println("The median is " + median(numArray, number));
        System.out.println("The step size is " + stepSize(numArray, number));
        System.out.println("The most occurring number is " + mostOccurring(numArray, number));

    }

    public static void printList(int[] list, int number) {
        // prints all numbers except 0
        for (int i = 0; i < number; i++) {
            System.out.println(list[i]);
        }
    }

    public static int median(int[] list, int number) {
        // finds the median
        int median = (number - 1) / 2;
        return list[median];
    }

    public static double stepSize(int[] list, int number) {
        // calculates the average step size
        int distance = 0;
        for (int i = 0; i <= number - 2; i++) {
            distance += list[i + 1] - list[i];
        }
        double avgStepSize = (double) distance / (number - 1);
        // if the list elements are less than 2, return 0
        if (number < 2) {
            return 0;
        } else {
            return avgStepSize;
        }
    }

    public static int mostOccurring(int[] list, int number) {
        // sets most values to the minimum
        int mostOccurringTimes = 0;
        int mostOccurringNumIndex = -1;

        for (int i = 0; i < number - 1; i++) {
            // sets the most occurring for each element
            int numOfOccurrences = 0;
            for (int j = 1; j < number; j++) {
                // calculates how many occurrences for a given number
                if (list[j] == list[i]) {
                    numOfOccurrences++;
                }
            }
            if (numOfOccurrences > mostOccurringTimes) {
                // if the value checked had more numbers, it updates the global most ammount of numbers
                mostOccurringTimes = numOfOccurrences;
                mostOccurringNumIndex = i;
            }
        }
        return list[mostOccurringNumIndex];
    }
    public static void bubbleSort(int[] list, int number) {
        boolean needNextPass = true;
        for (int k = 1; k < number && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < number - k; i++) {
                if (list[i] > list[i + 1]) {
        // Swap list[i] with list[i + 1]
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true; // Next pass still needed
                }
            }
        }
    }
}

/*
Input a value. 0 to exit:
153
Input a value. 0 to exit:
100
Input a value. 0 to exit:
532
Input a value. 0 to exit:
100
Input a value. 0 to exit:
534
Input a value. 0 to exit:
154
Input a value. 0 to exit:
153
Input a value. 0 to exit:
100
Input a value. 0 to exit:
101
Input a value. 0 to exit:
153
Input a value. 0 to exit:
155
Input a value. 0 to exit:
153
Input a value. 0 to exit:
100
Input a value. 0 to exit:
193
Input a value. 0 to exit:
154
Input a value. 0 to exit:
153
Input a value. 0 to exit:
0
100
100
100
100
101
153
153
153
153
153
154
154
155
193
532
534
The median is 153
The step size is 28.933333333333334
The most occurring number is 153



Input a value. 0 to exit:
66
Input a value. 0 to exit:
39
Input a value. 0 to exit:
38
Input a value. 0 to exit:
44
Input a value. 0 to exit:
65
Input a value. 0 to exit:
66
Input a value. 0 to exit:
67
Input a value. 0 to exit:
55
Input a value. 0 to exit:
44
Input a value. 0 to exit:
54
Input a value. 0 to exit:
66
Input a value. 0 to exit:
38
Input a value. 0 to exit:
67
Input a value. 0 to exit:
43
Input a value. 0 to exit:
66
Input a value. 0 to exit:
67
Input a value. 0 to exit:
33
Input a value. 0 to exit:
66
Input a value. 0 to exit:
51
Input a value. 0 to exit:
0
33
38
38
39
43
44
44
51
54
55
65
66
66
66
66
66
67
67
67
The median is 55
The step size is 1.8888888888888888
The most occurring number is 66



Input a value. 0 to exit:
10
Input a value. 0 to exit:
15
Input a value. 0 to exit:
19
Input a value. 0 to exit:
3
Input a value. 0 to exit:
7
Input a value. 0 to exit:
15
Input a value. 0 to exit:
4
Input a value. 0 to exit:
6
Input a value. 0 to exit:
19
Input a value. 0 to exit:
6
Input a value. 0 to exit:
15
Input a value. 0 to exit:
12
Input a value. 0 to exit:
9
Input a value. 0 to exit:
7
Input a value. 0 to exit:
15
Input a value. 0 to exit:
16
Input a value. 0 to exit:
10
Input a value. 0 to exit:
11
Input a value. 0 to exit:
8
Warning, only one more value allowed
Input a value. 0 to exit:
15
3
4
6
6
7
7
8
9
10
10
11
12
15
15
15
15
15
16
19
19
The median is 10
The step size is 0.8421052631578947
The most occurring number is 15
 */