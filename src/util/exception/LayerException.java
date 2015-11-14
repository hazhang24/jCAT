package util.exception;

/**
 * Respons�vel por lan�ar a exce��o LayerException
 * 
 * @version 1.0
 */
public abstract class LayerException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MsgExceptionList msgExceptionList;

	/**
	 * M�todo construtor para LayerException
	 */
	public LayerException()
	{
		super();
	}

	/**
	 * M�todo construtor para LayerException
	 */
	public LayerException(MsgException msg)
	{
		super();
		msgExceptionList = new MsgExceptionList(msg);
	}

	/**
	 * M�todo construtor para LayerException
	 */
	public LayerException(MsgExceptionList msgExceptionList)
	{
		super();
		this.msgExceptionList = msgExceptionList;
	}

	/**
	 * M�todo utilizado para recuperar uma MsgExceptionList.
	 * 
	 * @return MsgExceptionList
	 * @see MsgExceptionList
	 */
	public MsgExceptionList getMsgExceptionList()
	{
		return msgExceptionList;
	}

	/**
	 * M�todo utilizado para configurar uma MsgExceptionList.
	 * 
	 * @param list
	 *            informa um arrayList de MsgExceptionList
	 * @see MsgExceptionList
	 */
	public void setMsgExceptionList(MsgExceptionList list)
	{
		msgExceptionList = list;
	}
}
