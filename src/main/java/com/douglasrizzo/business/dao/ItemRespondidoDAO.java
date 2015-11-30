package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.business.entity.ItemRespondido;

public class ItemRespondidoDAO extends GenericDAO<ItemRespondido>
{
	public ItemRespondidoDAO(EntityManager em)
	{
		super(em);
	}
}
