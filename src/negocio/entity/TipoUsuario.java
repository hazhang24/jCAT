package negocio.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TipoUsuario extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descricao;
	@OneToMany(mappedBy = "tipoUsuario")
	private Set<Usuario> usuarios;

	public TipoUsuario()
	{
		usuarios = new HashSet<Usuario>();
	}

	public TipoUsuario(int id, String descricao)
	{
		super(id);
		this.descricao = descricao;
		usuarios = new HashSet<Usuario>();
	}

	public String getDescricao()
	{
		return descricao;
	}

	public Set<Usuario> getUsuarios()
	{
		return usuarios;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public void setUsuarios(Set<Usuario> usuarios)
	{
		this.usuarios = usuarios;
	}
}