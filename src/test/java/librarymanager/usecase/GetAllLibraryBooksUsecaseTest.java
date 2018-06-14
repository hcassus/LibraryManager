package librarymanager.usecase;

import librarymanager.gateway.LibraryBookGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetAllLibraryBooksUsecaseTest {

    private GetAllLibraryBooksUsecase getAllLibraryBooksUsecase;

    @Mock
    private LibraryBookGateway libraryBookGatewayFake;

    @Before
    public void setup(){
        getAllLibraryBooksUsecase = new GetAllLibraryBooksUsecase(libraryBookGatewayFake);
    }

    @Test
    public void getAllBooksTest(){
        getAllLibraryBooksUsecase.execute();
        verify(libraryBookGatewayFake, times(1)).getAllBooks();
    }
}
