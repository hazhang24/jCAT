package com.douglasrizzo.business.vo;

import java.io.Serializable;

import com.douglasrizzo.util.TipoUsuarioEnum;

public class LoginVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome, email, senha;
	private TipoUsuarioEnum tipo;

	public LoginVO()
	{}

	public LoginVO(int id, String nome, String email, String senha,
			TipoUsuarioEnum tipo)
	{
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
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

	public TipoUsuarioEnum getTipo()
	{
		return tipo;
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

	public void setTipo(TipoUsuarioEnum tipo)
	{
		this.tipo = tipo;
	}
}