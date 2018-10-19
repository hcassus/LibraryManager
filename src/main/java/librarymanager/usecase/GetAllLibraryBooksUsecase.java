package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.gateway.LibraryBookGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllLibraryBooksUsecase {

    private final LibraryBookGateway libraryBookGateway;

    public List<LibraryBook> execute() {
        return libraryBookGateway.getAllBooks();
    }
}
