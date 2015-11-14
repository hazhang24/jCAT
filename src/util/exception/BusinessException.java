package util.exception;

/**
 * Respons�vel por lan�ar a exce��o BusinessException
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
	 * M�todo construtor para BusinessException
	 */
	public BusinessException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * M�todo construtor para BusinessException
	 */
	public BusinessException(MsgExceptionList list)
	{
		super(list);
	}

}
