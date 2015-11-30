package util.exception;

/**
 * responsible for throwing BusinessExceptions
 * 
 * @version 1.0
 */
public class BusinessException extends LayerException
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for BusinessException
	 */
	public BusinessException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * Constructor for BusinessException
	 */
	public BusinessException(MsgExceptionList list)
	{
		super(list);
	}

}
