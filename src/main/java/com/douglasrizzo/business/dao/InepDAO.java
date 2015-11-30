package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.Inep;

public class InepDAO extends GenericDAO<Inep>
{
	public InepDAO(EntityManager em)
	{
		super(em);
	}
}
