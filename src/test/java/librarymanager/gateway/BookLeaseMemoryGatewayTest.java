package librarymanager.gateway;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookLeaseMemoryGatewayTest {

    private BookLeaseMemoryGateway bookLeaseMemoryGateway;

    @Before
    public void setup(){
        bookLeaseMemoryGateway = new BookLeaseMemoryGateway();
    }

    @Test
    public void saveLease(){
        String isbn = "9873216549873";

        LibraryBook book = new LibraryBook();
        book.setIsbn13(isbn);

        LibraryCustomer customer = new LibraryCustomer();
        customer.setName("Customer");

        BookLease lease = new BookLease();
        lease.setLibraryCustomer(customer);
        lease.setBook(book);


        bookLeaseMemoryGateway.saveBookLease(lease);

        assertThat(bookLeaseMemoryGateway.getLeaseByIsbn(isbn, customer), is(lease));
    }


}