package com.durys.jakub.socialfund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SocialFundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialFundApplication.class, args);
	}

}
