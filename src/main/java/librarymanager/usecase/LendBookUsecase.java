package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;

public class LendBookUsecase {

    private LibraryBookGateway libraryBookGateway;

    public LendBookUsecase(LibraryBookGateway libraryBookGateway){
        this.libraryBookGateway = libraryBookGateway;
    }

    public void execute(String title) {
        LibraryBook book = libraryBookGateway.getBookByTitle(title);
        book.setLent(true);
        libraryBookGateway.saveLibraryBook(book);
    }
}
