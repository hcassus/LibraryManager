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
public class LendLibraryBookByTitleUsecaseTest {

    @Mock
    private LibraryBookGateway libraryBookGateway;

    @Mock
    private LendBookUsecase lendBookUsecase;

    @Captor
    private ArgumentCaptor<LibraryBook> bookCaptor;

    @Captor
    private ArgumentCaptor<LibraryCustomer> customerCaptor;

    private LendBookByTitleUsecase lendBookByTitleUsecase;

    @Before
    public void setup(){

        lendBookByTitleUsecase = new LendBookByTitleUsecase(libraryBookGateway, lendBookUsecase);
    }

    @Test
    public void lendBookTest(){
        String bookTitle = "1984";
        LibraryBook book = new LibraryBook();
        book.setTitle(bookTitle);
        book.setLent(false);

        LibraryCustomer customer = new LibraryCustomer();
        customer.setName("Customer1");

        when(libraryBookGateway.getBookByTitle(bookTitle)).thenReturn(book);

        lendBookByTitleUsecase.execute(bookTitle, customer);

        verify(lendBookUsecase, times(1)).execute(bookCaptor.capture(), customerCaptor.capture());

        assertThat(bookCaptor.getValue(), is(book));
        assertThat(customerCaptor.getValue(), is(customer));
    }
}
