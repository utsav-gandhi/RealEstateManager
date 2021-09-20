package com.realestatemanager.exception;

@SuppressWarnings("serial")
public class NoDataFoundException extends CustomExceprion{

	private final String message ;
	private final String errorDesc;
	private final  Exception execption;
	
	
	public NoDataFoundException(String message) {
		super(message);
		this.message=message;
		this.errorDesc="";
		this.execption=null;
	}


	public String getMessage() {
		return message;
	}

}
