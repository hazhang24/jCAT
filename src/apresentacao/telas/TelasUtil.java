package apresentacao.telas;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import negocio.vo.LoginVO;
import util.TipoUsuarioEnum;

public class TelasUtil
{
	public static boolean checaLogin(TipoUsuarioEnum... tipos)
			throws IOException
	{
		LoginVO login = getLogin();

		if (login == null)
		{
			return false;
		}
		else
		{
			for (TipoUsuarioEnum tipo : tipos)
			{
				if (login.getTipo() == tipo)
				{
					return true;
				}
			}
		}

		return false;
	}

	public static ExternalContext getContext()
	{
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public static LoginVO getLogin()
	{
		return (LoginVO) ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true)).getAttribute("login");
	}

	public static HttpSession getSession()
	{
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);

	}
}