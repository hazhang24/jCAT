package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class CadastroInepVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id, tipoUsuarioId;
	protected String nome, sobrenome, email, senha;

	public CadastroInepVO()
	{}

	public CadastroInepVO(int id, String nome, String sobrenome, String email,
			String senha, int tipoUsuarioId)
	{
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuarioId = tipoUsuarioId;
	}

	public String getEmail()
	{
		return email;
	}

	public int getId()
	{
		return id;
	}

	public String getNome()
	{
		return nome;
	}

	public String getSenha()
	{
		return senha;
	}

	public String getSobrenome()
	{
		return sobrenome;
	}

	public int getTipoUsuarioId()
	{
		return tipoUsuarioId;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public void setSobrenome(String sobrenome)
	{
		this.sobrenome = sobrenome;
	}

	public void setTipoUsuarioId(int tipoUsuarioId)
	{
		this.tipoUsuarioId = tipoUsuarioId;
	}
}