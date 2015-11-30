package util.locator;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ProvidersSaxParserTester
{

	public static void main(String args[])
	{
		ProvidersSaxParserTester tester = new ProvidersSaxParserTester();
		tester.run();
	}

	public ProvidersSaxParserTester()
	{}

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

	protected void printProviders(HashMap<String, Provider> providers)
	{
		for (Provider provider : providers.values())
		{
			System.out.println("Provider: " + provider.getName());
			System.out.println("\tDesc: " + provider.getDesc());
			System.out.println("\tProperties: ");
			Hashtable<String, String> properties = provider.getProperties();
			String key;
			String value;
			for (Enumeration<String> keys = properties.keys(); keys
					.hasMoreElements(); System.out.println("\t\t" + key + " = "
					+ value))
			{
				key = keys.nextElement();
				value = properties.get(key);
			}

		}

	}

	public void run()
	{
		String fileName = "config/sl-providers-test.xml";
		InputStream input = getLocatorResourceAsStream(fileName);

		System.out.println(input);

		if (input == null)
		{
			System.out.println("The file [" + fileName + "] was not found.");
		}
		else
		{
			System.out.println("Initializing from file [" + fileName + "].");
			try
			{
				ProvidersSaxParser handler = new ProvidersSaxParser();
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser = factory.newSAXParser();
				parser.parse(input, handler);
				HashMap<String, Provider> providers = handler.getProviders();
				printProviders(providers);
			}
			catch (Exception _ex)
			{
				_ex.printStackTrace();
			}
		}
	}
}
