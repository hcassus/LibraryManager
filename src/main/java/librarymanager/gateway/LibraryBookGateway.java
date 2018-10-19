package librarymanager.gateway;

import librarymanager.domain.LibraryBook;

import java.util.List;

public interface LibraryBookGateway {

    LibraryBook saveLibraryBook(LibraryBook book);

    List<LibraryBook> getAllBooks();

    LibraryBook getBookByTitle(String title);

    void deleteBook(LibraryBook book);

    LibraryBook getBookByIsbn(String isbn13);
}
