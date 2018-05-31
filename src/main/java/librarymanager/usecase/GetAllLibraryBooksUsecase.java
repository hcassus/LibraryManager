package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;

import java.util.List;

public class GetAllLibraryBooksUsecase {

    private LibraryBookGateway libraryBookGateway;

    public GetAllLibraryBooksUsecase(LibraryBookGateway libraryBookGateway){
        this.libraryBookGateway = libraryBookGateway;
    }

    public List<LibraryBook> execute() {
        return libraryBookGateway.getAllBooks();
    }
}
