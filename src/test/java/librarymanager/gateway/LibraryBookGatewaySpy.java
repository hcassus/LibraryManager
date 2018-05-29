package librarymanager.gateway;

import librarymanager.domain.LibraryBook;

import java.util.List;

public class LibraryBookGatewaySpy implements LibraryBookGateway {

    private LibraryBook createdBook;

    public LibraryBook saveLibraryBook(LibraryBook book) {
        createdBook = book;
        return book;
    }

    public List<LibraryBook> getAllBooks() {
        return null;
    }

    public LibraryBook getCreatedBook(){
        return createdBook;
    }
}
