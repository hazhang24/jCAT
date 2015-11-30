package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class CadastroClassificacaoVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id, valor, acertos;
	String descricao;

	public CadastroClassificacaoVO(int id, int valor, int acertos,
			String descricao)
	{
		this.id = id;
		this.valor = valor;
		this.acertos = acertos;
		this.descricao = descricao;
	}

	public int getAcertos()
	{
		return acertos;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public int getId()
	{
		return id;
	}

	public int getValor()
	{
		return valor;
	}

	public void setAcertos(int acertos)
	{
		this.acertos = acertos;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setValor(int valor)
	{
		this.valor = valor;
	}
}