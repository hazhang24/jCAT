package com.douglasrizzo.util.dto;

import java.util.Collection;

public interface AttributeAccess
{
	public abstract void clearAttributes();

	public abstract void clearMessages();

	public abstract Object get(Object obj);

	public abstract AttributeList getAllAttributes();

	@SuppressWarnings("rawtypes")
	public abstract AttributeList getAttributes(Collection collection)
			throws ServiceDTOException;

	public abstract Message getMessage();

	public abstract boolean hasMessage();

	public abstract boolean hasNextMessage();

	public abstract void putMessage(Message message);

	public abstract void set(Object obj, Object obj1);

	public abstract void setAttributes(AttributeList attributelist)
			throws ServiceDTOException;
}
