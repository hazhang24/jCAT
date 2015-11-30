package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.Elaborador;

public class ElaboradorDAO extends GenericDAO<Elaborador>
{
	public ElaboradorDAO(EntityManager em)
	{
		super(em);
	}
}
