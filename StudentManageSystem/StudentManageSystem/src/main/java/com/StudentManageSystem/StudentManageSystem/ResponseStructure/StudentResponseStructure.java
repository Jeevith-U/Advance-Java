package com.StudentManageSystem.StudentManageSystem.ResponseStructure;

public class StudentResponseStructure <J> {
	
	private int statusCode ;
	private String message ;
	private J body ;
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
	public J getBody() {
		return body;
	}
	public void setBody(J body) {
		this.body = body;
	}
	

}
