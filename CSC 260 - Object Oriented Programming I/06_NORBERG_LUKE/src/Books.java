import java.util.Date;
import java.util.Random;

public class Books {

    private String id;
    private String title;
    private String[] authors;
    private boolean borrowed = false;
    private long date_borrowed;
    private Users user_borrowed;

    // constructor

    public Books(String title, String[] authors) {
        this.id = randomId();
        this.title = title;
        this.authors = authors;
    }

    // getters

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String[] getAuthors() {
        return this.authors;
    }

    public boolean getBorrowed() {
        return this.borrowed;
    }

    public long getDateBorrowed() {
        return this.date_borrowed;
    }

    public Users getUserBorrowed() {
        return this.user_borrowed;
    }

    // displays important book info
    public String getBookInfo() {
        // sets the title
        String bookInfo = "Title: " + this.title + "\nAuthor";
        // if there's one author, formats appropriately e.g. "William Shakespeare"
        if (this.authors.length == 1) {
            bookInfo += ": " + this.authors[0];
        }
        // if there's two authors, formats appropriately e.g. "Luke Norberg & Jayden Clark"
        else if (this.authors.length == 2) {
            bookInfo += ": " + this.authors[0] + " & " + this.authors[1];
        } else {
            // if there's 3 or more authors, formats appropriately e.g. "John, Shaun, & Matt"
            // adds s for plurals
            bookInfo += "s: ";
            for (int i = 0; i < this.authors.length; i++) {
                // the last author is appended normally
                if (i == this.authors.length - 1) {
                    bookInfo += this.authors[i];
                    // the second to last author has a comma and an & sign
                } else if (i == this.authors.length - 2) {
                    bookInfo += this.authors[i] + ", & ";
                    // everyone else has their name and a comma
                } else {
                    bookInfo += this.authors[i] + ", ";
                }
            }
        }
        return bookInfo;
    }

    // setters

    public void setBorrowed(boolean trueOrFalse) {
        this.borrowed = trueOrFalse;
    }

    public void setUserBorrowed(Users borrower) {
        Date date = new Date();
        this.user_borrowed = borrower;
        // sets the borrowing user's books borrowed to the book item
        borrower.setBooksBorrowed(this);
        this.date_borrowed = date.getTime();
        this.borrowed = true;
    }

    // if the setUserBorrowed method doesn't have a passed borrower, the book info is reset
    public void setUserBorrowed() {
        this.borrowed = false;
        this.date_borrowed = 0;
        this.user_borrowed.returnBorrowedBook(this);
        this.user_borrowed = null;
    }

    // accessory methods

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
