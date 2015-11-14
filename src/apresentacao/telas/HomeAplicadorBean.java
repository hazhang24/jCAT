package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import util.TipoUsuarioEnum;

@ManagedBean
@ViewScoped
public class HomeAplicadorBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeAplicadorBean() throws IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.APLICADOR))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
	}
}