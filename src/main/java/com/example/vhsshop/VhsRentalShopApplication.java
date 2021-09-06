package com.example.vhsshop;

import lombok.Lombok;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VhsRentalShopApplication {

	private static final Logger logger
			= LoggerFactory.getLogger(VhsRentalShopApplication.class);

	public static void main(String[] args) {
		logger.info("Started application!", VhsRentalShopApplication.class.getSimpleName());
		SpringApplication.run(VhsRentalShopApplication.class, args);
	}
}