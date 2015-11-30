package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class SecretariaListVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;

	public SecretariaListVO()
	{}

	public SecretariaListVO(int id, String nome)
	{
		this.id = id;
		this.nome = nome;
	}

	public int getId()
	{
		return id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
}