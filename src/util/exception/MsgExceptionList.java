package util.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Respons�vel por manipular uma cole��o de MsgException
 * 
 * @version 1.0
 */
public class MsgExceptionList implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Collection<MsgException> msgException = null;

	/**
	 * M�todo construtor para MsgExceptionList
	 */
	public MsgExceptionList()
	{
		msgException = new ArrayList<MsgException>();
	}

	/**
	 * M�todo construtor para MsgExceptionList
	 */
	public MsgExceptionList(MsgException msg)
	{
		msgException = new ArrayList<MsgException>();
		msgException.add(msg);
	}

	/**
	 * M�todo utilizado para adicionar uma cole��o de MsgException
	 * 
	 * @param msg
	 *            informar uma MsgException para ser adicionada a cole��o de
	 *            MsgException
	 */
	public void addMsgException(MsgException msg)
	{
		msgException.add(msg);
	}

	/**
	 * M�todo utilizado para obter uma cole��o de MsgException
	 * 
	 * @return Collection
	 */
	public Collection<MsgException> getMsgException()
	{
		return msgException;
	}

	/**
	 * M�todo utilizado para remover uma cole��o de MsgException
	 * 
	 * @param msg
	 *            informar uma MsgException para ser removida da cole��o de
	 *            MsgException
	 */
	public void removeMsgException(MsgException msg)
	{
		msgException.remove(msg);
	}

	/**
	 * M�todo utilizado para informar uma cole��o de MsgException
	 * 
	 * @param msgException
	 *            informar uma cole��o de MsgException a ser configurada
	 */
	public void setMsgException(Collection<MsgException> msgException)
	{
		this.msgException = new ArrayList<MsgException>();
		this.msgException = msgException;
	}
}