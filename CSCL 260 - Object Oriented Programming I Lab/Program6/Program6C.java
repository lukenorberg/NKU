/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 02/28/2023
    Assignment #3
    Instructor: Brian Sauer
 */
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        // sums the numbers 1 through ten and displays each sum
        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
            System.out.println(sum);
        }
        sum = 0;
        // sums the numbers until the sum is greater than 200 and displays each sum

        for (int i = 1; sum <= 200; i++) {
            sum = sum + i;
            System.out.println(sum);
        }
    }
}

/*
1
3
6
10
15
21
28
36
45
55
1
3
6
10
15
21
28
36
45
55
66
78
91
105
120
136
153
171
190
210
 */