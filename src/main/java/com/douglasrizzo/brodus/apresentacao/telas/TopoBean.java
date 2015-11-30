package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import negocio.vo.LoginVO;
import util.exception.LayerException;

@ManagedBean
@ViewScoped
public class TopoBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void efetuarLogoff() throws LayerException, IOException
	{
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();

		HttpSession session = (HttpSession) context.getSession(true);

		LoginVO aux = (LoginVO) session.getAttribute("login");

		if (aux != null)
		{
			@SuppressWarnings("unchecked")
			Set<Integer> logados = (Set<Integer>) context.getApplicationMap()
					.get("logados");
			logados.remove(aux.getId());

			context.getApplicationMap().put("logados", logados);

			session.removeAttribute("login");
			session.removeAttribute("nome");
		}
		context.redirect("Login.xhtml");
	}

	public String getNome()
	{
		return ((LoginVO) TelasUtil.getSession().getAttribute("login"))
				.getNome();
	}
}