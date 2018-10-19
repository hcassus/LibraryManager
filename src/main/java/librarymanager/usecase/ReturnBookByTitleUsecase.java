package librarymanager.usecase;

import librarymanager.domain.BookLease;
import librarymanager.domain.LibraryBook;
import librarymanager.gateway.BookLeaseGateway;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@RequiredArgsConstructor
public class ReturnBookByTitleUsecase {

    private final LibraryBookGateway libraryBookGateway;
    private final BookLeaseGateway bookLeaseGateway;

    public void execute(String bookTitle) {
        LibraryBook book = libraryBookGateway.getBookByTitle(bookTitle);
        book.setLent(false);

        BookLease lease = new BookLease();
        lease.setBook(book);
        lease.setReturnDate(LocalDate.now());

        libraryBookGateway.saveLibraryBook(book);
        bookLeaseGateway.saveBookLease(lease);
    }
}
