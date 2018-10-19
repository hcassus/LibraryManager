package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LendBookByIsbnUsecase {

    private final LibraryBookGateway libraryBookGateway;
    private final LendBookUsecase lendBookUsecase;

    public void execute(String isbn13, LibraryCustomer customer) {
        LibraryBook book = libraryBookGateway.getBookByIsbn(isbn13);
        lendBookUsecase.execute(book, customer);
    }
}
