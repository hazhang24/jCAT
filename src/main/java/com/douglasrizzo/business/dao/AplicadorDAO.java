package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.Aplicador;

public class AplicadorDAO extends GenericDAO<Aplicador>
{
	public AplicadorDAO(EntityManager em)
	{
		super(em);
	}

	public boolean alterar(Aplicador aplicador)
	{
		boolean result = false;
		Aplicador existenteAplicador = null;

		try
		{
			existenteAplicador = em.find(Aplicador.class, aplicador.getId());
			if (existenteAplicador != null)
			{
				em.merge(aplicador);
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
