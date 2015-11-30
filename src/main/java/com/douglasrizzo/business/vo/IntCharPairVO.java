package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class IntCharPairVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int integer;
	char character;

	public IntCharPairVO()
	{}

	public IntCharPairVO(Integer i, Character character)
	{
		integer = i;
		this.character = character;
	}

	public char getCharacter()
	{
		return character;
	}

	public int getInteger()
	{
		return integer;
	}

	public void setCharacter(char character)
	{
		this.character = character;
	}

	public void setInteger(int integer)
	{
		this.integer = integer;
	}
}