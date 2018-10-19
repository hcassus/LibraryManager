package librarymanager.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookLease {

    public LibraryBook book;

    public LibraryCustomer libraryCustomer;

    public LocalDate leaseDate;

    public LocalDate dueDate;

    public LocalDate returnDate;

}
