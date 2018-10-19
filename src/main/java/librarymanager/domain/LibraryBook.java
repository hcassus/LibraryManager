package librarymanager.domain;

import lombok.Data;

@Data
public class LibraryBook {

    private String title;

    private String isbn13;

    private boolean lent;

}
