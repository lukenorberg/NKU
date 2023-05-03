/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 04/18/2023
    Assignment #13
    Instructor: Brian Sauer
 */

public class Program13 {
    public static void main(String[] args) {
        Rational r1 = new Rational(1,6); // this will become 1/6
        System.out.println("r1 " + r1);
        Rational r2 = new Rational(-5, -7); // this will become 5/7
        System.out.println("r2 " +r2);
        Rational r3 = new Rational(4, 2); // this will become 2/1
        System.out.println("r3 " +r3);
        Rational r4 = new Rational(3, -2); // this will become -3/2
        System.out.println("r4 " + r4);
        Rational r5 = r1.add(r3); // 13/6 = 1/6 + 2/1
        System.out.printf("r5 (%s) = r1 (%s) + r3 (%s)\n", r5, r1, r3);
        Rational r6 = r5.multiply(r4); // -13/4 = 13/6 + -3/2
        System.out.printf("r6 (%s) = r5 (%s) * r4 (%s)\n", r6, r5, r4);
        Rational r7 = r2.subtract(r2);// 0/1 = 5/7 - 5/7
        System.out.printf("r7 (%s) = r2 (%s) - r2 (%s)\n", r7, r2, r2);
        String r3string = r3.toString();
        r3 = r4.subtract(r3);// -7/2 = -3/2 - 2/1
        System.out.printf("r3 (%s) = r4 (%s) - r3 (%s)\n", r3, r4, r3string);

// r3 (-7 / 2) = r4 (-3 / 2) - r3 (2 / 1)
// -3/2 > 13/6 returns -1
        System.out.printf("r4 (%s) > r5 (%s) returns %d\n", r4, r5,
                r4.compareTo(r5));
// 1/6 > 10/60 returns 0
        System.out.printf("r1(%s).compareTo(new Rational(10, 60)) returns %d\n",
                r1, r1.compareTo(new Rational(10, 60)));
// print out all 7 Rationals
        System.out.println("**** r1 - r7");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);
        System.out.println(r7);
    }
}

/*
r1 1/6
r2 5/7
r3 2/1
r4 -3/2
r5 (13/6) = r1 (1/6) + r3 (2/1)
r6 (-13/4) = r5 (13/6) * r4 (-3/2)
r7 (0/1) = r2 (5/7) - r2 (5/7)
r3 (-7/2) = r4 (-3/2) - r3 (2/1)
r4 (-3/2) > r5 (13/6) returns -1
r1(1/6).compareTo(new Rational(10, 60)) returns 0
**** r1 - r7
1/6
5/7
-7/2
-3/2
13/6
-13/4
0/1
 */