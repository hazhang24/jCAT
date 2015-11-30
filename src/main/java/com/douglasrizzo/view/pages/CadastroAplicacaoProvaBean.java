package com.douglasrizzo.view.pages;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.douglasrizzo.business.vo.CadastroAplicacaoProvaVO;
import com.douglasrizzo.business.vo.LoginVO;
import com.douglasrizzo.business.vo.ProvaListVO;
import com.douglasrizzo.util.TipoUsuarioEnum;
import com.douglasrizzo.util.exception.LayerException;
import com.douglasrizzo.view.service.Service;

@ManagedBean
@ViewScoped
public class CadastroAplicacaoProvaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ProvaListVO> provas;
	private ProvaListVO selectedProva;

	public CadastroAplicacaoProvaBean() throws LayerException, IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.APLICADOR))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}

		provas = new Service().provaListar(TelasUtil.getLogin().getId());
	}

	public void aplicar() throws LayerException, IOException
	{
		if (selectedProva != null)
		{
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			HttpSession session = (HttpSession) context.getSession(true);
			LoginVO login = (LoginVO) session.getAttribute("login");

			CadastroAplicacaoProvaVO prova;

			if ((prova = new Service()
					.aplicacaoProvaEfetuarCadastro(new CadastroAplicacaoProvaVO(
							0, login.getId(), selectedProva.getId(),
							selectedProva.getTitulo()))) != null)
			{
				session.setAttribute("provaAtual", prova.getId());
				context.redirect("AplicacaoProva.xhtml");
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage("Falha...",
								"Falha ao iniciar a aplicação!"));
			}
		}
	}

	public ArrayList<ProvaListVO> getProvas()
	{
		return provas;
	}

	public ProvaListVO getSelectedProva()
	{
		return selectedProva;
	}

	public void setProvas(ArrayList<ProvaListVO> provas)
	{
		this.provas = provas;
	}

	public void setSelectedProva(ProvaListVO selectedProva)
	{
		this.selectedProva = selectedProva;
	}
}