/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 04/11/2023
    Assignment #12
    Instructor: Brian Sauer
 */

import java.text.DecimalFormat;

public class Program12 {
    public static void main(String[] args) {

        // formats all non-zero decimals to 2 places
        DecimalFormat df = new DecimalFormat("#.##");

        // Creates right triangle objects
        RightTriangle triangle1 = new RightTriangle(5, 20);
        RightTriangle triangle2 = new RightTriangle(3, 4);
        RightTriangle triangle3 = new RightTriangle();
        RightTriangle triangle4 = new RightTriangle(16.3, 4.889);

        // outputs info for triangle1
        System.out.println(df.format(triangle1.getPerimeter()));
        System.out.println(df.format(triangle1.getAngleA()));
        System.out.println(df.format(triangle1.getAngleB()));

        // outputs info for triangle 2
        System.out.println(df.format(triangle2.getArea()));

        // sets new sides for triangle 3
        triangle3.setSideA(10.1);
        triangle3.setSideB(12.4);

        // outputs angles A and B of triangle 3
        System.out.println(df.format(triangle3.getAngleA()));
        System.out.println(df.format(triangle3.getAngleB()));

        // outputs triangle 4's triangle and properties
        System.out.println(triangle4);

        // fails to set triangle 4's side to a negative number
        triangle4.setSideA(-6);

        // outputs triangle 4's triangle and properties
        System.out.println(triangle4);

        // sets triangle 2's side A
        triangle2.setSideA(5);

        // outputs triangle 2's triangle and properties
        System.out.println(triangle2);
    }
}

/*
45.62
14.04
75.96
6
39.16
50.84
Side A: 16.3
Side B: 4.89
Hypotenuse: 17.02
Perimeter: 38.21
Area: 39.85
Please enter a number greater than 0
Side A: 16.3
Side B: 4.89
Hypotenuse: 17.02
Perimeter: 38.21
Area: 39.85
Side A: 5
Side B: 4
Hypotenuse: 6.4
Perimeter: 15.4
Area: 10
 */