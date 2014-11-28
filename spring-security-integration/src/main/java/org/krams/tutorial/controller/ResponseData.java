package org.krams.tutorial.controller;

import java.util.List;
import java.util.Map;

public class ResponseData {
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Map<String, String>> getMessage() {
		return message;
	}
	public void setMessage(List<Map<String, String>> message) {
		this.message = message;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	private String status;
	private List<Map<String,String>> message;
	private Map<String,String> data;
	

}
