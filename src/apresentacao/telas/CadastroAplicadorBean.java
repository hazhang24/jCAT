package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.vo.CadastroAplicadorVO;
import negocio.vo.CadastroTurmaVO;
import negocio.vo.TurmaListVO;
import util.TipoUsuarioEnum;
import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class CadastroAplicadorBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CadastroAplicadorVO aplicador;
	private ArrayList<TurmaListVO> turmas;
	private CadastroTurmaVO selectedTurma;

	public CadastroAplicadorBean() throws LayerException, IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.SECRETARIA))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		if (aplicador == null)
		{
			aplicador = new CadastroAplicadorVO();
		}
		turmas = new Service().turmaListar();
	}

	public void efetuarCadastro() throws LayerException
	{
		if (new Service().aplicadorEfetuarCadastro(aplicador))
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

	public CadastroAplicadorVO getAplicador()
	{
		return aplicador;
	}

	public CadastroTurmaVO getSelectedTurma()
	{
		return selectedTurma;
	}

	public ArrayList<TurmaListVO> getTurmas()
	{
		return turmas;
	}

	public void setAplicador(CadastroAplicadorVO aplicador)
	{
		this.aplicador = aplicador;
	}

	public void setSelectedTurma(CadastroTurmaVO selectedTurma)
	{
		this.selectedTurma = selectedTurma;
	}

	public void setTurmas(ArrayList<TurmaListVO> turmas)
	{
		this.turmas = turmas;
	}
}
