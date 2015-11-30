package util.exception;

public final class Environment
{

	public static final int PRODUCAO = 1;
	public static final int DESENVOLVIMENTO = 2;

	public static int getEnvironment()
	{
		return DESENVOLVIMENTO;
	}

	public static boolean getLogTraceFile()
	{
		return true;
	}

	public static boolean getLogTraceSystemOut()
	{
		return false;
	}

	/**
	 * Constructor method
	 */
	private Environment()
	{}
}
