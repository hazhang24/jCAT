package negocio.vo;

import java.io.Serializable;

public class EscolaListVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String descricao;

	public EscolaListVO()
	{}

	public EscolaListVO(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object arg0)
	{
		if (arg0 instanceof EscolaListVO)
		{
			EscolaListVO aux = (EscolaListVO) arg0;
			return id == aux.id && descricao.equals(aux.descricao);
		}
		return false;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public int getId()
	{
		return id;
	}

	@Override
	public int hashCode()
	{
		int hash = id;
		for (char c : descricao.toCharArray())
		{
			hash += c;
		}

		return hash;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
