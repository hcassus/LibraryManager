package librarymanager.repository;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.BookLeaseGateway;

import java.util.ArrayList;
import java.util.List;

public class BookLeaseMemoryGateway implements BookLeaseGateway {

    private List<BookLease> leases = new ArrayList<>();

    @Override
    public void saveBookLease(BookLease lease){
        leases.add(lease);
    }

    @Override
    public BookLease getLeaseByIsbnAndCustomer(String bookIsbn13, LibraryCustomer customer) {
        return leases.stream()
                .filter(lease -> lease.getBook().getIsbn13().equals(bookIsbn13))
                .filter(lease -> lease.getLibraryCustomer().equals(customer))
                .findFirst()
                .get();
    }

    @Override
    public BookLease getLeaseByTitleAndCustomer(String bookTitle, LibraryCustomer customer) {
        return leases.stream()
                .filter(lease -> lease.getBook().getTitle().equals(bookTitle))
                .filter(lease -> lease.getLibraryCustomer().equals(customer))
                .findFirst()
                .get();
    }
}

