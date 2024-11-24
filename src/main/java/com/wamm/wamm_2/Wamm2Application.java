package com.wamm.wamm_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ServletComponentScan
@EnableJms
public class Wamm2Application {

	public static void main(String[] args) {
		SpringApplication.run(Wamm2Application.class, args);
	}

}
