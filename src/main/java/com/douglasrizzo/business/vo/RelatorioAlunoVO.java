package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class RelatorioAlunoVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id, acertos, erros, total, clasValor;
	String aluno, tempo, clasDescricao;

	public RelatorioAlunoVO()
	{}

	public RelatorioAlunoVO(int id, int acertos, int erros, int total,
			String aluno, int clasValor, String clasDescricao)
	{
		this.id = id;
		this.acertos = acertos;
		this.erros = erros;
		this.total = total;
		this.aluno = aluno;
		this.clasValor = clasValor;
		this.clasDescricao = clasDescricao;
	}

	public int getAcertos()
	{
		return acertos;
	}

	public String getAluno()
	{
		return aluno;
	}

	public String getClasDescricao()
	{
		return clasDescricao;
	}

	public int getClasValor()
	{
		return clasValor;
	}

	public int getErros()
	{
		return erros;
	}

	public int getId()
	{
		return id;
	}

	public String getTempo()
	{
		return tempo;
	}

	public int getTotal()
	{
		return total;
	}

	public void setAcertos(int acertos)
	{
		this.acertos = acertos;
	}

	public void setAluno(String aluno)
	{
		this.aluno = aluno;
	}

	public void setClasDescricao(String clasDescricao)
	{
		this.clasDescricao = clasDescricao;
	}

	public void setClasValor(int clasValor)
	{
		this.clasValor = clasValor;
	}

	public void setErros(int erros)
	{
		this.erros = erros;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTempo(String tempo)
	{
		this.tempo = tempo;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}
}