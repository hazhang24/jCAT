package com.douglasrizzo.view.pages;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.douglasrizzo.business.vo.ExibirItemVO;
import com.douglasrizzo.business.vo.InstanciaAlunoVO;
import com.douglasrizzo.util.exception.LayerException;
import com.douglasrizzo.view.service.Service;

@ManagedBean
@ViewScoped
public class ItemBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InstanciaAlunoVO instancia;
	private ExibirItemVO item;

	public ItemBean() throws IOException, LayerException
	{
		if (instancia == null)
		{
			instancia = (InstanciaAlunoVO) ((HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true))
					.getAttribute("aplicacao");
			if (instancia == null)
			{
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("LoginAluno.xhtml");
				return;
			}
		}

		if (instancia.getAtual() < instancia.getItens().size())
		{
			item = instancia.getItens().get(instancia.getAtual());
			instancia.setAtual(instancia.getAtual() + 1);
			((HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(true)).setAttribute(
					"aplicacao", instancia);

			if (instancia.getAtual() < instancia.getItens().size())
			{
				item.setMsgBotao("Próxima");
			}
			else
			{
				item.setMsgBotao("Fim");
			}
		}
		else
		{
			item = new ExibirItemVO();
			new Service().alunoFinalizarInstancia(instancia);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("RelatorioAluno.xhtml");
		}
	}

	public InstanciaAlunoVO getInstancia()
	{
		return instancia;
	}

	public ExibirItemVO getItem()
	{
		return item;
	}

	public void proximo() throws IOException, LayerException
	{
		new Service().alunoProcessarResposta(item);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("Item.xhtml");
	}

	public void setInstancia(InstanciaAlunoVO instancia)
	{
		this.instancia = instancia;
	}

	public void setItem(ExibirItemVO item)
	{
		this.item = item;
	}
}