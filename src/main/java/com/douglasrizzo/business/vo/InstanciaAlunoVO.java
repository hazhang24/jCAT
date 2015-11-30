package com.douglasrizzo.business.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class InstanciaAlunoVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, atual;
	private long tempo;
	private Date data;
	private String aluno, tituloProva, descricaoProva;
	private ArrayList<ExibirItemVO> itens;

	public InstanciaAlunoVO()
	{
		itens = new ArrayList<ExibirItemVO>();
	}

	public InstanciaAlunoVO(int id, int atual, long tempo, Date data,
			String aluno, String tituloProva, String descricaoProva)
	{
		this.id = id;
		this.atual = atual;
		this.tempo = tempo;
		this.data = data;
		this.aluno = aluno;
		this.tituloProva = tituloProva;
		this.descricaoProva = descricaoProva;
		itens = new ArrayList<ExibirItemVO>();
	}

	public String getAluno()
	{
		return aluno;
	}

	public int getAtual()
	{
		return atual;
	}

	public Date getData()
	{
		return data;
	}

	public String getDescricaoProva()
	{
		return descricaoProva;
	}

	public int getId()
	{
		return id;
	}

	public ArrayList<ExibirItemVO> getItens()
	{
		return itens;
	}

	public long getTempo()
	{
		return tempo;
	}

	public String getTituloProva()
	{
		return tituloProva;
	}

	public void setAluno(String aluno)
	{
		this.aluno = aluno;
	}

	public void setAtual(int atual)
	{
		this.atual = atual;
	}

	public void setData(Date data)
	{
		this.data = data;
	}

	public void setDescricaoProva(String descricaoProva)
	{
		this.descricaoProva = descricaoProva;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setItens(ArrayList<ExibirItemVO> itens)
	{
		this.itens = itens;
	}

	public void setTempo(long tempo)
	{
		this.tempo = tempo;
	}

	public void setTituloProva(String tituloProva)
	{
		this.tituloProva = tituloProva;
	}

}