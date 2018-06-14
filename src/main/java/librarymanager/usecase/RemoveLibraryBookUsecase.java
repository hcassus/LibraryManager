package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;

public class RemoveLibraryBookUsecase {

    private LibraryBookGateway libraryBookGateway;

    public RemoveLibraryBookUsecase(LibraryBookGateway libraryBookGateway) {
        this.libraryBookGateway = libraryBookGateway;
    }

    public void execute(LibraryBook book) {
        libraryBookGateway.deleteBook(book);
    }
}
