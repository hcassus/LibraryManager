package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGatewayFake;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetAllLibraryBooksUsecaseTest {

    private GetAllLibraryBooksUsecase getAllLibraryBooksUsecase;
    private LibraryBookGatewayFake libraryBookGatewayFake;

    @Before
    public void setup(){
        libraryBookGatewayFake = new LibraryBookGatewayFake();
        getAllLibraryBooksUsecase = new GetAllLibraryBooksUsecase(libraryBookGatewayFake);
    }

    @Test
    public void getAllBooksTest(){
        LibraryBook book1 = new LibraryBook();
        book1.setTitle("Chronicles of Narnia");
        LibraryBook book2 = new LibraryBook();
        book2.setTitle("Animal Farm");
        libraryBookGatewayFake.setCreatedBooks(Arrays.asList(book1,book2));

        List<LibraryBook> books = getAllLibraryBooksUsecase.execute();

        assertThat(books, hasItems(book1, book2));
    }
}
