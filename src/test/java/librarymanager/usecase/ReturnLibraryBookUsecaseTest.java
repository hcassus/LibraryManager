package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReturnLibraryBookUsecaseTest {

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    private ReturnBookUsecase returnBookUsecase;

    @Before
    public void setup(){
        returnBookUsecase = new ReturnBookUsecase(libraryBookGateway);
    }

    @Test
    public void returnBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        book.setLent(true);

        when(libraryBookGateway.getBookByTitle(bookTitle)).thenReturn(book);

        returnBookUsecase.execute("1984");

        verify(libraryBookGateway, times(1)).saveLibraryBook(bookCaptor.capture());
        assertThat(bookCaptor.getValue().isLent(), is(false));
    }
}
