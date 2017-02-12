package com.nokia.sample.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nokia.sample.model.DataClient;
import com.nokia.sample.model.DataClient.Data;

@SpringBootApplication
public class ApplicationProtoBuff {

	public static void main(String args[]) {
		SpringApplication.run(ApplicationProtoBuff.class, args);
	}

	@PostConstruct
	private void callService() {
		URL url;
		try {
			url = new URL("http://localhost:8080/service/getData?id=1");
			URLConnection urlc = url.openConnection();
			urlc.setDoInput(true);
	        urlc.setRequestProperty("Accept", "application/x-protobuf");
	        Data data = DataClient.Data.newBuilder().mergeFrom(urlc.getInputStream()).build();
	        System.out.println("Output 1 : " + data.getValue());
	        System.out.println("Output 2 : " + data.getName());
	        System.out.println("Output 3 : " + data.getTest());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}