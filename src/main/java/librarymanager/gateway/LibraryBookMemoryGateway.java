package librarymanager.gateway;

import librarymanager.domain.LibraryBook;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookMemoryGateway implements LibraryBookGateway{

    private List<LibraryBook> libraryBookList = new ArrayList<>();

    public LibraryBook saveLibraryBook(LibraryBook newBook) {
        LibraryBook updatedBook;
        LibraryBook existingBook = getExistingBook(newBook);

        if(existingBook != null){
            updatedBook = updateBook(existingBook, newBook);
        } else {
            libraryBookList.add(newBook);
            updatedBook = newBook;
        }
        return updatedBook;
    }

    private LibraryBook getExistingBook(LibraryBook newBook) {
        LibraryBook isbnBook = null;
        LibraryBook titleBook = null;

        String isbn13 = newBook.getIsbn13();
        String title = newBook.getTitle();

        if(isbn13 != null)
            isbnBook = getBookByIsbn(isbn13);

        if(title != null)
            titleBook = getBookByTitle(title);

        return isbnBook != null ? isbnBook : titleBook;
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

    @Override
    public void deleteBook(LibraryBook book) {
        libraryBookList.remove(book);
    }

    @Override
    public LibraryBook getBookByIsbn(String isbn13) {
        return libraryBookList.stream().filter( book -> book.getIsbn13().equals(isbn13)).findFirst().orElse(null);
    }
}
