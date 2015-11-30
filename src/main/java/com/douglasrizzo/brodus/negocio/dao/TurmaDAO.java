package negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import negocio.entity.Turma;

public class TurmaDAO extends GenericDAO<Turma>
{
	public TurmaDAO(EntityManager em)
	{
		super(em);
	}

	public boolean alterar(Turma turma)
	{
		boolean result = false;
		Turma existente = null;

		try
		{
			existente = em.find(Turma.class, turma.getId());
			if (existente != null)
			{
				em.merge(turma);
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
	public Turma findByAplicador(int aplicadorId)
	{
		Turma result = null;

		try
		{
			Query q = em
					.createQuery("from Turma where aplicador.id like :aplicadorId");
			q.setParameter("aplicadorId", aplicadorId);

			List<Turma> results = q.getResultList();
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