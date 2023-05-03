public class Student {
    private String name;
    private String ssn;
    private int hoursAttempted;
    private int qualityPoints;

    public Student(String name, String ssn, int hoursAttempted, int qualityPoints) {
        this.name = name;
        this.ssn = ssn;
        this.hoursAttempted = hoursAttempted;
        this.qualityPoints = qualityPoints;
    }

    public int getHoursAttempted() {
        return hoursAttempted;
    }

    public double getGPA() {
        if (hoursAttempted == 0) {
            return 0;
        }
        return ((double) qualityPoints / hoursAttempted);
    }

    public boolean qualifiedForScholarship() {
        return getGPA() >= 3;
    }

    public String toString() {
        return String.format("Name: %s SSN: %s GPA: %.2f Qualified for scholarship: %b", name, ssn, getGPA(), qualifiedForScholarship());
    }
}
