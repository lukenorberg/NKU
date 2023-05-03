import java.util.Random;
import java.util.ArrayList;

public class Users {
    private String id;
    private String name;
    private ArrayList<Books> booksBorrowed;
    private ArrayList<Books> booksReturned;
    private boolean active;
    private int times_fined;

    // constructors

    Users(String name) {
        this.id = randomId();
        this.name = name;
        this.booksBorrowed = new ArrayList<Books>();
        this.booksReturned = new ArrayList<Books>();
        this.active = true;
        times_fined = 0;
    }

    // getters

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Books> getBooksBorrowed() {
        return this.booksBorrowed;
    }


    public ArrayList<Books> getBooksReturned() {
        return this.booksReturned;
    }

    public boolean getActive() {
        return this.active;
    }

    public int getTimesFined() {
        return this.times_fined;
    }

    // setters

    public void setTimesFined() {
        times_fined++;
    }

    public void setActive(boolean trueOrFalse) {
        this.active = trueOrFalse;
    }

    public void setBooksBorrowed(Books book) {
        booksBorrowed.add(book);

    }

    // accessory methods

    public void returnBorrowedBook(Books book) {
        booksReturned.add(book);
        booksBorrowed.remove(book);
    }

    private String randomId() {
        String finalString = "";
        // creates an array of letters and numbers
        String[] idChars = "abcdefghijklmnopqrstuvwxyz1234567890".split("");
        Random random = new Random();
        // adds 10 random characters for the id
        for (int i = 0; i <= 10; i++) {
            int randomCharIndex = random.nextInt(idChars.length);
            finalString += idChars[randomCharIndex];
        }

        return finalString;
    }
}
