package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    //Commandline runners will be ran once the application context has been loaded
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Bagging", "thief")));
        };
    }
    
    @Bean
    CommandLineRunner initDatabaseTwice(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Erik van Roon", "Consultant")));
        };
    }
}