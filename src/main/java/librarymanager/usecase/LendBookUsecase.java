package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LendBookUsecase {

    private final LibraryBookGateway libraryBookGateway;

    public void execute(String title) {
        LibraryBook book = libraryBookGateway.getBookByTitle(title);
        book.setLent(true);
        libraryBookGateway.saveLibraryBook(book);
    }
}
