package com.douglasrizzo.business.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Instancia extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long tempo;
	private boolean iniciada;
	private Date data;

	@ManyToOne
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Aplicacao aplicacao;

	@ManyToOne
	private Classificacao classificacao;

	@OneToMany(mappedBy = "instancia")
	private Set<ItemRespondido> itensRespondidos;

	public Instancia()
	{
		itensRespondidos = new HashSet<ItemRespondido>();
	}

	public Instancia(int id, long tempo, boolean iniciada, Date data,
			Aluno aluno, Aplicacao aplicacao, Classificacao classificacao)
	{
		super(id);
		this.tempo = tempo;
		this.iniciada = iniciada;
		this.data = data;
		this.aluno = aluno;
		this.aplicacao = aplicacao;
		this.classificacao = classificacao;
		itensRespondidos = new HashSet<ItemRespondido>();
	}

	public Aluno getAluno()
	{
		return aluno;
	}

	public Aplicacao getAplicacao()
	{
		return aplicacao;
	}

	public Classificacao getClassificacao()
	{
		return classificacao;
	}

	public Date getData()
	{
		return data;
	}

	public Set<ItemRespondido> getItensRespondidos()
	{
		return itensRespondidos;
	}

	public long getTempo()
	{
		return tempo;
	}

	public boolean isIniciada()
	{
		return iniciada;
	}

	public void setAluno(Aluno aluno)
	{
		this.aluno = aluno;
	}

	public void setAplicacao(Aplicacao aplicacao)
	{
		this.aplicacao = aplicacao;
	}

	public void setClassificacao(Classificacao classificacao)
	{
		this.classificacao = classificacao;
	}

	public void setData(Date data)
	{
		this.data = data;
	}

	public void setIniciada(boolean iniciada)
	{
		this.iniciada = iniciada;
	}

	public void setItensRespondidos(Set<ItemRespondido> itensRespondidos)
	{
		this.itensRespondidos = itensRespondidos;
	}

	public void setTempo(long tempo)
	{
		this.tempo = tempo;
	}
}