package com.douglasrizzo.business.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Classificacao extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int valor, acertos;
	@Column(length = 1000)
	private String descricao;
	@OneToMany(mappedBy = "classificacao")
	private Set<Instancia> instancias;

	public Classificacao()
	{
		instancias = new HashSet<Instancia>();
	}

	public Classificacao(int id, int valor, int acertos, String descricao)
	{
		super(id);
		this.valor = valor;
		this.acertos = acertos;
		this.descricao = descricao;
		instancias = new HashSet<Instancia>();
	}

	public int getAcertos()
	{
		return acertos;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public Set<Instancia> getInstancias()
	{
		return instancias;
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

	public void setInstancias(Set<Instancia> instancias)
	{
		this.instancias = instancias;
	}

	public void setValor(int valor)
	{
		this.valor = valor;
	}
}