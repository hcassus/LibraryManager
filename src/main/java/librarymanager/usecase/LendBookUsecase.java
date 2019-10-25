package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.BookLeaseGateway;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class LendBookUsecase {

    private final LibraryBookGateway libraryBookGateway;
    private final BookLeaseGateway bookLeaseGateway;

    public void execute(LibraryBook book, LibraryCustomer customer) {
        book.setLent(true);

        LocalDate now = LocalDate.now();

        BookLease bookLease = new BookLease();
        bookLease.setBook(book);
        bookLease.setLeaseDate(now);
        bookLease.setDueDate(now.plusDays(14));
        bookLease.setLibraryCustomer(customer);

        libraryBookGateway.saveOrUpdateBook(book);
        bookLeaseGateway.saveBookLease(bookLease);
    }
}
