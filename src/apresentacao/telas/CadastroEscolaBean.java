package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.vo.CadastroEscolaVO;
import util.TipoUsuarioEnum;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class CadastroEscolaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CadastroEscolaVO escola;

	public CadastroEscolaBean() throws IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.INEP))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		if (escola == null)
		{
			escola = new CadastroEscolaVO();
		}
	}

	public void efetuarCadastro() throws LayerException
	{
		if (escola.getNome().equals(""))
		{
			if (new Service().escolaEfetuarCadastro(escola))
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
	}

	public CadastroEscolaVO getEscola()
	{
		return escola;
	}

	public void setEscola(CadastroEscolaVO escola)
	{
		this.escola = escola;
	}
}