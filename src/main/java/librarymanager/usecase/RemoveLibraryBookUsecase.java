package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveLibraryBookUsecase {

    private final LibraryBookGateway libraryBookGateway;

    public void execute(LibraryBook book) {
        libraryBookGateway.deleteBook(book);
    }
}
