package com.douglasrizzo.business.vo;

import java.io.Serializable;
import java.util.Date;

public class CadastroAlunoVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, turmaId;
	private boolean ensinoInfantil;
	private Date nascimento;
	private String nome;

	public CadastroAlunoVO()
	{}

	public CadastroAlunoVO(int id, int turmaId, boolean ensinoInfantil,
			Date nascimento, String nome)
	{
		this.id = id;
		this.turmaId = turmaId;
		this.ensinoInfantil = ensinoInfantil;
		this.nascimento = nascimento;
		this.nome = nome;
	}

	public int getId()
	{
		return id;
	}

	public Date getNascimento()
	{
		return nascimento;
	}

	public String getNome()
	{
		return nome;
	}

	public int getTurmaId()
	{
		return turmaId;
	}

	public boolean isEnsinoInfantil()
	{
		return ensinoInfantil;
	}

	public void setEnsinoInfantil(boolean ensinoInfantil)
	{
		this.ensinoInfantil = ensinoInfantil;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNascimento(Date nascimento)
	{
		this.nascimento = nascimento;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setTurmaId(int turmaId)
	{
		this.turmaId = turmaId;
	}
}
