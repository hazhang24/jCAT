package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.vo.CadastroInepVO;
import util.TipoUsuarioEnum;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class CadastroInepBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private CadastroInepVO inep;

	public CadastroInepBean() throws IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.INEP))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		if (inep == null)
		{
			inep = new CadastroInepVO();
		}
	}

	public void efetuarCadastro() throws LayerException
	{
		if (new Service().inepEfetuarCadastro(inep))
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

	public CadastroInepVO getUsuario()
	{
		return inep;
	}

	public void setUsuario(CadastroInepVO usuario)
	{
		inep = usuario;
	}
}