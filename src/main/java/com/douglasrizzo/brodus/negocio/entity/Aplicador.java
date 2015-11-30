package negocio.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Aplicador extends Usuario
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne(fetch = FetchType.EAGER)
	private Turma turma;

	public Aplicador()
	{}

	public Aplicador(int id, String nome, String sobrenome, String email,
			String senha, TipoUsuario tipoUsuario, Turma turma)
	{
		super(id, nome, sobrenome, email, senha, tipoUsuario);
		this.turma = turma;
	}

	public Turma getTurma()
	{
		return turma;
	}

	public void setTurma(Turma turma)
	{
		this.turma = turma;
	}
}