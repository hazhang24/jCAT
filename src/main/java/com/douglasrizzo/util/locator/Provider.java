package com.douglasrizzo.util.locator;

import java.util.Hashtable;

public class Provider
{
	protected String name;

	protected String desc;

	protected Hashtable<String, String> properties;

	public Provider()
	{
		properties = new Hashtable<String, String>();
	}

	public String getDesc()
	{
		return desc;
	}

	public String getName()
	{
		return name;
	}

	public Hashtable<String, String> getProperties()
	{
		return properties;
	}

	public void setDesc(String string)
	{
		desc = string;
	}

	public void setName(String string)
	{
		name = string;
	}

	public void setProperties(Hashtable<String, String> properties)
	{
		this.properties = properties;
	}

	public void setProperty(String key, String value)
	{
		properties.put(key, value);
	}
}
