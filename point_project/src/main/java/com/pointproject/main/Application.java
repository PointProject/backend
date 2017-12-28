package com.pointproject.main;

import com.pointproject.config.JwtFilter;
import com.pointproject.enities.City;
import com.pointproject.enities.Country;
import com.pointproject.enities.GameUser;
import com.pointproject.repositories.CityRepo;
import com.pointproject.repositories.CountryRepo;
import com.pointproject.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/secure/*");

        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CountryRepo repo, UserRepo userRepo, CityRepo cityRepo) {
        return (args) -> {

            Country country = new Country("Ukraine");

            repo.save(country);
            repo.save(new Country("USA"));
            userRepo.save(new GameUser("admin","admin","admin","admin",18));

            cityRepo.save(new City("Moscow"));
            cityRepo.save(new City(repo.findAll().iterator().next(),"Odessa"));

/*            for (City city : cityRepo.findAll()){
                try {
                    System.err.println(city.getTitle() + " " + city.getCountry().getTitle());
                }catch (NullPointerException e){
                    System.err.println(city);
                }
            }*/

        };
    }
}
