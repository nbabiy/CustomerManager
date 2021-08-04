package com.nbabiy.customerManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author nazariibabii
 */
@SpringBootApplication
@EntityScan("com.nbabiy.customerManager")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
