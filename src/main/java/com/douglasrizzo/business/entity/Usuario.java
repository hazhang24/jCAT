package com.douglasrizzo.business.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome, sobrenome, email, senha;

	@ManyToOne
	private TipoUsuario tipoUsuario;

	public Usuario()
	{}

	public Usuario(int id, String nome, String sobrenome, String email,
			String senha, TipoUsuario tipoUsuario)
	{
		super(id);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail()
	{
		return email;
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

	public TipoUsuario getTipoUsuario()
	{
		return tipoUsuario;
	}

	public void setEmail(String email)
	{
		this.email = email;
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

	public void setTipoUsuario(TipoUsuario tipoUsuario)
	{
		this.tipoUsuario = tipoUsuario;
	}
}