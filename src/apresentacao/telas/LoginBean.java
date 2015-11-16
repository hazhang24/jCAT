package apresentacao.telas;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import negocio.vo.InstanciaAlunoVO;
import negocio.vo.LoginVO;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@RequestScoped
public class LoginBean
{
	private LoginVO login;

	public LoginBean()
	{
		if (login == null)
		{
			login = new LoginVO();
		}
	}

	public void efetuarLogin() throws LayerException, IOException
	{
		if ((login = new Service().usuarioEfetuarLogin(login)) != null
				&& login.getTipo() != null)
		{
			ExternalContext context = TelasUtil.getContext();
			HttpSession session = TelasUtil.getSession();

			@SuppressWarnings("unchecked")
			Set<Integer> logados = (Set<Integer>) context.getApplicationMap()
					.get("logados");

			if (logados == null)
			{
				logados = new HashSet<Integer>();
			}

			else if (logados.contains(login.getId()))
			{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Falha no login!",
								"Este usuário já está logado!"));
				return;
			}

			LoginVO aux = (LoginVO) session.getAttribute("login");
			if (aux != null)
			{
				logados.remove(aux.getId());
			}

			logados.add(login.getId());
			session.setAttribute("login", login);
			session.setAttribute("nome", login.getNome());

			FacesContext.getCurrentInstance().getExternalContext()
					.getApplicationMap().put("logados", logados);

			String retorno = "Home";

			switch (login.getTipo())
			{
				case APLICADOR:
					retorno += "Aplicador";
					break;
				case ELABORADOR:
					retorno += "Elaborador";
					break;
				case INEP:
					retorno += "INEP";
					break;
				case SECRETARIA:
					retorno += "Secretaria";
					break;
			}

			retorno += ".xhtml";

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(retorno);
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Falha no login!", "Usuário ou senha errados!"));
		}
	}

	@SuppressWarnings("unchecked")
	public void efetuarLoginAluno() throws LayerException, IOException
	{
		InstanciaAlunoVO vo = new Service().alunoEfetuarLogin(login);
		if (vo != null)
		{
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			Set<Integer> alunosLogados = (HashSet<Integer>) context
					.getApplicationMap().get("alunosLogados");

			if (alunosLogados == null)
			{
				alunosLogados = new HashSet<Integer>();
			}
			else if (alunosLogados.contains(login.getId()))
			{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Falha no login!",
								"Esta prova já está sendo realizada!"));
				return;
			}

			alunosLogados.add(login.getId());
			context.getApplicationMap().put("logados", alunosLogados);

			((HttpSession) context.getSession(true)).setAttribute("loginAluno",
					login);
			((HttpSession) context.getSession(true)).setAttribute("aplicacao",
					vo);

			context.redirect("Item.xhtml");
		}
	}

	public LoginVO getLogin()
	{
		return login;
	}

	public void setLogin(LoginVO login)
	{
		this.login = login;
	}
}