package com.douglasrizzo.business.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class AplicacaoProvaVO implements Serializable
{
	public class AplicacaoProvaItemVO implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int id, respondidas, acertos, erros, total;
		private String aluno, iniciado, tempo;

		public AplicacaoProvaItemVO()
		{}

		public AplicacaoProvaItemVO(int id, String aluno, String iniciado,
				String tempo, int respondidas, int acertos, int erros, int total)
		{
			this.id = id;
			this.aluno = aluno;
			this.iniciado = iniciado;
			this.tempo = tempo;
			this.respondidas = respondidas;
			this.acertos = acertos;
			this.erros = erros;
			this.total = total;
		}

		public int getAcertos()
		{
			return acertos;
		}

		public String getAluno()
		{
			return aluno;
		}

		public int getErros()
		{
			return erros;
		}

		public int getId()
		{
			return id;
		}

		public String getIniciado()
		{
			return iniciado;
		}

		public int getRespondidas()
		{
			return respondidas;
		}

		public String getTempo()
		{
			return tempo;
		}

		public int getTotal()
		{
			return total;
		}

		public void setAcertos(int acertos)
		{
			this.acertos = acertos;
		}

		public void setAluno(String aluno)
		{
			this.aluno = aluno;
		}

		public void setErros(int erros)
		{
			this.erros = erros;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public void setIniciado(String iniciado)
		{
			this.iniciado = iniciado;
		}

		public void setRespondidas(int respondidas)
		{
			this.respondidas = respondidas;
		}

		public void setTempo(String tempo)
		{
			this.tempo = tempo;
		}

		public void setTotal(int total)
		{
			this.total = total;
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String turma, data;

	private ArrayList<AplicacaoProvaItemVO> itens;

	public AplicacaoProvaVO()
	{
		itens = new ArrayList<AplicacaoProvaVO.AplicacaoProvaItemVO>();
	}

	public AplicacaoProvaVO(String turma, String data)
	{
		this.turma = turma;
		this.data = data;
		itens = new ArrayList<AplicacaoProvaVO.AplicacaoProvaItemVO>();
	}

	public String getData()
	{
		return data;
	}

	public ArrayList<AplicacaoProvaItemVO> getItens()
	{
		return itens;
	}

	public String getTurma()
	{
		return turma;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public void setItens(ArrayList<AplicacaoProvaItemVO> itens)
	{
		this.itens = itens;
	}

	public void setTurma(String turma)
	{
		this.turma = turma;
	}
}
