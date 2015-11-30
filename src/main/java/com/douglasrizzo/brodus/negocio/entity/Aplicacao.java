package negocio.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aplicacao extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date data;
	@OneToOne
	private Turma turma;

	@ManyToOne
	private Prova prova;

	@ManyToOne
	private Aplicador aplicador;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aplicacao")
	private Set<Instancia> instancias;

	public Aplicacao()
	{
		instancias = new HashSet<Instancia>();
	}

	public Aplicacao(int id, Date data, Turma turma, Prova prova,
			Aplicador aplicador)
	{
		super(id);
		this.data = data;
		this.turma = turma;
		this.prova = prova;
		this.aplicador = aplicador;
		instancias = new HashSet<Instancia>();
	}

	public Aplicador getAplicador()
	{
		return aplicador;
	}

	public Date getData()
	{
		return data;
	}

	public Set<Instancia> getInstancias()
	{
		return instancias;
	}

	public Prova getProva()
	{
		return prova;
	}

	public Turma getTurma()
	{
		return turma;
	}

	public void setAplicador(Aplicador aplicador)
	{
		this.aplicador = aplicador;
	}

	public void setData(Date data)
	{
		this.data = data;
	}

	public void setInstancias(Set<Instancia> instancias)
	{
		this.instancias = instancias;
	}

	public void setProva(Prova prova)
	{
		this.prova = prova;
	}

	public void setTurma(Turma turma)
	{
		this.turma = turma;
	}
}