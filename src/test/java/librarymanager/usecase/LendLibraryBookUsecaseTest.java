package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGatewayFake;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LendLibraryBookUsecaseTest {

    private LibraryBookGatewayFake libraryBookGatewayFake;
    private LendBookUsecase lendBookUsecase;

    @Before
    public void setup(){
        libraryBookGatewayFake = new LibraryBookGatewayFake();
        lendBookUsecase = new LendBookUsecase(libraryBookGatewayFake);
        libraryBookGatewayFake.setCreatedBooks(new ArrayList<>());
    }

    @Test
    public void lendBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        book.setLent(false);
        List<LibraryBook> books = new ArrayList<>();
        books.add(book);
        libraryBookGatewayFake.setCreatedBooks(books);

        lendBookUsecase.execute("1984");

        assertThat(libraryBookGatewayFake.getCreatedBook(), is(book));
        assertThat(libraryBookGatewayFake.getCreatedBook().isLent(), is(true));

    }
}
