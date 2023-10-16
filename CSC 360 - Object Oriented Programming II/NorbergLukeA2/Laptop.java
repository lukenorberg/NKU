package hw;

public class Laptop implements Comparable<Laptop> {

    private double cpu;
    private int ram;
    private int hdd;
    private boolean graphics;
    private double screen;
    private int weight;
    private int battery;
    private int price;
    private double laptopScore;

    // max values for each feature
    final private static double cpuMax = 3.0;
    final private static int ramMax = 32;
    final private static int hddMax = 2048;
    final private static double screenMax = 17.0;
    final private static int weightMax = 6;
    final private static int batteryMax = 9;
    final private static int priceMax = 2000;

    public double getLaptopScore() {
        return laptopScore;
    }

    public Laptop(double cpu, int ram, int hdd, boolean graphics, double screen, int weight, int battery, int price) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.graphics = graphics;
        this.screen = screen;
        this.weight = weight;
        this.battery = battery;
        this.price = price;

        // calculates laptop score up to 10
        this.laptopScore = (2 * cpu/cpuMax) + (2.0 * ram/ramMax) + (1.0 * hdd/hddMax)
                + ((graphics) ? 1 : 0) + (1 * screen/screenMax) + (1.0 * weight/weightMax)
                        + (1.0 * battery/batteryMax) + (1.0 * price/priceMax);
    }

    // compares laptop score
    @Override
    public int compareTo(Laptop o) {
        if (this.laptopScore == o.getLaptopScore()) return 0;
        return (this.laptopScore > o.getLaptopScore()) ? 1 : -1;
    }

    @Override
    public String toString() {
        return String.format(
                "Laptop with CPU = %f, RAM = %d, HDD = %d, graphics card = %b, "
                + "screen size = %f, weight = %d, battery = %d, price = $%d, laptop score = %f",
                cpu, ram, hdd, graphics, screen, weight, battery, price, laptopScore
        );
    }

    // generates 5 sorted laptops with random stats
    public static Laptop[] randomLaptopGenerator() {
        Laptop[] randomLaptops = new Laptop[5];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < randomLaptops.length; i++) {
            randomLaptops[i] = new Laptop(
                random.nextDouble() * (cpuMax - 0.1) + 0.1, // between 0.1 and cpuMax
                random.nextInt(ramMax) + 1, // between 1 and ramMax
                random.nextInt(hddMax - 64 + 1) + 64, // between 64 and hddMax
                     random.nextBoolean(),
              random.nextDouble() * (screenMax - 10) + 10.0, // between 10 and screenMax
              random.nextInt(weightMax) + 1, // between 1 and weightMax
              random.nextInt(batteryMax) + 1, // between 1 and batteryMax
               random.nextInt(priceMax - 200 + 1) + 200 // between 200 and priceMax
                    );
        }
        java.util.Arrays.sort(randomLaptops);
        return randomLaptops;
    }

    public static void main(String[] args) {
        Laptop[] randomLaptops = randomLaptopGenerator();
        for (Laptop laptop : randomLaptops) {
            System.out.println(laptop);
        }
    }
}


