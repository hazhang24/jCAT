package com.douglasrizzo.business.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Elaborador extends Usuario
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "elaborador", fetch = FetchType.LAZY)
	private Set<Item> itens;

	public Elaborador()
	{
		itens = new HashSet<Item>();
	}

	public Elaborador(int id, String nome, String sobrenome, String email,
			String senha, TipoUsuario tipoUsuario)
	{
		super(id, nome, sobrenome, email, senha, tipoUsuario);
		itens = new HashSet<Item>();
	}

	public Set<Item> getItens()
	{
		return itens;
	}

	public void setItens(Set<Item> itens)
	{
		this.itens = itens;
	}
}