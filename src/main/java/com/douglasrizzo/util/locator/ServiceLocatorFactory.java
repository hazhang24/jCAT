package com.douglasrizzo.util.locator;

import java.util.HashMap;

public class ServiceLocatorFactory
{
	protected static final HashMap<String, ServiceLocator> locators = new HashMap<String, ServiceLocator>();

	public static ServiceLocator getServiceLocator(Class<?> clazz)
	{
		String name = clazz.getName();
		ServiceLocator sl = null;
		if (locators.containsKey(name))
		{
			sl = locators.get(name);
		}
		else
		{
			sl = new ServiceLocatorImpl();
			locators.put(name, sl);
		}
		return sl;
	}

	public static ServiceLocator getServiceLocator(String name)
	{
		ServiceLocator sl = null;
		if (locators.containsKey(name))
		{
			sl = locators.get(name);
		}
		else
		{
			sl = new ServiceLocatorImpl();
			locators.put(name, sl);
		}
		return sl;
	}

	public ServiceLocatorFactory()
	{}
}