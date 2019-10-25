package librarymanager.gateway;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryCustomer;

public interface BookLeaseGateway {
    void saveBookLease(BookLease lease);

    BookLease getLeaseByIsbnAndCustomer(String bookIsbn13, LibraryCustomer customer);

    BookLease getLeaseByTitleAndCustomer(String bookTitle, LibraryCustomer customer);
}
