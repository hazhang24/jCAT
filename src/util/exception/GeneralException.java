package util.exception;

/**
 * Respons�vel por lan�ar a exce��o GeneralException
 * 
 * @version 1.0
 */
public final class GeneralException extends SysException
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * M�todo construtor para GeneralException
	 */
	GeneralException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * M�todo construtor para GeneralException
	 */
	GeneralException(MsgExceptionList list)
	{
		super(list);
	}
}
