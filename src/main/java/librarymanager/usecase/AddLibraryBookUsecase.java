package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddLibraryBookUsecase {

    private final LibraryBookGateway libraryBookGateway;

    public void execute(LibraryBook book) {
        libraryBookGateway.saveLibraryBook(book);
    }
}
