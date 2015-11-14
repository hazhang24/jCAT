package negocio.vo;

import java.io.Serializable;

public class CadastroAplicacaoProvaVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, aplicadorId, provaId;
	private String titulo;

	public CadastroAplicacaoProvaVO()
	{}

	public CadastroAplicacaoProvaVO(int id, int aplicadorId, int provaId,
			String titulo)
	{
		this.id = id;
		this.aplicadorId = aplicadorId;
		this.provaId = provaId;
		this.titulo = titulo;
	}

	public int getAplicadorId()
	{
		return aplicadorId;
	}

	public int getId()
	{
		return id;
	}

	public int getProvaId()
	{
		return provaId;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setAplicadorId(int aplicadorId)
	{
		this.aplicadorId = aplicadorId;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setProvaId(int provaId)
	{
		this.provaId = provaId;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
}