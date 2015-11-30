package negocio.vo;

public class CadastroAplicadorVO extends CadastroElaboradorVO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int turmaId;

	public CadastroAplicadorVO()
	{}

	public CadastroAplicadorVO(int id, String nome, String sobrenome,
			String email, String senha, int tipoUsuarioId, int turmaId)
	{
		super(id, nome, sobrenome, email, senha, tipoUsuarioId);
		this.turmaId = turmaId;
	}

	public int getTurmaId()
	{
		return turmaId;
	}

	public void setTurmaId(int turmaId)
	{
		this.turmaId = turmaId;
	}

}