package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.Secretaria;

public class SecretariaDAO extends GenericDAO<Secretaria>
{
	public SecretariaDAO(EntityManager em)
	{
		super(em);
	}
}
