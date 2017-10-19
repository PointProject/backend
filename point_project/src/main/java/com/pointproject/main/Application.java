package com.pointproject.main;

import com.pointproject.enities.Country;
import com.pointproject.repositories.CountryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.pointproject.repositories"})
@ComponentScan(basePackages = {"com.pointproject"})
@EntityScan(basePackages = {"com.pointproject"})
@EnableAutoConfiguration
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(@Autowired CountryRepo repo) {
        return (args) -> {
            // save a couple of customers
            repo.save(new Country("Ukraine"));
            repo.save(new Country("USA"));

            // fetch all customers
            log.info("Customers found with findAll():");
        };
    }
}
