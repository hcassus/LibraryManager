package librarymanager.config;

import librarymanager.gateway.LibraryBookGateway;
import librarymanager.usecase.AddLibraryBookUsecase;
import librarymanager.usecase.GetAllLibraryBooksUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseBeanConfig {

    @Bean
    public GetAllLibraryBooksUsecase getBookUsecase(LibraryBookGateway libraryBookGateway){
        return new GetAllLibraryBooksUsecase(libraryBookGateway);
    }

    @Bean
    public AddLibraryBookUsecase addLibraryBookUsecase(LibraryBookGateway libraryBookGateway){
        return new AddLibraryBookUsecase(libraryBookGateway);
    }

}
