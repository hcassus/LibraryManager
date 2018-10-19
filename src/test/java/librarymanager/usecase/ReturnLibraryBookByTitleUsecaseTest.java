package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.gateway.BookLeaseMemoryGateway;
import librarymanager.gateway.LibraryBookGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReturnLibraryBookByTitleUsecaseTest {

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Mock
    private BookLeaseMemoryGateway bookLeaseGateway;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    @Captor
    private ArgumentCaptor<BookLease> bookLeaseCaptor;

    private ReturnBookByTitleUsecase returnBookByTitleUsecase;

    @Before
    public void setup(){
        returnBookByTitleUsecase = new ReturnBookByTitleUsecase(libraryBookGateway, bookLeaseGateway);
    }

    @Test
    public void returnBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        book.setLent(true);

        when(libraryBookGateway.getBookByTitle(bookTitle)).thenReturn(book);

        returnBookByTitleUsecase.execute("1984");

        verify(libraryBookGateway, times(1)).saveLibraryBook(bookCaptor.capture());
        verify(bookLeaseGateway, times(1)).saveBookLease(bookLeaseCaptor.capture());

        assertThat(bookCaptor.getValue().isLent(), is(false));

        BookLease bookLease = bookLeaseCaptor.getValue();
        assertThat(bookLease.getBook(), is(book));
        assertThat(bookLease.getReturnDate(), is(LocalDate.now()));
    }
}
