package com.raza.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Main entry point of the Spring Boot application
 */
@SpringBootApplication(
    exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
    }
)
public class PortfolioApplication {

    /**
     * Starts the Spring Boot application
     */
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }
}
