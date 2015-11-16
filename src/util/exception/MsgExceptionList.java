package util.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Responsável por manipular uma coleção de MsgException
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
	 * Método construtor para MsgExceptionList
	 */
	public MsgExceptionList()
	{
		msgException = new ArrayList<MsgException>();
	}

	/**
	 * Método construtor para MsgExceptionList
	 */
	public MsgExceptionList(MsgException msg)
	{
		msgException = new ArrayList<MsgException>();
		msgException.add(msg);
	}

	/**
	 * Método utilizado para adicionar uma coleção de MsgException
	 * 
	 * @param msg
	 *            informar uma MsgException para ser adicionada a coleção de
	 *            MsgException
	 */
	public void addMsgException(MsgException msg)
	{
		msgException.add(msg);
	}

	/**
	 * Método utilizado para obter uma coleção de MsgException
	 * 
	 * @return Collection
	 */
	public Collection<MsgException> getMsgException()
	{
		return msgException;
	}

	/**
	 * Método utilizado para remover uma coleção de MsgException
	 * 
	 * @param msg
	 *            informar uma MsgException para ser removida da coleção de
	 *            MsgException
	 */
	public void removeMsgException(MsgException msg)
	{
		msgException.remove(msg);
	}

	/**
	 * Método utilizado para informar uma coleção de MsgException
	 * 
	 * @param msgException
	 *            informar uma coleção de MsgException a ser configurada
	 */
	public void setMsgException(Collection<MsgException> msgException)
	{
		this.msgException = new ArrayList<MsgException>();
		this.msgException = msgException;
	}
}