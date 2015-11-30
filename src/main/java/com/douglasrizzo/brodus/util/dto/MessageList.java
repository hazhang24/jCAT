package util.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageList implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Message> messages;
	private int numMessages;
	private int current;

	public MessageList()
	{
		numMessages = 0;
		current = 0;
		messages = new ArrayList<Message>();
	}

	public Message getMessage()
	{
		Message message = messages.get(current);
		current++;
		return message;
	}

	public boolean hasMessage()
	{
		current = 0;
		return numMessages > 0;
	}

	public boolean hasNextMessage()
	{
		return current < numMessages;
	}

	public void putMessage(Message message)
	{
		messages.add(message);
		numMessages++;
	}
}
