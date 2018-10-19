package librarymanager.gateway;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryCustomer;

public interface BookLeaseGateway {
    void saveBookLease(BookLease lease);

    BookLease getLeaseByIsbn(String bookIsbn13, LibraryCustomer customer);
}
