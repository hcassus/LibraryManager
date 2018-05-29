package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;

public class AddLibraryBookUsecase {

    private LibraryBookGateway libraryBookGateway;

    public AddLibraryBookUsecase(LibraryBookGateway libraryBookGateway){
        this.libraryBookGateway = libraryBookGateway;
    }

    public void execute(LibraryBook book) {
        libraryBookGateway.saveLibraryBook(book);
    }
}
