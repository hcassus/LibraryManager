package librarymanager.gateway;

import librarymanager.domain.LibraryBook;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookMemoryGateway implements LibraryBookGateway{

    private List<LibraryBook> libraryBookList = new ArrayList<LibraryBook>();

    public LibraryBook saveLibraryBook(LibraryBook book) {
        libraryBookList.add(book);
        return book;
    }

    public List<LibraryBook> getAllBooks() {
        return libraryBookList;
    }
}
