package hw;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {

    private double side;
    private boolean wasCloned = false;

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public boolean getWasCloned() {
        return wasCloned;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 8;
    }

    // compares side of octogon for comparison
    @Override
    public int compareTo(Octagon o) {
        if (this.side == o.getSide()) return 0;
        return (this.side > o.getSide()) ? 1 : -1;
    }

    // performs a shallow clone
    @Override
    public Octagon clone() {
        try {
            Octagon clone = (Octagon) super.clone();
            clone.wasCloned = true;
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return
                String.format(
                "Octagon with side = %.1f, perimeter = %.1f, area = %f, wasCloned = %b",
                        getSide(), getPerimeter(), getArea(), getWasCloned()
                );
    }
}
