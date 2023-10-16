package hw;

public class TestOctagon {
    public static void main(String[] args) {
        Octagon oct1 = new Octagon(5);
        System.out.println(oct1);
        Octagon oct2 = oct1.clone();
        System.out.println(oct2);
        System.out.println(oct1.compareTo(oct2));
    }
}
