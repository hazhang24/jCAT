package negocio.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDAO
{
	/**
	 * Exclui um arquivo
	 * 
	 * @param id
	 *            Id do objeto a ser removido
	 * @return True se bem sucedido, false se houve erro.
	 */
	public boolean excluir(String caminho)
	{
		File file = new File(caminho);
		if (file.exists() && file.isFile())
		{
			return file.delete();
		}
		return false;
	}

	public boolean existe(String fullpath)
	{
		return new File(fullpath).exists();
	}

	/**
	 * Insere (persiste) um objeto
	 * 
	 * @param obj
	 *            Objeto a ser persistido
	 * @return True se bem sucedido, false se houve erro.
	 */
	public boolean inserir(byte[] binary, String fullpath)
	{
		try
		{
			FileOutputStream ofs = new FileOutputStream(new File(fullpath));
			ofs.write(binary);
			ofs.flush();
			ofs.close();

			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	// public void upload(byte[] som, String aux) throws IOException
	// {
	// URL url = new URL(Util.FILE_PATH);
	// HttpURLConnection con = (HttpURLConnection)url.openConnection();
	// try
	// {
	// con.setDoOutput(true);
	// con.setRequestMethod("POST");
	// con.addRequestProperty("Authorization", "Basic " +
	// org.jboss.util.Base64.encodeBytes("admin:admin".getBytes()));
	// OutputStream out = con.getOutputStream();
	// try
	// {
	// InputStream in = new ByteArrayInputStream(som);
	//
	// try
	// {
	// byte buffer[] = new byte[4096];
	// for(int n = in.read(buffer); n > 0; n = in.read(buffer))
	// {
	// out.write(buffer, 0, n);
	// }
	// }
	// finally
	// {
	// in.close();
	// }
	// }
	// finally
	// {
	// out.close();
	// }
	// int code = con.getResponseCode();
	// if(code != HttpURLConnection.HTTP_OK)
	// {
	// String msg = con.getResponseMessage();
	// throw new IOException("HTTP Error " + code + ": " + msg);
	// }
	// }
	// finally
	// {
	// con.disconnect();
	// }
	// }
}