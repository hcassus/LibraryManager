package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddLibraryBookUsecase {

    private final LibraryBookGateway libraryBookGateway;

    public LibraryBook execute(LibraryBook book) {
        return libraryBookGateway.saveBook(book);
    }
}
