package librarymanager.usecase;

import librarymanager.domain.LibraryBook;
import librarymanager.domain.LibraryCustomer;
import librarymanager.gateway.LibraryBookGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LendLibraryBookByIsbnUsecaseTest {

    @Mock
    private LendBookUsecase lendBookUsecase;

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    @Captor
    private ArgumentCaptor<LibraryCustomer> customerCaptor;

    private LendBookByIsbnUsecase lendBookByIsbnUsecase;

    @Before
    public void setup(){
        lendBookByIsbnUsecase = new LendBookByIsbnUsecase(libraryBookGateway, lendBookUsecase);
    }

    @Test
    public void lendBookByIsbnTest(){
        String bookIsbn13 = "9870123456789";
        LibraryBook book = new LibraryBook();
        book.setIsbn13(bookIsbn13);
        book.setLent(false);

        LibraryCustomer customer = new LibraryCustomer();
        customer.setName("Customer1");

        when(libraryBookGateway.getBookByIsbn(bookIsbn13)).thenReturn(book);

        lendBookByIsbnUsecase.execute(bookIsbn13, customer);

        verify(lendBookUsecase, times(1)).execute(bookCaptor.capture(), customerCaptor.capture());

        assertThat(bookCaptor.getValue(), is(book));
        assertThat(customerCaptor.getValue(), is(customer));
    }
}
