package com.douglasrizzo.view.pages;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.douglasrizzo.business.vo.CadastroAlunoVO;
import com.douglasrizzo.business.vo.TurmaListVO;
import com.douglasrizzo.util.TipoUsuarioEnum;
import com.douglasrizzo.util.exception.LayerException;
import com.douglasrizzo.view.service.Service;

@ManagedBean
@ViewScoped
public class CadastroAlunoBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CadastroAlunoVO aluno;
	private ArrayList<TurmaListVO> turmas;
	private TurmaListVO selectedTurma;

	public CadastroAlunoBean() throws LayerException, IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.SECRETARIA))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		if (aluno == null)
		{
			aluno = new CadastroAlunoVO();
		}
		turmas = new Service().turmaListar();
	}

	public void efetuarCadastro() throws LayerException
	{
		if (new Service().alunoEfetuarCadastro(aluno))
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

	public CadastroAlunoVO getAluno()
	{
		return aluno;
	}

	public TurmaListVO getSelectedTurma()
	{
		return selectedTurma;
	}

	public ArrayList<TurmaListVO> getTurmas()
	{
		return turmas;
	}

	public void setAluno(CadastroAlunoVO aluno)
	{
		this.aluno = aluno;
	}

	public void setSelectedTurma(TurmaListVO selectedTurma)
	{
		this.selectedTurma = selectedTurma;
	}

	public void setTurmas(ArrayList<TurmaListVO> turmas)
	{
		this.turmas = turmas;
	}
}