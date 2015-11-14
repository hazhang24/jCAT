package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.vo.CadastroElaboradorVO;
import util.TipoUsuarioEnum;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class CadastroElaboradorBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CadastroElaboradorVO elaborador;

	public CadastroElaboradorBean() throws IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.INEP))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		if (elaborador == null)
		{
			elaborador = new CadastroElaboradorVO();
		}
	}

	public void efetuarCadastro() throws LayerException
	{
		if (new Service().elaboradorEfetuarCadastro(elaborador))
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

	public CadastroElaboradorVO getUsuario()
	{
		return elaborador;
	}

	public void setUsuario(CadastroElaboradorVO usuario)
	{
		elaborador = usuario;
	}
}