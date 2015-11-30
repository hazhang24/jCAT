package apresentacao.telas;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import negocio.vo.AplicacaoProvaVO;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class AplicacaoProvaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AplicacaoProvaVO aplicacao;

	public AplicacaoProvaBean() throws LayerException
	{
		aplicacao = new Service()
				.atualizarTela((Integer) ((HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(true)).getAttribute("provaAtual"));
	}

	public AplicacaoProvaVO getAplicacao()
	{
		return aplicacao;
	}

	public void setAplicacao(AplicacaoProvaVO aplicacao)
	{
		this.aplicacao = aplicacao;
	}
}