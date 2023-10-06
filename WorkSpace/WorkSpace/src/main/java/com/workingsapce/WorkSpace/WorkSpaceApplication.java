package com.workingsapce.WorkSpace;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
public class WorkSpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkSpaceApplication.class, args);
	}
}
