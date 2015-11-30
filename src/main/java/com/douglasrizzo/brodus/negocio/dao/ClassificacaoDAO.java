package negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import negocio.entity.Classificacao;

public class ClassificacaoDAO extends GenericDAO<Classificacao>
{
	public ClassificacaoDAO(EntityManager em)
	{
		super(em);
	}

	public Classificacao findByValor(int valor)
	{
		Classificacao result = null;

		try
		{
			Query q = em.createQuery("from Classificacao where valor = :valor");
			q.setParameter("valor", valor);

			List<Classificacao> results = q.getResultList();
			if (results.size() > 0)
			{
				result = results.get(0);
			}
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