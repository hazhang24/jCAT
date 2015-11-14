package util.locator;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LocatorConfig
{
	private static final Log logger;

	protected static final LocatorConfig me = new LocatorConfig();

	public static LocatorConfig getInstance()
	{
		return me;
	}

	private String providersFile;

	private String servicesFile;

	static
	{
		logger = LogFactory.getLog(LocatorConfig.class);
	}

	protected LocatorConfig()
	{
		providersFile = System.getProperty("sl.providers",
				"config/sl-providers.xml");
		servicesFile = System.getProperty("sl.services",
				"config/sl-services.xml");
	}

	protected InputStream getLocatorResourceAsStream(String name)
	{
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null)
		{
			classLoader = getClass().getClassLoader();
		}
		InputStream input = classLoader.getResourceAsStream(name);
		return input;
	}

	public HashMap<String, Provider> getProviders()
	{
		InputStream input = getLocatorResourceAsStream(providersFile);
		if (input == null)
		{
			logger.warn("The configuration file [" + providersFile
					+ "] of naming service providers was not found.");
		}
		else
		{
			logger.info("Initializing the naming service providers configuration from file ["
					+ providersFile + "].");
			try
			{
				ProvidersSaxParser handler = new ProvidersSaxParser();
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser = factory.newSAXParser();
				parser.parse(input, handler);
				return handler.getProviders();
			}
			catch (Exception _ex)
			{
				logger.fatal(
						"An unexpected error parsing the naming service providers file ["
								+ providersFile + "]: [" + _ex.getMessage()
								+ "].", _ex);
			}
		}
		return null;
	}

	public HashMap<String, Service> getServices()
	{
		InputStream input = getLocatorResourceAsStream(servicesFile);
		if (input == null)
		{
			logger.warn("The configuration file [" + servicesFile
					+ "] of services was not found.");
		}
		else
		{
			logger.info("Initializing the services configuration from file ["
					+ servicesFile + "].");
			try
			{
				ServicesSaxParser handler = new ServicesSaxParser();
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser = factory.newSAXParser();
				parser.parse(input, handler);
				return handler.getServices();
			}
			catch (Exception _ex)
			{
				logger.fatal(
						"An unexpected error parsing the naming service providers file ["
								+ providersFile + "]: [" + _ex.getMessage()
								+ "].", _ex);
			}
		}
		return null;
	}
}
