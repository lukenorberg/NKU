import java.util.Scanner;

public class PowersUsername {
    private static int multiplications;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        double base = scanner.nextDouble();
        System.out.print("Enter a non-negative integer exponent: ");
        int exponent = scanner.nextInt();

        // EXPECT
        multiplications = 0;
        System.out.printf("\nComputing %f to the power %d\n", base, exponent);
        System.out.printf("Math.pow(%f, %d) = %f\n\n", base, exponent, Math.pow(base, exponent));

        // PART I
        multiplications = 0;
        System.out.printf("power1(%f, %d) = %f \n", base, exponent, power1(base, exponent));
        System.out.printf("Multiplications = %d\n\n", multiplications);

        // PART II
        multiplications = 0;
        System.out.printf("power2(%f, %d) = %f \n", base, exponent, power2(base, exponent));
        System.out.printf("Multiplications = %d\n\n", multiplications);

        // PART III
        multiplications = 0;
        System.out.printf("power3(%f, %d) = %f \n", base, exponent, power3(base, exponent));
        System.out.printf("Multiplications = %d\n\n", multiplications);

        // PART IV
        multiplications = 0;
        System.out.printf("power4(%f, %d) = %f \n", base, exponent, power4(base, exponent));
        System.out.printf("Multiplications = %d\n\n", multiplications);

        // PART V
        multiplications = 0;
        System.out.printf("power5(%f, %d) = %f \n", base, exponent, power5(base, exponent));
        System.out.printf("Multiplications = %d\n\n", multiplications);
        scanner.close();
    }

    // PART I
    public static double power1(double b, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        double accum = 1;
        for (int i = 0; i < n; i++) {
            multiplications++;
            accum *= b;
        }
        return accum;
    }

    // PART II
    public static double power2(double b, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (n == 0) return 1;
        multiplications++;
        return b * power2(b, n - 1);
    }

    // PART III
    public static double power3(double b, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (n == 0) return 1;
        double sqrt = power3(b, n / 2);
        if (n % 2 == 0) {
            multiplications++;
            return sqrt * sqrt;
        }
        multiplications += 2;
        return b * sqrt * sqrt;
    }

    // PART IV
    public static double multPow(double a, double b, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (n == 0) return a;
        if (n % 2 == 0) {
            multiplications++;
            return multPow(a, b * b, n / 2);
        }
        multiplications += 2;
        return multPow(b * a, b * b, n / 2);
    }

    public static double power4(double b, int n) {
        return multPow(1, b, n);
    }

    // PART V
    public static double power5(double b, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        double a = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                multiplications++;
            } else {
                multiplications += 2;
                a *= b;
            }
            b *= b;
            n /= 2;
        }
        return a;
    }
}
