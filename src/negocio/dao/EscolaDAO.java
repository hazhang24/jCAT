package negocio.dao;

import javax.persistence.EntityManager;

import negocio.entity.Escola;

public class EscolaDAO extends GenericDAO<Escola>
{
	public EscolaDAO(EntityManager em)
	{
		super(em);
	}
}
