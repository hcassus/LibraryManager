package librarymanager.gateway;

import librarymanager.domain.LibraryBook;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryBookMemoryGatewayTest {

    private LibraryBookMemoryGateway libraryBookMemoryGateway;

    @Before
    public void setup(){
        libraryBookMemoryGateway = new LibraryBookMemoryGateway();
    }

    @Test
    public void saveBookTest(){
        String bookTitle = "Lord of the Rings";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);

        LibraryBook persistedBook = libraryBookMemoryGateway.saveLibraryBook(book);

        assertThat(persistedBook.getTitle(), is(bookTitle));
    }

    @Test
    public void retrieveAllBooksTest(){
        String bookTitle = "Anne Frank Diary";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);

        String bookTitle2 = "Harry Potter";
        LibraryBook book2 = new LibraryBook();
        book2.setTitle(bookTitle2);

        libraryBookMemoryGateway.saveLibraryBook(book);
        libraryBookMemoryGateway.saveLibraryBook(book2);

        List<LibraryBook> persistedBooks = libraryBookMemoryGateway.getAllBooks();

        assertThat(persistedBooks, hasItems(book, book2));
    }

    @Test
    public void retrieveBookByTitleTest(){
        String bookTitle = "Anne Frank Diary";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);

        String bookTitle2 = "Harry Potter";
        LibraryBook book2 = new LibraryBook();
        book2.setTitle(bookTitle2);

        String bookTitle3 = "50 Shades of Grey";
        LibraryBook book3 = new LibraryBook();
        book3.setTitle(bookTitle3);

        libraryBookMemoryGateway.saveLibraryBook(book);
        libraryBookMemoryGateway.saveLibraryBook(book2);
        libraryBookMemoryGateway.saveLibraryBook(book3);

        LibraryBook retrievedBook = libraryBookMemoryGateway.getBookByTitle("Harry Potter");

        assertThat(retrievedBook, is(book2));
        assertThat(retrievedBook.getTitle(), is("Harry Potter"));
    }

    @Test
    public void retrieveBookByIsbnTest(){
        String bookIsbn13 = "9870123456789";
        LibraryBook book = new LibraryBook();
        book.setIsbn13(bookIsbn13);

        String desiredIsbn = "9870123456456";
        LibraryBook book2 = new LibraryBook();
        book2.setIsbn13(desiredIsbn);

        String bookIsbn13_3 = "9870123456123";
        LibraryBook book3 = new LibraryBook();
        book3.setIsbn13(bookIsbn13_3);

        libraryBookMemoryGateway.saveLibraryBook(book);
        libraryBookMemoryGateway.saveLibraryBook(book2);
        libraryBookMemoryGateway.saveLibraryBook(book3);

        LibraryBook retrievedBook = libraryBookMemoryGateway.getBookByIsbn(desiredIsbn);

        assertThat(retrievedBook, is(book2));
        assertThat(retrievedBook.getIsbn13(), is(desiredIsbn));
    }

    @Test
    public void updateExistingBookTest(){
        String bookTitle = "Anne Frank Diary";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        book.setLent(false);

        LibraryBook book2 = new LibraryBook();
        book2.setTitle(bookTitle);
        book2.setLent(true);

        libraryBookMemoryGateway.saveLibraryBook(book);
        libraryBookMemoryGateway.saveLibraryBook(book2);

        assertThat(libraryBookMemoryGateway.getAllBooks().size(), is(1));
        assertThat(libraryBookMemoryGateway.getBookByTitle(bookTitle).isLent(), is(true));
    }

    @Test
    public void removeExistingBookTest(){
        String bookTitle1 = "Anne Frank Diary";
        String bookTitle2 = "The Karamazov Brothers";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle1);
        book.setLent(false);

        LibraryBook book2 = new LibraryBook();
        book2.setTitle(bookTitle2);
        book2.setLent(true);

        libraryBookMemoryGateway.saveLibraryBook(book);
        libraryBookMemoryGateway.saveLibraryBook(book2);

        libraryBookMemoryGateway.deleteBook(book2);

        assertThat(libraryBookMemoryGateway.getAllBooks().size(), is(1));
        assertThat(libraryBookMemoryGateway.getAllBooks().get(0), is(book));
    }
}