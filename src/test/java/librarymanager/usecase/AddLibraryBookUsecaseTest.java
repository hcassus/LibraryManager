package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGatewayFake;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddLibraryBookUsecaseTest {

    private AddLibraryBookUsecase addLibraryBookUsecase;
    private LibraryBookGatewayFake libraryBookGateway;

    @Before
    public void setup(){
        libraryBookGateway = new LibraryBookGatewayFake();
        addLibraryBookUsecase = new AddLibraryBookUsecase(libraryBookGateway);
    }

    @Test
    public void addBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);

        addLibraryBookUsecase.execute(book);

        LibraryBook createdBook = libraryBookGateway.getCreatedBook();

        assertThat(createdBook.getTitle(), is(bookTitle));
    }
}
