package negocio.vo;

import java.io.Serializable;

public class CadastroSecretariaVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, tipoUsuarioId, escolaId;
	private String nome, sobrenome, email, senha;

	public CadastroSecretariaVO()
	{}

	public CadastroSecretariaVO(int id, int tipoUsuarioId, int escolaId,
			String nome, String sobrenome, String email, String senha)
	{
		this.id = id;
		this.tipoUsuarioId = tipoUsuarioId;
		this.escolaId = escolaId;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}

	public String getEmail()
	{
		return email;
	}

	public int getEscolaId()
	{
		return escolaId;
	}

	public int getId()
	{
		return id;
	}

	public String getNome()
	{
		return nome;
	}

	public String getSenha()
	{
		return senha;
	}

	public String getSobrenome()
	{
		return sobrenome;
	}

	public int getTipoUsuarioId()
	{
		return tipoUsuarioId;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setEscolaId(int escolaId)
	{
		this.escolaId = escolaId;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public void setSobrenome(String sobrenome)
	{
		this.sobrenome = sobrenome;
	}

	public void setTipoUsuarioId(int tipoUsuarioId)
	{
		this.tipoUsuarioId = tipoUsuarioId;
	}
}