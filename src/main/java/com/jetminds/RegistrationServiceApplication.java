package com.jetminds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Service entry point.
 *
 * @author Erik Khalimov
 */
@SpringBootApplication
public class RegistrationServiceApplication {
    /**
     * Application entry point.
     *
     * @param args
     *  command-line arguments
     *
     */
    public static void main(final String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }
}
