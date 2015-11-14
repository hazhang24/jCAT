package negocio.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class AplicacaoListVO implements Serializable
{
	public class AplicacaoListItemVO implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private int id, acertos, erros, total, classificacao;
		private String aluno;
		private double tempo;

		public AplicacaoListItemVO(int id, int acertos, int erros, int total,
				String aluno, int tempo, int classificacao)
		{
			this.id = id;
			this.acertos = acertos;
			this.erros = erros;
			this.total = total;
			this.aluno = aluno;
			this.tempo = tempo;
			this.classificacao = classificacao;
		}

		public int getAcertos()
		{
			return acertos;
		}

		public String getAluno()
		{
			return aluno;
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
	private ArrayList<AplicacaoListItemVO> instancias;

	public AplicacaoListVO()
	{
		instancias = new ArrayList<AplicacaoListVO.AplicacaoListItemVO>();
	}

	public AplicacaoListVO(int id, String data, String turma, String prova,
			int alunos, int itens)
	{
		this.id = id;
		this.data = data;
		this.turma = turma;
		this.prova = prova;
		this.alunos = alunos;
		this.itens = itens;
		instancias = new ArrayList<AplicacaoListVO.AplicacaoListItemVO>();
	}

	public int getAlunos()
	{
		return alunos;
	}

	public String getData()
	{
		return data;
	}

	public int getId()
	{
		return id;
	}

	public ArrayList<AplicacaoListItemVO> getInstancias()
	{
		return instancias;
	}

	public int getItens()
	{
		return itens;
	}

	public String getProva()
	{
		return prova;
	}

	public String getTurma()
	{
		return turma;
	}

	public void setAlunos(int alunos)
	{
		this.alunos = alunos;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setInstancias(ArrayList<AplicacaoListItemVO> instancias)
	{
		this.instancias = instancias;
	}

	public void setItens(int itens)
	{
		this.itens = itens;
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