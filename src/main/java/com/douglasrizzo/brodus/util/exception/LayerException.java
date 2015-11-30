package util.exception;

/**
 * Responsible for launching LayerException
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
	 * Constructor for LayerException
	 */
	public LayerException()
	{
		super();
	}

	/**
	 * Constructor for LayerException
	 */
	public LayerException(MsgException msg)
	{
		super();
		msgExceptionList = new MsgExceptionList(msg);
	}

	/**
	 * Constructor for LayerException
	 */
	public LayerException(MsgExceptionList msgExceptionList)
	{
		super();
		this.msgExceptionList = msgExceptionList;
	}

	/**
	 * Método utilizado para recuperar uma MsgExceptionList.
	 * 
	 * @return MsgExceptionList
	 * @see MsgExceptionList
	 */
	public MsgExceptionList getMsgExceptionList()
	{
		return msgExceptionList;
	}

	/**
	 * Método utilizado para configurar uma MsgExceptionList.
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
