package com.nokia.sample.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.nokia.sample.model.Data;

@SpringBootApplication
public class ApplicationRegular {

	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		Data data = restTemplate.getForObject("http://localhost:8080/service/getData1?id=1", Data.class);
		System.out.println(data.getValue());
	}
}
