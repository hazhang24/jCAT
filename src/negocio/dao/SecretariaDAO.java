package negocio.dao;

import javax.persistence.EntityManager;

import negocio.entity.Secretaria;

public class SecretariaDAO extends GenericDAO<Secretaria>
{
	public SecretariaDAO(EntityManager em)
	{
		super(em);
	}
}
