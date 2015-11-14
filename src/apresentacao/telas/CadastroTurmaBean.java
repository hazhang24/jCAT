package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import negocio.vo.CadastroTurmaVO;
import negocio.vo.LoginVO;
import util.TipoUsuarioEnum;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class CadastroTurmaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CadastroTurmaVO turma;

	public CadastroTurmaBean() throws LayerException, IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.SECRETARIA))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}

		if (turma == null)
		{
			turma = new CadastroTurmaVO();
		}
	}

	public void efetuarCadastro() throws LayerException
	{
		turma.setSecretariaId(((LoginVO) ((HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true))
				.getAttribute("login")).getId());

		if (new Service().turmaEfetuarCadastro(turma))
		{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("Sucesso!",
							"Cadastro efetuado com sucesso!"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Falha...", "Falha no cadastro!"));
		}
	}

	public CadastroTurmaVO getTurma()
	{
		return turma;
	}

	public void setTurma(CadastroTurmaVO turma)
	{
		this.turma = turma;
	}
}