package com.douglasrizzo.business.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Secretaria extends Usuario
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Escola escola;

	public Secretaria()
	{}

	public Secretaria(int id, String nome, String sobrenome, String email,
			String senha, TipoUsuario tipoUsuario, Escola escola)
	{
		super(id, nome, sobrenome, email, senha, tipoUsuario);
		this.escola = escola;
	}

	public Escola getEscola()
	{
		return escola;
	}

	public void setEscola(Escola escola)
	{
		this.escola = escola;
	}
}