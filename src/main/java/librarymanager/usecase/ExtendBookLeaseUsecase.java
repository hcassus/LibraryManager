package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.BookLeaseGateway;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ExtendBookLeaseUsecase {

    private final BookLeaseGateway  bookLeaseGateway;

    public void execute(String bookIsbn13, LibraryCustomer customer) {
        BookLease lease = bookLeaseGateway.getLeaseByIsbnAndCustomer(bookIsbn13, customer);
        lease.setDueDate(LocalDate.now().plusDays(14));
        bookLeaseGateway.saveBookLease(lease);
    }
}
