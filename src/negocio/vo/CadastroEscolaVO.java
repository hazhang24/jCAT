package negocio.vo;

import java.io.Serializable;

public class CadastroEscolaVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, codigo;
	private String nome;

	public CadastroEscolaVO()
	{}

	public CadastroEscolaVO(int id, int codigo, String nome)
	{
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public int getId()
	{
		return id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
}
