package util.exception;

/**
 * Responsible for throwing GeneralException
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
	 * Constructor for GeneralException
	 */
	GeneralException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * Constructor for GeneralException
	 */
	GeneralException(MsgExceptionList list)
	{
		super(list);
	}
}
