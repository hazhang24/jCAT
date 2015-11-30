package negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import negocio.entity.Aplicacao;

public class AplicacaoDAO extends GenericDAO<Aplicacao>
{
	public AplicacaoDAO(EntityManager em)
	{
		super(em);
	}

	public List<Aplicacao> listByEscola(int escolaId)
	{
		List<Aplicacao> results = null;

		try
		{
			Query q = em
					.createQuery("from Aplicacao where turma.escola.id like :escolaId");
			q.setParameter("escolaId", escolaId);

			results = q.getResultList();
		}
		catch (Exception e)
		{
			if (debugInfo)
			{
				e.printStackTrace();
			}
		}
		return results;
	}
}
