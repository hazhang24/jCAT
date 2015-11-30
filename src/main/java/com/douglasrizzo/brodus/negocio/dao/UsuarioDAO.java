package negocio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import negocio.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>
{
	public UsuarioDAO(EntityManager em)
	{
		super(em);
	}

	public boolean alterar(Usuario usuario)
	{
		boolean result = false;
		Usuario existenteUsuario = null;

		try
		{
			existenteUsuario = em.find(Usuario.class, usuario.getId());
			if (existenteUsuario != null)
			{
				em.merge(usuario);
				result = true;
			}
			else
			{
				result = false;
			}
		}
		catch (Exception e)
		{
			if (debugInfo)
			{
				e.printStackTrace();
			}
			result = false;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Usuario localizarPorEmail(String email)
	{
		try
		{
			Query q = em.createQuery("from Usuario where email like :email");
			q.setParameter("email", email);
			List<Usuario> lista = q.getResultList();
			if (lista.size() > 0)
			{
				return lista.get(0);
			}
		}
		catch (Exception e)
		{
			if (debugInfo)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> localizarPorNome(Usuario usuario)
	{
		List<Usuario> result = new ArrayList<Usuario>();

		try
		{
			Query q = em.createQuery("from Usuario where nome like :nome");
			q.setParameter("nome", usuario.getNome());
			result = q.getResultList();
		}
		catch (Exception e)
		{
			if (debugInfo)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
}