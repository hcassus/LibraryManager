package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import librarymanager.repository.BookLeaseMemoryGateway;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnLibraryBookByIsbnUsecaseTest {

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Mock
    private BookLeaseMemoryGateway bookLeaseGateway;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    @Captor
    private ArgumentCaptor<BookLease> bookLeaseCaptor;

    private ReturnBookByIsbnUsecase returnBookByIsbnUsecase;

    @Before
    public void setup(){
        returnBookByIsbnUsecase = new ReturnBookByIsbnUsecase(libraryBookGateway, bookLeaseGateway);
    }

    @Test
    public void returnBookTest(){
        String bookIsbn = "1234567890123";
        LibraryBook book = new LibraryBook();
        book.setIsbn13(bookIsbn);
        book.setLent(true);

        LibraryCustomer customer = new LibraryCustomer();
        customer.setName("Sorin");

        BookLease lease = new BookLease();
        lease.setBook(book);
        lease.setLibraryCustomer(customer);

        when(libraryBookGateway.getBookByIsbn(bookIsbn)).thenReturn(book);
        when(bookLeaseGateway.getLeaseByIsbnAndCustomer(bookIsbn, customer)).thenReturn(lease);

        returnBookByIsbnUsecase.execute("1234567890123", customer);

        verify(libraryBookGateway, times(1)).saveOrUpdateBook(bookCaptor.capture());
        verify(bookLeaseGateway, times(1)).saveBookLease(bookLeaseCaptor.capture());

        assertThat(bookCaptor.getValue().isLent(), is(false));

        BookLease bookLease = bookLeaseCaptor.getValue();
        assertThat(bookLease.getBook(), is(book));
        assertThat(bookLease.getReturnDate(), is(LocalDate.now()));
    }
}
