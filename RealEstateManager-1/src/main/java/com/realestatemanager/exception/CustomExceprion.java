package com.realestatemanager.exception;

public class CustomExceprion extends Exception{

	
	private static final long serialVersionUID = 1L;
	private final String message ;
	private final String errorDesc;
	private final  Exception execption;
	
	
	public CustomExceprion(String message)
	{
		this.message=message;
		this.errorDesc="";
		this.execption=null;
		
	}


	public String getMessage() {
		return message;
	}
	
	
	
}
