package com.nokia.sample.test;

import org.springframework.web.client.RestTemplate;

import com.nokia.sample.model.Data1;

public class ApplicationProtoBuff {
    
	
	
	public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Data1 data1 = restTemplate.getForObject("http://localhost:8080/service/getData?id=0", Data1.class);
        System.out.println(data1.getId());
        //System.out.println(data1.getValue());
    }	
}
