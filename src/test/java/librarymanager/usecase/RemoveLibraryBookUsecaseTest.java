package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGatewayFake;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RemoveLibraryBookUsecaseTest {

    private RemoveLibraryBookUsecase removeLibraryBookUsecase;
    private LibraryBookGatewayFake libraryBookGateway;

    @Before
    public void setup(){
        libraryBookGateway = new LibraryBookGatewayFake();
        removeLibraryBookUsecase = new RemoveLibraryBookUsecase(libraryBookGateway);
    }

    @Test
    public void removeBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        libraryBookGateway.saveLibraryBook(book);

        removeLibraryBookUsecase.execute(book);

        List<LibraryBook> allBooks = libraryBookGateway.getAllBooks();

        assertThat(allBooks.size(), is(0));
    }
}
