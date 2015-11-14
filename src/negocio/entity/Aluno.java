package negocio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Aluno extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private boolean ensinoInfantil;
	private Date nascimento;
	@ManyToOne(fetch = FetchType.EAGER)
	private Turma turma;

	public Aluno()
	{}

	public Aluno(int id, String nome, boolean ensinoInfantil, Date nascimento,
			Turma turma)
	{
		super(id);
		this.nome = nome;
		this.ensinoInfantil = ensinoInfantil;
		this.nascimento = nascimento;
		this.turma = turma;
	}

	public Date getNascimento()
	{
		return nascimento;
	}

	public String getNome()
	{
		return nome;
	}

	public Turma getTurma()
	{
		return turma;
	}

	public boolean isEnsinoInfantil()
	{
		return ensinoInfantil;
	}

	public void setEnsinoInfantil(boolean ensinoInfantil)
	{
		this.ensinoInfantil = ensinoInfantil;
	}

	public void setNascimento(Date nascimento)
	{
		this.nascimento = nascimento;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setTurma(Turma turma)
	{
		this.turma = turma;
	}
}