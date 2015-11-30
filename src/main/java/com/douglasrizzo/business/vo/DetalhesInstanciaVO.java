package com.douglasrizzo.business.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class DetalhesInstanciaVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, qtdAcertos, erros, total, classificacao;
	private String aluno, clasDesc;
	private double tempo;
	private ArrayList<IntCharPairVO> acertos;

	public DetalhesInstanciaVO()
	{}

	public DetalhesInstanciaVO(int id, int acertos, int erros, int total,
			int classificacao, String aluno, double tempo, String clasDesc)
	{
		this.id = id;
		qtdAcertos = acertos;
		this.erros = erros;
		this.total = total;
		this.classificacao = classificacao;
		this.aluno = aluno;
		this.tempo = tempo;
		this.clasDesc = clasDesc;
		this.acertos = new ArrayList<IntCharPairVO>();
	}

	public ArrayList<IntCharPairVO> getAcertos()
	{
		return acertos;
	}

	public String getAluno()
	{
		return aluno;
	}

	public String getClasDesc()
	{
		return clasDesc;
	}

	public int getClassificacao()
	{
		return classificacao;
	}

	public int getErros()
	{
		return erros;
	}

	public int getId()
	{
		return id;
	}

	public int getQtdAcertos()
	{
		return qtdAcertos;
	}

	public double getTempo()
	{
		return tempo;
	}

	public int getTotal()
	{
		return total;
	}

	public void setAcertos(ArrayList<IntCharPairVO> acertos)
	{
		this.acertos = acertos;
	}

	public void setAluno(String aluno)
	{
		this.aluno = aluno;
	}

	public void setClasDesc(String clasDesc)
	{
		this.clasDesc = clasDesc;
	}

	public void setClassificacao(int classificacao)
	{
		this.classificacao = classificacao;
	}

	public void setErros(int erros)
	{
		this.erros = erros;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setQtdAcertos(int qtdAcertos)
	{
		this.qtdAcertos = qtdAcertos;
	}

	public void setTempo(double tempo)
	{
		this.tempo = tempo;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}
}