package com.paloma.MVCMudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MvcMudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcMudiApplication.class, args);
	}

}
