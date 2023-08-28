package edu.jsp.encryptionanddecryption.exception;

import java.util.InputMismatchException;

public class PasswordMissMatchExecption extends InputMismatchException{
	
	String messeage ;
	public PasswordMissMatchExecption(String messeage){
		this.messeage=messeage ;
		
	}
	
	public String getMessage() {
        return  messeage;
    }
}
