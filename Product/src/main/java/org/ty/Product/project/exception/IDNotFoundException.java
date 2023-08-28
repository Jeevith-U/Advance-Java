package org.ty.Product.project.exception;

import java.sql.SQLException;

public class IDNotFoundException extends SQLException {
	
	public IDNotFoundException(String msg){
		super(msg) ;
	}
}
