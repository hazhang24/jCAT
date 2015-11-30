package com.douglasrizzo.business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.douglasrizzo.business.entity.Aluno;

public class AlunoDAO extends GenericDAO<Aluno>
{
	public AlunoDAO(EntityManager em)
	{
		super(em);
	}

	public List<Aluno> findByTurma(int turmaId)
	{
		List<Aluno> results = null;

		try
		{
			Query q = em.createQuery("from Aluno where turma.id like :turmaId");
			q.setParameter("turmaId", turmaId);

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
