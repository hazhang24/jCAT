package util.log;

import java.io.InputStream;
import java.util.Properties;

import util.Util;

public class LogConfig
{
	private static String PROPS_ENVIRONMENT = "ambiente";
	private static String PROPS_DEV = "desenvolvimento";
	private static String PROPS_PRD = "producao";

	private String directory;

	public LogConfig()
	{
		loadConfig();
	}

	public String getDirectory()
	{
		return directory;
	}

	private void loadConfig()
	{
		Properties props = loadProperties();

		if (props.getProperty(PROPS_ENVIRONMENT).equalsIgnoreCase(PROPS_DEV))
		{
			setDirectory(props.getProperty("des_directory"));
		}

		if (props.getProperty(PROPS_ENVIRONMENT).equalsIgnoreCase(PROPS_PRD))
		{
			setDirectory(props.getProperty("prd_directory"));
		}
	}

	private Properties loadProperties()
	{
		Properties props = new Properties();
		try
		{
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			if (classLoader == null)
			{
				classLoader = getClass().getClassLoader();
			}
			InputStream input = classLoader.getResourceAsStream(Util.LOG_FILE);
			if (input == null)
			{
				System.out.println("***** Arquivo de propriedades "
						+ Util.LOG_FILE + " n�o encontrado! *****");
			}
			props.load(input);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return props;
	}

	public void setDirectory(String _directory)
	{
		directory = _directory;
	}
}