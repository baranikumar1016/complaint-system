package com.complaint.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.complaint.system")
@EnableJpaRepositories(basePackages = "com.complaint.system.repository")
public class ComplaintSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintSystemApplication.class, args);
    }
}
