package com.identity.e2e.exceptions;

public class DirectoryScannerException extends Exception 
{
	private static final long serialVersionUID = 8912951951367197672L;

	/**
	 * 
	 * @param message
	 */
	public DirectoryScannerException(final String message) 
	{
		super(message);
	}
	
	/**
	 * 
	 * @param message
	 * @param t
	 */
	public DirectoryScannerException(String message, Throwable t) 
	{
		super(message,t);
	}
}
