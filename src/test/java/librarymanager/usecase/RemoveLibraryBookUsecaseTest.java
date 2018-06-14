package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RemoveLibraryBookUsecaseTest {

    private RemoveLibraryBookUsecase removeLibraryBookUsecase;

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Before
    public void setup(){
        removeLibraryBookUsecase = new RemoveLibraryBookUsecase(libraryBookGateway);
    }

    @Test
    public void removeBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);

        removeLibraryBookUsecase.execute(book);

        verify(libraryBookGateway, times(1)).deleteBook(book);
    }
}
