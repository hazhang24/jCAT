package util.locator;

import java.util.ArrayList;

public class Service
{
	protected String name;

	protected String desc;

	protected boolean cacheable;

	protected String jndiName;

	protected ArrayList<String> providers;

	public Service()
	{
		providers = new ArrayList<String>();
	}

	public void addProvider(String provider)
	{
		providers.add(provider);
	}

	public String getDesc()
	{
		return desc;
	}

	public String getJndiName()
	{
		return jndiName;
	}

	public String getName()
	{
		return name;
	}

	public String[] getProviders()
	{
		return providers.toArray(new String[providers.size()]);
	}

	public boolean isCacheable()
	{
		return cacheable;
	}

	public void setCacheable(boolean b)
	{
		cacheable = b;
	}

	public void setDesc(String string)
	{
		desc = string;
	}

	public void setJndiName(String string)
	{
		jndiName = string;
	}

	public void setName(String string)
	{
		name = string;
	}
}
