package negocio.dao;

import javax.persistence.EntityManager;

import negocio.entity.Elaborador;

public class ElaboradorDAO extends GenericDAO<Elaborador>
{
	public ElaboradorDAO(EntityManager em)
	{
		super(em);
	}
}
