package librarymanager.controller;

import librarymanager.domain.LibraryBook;
import librarymanager.usecase.AddLibraryBookUsecase;
import librarymanager.usecase.GetAllLibraryBooksUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class LibraryController {

    private final GetAllLibraryBooksUsecase getAllLibraryBooksUsecase;
    private final AddLibraryBookUsecase addLibraryBookUsecase;

    @RequestMapping(method = RequestMethod.GET, path = "/book")
    public Collection<LibraryBook> getAllBooks(){
        return getAllLibraryBooksUsecase.execute();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/book")
    public LibraryBook addBookToLibrary(@RequestBody LibraryBook book){
        return addLibraryBookUsecase.execute(book);
    }

}
