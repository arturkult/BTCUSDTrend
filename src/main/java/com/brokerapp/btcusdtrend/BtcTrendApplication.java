package com.brokerapp.btcusdtrend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class BtcTrendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtcTrendApplication.class, args);
	}
}
