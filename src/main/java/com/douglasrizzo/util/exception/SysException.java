package com.douglasrizzo.util.exception;

/**
 * Responsible for launching SysException
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
	 * Constructor for SysException
	 */
	public SysException()
	{
		super();
	}

	/**
	 * Constructor for SysException
	 */
	public SysException(MsgException msg)
	{
		super(msg);
	}

	/**
	 * Constructor for SysException
	 */
	public SysException(MsgExceptionList list)
	{
		super(list);
	}
}
