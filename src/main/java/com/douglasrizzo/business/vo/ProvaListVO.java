package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class ProvaListVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;

	public ProvaListVO()
	{}

	public ProvaListVO(int id, String titulo)
	{
		this.id = id;
		this.titulo = titulo;
	}

	@Override
	public boolean equals(Object arg0)
	{
		if (arg0 instanceof ProvaListVO)
		{
			ProvaListVO aux = (ProvaListVO) arg0;
			return id == aux.id && titulo.equals(aux.getTitulo());
		}
		return false;
	}

	public int getId()
	{
		return id;
	}

	public String getTitulo()
	{
		return titulo;
	}

	@Override
	public int hashCode()
	{
		int hash = id;
		for (char c : titulo.toCharArray())
		{
			hash += c;
		}

		return hash;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
}