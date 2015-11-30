package com.douglasrizzo.util.locator;

public interface ServiceLocator
{
	public abstract Object getService(String s) throws ServiceLocatorException;
}