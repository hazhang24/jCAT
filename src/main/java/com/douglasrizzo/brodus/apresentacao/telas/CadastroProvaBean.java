package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.vo.CadastroProvaVO;
import negocio.vo.CadastroProvaVO.CadastroProvaItemVO;

import org.primefaces.model.DualListModel;

import util.TipoUsuarioEnum;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class CadastroProvaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DualListModel<CadastroProvaVO.CadastroProvaItemVO> itens;
	private CadastroProvaVO prova;

	public CadastroProvaBean() throws LayerException, IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.ELABORADOR))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		List<CadastroProvaVO.CadastroProvaItemVO> source = new Service()
				.provaRecuperarItensParaEscolha();
		List<CadastroProvaVO.CadastroProvaItemVO> target = new ArrayList<CadastroProvaVO.CadastroProvaItemVO>();

		if (prova == null)
		{
			prova = new CadastroProvaVO();
		}

		itens = new DualListModel<CadastroProvaVO.CadastroProvaItemVO>(source,
				target);
	}

	public void efetuarCadastro() throws RemoteException, LayerException
	{
		List<CadastroProvaItemVO> lista = itens.getTarget();

		if (prova == null)
		{
			prova = new CadastroProvaVO();
		}

		if (lista.size() > 0)
		{
			for (CadastroProvaItemVO cadastroProvaItemVO : lista)
			{
				prova.getItens().add(cadastroProvaItemVO.getId());
			}

			if (new Service().provaEfetuarCadastro(prova))
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

	public DualListModel<CadastroProvaVO.CadastroProvaItemVO> getItens()
	{
		return itens;
	}

	public CadastroProvaVO getProva()
	{
		return prova;
	}

	public void setItens(
			DualListModel<CadastroProvaVO.CadastroProvaItemVO> itens)
	{
		this.itens = itens;
	}

	public void setProva(CadastroProvaVO prova)
	{
		this.prova = prova;
	}
}