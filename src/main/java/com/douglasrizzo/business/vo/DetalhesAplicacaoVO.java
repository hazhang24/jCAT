package com.douglasrizzo.business.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetalhesAplicacaoVO implements Serializable
{
	public class DetalhesAplicacaoInstanciaVO implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int id, acertos, erros, total, classificacao;
		private String aluno, clasDesc;
		private double tempo;
		private ArrayList<IntCharPairVO> respostas;

		public DetalhesAplicacaoInstanciaVO()
		{
			respostas = new ArrayList<IntCharPairVO>();
		}

		public DetalhesAplicacaoInstanciaVO(int id, int acertos, int erros,
				int total, int classificacao, String aluno, double tempo,
				String clasDesc)
		{
			this.id = id;
			this.acertos = acertos;
			this.erros = erros;
			this.total = total;
			this.classificacao = classificacao;
			this.aluno = aluno;
			this.tempo = tempo;
			this.clasDesc = clasDesc;
			respostas = new ArrayList<IntCharPairVO>();
		}

		public int getAcertos()
		{
			return acertos;
		}

		public String getAluno()
		{
			return aluno;
		}

		public String getClasDesc()
		{
			return clasDesc;
		}

		public int getClassificacao()
		{
			return classificacao;
		}

		public int getErros()
		{
			return erros;
		}

		public int getId()
		{
			return id;
		}

		public ArrayList<IntCharPairVO> getRespostas()
		{
			return respostas;
		}

		public double getTempo()
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

		public void setClasDesc(String clasDesc)
		{
			this.clasDesc = clasDesc;
		}

		public void setClassificacao(int classificacao)
		{
			this.classificacao = classificacao;
		}

		public void setErros(int erros)
		{
			this.erros = erros;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public void setRespostas(ArrayList<IntCharPairVO> respostas)
		{
			this.respostas = respostas;
		}

		public void setTempo(double tempo)
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

	private int id, alunos, itens;
	private String data, turma, prova;
	private double mediaClassificacao;
	private ArrayList<Integer> acertosItem;
	private List<Number> classificacoes;
	private ArrayList<DetalhesAplicacaoInstanciaVO> instancias;

	public DetalhesAplicacaoVO()
	{
		acertosItem = new ArrayList<Integer>();
		classificacoes = new ArrayList<Number>();
		instancias = new ArrayList<DetalhesAplicacaoVO.DetalhesAplicacaoInstanciaVO>();
	}

	public DetalhesAplicacaoVO(int id, int alunos, int itens, String data,
			String turma, String prova, double mediaClassificacao)
	{
		this.id = id;
		this.alunos = alunos;
		this.itens = itens;
		this.data = data;
		this.turma = turma;
		this.prova = prova;
		this.mediaClassificacao = mediaClassificacao;
		acertosItem = new ArrayList<Integer>();
		classificacoes = new ArrayList<Number>();
		instancias = new ArrayList<DetalhesAplicacaoVO.DetalhesAplicacaoInstanciaVO>();
	}

	public ArrayList<Integer> getAcertosItem()
	{
		return acertosItem;
	}

	public int getAlunos()
	{
		return alunos;
	}

	public List<Number> getClassificacoes()
	{
		return classificacoes;
	}

	public String getData()
	{
		return data;
	}

	public int getId()
	{
		return id;
	}

	public ArrayList<DetalhesAplicacaoInstanciaVO> getInstancias()
	{
		return instancias;
	}

	public int getItens()
	{
		return itens;
	}

	public double getMediaClassificacao()
	{
		return mediaClassificacao;
	}

	public String getProva()
	{
		return prova;
	}

	public String getTurma()
	{
		return turma;
	}

	public void setAcertosItem(ArrayList<Integer> acertosItem)
	{
		this.acertosItem = acertosItem;
	}

	public void setAlunos(int alunos)
	{
		this.alunos = alunos;
	}

	public void setClassificacoes(List<Number> classificacoes)
	{
		this.classificacoes = classificacoes;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setInstancias(ArrayList<DetalhesAplicacaoInstanciaVO> instancias)
	{
		this.instancias = instancias;
	}

	public void setItens(int itens)
	{
		this.itens = itens;
	}

	public void setMediaClassificacao(double mediaClassificacao)
	{
		this.mediaClassificacao = mediaClassificacao;
	}

	public void setProva(String prova)
	{
		this.prova = prova;
	}

	public void setTurma(String turma)
	{
		this.turma = turma;
	}
}