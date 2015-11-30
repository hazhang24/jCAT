package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.Instancia;

public class InstanciaDAO extends GenericDAO<Instancia>
{
	public InstanciaDAO(EntityManager em)
	{
		super(em);
	}

	public boolean alterar(Instancia instancia)
	{
		boolean result = false;
		Instancia existente = null;

		try
		{
			existente = em.find(Instancia.class, instancia.getId());
			if (existente != null)
			{
				em.merge(instancia);
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
}