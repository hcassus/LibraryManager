package librarymanager.config;

import librarymanager.gateway.LibraryBookGateway;
import librarymanager.repository.LibraryBookMemoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeanConfig {

    @Bean
    public LibraryBookGateway libraryBookGateway(){
        return new LibraryBookMemoryGateway();
    }

}
