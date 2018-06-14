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
public class LendLibraryBookUsecaseTest {

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    private LendBookUsecase lendBookUsecase;

    @Before
    public void setup(){
        lendBookUsecase = new LendBookUsecase(libraryBookGateway);
    }

    @Test
    public void lendBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        book.setLent(false);

        when(libraryBookGateway.getBookByTitle(bookTitle)).thenReturn(book);

        lendBookUsecase.execute("1984");

        verify(libraryBookGateway, times(1)).saveLibraryBook(bookCaptor.capture());
        assertThat(bookCaptor.getValue().isLent(), is(true));
    }
}
