package com.softcaribbean;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@Configuration
@SpringBootApplication
@EnableJpaRepositories("com.softcaribbean.repository")
public class MyApplication  extends ServletInitializer{
	
	private static Logger log = Logger.getLogger(MyApplication.class);
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		try {
		SpringApplication.run(MyApplication.class, args);
		}catch(Exception e) {
			log.fatal(e.getMessage());
		}
	}

}
