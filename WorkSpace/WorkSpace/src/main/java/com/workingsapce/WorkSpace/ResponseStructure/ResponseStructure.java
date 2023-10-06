package com.workingsapce.WorkSpace.ResponseStructure;

import lombok.Data;

@Data
public class ResponseStructure <J> {
	
	private int statusCode ;
	private String message ;
	private J data ;
}
