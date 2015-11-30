package com.douglasrizzo.util.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class ServiceDTO implements Serializable, AttributeAccess
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AttributeList attributes;
	private MessageList messages;

	public ServiceDTO()
	{
		attributes = new AttributeList();
		messages = new MessageList();
	}

	@Override
	public void clearAttributes()
	{
		attributes = new AttributeList();
	}

	@Override
	public void clearMessages()
	{
		messages = new MessageList();
	}

	@Override
	public Object get(Object key)
	{
		return attributes.get(key);
	}

	@Override
	public AttributeList getAllAttributes()
	{
		return (AttributeList) attributes.clone();
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public AttributeList getAttributes(Collection keysOfAttributes)
			throws ServiceDTOException
	{
		Iterator keys = keysOfAttributes.iterator();
		Object key = null;
		AttributeList result = new AttributeList();
		try
		{
			for (; keys.hasNext(); result.put(key, attributes.get(key)))
			{
				key = keys.next();
			}
			return result;
		}
		catch (Exception e)
		{
			throw new ServiceDTOException(e.getMessage());
		}
	}

	@Override
	public Message getMessage()
	{
		return messages.getMessage();
	}

	@Override
	public boolean hasMessage()
	{
		return messages.hasMessage();
	}

	@Override
	public boolean hasNextMessage()
	{
		return messages.hasNextMessage();
	}

	@Override
	public void putMessage(Message message)
	{
		messages.putMessage(message);
	}

	@Override
	public void set(Object key, Object value)
	{
		attributes.put(key, value);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public void setAttributes(AttributeList pairsKeysValues)
			throws ServiceDTOException
	{
		Iterator entries = pairsKeysValues.entrySet().iterator();
		java.util.Map.Entry entry = null;
		try
		{
			for (; entries.hasNext(); attributes.put(entry.getKey(),
					entry.getValue()))
			{
				entry = (java.util.Map.Entry) entries.next();
			}
		}
		catch (Exception e)
		{
			throw new ServiceDTOException(e.getMessage());
		}
	}
}