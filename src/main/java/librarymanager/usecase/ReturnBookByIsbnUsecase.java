package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.BookLeaseGateway;
import librarymanager.gateway.LibraryBookGateway;

import java.time.LocalDate;

public class ReturnBookByIsbnUsecase {

    private LibraryBookGateway libraryBookGateway;
    private BookLeaseGateway bookLeaseGateway;

    public ReturnBookByIsbnUsecase(LibraryBookGateway libraryBookGateway, BookLeaseGateway bookLeaseGateway) {
        this.libraryBookGateway = libraryBookGateway;
        this.bookLeaseGateway = bookLeaseGateway;
    }

    public void execute(String isbn13, LibraryCustomer customer) {
        LibraryBook book = libraryBookGateway.getBookByIsbn(isbn13);
        book.setLent(false);

        BookLease lease = bookLeaseGateway.getLeaseByIsbnAndCustomer(isbn13, customer);
        lease.setBook(book);
        lease.setReturnDate(LocalDate.now());

        libraryBookGateway.saveOrUpdateBook(book);
        bookLeaseGateway.saveBookLease(lease);
    }
}
