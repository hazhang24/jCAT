package com.douglasrizzo.business.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class CadastroProvaVO implements Serializable
{
	public class CadastroProvaItemVO implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int id;
		private String enunciado, elaborador;
		private String ultimaUtilizacao;

		public CadastroProvaItemVO()
		{}

		public CadastroProvaItemVO(int id, String enunciado, String elaborador,
				String ultimaUtilizacao)
		{
			this.id = id;
			this.enunciado = enunciado;
			this.elaborador = elaborador;
			this.ultimaUtilizacao = ultimaUtilizacao;
		}

		public String getElaborador()
		{
			return elaborador;
		}

		public String getEnunciado()
		{
			return enunciado;
		}

		public int getId()
		{
			return id;
		}

		public String getUltimaUtilizacao()
		{
			return ultimaUtilizacao;
		}

		public void setElaborador(String elaborador)
		{
			this.elaborador = elaborador;
		}

		public void setEnunciado(String enunciado)
		{
			this.enunciado = enunciado;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public void setUltimaUtilizacao(String ultimaUtilizacao)
		{
			this.ultimaUtilizacao = ultimaUtilizacao;
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String titulo, descricao;
	private ArrayList<Integer> itens;

	public CadastroProvaVO()
	{
		itens = new ArrayList<Integer>();
	}

	public CadastroProvaVO(int id, String titulo, String descricao)
	{
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		itens = new ArrayList<Integer>();
	}

	public String getDescricao()
	{
		return descricao;
	}

	public int getId()
	{
		return id;
	}

	public ArrayList<Integer> getItens()
	{
		return itens;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setItens(ArrayList<Integer> itens)
	{
		this.itens = itens;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
}