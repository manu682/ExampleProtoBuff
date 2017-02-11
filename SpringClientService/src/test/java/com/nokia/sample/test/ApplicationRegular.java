package com.nokia.sample.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.nokia.sample.model.Data1;

@SpringBootApplication
public class ApplicationRegular {
    
	@Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
	
	public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Data1 data1 = restTemplate.getForObject("http://localhost:8080/service/getData1?id=0", Data1.class);
        System.out.println(data1.getId());
    }	
}
