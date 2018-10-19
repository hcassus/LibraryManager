package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LendBookByTitleUsecase {

    private final LibraryBookGateway libraryBookGateway;
    private final LendBookUsecase lendBookUsecase;

    public void execute(String title, LibraryCustomer customer) {
        LibraryBook book = libraryBookGateway.getBookByTitle(title);
        lendBookUsecase.execute(book, customer);
    }
}
