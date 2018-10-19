package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.BookLeaseGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ExtendBookLeaseByIsbnUsecaseTest {

    @Mock
    private BookLeaseGateway bookLeaseGateway;

    @Captor
    private ArgumentCaptor<BookLease> bookLeaseCaptor;

    private ExtendBookLeaseUsecase extendBookLeaseUsecase;

    @Before
    public void setup(){
        extendBookLeaseUsecase = new ExtendBookLeaseUsecase(bookLeaseGateway);
    }

    @Test
    public void extendLeaseByIsbnTest(){
        String bookIsbn13 = "9870123456789";
        LocalDate dueDate = now().plusDays(5);

        LibraryBook book = new LibraryBook();
        book.setIsbn13(bookIsbn13);
        book.setLent(true);

        BookLease bookLease = new BookLease();
        bookLease.setBook(book);
        bookLease.setDueDate(dueDate);

        LibraryCustomer customer = new LibraryCustomer();
        customer.setName("Customer1");

        when(bookLeaseGateway.getLeaseByIsbn(bookIsbn13, customer)).thenReturn(bookLease);

        extendBookLeaseUsecase.execute(bookIsbn13, customer);

        verify(bookLeaseGateway, times(1)).getLeaseByIsbn(bookIsbn13, customer);
        verify(bookLeaseGateway, times(1)).saveBookLease(bookLeaseCaptor.capture());

        BookLease lease = bookLeaseCaptor.getValue();
        assertThat(lease, is(bookLease));
        assertThat(lease.getDueDate(), is(now().plusDays(14)));
    }

}
