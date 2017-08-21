package com.identity.e2e.exceptions;

public class FileReaderException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public FileReaderException(String message) 
	{
		super(message);
	}
	
	public FileReaderException(String message, Throwable t) 
	{
		super(message,t);
	}
}
