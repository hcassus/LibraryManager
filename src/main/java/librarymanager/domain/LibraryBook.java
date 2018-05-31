package librarymanager.domain;

public class LibraryBook {

    private String name;
    private boolean isLent;

    public void setTitle(String bookTitle) {
        name = bookTitle;
    }

    public String getTitle() {
        return name;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }
}
