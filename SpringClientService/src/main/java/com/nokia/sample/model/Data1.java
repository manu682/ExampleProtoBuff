package com.nokia.sample.model;

import java.util.List;

public class Data1 {
	private Integer id;
	private String value;
	private List<String> messageType;
	
	public Data1() {
		// TODO Auto-generated constructor stub
	}
	
	public Data1(Integer id, String value, List<String> messageType) {
		this.id = id;
		this.value = value;
		this.messageType = messageType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public List<String> getMessageType() {
		return messageType;
	}
	

	public void setMessageType(List<String> messageType) {
		this.messageType = messageType;
	}
}
