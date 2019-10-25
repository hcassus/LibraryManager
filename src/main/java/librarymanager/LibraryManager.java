package librarymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("librarymanager.config")
public class LibraryManager {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManager.class, args);
    }
}
