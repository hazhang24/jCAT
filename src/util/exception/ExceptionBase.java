package util.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class ExceptionBase extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Gera TraceString associada � thread corrente.
	 * 
	 * A Trace String � composta pela identifica��o da thread e o timestamp.
	 * 
	 * @return String com identifica��o do erro original.
	 */
	private static String exceptionTraceCode()
	{
		return Thread.currentThread().toString() + new Date();
	}

	private String traceString = "";

	/**
	 * Construtor
	 * 
	 * Assinatura de construtor que recebe uma exce��o derivada de ExceptionBase
	 * e portanto j� � uma exce��o que encapsula a original e j� possui
	 * TraceString, que � reaproveitada para que possa ser usada como elemento
	 * de trace do problema.
	 * 
	 * @param e
	 *            exce��o derivada de ExceptionBase
	 */
	public ExceptionBase(ExceptionBase e)
	{
		super(e);
		traceString = e.getTraceString();
	}

	/**
	 * Construtor
	 * 
	 * Assinatura de construtor que recebe uma exce��o derivada de ExceptionBase
	 * e portanto j� � uma exce��o que encapsula a original e j� possui
	 * TraceString, que � reaproveitada para que possa ser usada como elemento
	 * de trace do problema.
	 * 
	 * @param e
	 *            exce��o derivada de ExceptionBase
	 */
	public ExceptionBase(String str)
	{
		super(str);
		traceString = ExceptionBase.exceptionTraceCode();
	}

	/**
	 * Construtor
	 * 
	 * Assinatura de construtor que recebe uma exce��o derivada de ExceptionBase
	 * e portanto j� � uma exce��o que encapsula a original e j� possui
	 * TraceString, que � reaproveitada para que possa ser usada como elemento
	 * de trace do problema.
	 * 
	 * @param e
	 *            exce��o derivada de ExceptionBase
	 */
	public ExceptionBase(String str, ExceptionBase e)
	{
		super(str, e);
		traceString = e.getTraceString();
	}

	/**
	 * Construtor
	 * 
	 * Assinatura de construtor que recebe uma exce��o derivada de ExceptionBase
	 * e portanto j� � uma exce��o que encapsula a original e j� possui
	 * TraceString, que � reaproveitada para que possa ser usada como elemento
	 * de trace do problema.
	 * 
	 * @param e
	 *            exce��o derivada de ExceptionBase
	 */
	public ExceptionBase(String str, Throwable e)
	{
		super(str, e);
		traceString = ExceptionBase.exceptionTraceCode();
	}

	/**
	 * Construtor
	 * 
	 * Assinatura de construtor que recebe a exce��o original, n�o derivada de
	 * ExceptionBase.
	 * 
	 * Este construtor dever� ser chamada para a exception original e portanto
	 * gera a TraceString.
	 * 
	 * @param e
	 */
	public ExceptionBase(Throwable e)
	{
		super(e);
		traceString = ExceptionBase.exceptionTraceCode();
	}

	/**
	 * Retorna uma String contendo todo o StackTrace.
	 * 
	 * @return String
	 */
	public String getStackTraceString()
	{
		StringWriter s = new StringWriter();
		PrintWriter w = new PrintWriter(s);
		this.printStackTrace(w);
		return s.toString();
	}

	/**
	 * Exibe a TraceString associada � exce��o.
	 * 
	 * @return String
	 */
	public String getTraceString()
	{
		return traceString;
	}
}