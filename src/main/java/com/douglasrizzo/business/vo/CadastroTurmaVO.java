package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class CadastroTurmaVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, aplicadorId, secretariaId;
	private String nome;

	public CadastroTurmaVO()
	{}

	public CadastroTurmaVO(int id, int aplicadorId, int secretariaId,
			String nome)
	{
		this.id = id;
		this.aplicadorId = aplicadorId;
		this.secretariaId = secretariaId;
		this.nome = nome;
	}

	public CadastroTurmaVO(int id, int secretariaId, String nome)
	{
		this.id = id;
		this.secretariaId = secretariaId;
		this.nome = nome;
	}

	public int getAplicadorId()
	{
		return aplicadorId;
	}

	public int getId()
	{
		return id;
	}

	public String getNome()
	{
		return nome;
	}

	public int getSecretariaId()
	{
		return secretariaId;
	}

	public void setAplicadorId(int aplicadorId)
	{
		this.aplicadorId = aplicadorId;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setSecretariaId(int secretariaId)
	{
		this.secretariaId = secretariaId;
	}

}
