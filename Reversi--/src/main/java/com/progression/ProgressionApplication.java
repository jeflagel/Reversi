package com.progression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages ="com.progression" )
public class ProgressionApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProgressionApplication.class, args);
	}

}

