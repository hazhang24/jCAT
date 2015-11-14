package negocio.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericDAO<T>
{

	public static final boolean debugInfo = false;

	static EntityManager em;
	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO(EntityManager em)
	{
		GenericDAO.em = em;

		Class<?> thisClass = getClass();
		if (debugInfo)
		{
			System.out.println(thisClass);
		}
		ParameterizedType t = (ParameterizedType) thisClass
				.getGenericSuperclass();
		Type t2 = t.getActualTypeArguments()[0];
		if (debugInfo)
		{
			System.out.println(t2);
		}
		this.classe = (Class<T>) t2;
	}

	/**
	 * Exclui um objeto persistido
	 * 
	 * @param id
	 *            Id do objeto a ser removido
	 * @return True se bem sucedido, false se houve erro.
	 */
	public boolean excluir(int id)
	{
		T obj = null;
		boolean result = false;

		try
		{
			obj = em.find(classe, id);

			em.remove(obj);
			result = true;
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

	/**
	 * Insere (persiste) um objeto e retorna o objeto inserido
	 * 
	 * @param obj
	 *            Objeto a ser persistido
	 * @return O objeto se bem sucedido, caso contr�rio null
	 */
	public T insereRetorna(T obj)
	{
		T result = null;

		try
		{
			result = em.merge(obj);
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

	/**
	 * Insere (persiste) um objeto
	 * 
	 * @param obj
	 *            Objeto a ser persistido
	 * @return True se bem sucedido, false se houve erro.
	 */
	public boolean inserir(T obj)
	{
		boolean result = false;

		try
		{
			em.merge(obj);
			result = true;
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

	/**
	 * Lista todos os objetos persistidos da classe
	 * 
	 * @return Lista de objetos persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<T> listar()
	{
		List<T> list = null;

		try
		{
			list = em.createQuery("from " + classe.getSimpleName())
					.getResultList();
		}
		catch (Exception e)
		{
			if (debugInfo)
			{
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * Localiza um objeto persistido pelo id
	 * 
	 * @param id
	 *            Id do objeto
	 * @return Objeto persistido
	 */
	public T localizar(int id)
	{
		T obj = null;

		try
		{
			obj = em.find(classe, id);
		}
		catch (Exception e)
		{
			if (debugInfo)
			{
				e.printStackTrace();
			}
		}
		return obj;
	}
}