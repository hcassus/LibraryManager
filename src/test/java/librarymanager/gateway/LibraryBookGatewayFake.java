package librarymanager.gateway;

import librarymanager.domain.LibraryBook;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookGatewayFake implements LibraryBookGateway {

    private List<LibraryBook> createdBooks = new ArrayList<LibraryBook>();

    public LibraryBook saveLibraryBook(LibraryBook book) {
        createdBooks.add(book);
        return book;
    }

    public List<LibraryBook> getAllBooks() {
        return createdBooks;
    }

    public LibraryBook getBookByTitle(String title) {
        return createdBooks.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }

    public LibraryBook getCreatedBook(){
        return createdBooks.get(0);
    }

    public void setCreatedBooks(List<LibraryBook> books){
        this.createdBooks = books;
    }
}
