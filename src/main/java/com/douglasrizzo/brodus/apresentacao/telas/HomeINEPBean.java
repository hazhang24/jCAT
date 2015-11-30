package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import util.TipoUsuarioEnum;

@ManagedBean
@ViewScoped
public class HomeINEPBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeINEPBean() throws IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.INEP))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
	}
}