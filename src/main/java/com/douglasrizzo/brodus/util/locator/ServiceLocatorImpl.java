package util.locator;

public class ServiceLocatorImpl extends Locator implements ServiceLocator
{
	public ServiceLocatorImpl()
	{}

	@Override
	public Object getService(String jndiName) throws ServiceLocatorException
	{
		return lookup(jndiName);
	}
}
