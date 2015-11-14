package util.exception;

import java.io.Serializable;

/**
 * Respons�vel por manipular uma MsgException
 * 
 * @version 1.0
 */
public class MsgException implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private Object[] params;
	private Object details = "";

	/**
	 * M�todo construtor para MsgException
	 */
	public MsgException(Object details)
	{
		this.details = details;
	}

	/**
	 * M�todo construtor para MsgException
	 */
	public MsgException(Object[] params)
	{
		this.params = params;
	}

	/**
	 * M�todo construtor para MsgException
	 */
	public MsgException(Object[] params, Object details)
	{
		this.params = params;
		this.details = details;
	}

	/**
	 * M�todo construtor para MsgException
	 */
	public MsgException(String code)
	{
		this.code = code;
	}

	/**
	 * M�todo construtor para MsgException
	 */
	public MsgException(String code, Object details)
	{
		this.code = code;
		this.details = details;
	}

	/**
	 * M�todo construtor para MsgException
	 */
	public MsgException(String code, Object[] params)
	{
		this.code = code;
		this.params = params;
	}

	/**
	 * M�todo construtor para MsgException
	 */
	public MsgException(String code, Object[] params, Object details)
	{
		this.code = code;
		this.params = params;
		this.details = details;
	}

	/**
	 * M�todo utilizado para obter o c�digo de uma MsgException
	 * 
	 * @return String
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * M�todo utilizado para obter os detalhes de uma MsgException
	 * 
	 * @return Object
	 */
	public Object getDetails()
	{
		return details;
	}

	/**
	 * M�todo utilizado para obter os par�metros de uma MsgException
	 * 
	 * @return Object[]
	 */
	public Object[] getParams()
	{
		return params;
	}
}
