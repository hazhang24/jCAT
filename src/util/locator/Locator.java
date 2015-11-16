package util.locator;

import java.util.HashMap;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Locator
{
	private static final Log logger;
	protected HashMap<String, Object> cache;
	protected HashMap<?, ?> services;
	protected HashMap<?, ?> providers;

	static
	{
		logger = LogFactory.getLog(Locator.class);
	}

	public Locator()
	{
		cache = new HashMap<String, Object>();
		services = null;
		providers = null;
		LocatorConfig config = new LocatorConfig();
		providers = config.getProviders();
		services = config.getServices();
	}

	public void clear()
	{
		cache.clear();
	}

	public void clearCache(String envName)
	{
		if (cache.containsKey(envName))
		{
			cache.remove(envName);
		}
	}

	private Service getService(String envName)
	{
		if (services != null && services.containsKey(envName))
		{
			return (Service) services.get(envName);
		}
		else
		{
			return null;
		}
	}

	protected Object lookup(String envName) throws ServiceLocatorException
	{
		Service service = getService(envName);
		if (service == null)
		{
			return lookupLocal(envName);
		}
		if (service.isCacheable() && cache.containsKey(envName))
		{
			return cache.get(envName);
		}
		String jndiName = service.getJndiName() != null ? service.getJndiName()
				: envName;
		Object envEntry = lookupProviders(service.getProviders(), jndiName);
		if (envEntry == null)
		{
			envEntry = lookupLocal(jndiName);
		}
		if (service.isCacheable())
		{
			cache.put(envName, envEntry);
		}
		return envEntry;
	}

	private Object lookupLocal(String envName) throws ServiceLocatorException
	{
		InitialContext ic = null;
		try
		{
			ic = new InitialContext();
			Object obj = ic.lookup(envName);
			return obj;
		}
		catch (NamingException _nex)
		{
			throw new ServiceLocatorException("O objeto nomeado[" + envName
					+ "] não foi encontrado localmente para JNDI service: ["
					+ _nex.getMessage() + "].", _nex);
		}
		finally
		{
			try
			{
				if (ic != null)
				{
					ic.close();
				}
			}
			catch (NamingException _nex)
			{
				logger.warn(
						"Não foi possível fechar o contexto: ["
								+ _nex.getMessage() + "].", _nex);
			}
		}
	}

	private Object lookupProviders(String providersName[], String envName)
	{
		if (providers != null && providersName != null)
		{
			for (String element : providersName)
			{
				Provider provider = (Provider) providers.get(element);
				try
				{
					return lookupRemote(provider, envName);
				}
				catch (Exception _ex)
				{
					logger.warn(_ex.getMessage(), _ex);
				}
			}
		}
		return null;
	}

	private Object lookupRemote(Provider provider, String envName)
			throws ServiceLocatorException
	{
		InitialContext ic = null;
		try
		{
			ic = new InitialContext(provider.getProperties());
			Object obj = ic.lookup(envName);
			return obj;
		}
		catch (NamingException _nex)
		{
			throw new ServiceLocatorException("O objeto nomeado[" + envName
					+ "] não foi encontrado remotamente para JNDI service["
					+ provider.getProperties() + "]: [" + _nex.getMessage()
					+ "].", _nex);
		}
		finally
		{
			try
			{
				if (ic != null)
				{
					ic.close();
				}
			}
			catch (NamingException _nex)
			{
				logger.warn(
						"Não foi possível fechar o contexto: ["
								+ _nex.getMessage() + "].", _nex);
			}
		}
	}
}