public class LawStudent extends Student {
    private int lsat;

    public LawStudent(String name, String ssn, int hoursAttempted, int qualityPoints, int lsat) {
        super(name, ssn, hoursAttempted, qualityPoints);
        this.lsat = lsat;
    }

    public boolean qualifiedForScholarship() {
        return getGPA() >= 3.25 && lsat >= 150;
    }

    public String toString() {
        return super.toString() + " LSAT: " + lsat;
    }
}
