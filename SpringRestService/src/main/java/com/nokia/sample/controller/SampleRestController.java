package com.nokia.sample.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.sample.model.Data1;
import com.nokia.sample.model.DataServer;
import com.nokia.sample.model.DataServer.Data;
import com.nokia.sample.model.DataServer.Data.Corpus;

@RestController
@RequestMapping("/service")
public class SampleRestController {
	private List<String> dataList = new ArrayList<String>(Arrays.asList("spring", "rest", "src"));
	
	@Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
	
	@RequestMapping("/getData1")
	public Data1 getData1(@RequestParam(value = "id", defaultValue = "0") Integer id) {
		// Without Protobuffer
		List<String> typeList = new ArrayList<String>(Arrays.asList("Type 1", "Type 2"));
		return new Data1(id, dataList.get(id), typeList);
	}
	
	@RequestMapping("/getData")
	public Data getData(@RequestParam(value = "id", defaultValue = "0") Integer id) {
		// With Protobuffer
		List<String> typeList = new ArrayList<String>(Arrays.asList("Type 1", "Type 2"));
		return DataServer.Data.newBuilder().setId(id).setValue(dataList.get(id)).addAllMessageType(typeList)
				.setCorpus(Corpus.VIDEO).build();
	}
}