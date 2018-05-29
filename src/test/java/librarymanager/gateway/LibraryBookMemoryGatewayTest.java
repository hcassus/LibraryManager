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
    public void retrieveCreatedBookTest(){
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
}