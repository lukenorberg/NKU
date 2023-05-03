/*
    Author: Luke Norberg
    Course: CSC260L - 002
    Date: 04/25/2023
    Assignment #14
    Instructor: Brian Sauer
 */

public class TestStudents {
    public static void main(String[] args) {
        Student[] students = new Student[6];
        students[0] = new Student("Fred Blunt", "111-11-1111", 40, 110);
        students[1] = new Student("Jean Green", "222-22-2222", 80, 280);
        students[2] = new GradStudent("Joan Short", "333-33-3333", 15, 60);
        students[3] = new GradStudent("Jack Jones", "444-44-4444", 30, 108);
        students[4] = new LawStudent("Mark Adams", "555-55-5555", 20, 70, 145);
        students[5] = new LawStudent("Anne Sachs", "666-66-6666", 20, 65, 150);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

/*
Name: Fred Blunt SSN: 111-11-1111 GPA: 2.75 Qualified for scholarship: false
Name: Jean Green SSN: 222-22-2222 GPA: 3.50 Qualified for scholarship: true
Name: Joan Short SSN: 333-33-3333 GPA: 4.00 Qualified for scholarship: false
Name: Jack Jones SSN: 444-44-4444 GPA: 3.60 Qualified for scholarship: true
Name: Mark Adams SSN: 555-55-5555 GPA: 3.50 Qualified for scholarship: false LSAT: 145
Name: Anne Sachs SSN: 666-66-6666 GPA: 3.25 Qualified for scholarship: true LSAT: 150
 */
