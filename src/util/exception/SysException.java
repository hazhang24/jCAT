package util.exception;

/**
 * Respons�vel por lan�ar a exce��o SysException
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
	 * M�todo construtor para SysException
	 */
	public SysException()
	{
		super();
	}

	/**
	 * M�todo construtor para SysException
	 */
	public SysException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * M�todo construtor para SysException
	 */
	public SysException(MsgExceptionList list)
	{
		super(list);
	}
}
