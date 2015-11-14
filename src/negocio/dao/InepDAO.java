package negocio.dao;

import javax.persistence.EntityManager;

import negocio.entity.Inep;

public class InepDAO extends GenericDAO<Inep>
{
	public InepDAO(EntityManager em)
	{
		super(em);
	}
}
