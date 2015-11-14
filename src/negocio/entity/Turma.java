package negocio.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	@ManyToOne(fetch = FetchType.EAGER)
	private Escola escola;
	@OneToOne(optional = true)
	private Aplicador aplicador;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "turma")
	private Set<Aluno> alunos;

	public Turma()
	{
		alunos = new HashSet<Aluno>();
	}

	public Turma(int id, String nome, Escola escola, Aplicador aplicador)
	{
		super(id);
		this.nome = nome;
		this.escola = escola;
		this.aplicador = aplicador;
		alunos = new HashSet<Aluno>();
	}

	public Set<Aluno> getAlunos()
	{
		return alunos;
	}

	public Aplicador getAplicador()
	{
		return aplicador;
	}

	public Escola getEscola()
	{
		return escola;
	}

	public String getNome()
	{
		return nome;
	}

	public void setAlunos(Set<Aluno> alunos)
	{
		this.alunos = alunos;
	}

	public void setAplicador(Aplicador aplicador)
	{
		this.aplicador = aplicador;
	}

	public void setEscola(Escola escola)
	{
		this.escola = escola;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
}