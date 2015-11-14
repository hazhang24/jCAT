package negocio.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class ItemRespondido extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean acerto;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Instancia instancia;
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;

	public ItemRespondido()
	{}

	public ItemRespondido(int id, boolean acerto, Instancia instancia, Item item)
	{
		super(id);
		this.acerto = acerto;
		this.instancia = instancia;
		this.item = item;
	}

	public Instancia getInstancia()
	{
		return instancia;
	}

	public Item getItem()
	{
		return item;
	}

	public boolean isAcerto()
	{
		return acerto;
	}

	public void setAcerto(boolean acerto)
	{
		this.acerto = acerto;
	}

	public void setInstancia(Instancia instancia)
	{
		this.instancia = instancia;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}
}