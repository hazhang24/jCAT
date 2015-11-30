package com.douglasrizzo.view.pages;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.douglasrizzo.util.TipoUsuarioEnum;

@ManagedBean
@ViewScoped
public class HomeSecretariaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeSecretariaBean() throws IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.SECRETARIA))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
	}
}