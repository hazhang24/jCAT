package negocio.dao;

import javax.persistence.EntityManager;

import negocio.entity.Prova;

public class ProvaDAO extends GenericDAO<Prova>
{
	public ProvaDAO(EntityManager em)
	{
		super(em);
	}
}
