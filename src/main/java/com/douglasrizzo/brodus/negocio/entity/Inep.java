package negocio.entity;

import javax.persistence.Entity;

@Entity
public class Inep extends Usuario
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean bogus;

	public Inep()
	{}

	public Inep(int id, String nome, String sobrenome, String email,
			String senha, TipoUsuario tipoUsuario, boolean bogus)
	{
		super(id, nome, sobrenome, email, senha, tipoUsuario);
		this.bogus = bogus;
	}

	public boolean isBogus()
	{
		return bogus;
	}

	public void setBogus(boolean bogus)
	{
		this.bogus = bogus;
	}

}
