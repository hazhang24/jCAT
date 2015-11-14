package util.exception;

/**
 * Respons�vel por lan�ar a exce��o DAOException
 * 
 * @version 1.0
 */
public final class DAOException extends SysException
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * M�todo construtor para DAOException
	 */
	DAOException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * M�todo construtor para DAOException
	 */
	DAOException(MsgExceptionList list)
	{
		super(list);
	}

}
