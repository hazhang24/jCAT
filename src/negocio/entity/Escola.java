package negocio.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Escola extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;

	@OneToMany(mappedBy = "escola", fetch = FetchType.LAZY)
	private Set<Turma> turmas;

	public Escola()
	{
		turmas = new HashSet<Turma>();
	}

	public Escola(int id, int codigo, String nome)
	{
		super(id);
		this.codigo = codigo;
		this.nome = nome;
		turmas = new HashSet<Turma>();
	}

	public int getCodigo()
	{
		return codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public Set<Turma> getTurmas()
	{
		return turmas;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setTurmas(Set<Turma> turmas)
	{
		this.turmas = turmas;
	}
}
