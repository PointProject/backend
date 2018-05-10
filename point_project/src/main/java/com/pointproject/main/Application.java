package com.pointproject.main;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.pointproject.config.JwtFilter;

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
    public CommandLineRunner initializeApp() {
        return (args) -> {
            initializeFB();
        };
    }

    private void initializeFB() throws IOException {
        FileInputStream serviceAccount = new FileInputStream(this.getClass()
                                                                 .getClassLoader()
                                                                 .getResource(
                                                                     "paidpoint-228-firebase-adminsdk-crlnq-1aec94312b.json")
                                                                 .getPath());

        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(
            GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://paidpoint-228.firebaseio.com/")
            .build();

        FirebaseApp.initializeApp(options);
    }
}
