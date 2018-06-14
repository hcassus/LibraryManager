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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddLibraryBookUsecaseTest {

    private AddLibraryBookUsecase addLibraryBookUsecase;

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    @Before
    public void setup(){
        addLibraryBookUsecase = new AddLibraryBookUsecase(libraryBookGateway);
    }

    @Test
    public void addBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);

        addLibraryBookUsecase.execute(book);

        verify(libraryBookGateway, times(1)).saveLibraryBook(bookCaptor.capture());
        assertThat(bookCaptor.getValue(), is(book));
    }
}
