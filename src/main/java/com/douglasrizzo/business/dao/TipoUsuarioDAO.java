package com.douglasrizzo.business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.douglasrizzo.business.entity.TipoUsuario;

public class TipoUsuarioDAO extends GenericDAO<TipoUsuario>
{
	public TipoUsuarioDAO(EntityManager em)
	{
		super(em);
	}

	@SuppressWarnings("unchecked")
	public TipoUsuario localizarPorDescricao(String descricao)
	{
		TipoUsuario result = null;

		try
		{
			Query q = em
					.createQuery("from TipoUsuario where descricao like :descricao");
			q.setParameter("descricao", descricao);

			List<TipoUsuario> results = q.getResultList();
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
