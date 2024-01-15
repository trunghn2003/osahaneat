package com.cybersoft.osahaneat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@Import(CorsConfig.class)
@EnableCaching
@SpringBootApplication
public class OsahaneatApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsahaneatApplication.class, args);
	}

}
