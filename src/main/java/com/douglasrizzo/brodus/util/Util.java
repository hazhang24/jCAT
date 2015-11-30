package util;

import java.util.regex.Pattern;

public class Util
{
	public static final String LOG_FILE = "config/portallog.properties",
			FILE_SAVE_PATH = "/home/douglas/Desktop/dev/apache-tomcat-7.0.37/uploads/",
			FILE_ONLINE_PATH = "http://localhost:8080/uploads/";

	public static String encrypt(String sign)
	{
		try
		{
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(sign.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (byte element : hash)
			{
				if ((0xff & element) < 0x10)
				{
					hexString.append("0" + Integer.toHexString(0xFF & element));
				}
				else
				{
					hexString.append(Integer.toHexString(0xFF & element));
				}
			}
			sign = hexString.toString();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return sign;
	}

	/**
	 * 
	 * @author mkyong
	 * 
	 *         Valida email
	 * 
	 * @param email
	 *            email para validação
	 * @return verdadeiro se válido, caso contrário, falso
	 */
	public boolean validateEmail(final String hex)
	{
		return Pattern
				.compile(
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
				.matcher(hex).matches();
	}
}