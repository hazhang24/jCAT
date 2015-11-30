package com.douglasrizzo.util.locator;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ServiceLocatorException extends Exception
{
	private static final long serialVersionUID = 1L;

	private Throwable cause;

	public ServiceLocatorException()
	{

	}

	public ServiceLocatorException(String message)
	{
		super(message);
	}

	public ServiceLocatorException(String message, Throwable cause)
	{
		super(message);
		this.cause = cause;
	}

	public ServiceLocatorException(Throwable cause)
	{
		super(cause.getMessage());
		this.cause = cause;
	}

	@Override
	public Throwable getCause()
	{
		return cause;
	}

	@Override
	public void printStackTrace()
	{
		super.printStackTrace();
		if (cause != null)
		{
			System.err.print("Caused by: ");
			cause.printStackTrace();
		}
	}

	@Override
	public void printStackTrace(PrintStream s)
	{
		super.printStackTrace(s);
		if (cause != null)
		{
			s.print("Caused by: ");
			cause.printStackTrace(s);
		}
	}

	@Override
	public void printStackTrace(PrintWriter s)
	{
		super.printStackTrace(s);
		if (cause != null)
		{
			s.print("Caused by: ");
			cause.printStackTrace(s);
		}
	}
}