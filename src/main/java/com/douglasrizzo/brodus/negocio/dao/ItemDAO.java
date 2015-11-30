package negocio.dao;

import javax.persistence.EntityManager;

import negocio.entity.Item;

public class ItemDAO extends GenericDAO<Item>
{
	public ItemDAO(EntityManager em)
	{
		super(em);
	}

	public boolean alterar(Item item)
	{
		boolean result = false;
		Item existente = null;

		try
		{
			existente = em.find(Item.class, item.getId());
			if (existente != null)
			{
				em.merge(item);
				result = true;
			}
			else
			{
				result = false;
			}
		}
		catch (Exception e)
		{
			if (debugInfo)
			{
				e.printStackTrace();
			}
			result = false;
		}
		return result;
	}
}
