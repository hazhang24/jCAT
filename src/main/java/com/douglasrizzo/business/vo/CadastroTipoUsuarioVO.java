package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class CadastroTipoUsuarioVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String descricao;

	public CadastroTipoUsuarioVO()
	{}

	public CadastroTipoUsuarioVO(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public int getId()
	{
		return id;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
