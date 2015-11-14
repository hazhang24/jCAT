package negocio.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Prova extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo, descricao;
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Item> itens;

	public Prova()
	{
		itens = new HashSet<Item>();
	}

	public Prova(int id, String titulo, String descricao)
	{
		super(id);
		this.titulo = titulo;
		this.descricao = descricao;
		itens = new HashSet<Item>();
	}

	public String getDescricao()
	{
		return descricao;
	}

	public Set<Item> getItens()
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

	public void setItens(Set<Item> itens)
	{
		this.itens = itens;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
}
