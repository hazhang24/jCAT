package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.Prova;

public class ProvaDAO extends GenericDAO<Prova>
{
	public ProvaDAO(EntityManager em)
	{
		super(em);
	}
}
