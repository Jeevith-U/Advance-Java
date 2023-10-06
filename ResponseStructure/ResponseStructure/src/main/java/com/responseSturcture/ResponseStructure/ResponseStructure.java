package com.responseSturcture.ResponseStructure;

public class ResponseStructure <J>{
	
	private int statusCode ;
	private String message ;
	private J data ;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public J getData() {
		return data;
	}
	public void setData(J data) {
		this.data = data;
	}
	
}
