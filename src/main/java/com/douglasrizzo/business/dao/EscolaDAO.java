package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.Escola;

public class EscolaDAO extends GenericDAO<Escola>
{
	public EscolaDAO(EntityManager em)
	{
		super(em);
	}
}
