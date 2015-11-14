package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.vo.AplicacaoListVO;
import negocio.vo.AplicacaoListVO.AplicacaoListItemVO;
import util.TipoUsuarioEnum;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class RelatoriosBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<AplicacaoListVO> aplicacoes;
	private AplicacaoListVO selectedAplicacao;
	private AplicacaoListItemVO selectedInstancia;

	public RelatoriosBean() throws LayerException, IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.INEP,
				TipoUsuarioEnum.SECRETARIA))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}

		if (aplicacoes == null)
		{
			aplicacoes = new Service().aplicacoesListar(TelasUtil.getLogin());
		}
	}

	public void detalhesAplicacao() throws IOException
	{
		TelasUtil.getSession().setAttribute("aplicacaoId",
				selectedAplicacao.getId());

		TelasUtil.getContext().redirect("DetalhesAplicacao.xhtml");
	}

	public void detalhesInstancia() throws IOException
	{
		TelasUtil.getSession().setAttribute("instanciaId",
				selectedInstancia.getId());

		TelasUtil.getContext().redirect("DetalhesInstancia.xhtml");
	}

	public ArrayList<AplicacaoListVO> getAplicacoes()
	{
		return aplicacoes;
	}

	public AplicacaoListVO getSelectedAplicacao()
	{
		return selectedAplicacao;
	}

	public AplicacaoListItemVO getSelectedInstancia()
	{
		return selectedInstancia;
	}

	public void setAplicacoes(ArrayList<AplicacaoListVO> aplicacoes)
	{
		this.aplicacoes = aplicacoes;
	}

	public void setSelectedAplicacao(AplicacaoListVO selectedAplicacao)
	{
		this.selectedAplicacao = selectedAplicacao;
	}

	public void setSelectedInstancia(AplicacaoListItemVO selectedInstancia)
	{
		this.selectedInstancia = selectedInstancia;
	}
}
