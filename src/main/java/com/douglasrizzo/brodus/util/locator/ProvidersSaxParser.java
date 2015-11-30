package util.locator;

import java.io.CharArrayWriter;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ProvidersSaxParser extends DefaultHandler
{
	private static final Log logger;

	protected CharArrayWriter contents;

	protected boolean inProvider;

	protected boolean inProperty;

	protected HashMap<String, Provider> providers;

	protected Provider provider;

	protected String propertyName;

	protected String propertyValue;

	static
	{
		logger = LogFactory.getLog(ProvidersSaxParser.class);
	}

	public ProvidersSaxParser()
	{
		contents = new CharArrayWriter();
		inProvider = false;
		inProperty = false;
		providers = new HashMap<String, Provider>();
		logger.debug("ProvidersSaxParser 2.0 - SAX 2.0 Implementation");
	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException
	{
		contents.write(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException
	{

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		if (inProperty && inProvider && "property".equals(qName))
		{
			provider.setProperty(propertyName, propertyValue);
			inProperty = false;
		}
		if (inProperty && inProvider)
		{
			parseProperty(qName, contents.toString());
		}
		else
		{
			if (inProvider)
			{
				parseProvider(qName, contents.toString());
			}

			if (inProvider && "provider".equals(qName))
			{
				providers.put(provider.getName(), provider);
				inProvider = false;
			}
		}
	}

	@Override
	public void error(SAXParseException _saxpex) throws SAXException
	{
		logger.error("Error: [" + _saxpex.getMessage() + "].", _saxpex);
	}

	@Override
	public void fatalError(SAXParseException _saxpex) throws SAXException
	{
		logger.fatal("Fatal Error: [" + _saxpex.getMessage() + "].", _saxpex);
	}

	public HashMap<String, Provider> getProviders()
	{
		return providers;
	}

	protected void parseProperty(String tagName, String tagValue)
			throws SAXParseException
	{
		if ("name".equals(tagName))
		{
			propertyName = tagValue;
		}
		if ("value".equals(tagName))
		{
			propertyValue = tagValue;
		}
	}

	protected void parseProvider(String tagName, String tagValue)
			throws SAXParseException
	{
		if ("name".equals(tagName))
		{
			provider.setName(tagValue);
			return;
		}
		if ("desc".equals(tagName))
		{
			provider.setDesc(tagValue);
			return;
		}
		else
		{
			return;
		}
	}

	@Override
	public void startDocument() throws SAXException
	{

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attr) throws SAXException
	{
		contents.reset();
		if (inProvider && "property".equals(qName))
		{
			inProperty = true;
			propertyName = null;
			propertyValue = null;
			return;
		}
		if (!inProvider && "provider".equals(qName))
		{
			inProvider = true;
			provider = new Provider();
			return;
		}
		else
		{
			return;
		}
	}

	@Override
	public void warning(SAXParseException _saxpex) throws SAXException
	{
		logger.warn("Warning: [" + _saxpex.getMessage() + "].", _saxpex);
	}
}
