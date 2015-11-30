package com.douglasrizzo.util.dto;

import java.io.Serializable;

public class Message implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String message;

	public Message(int id, String message)
	{
		this.id = id;
		this.message = message;
	}

	public int getId()
	{
		return id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
