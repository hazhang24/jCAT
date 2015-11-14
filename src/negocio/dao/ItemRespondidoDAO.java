package negocio.dao;

import javax.persistence.EntityManager;

import negocio.entity.ItemRespondido;

public class ItemRespondidoDAO extends GenericDAO<ItemRespondido>
{
	public ItemRespondidoDAO(EntityManager em)
	{
		super(em);
	}
}
