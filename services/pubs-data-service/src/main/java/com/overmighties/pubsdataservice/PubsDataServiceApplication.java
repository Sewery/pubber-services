package com.overmighties.pubsdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class PubsDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubsDataServiceApplication.class, args);
	}

}
