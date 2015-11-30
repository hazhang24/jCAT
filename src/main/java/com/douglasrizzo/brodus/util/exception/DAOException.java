package util.exception;

/**
 * Responsible for throwing DAOException
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
	 * Constructor for DAOException
	 */
	DAOException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * Constructor for DAOException
	 */
	DAOException(MsgExceptionList list)
	{
		super(list);
	}

}
