package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ReturnBookUsecase {

    private final LibraryBookGateway libraryBookGateway;

    public void execute(String bookTitle) {
        LibraryBook book = libraryBookGateway.getBookByTitle(bookTitle);
        book.setLent(false);
        libraryBookGateway.saveLibraryBook(book);
    }
}
