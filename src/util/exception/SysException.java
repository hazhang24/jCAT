package util.exception;

/**
 * Responsável por lançar a exceção SysException
 * 
 * @version 1.0
 */
public abstract class SysException extends LayerException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Método construtor para SysException
	 */
	public SysException()
	{
		super();
	}

	/**
	 * Método construtor para SysException
	 */
	public SysException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * Método construtor para SysException
	 */
	public SysException(MsgExceptionList list)
	{
		super(list);
	}
}
