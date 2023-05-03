public class GradStudent extends Student {
    public GradStudent(String name, String number, int hoursAttempted, int qualityPoints) {
        super(name, number, hoursAttempted, qualityPoints);
    }

    public boolean qualifiedForScholarship() {
        return getGPA() >= 3.5 && getHoursAttempted() >= 30;
    }
}
