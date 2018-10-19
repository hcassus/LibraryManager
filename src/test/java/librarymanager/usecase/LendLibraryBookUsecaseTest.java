package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
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
public class LendLibraryBookUsecaseTest {

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Mock
    private BookLeaseMemoryGateway bookLeaseGateway;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    @Captor
    private ArgumentCaptor<BookLease> bookLeaseCaptor;

    private LendBookUsecase lendBookUsecase;

    @Before
    public void setup(){
        lendBookUsecase = new LendBookUsecase(libraryBookGateway, bookLeaseGateway);
    }

    @Test
    public void lendBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        book.setLent(false);

        LibraryCustomer customer = new LibraryCustomer();
        customer.setName("Customer1");

        lendBookUsecase.execute(book, customer);

        verify(libraryBookGateway, times(1)).saveLibraryBook(bookCaptor.capture());
        verify(bookLeaseGateway, times(1)).saveBookLease(bookLeaseCaptor.capture());

        assertThat(bookCaptor.getValue().isLent(), is(true));

        BookLease bookLease = bookLeaseCaptor.getValue();
        assertThat(bookLease.getBook(), is(book));
        assertThat(bookLease.getLibraryCustomer(), is(customer));
        assertThat(bookLease.getLeaseDate(), is(LocalDate.now()));
        assertThat(bookLease.getDueDate(), is(LocalDate.now().plusDays(14)));
    }
}
