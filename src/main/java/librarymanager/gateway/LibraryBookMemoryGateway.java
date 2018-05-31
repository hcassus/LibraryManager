package librarymanager.gateway;

import librarymanager.domain.LibraryBook;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookMemoryGateway implements LibraryBookGateway{

    private List<LibraryBook> libraryBookList = new ArrayList<LibraryBook>();

    public LibraryBook saveLibraryBook(LibraryBook newBook) {
        LibraryBook updatedBook;
        LibraryBook existingBook = getBookByTitle(newBook.getTitle());

        if(existingBook != null){
            updatedBook = updateBook(existingBook, newBook);
        } else {
            libraryBookList.add(newBook);
            updatedBook = newBook;
        }
        return updatedBook;
    }

    private LibraryBook updateBook(LibraryBook existingBook, LibraryBook newBook) {
        libraryBookList.remove(existingBook);
        libraryBookList.add(newBook);
        return newBook;
    }

    public List<LibraryBook> getAllBooks() {
        return libraryBookList;
    }

    public LibraryBook getBookByTitle(String title) {
        return libraryBookList.stream().filter( book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }
}
