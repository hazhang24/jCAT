package com.douglasrizzo.view.pages;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.douglasrizzo.business.vo.CadastroSecretariaVO;
import com.douglasrizzo.business.vo.EscolaListVO;
import com.douglasrizzo.util.TipoUsuarioEnum;
import com.douglasrizzo.util.exception.LayerException;
import com.douglasrizzo.view.service.Service;

@ManagedBean
@ViewScoped
public class CadastroSecretariaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CadastroSecretariaVO secretaria;
	private ArrayList<EscolaListVO> escolas;
	private EscolaListVO selectedEscola;

	public CadastroSecretariaBean() throws LayerException, IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.INEP))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		if (secretaria == null)
		{
			secretaria = new CadastroSecretariaVO();
		}

		escolas = new Service().escolaListar();
	}

	public void efetuarCadastro() throws LayerException
	{
		if (selectedEscola != null)
		{
			secretaria.setEscolaId(selectedEscola.getId());
			if (new Service().secretariaEfetuarCadastro(secretaria))
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

	public ArrayList<EscolaListVO> getEscolas()
	{
		return escolas;
	}

	public CadastroSecretariaVO getSecretaria()
	{
		return secretaria;
	}

	public EscolaListVO getSelectedEscola()
	{
		return selectedEscola;
	}

	public void setEscolas(ArrayList<EscolaListVO> escolas)
	{
		this.escolas = escolas;
	}

	public void setSecretaria(CadastroSecretariaVO secretaria)
	{
		this.secretaria = secretaria;
	}

	public void setSelectedEscola(EscolaListVO selectedEscola)
	{
		this.selectedEscola = selectedEscola;
	}

}