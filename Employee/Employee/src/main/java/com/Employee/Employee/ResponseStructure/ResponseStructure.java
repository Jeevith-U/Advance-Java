package com.Employee.Employee.ResponseStructure;

public class ResponseStructure <J>{
	
	private int statuscode ;
	private String message ;
	private J body ;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public J getBody() {
		return body;
	}
	public void setBody(J body) {
		this.body = body;
	}
	
}
