package negocio.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item extends Entidade
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descritor, altA, altB, altC, altD, imgA, imgB, imgC, imgD,
			imgEnunciado, narracao;
	private char correta;
	private Date ultimaUtilizacao;

	@ManyToOne(fetch = FetchType.EAGER)
	private Elaborador elaborador;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "itens")
	private Set<Prova> provas;
	@OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
	private Set<ItemRespondido> itensRespondidos;

	public Item()
	{
		provas = new HashSet<Prova>();
		itensRespondidos = new HashSet<ItemRespondido>();
	}

	public Item(int id, String enunciado, String altA, String altB,
			String altC, String altD, String imgA, String imgB, String imgC,
			String imgD, String imgEnunciado, String narracao, char correta,
			Date ultimaUtilizacao, Elaborador elaborador)
	{
		super(id);
		descritor = enunciado;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.imgA = imgA;
		this.imgB = imgB;
		this.imgC = imgC;
		this.imgD = imgD;
		this.imgEnunciado = imgEnunciado;
		this.narracao = narracao;
		this.correta = correta;
		this.ultimaUtilizacao = ultimaUtilizacao;
		this.elaborador = elaborador;
		provas = new HashSet<Prova>();
		itensRespondidos = new HashSet<ItemRespondido>();
	}

	public String getAltA()
	{
		return altA;
	}

	public String getAltB()
	{
		return altB;
	}

	public String getAltC()
	{
		return altC;
	}

	public String getAltD()
	{
		return altD;
	}

	public char getCorreta()
	{
		return correta;
	}

	public String getDescritor()
	{
		return descritor;
	}

	public Elaborador getElaborador()
	{
		return elaborador;
	}

	public String getImgA()
	{
		return imgA;
	}

	public String getImgB()
	{
		return imgB;
	}

	public String getImgC()
	{
		return imgC;
	}

	public String getImgD()
	{
		return imgD;
	}

	public String getImgEnunciado()
	{
		return imgEnunciado;
	}

	public Set<ItemRespondido> getItensRespondidos()
	{
		return itensRespondidos;
	}

	public String getNarracao()
	{
		return narracao;
	}

	public Set<Prova> getProvas()
	{
		return provas;
	}

	public Date getUltimaUtilizacao()
	{
		return ultimaUtilizacao;
	}

	public void setAltA(String altA)
	{
		this.altA = altA;
	}

	public void setAltB(String altB)
	{
		this.altB = altB;
	}

	public void setAltC(String altC)
	{
		this.altC = altC;
	}

	public void setAltD(String altD)
	{
		this.altD = altD;
	}

	public void setCorreta(char correta)
	{
		this.correta = correta;
	}

	public void setDescritor(String descritor)
	{
		this.descritor = descritor;
	}

	public void setElaborador(Elaborador elaborador)
	{
		this.elaborador = elaborador;
	}

	public void setImgA(String imgA)
	{
		this.imgA = imgA;
	}

	public void setImgB(String imgB)
	{
		this.imgB = imgB;
	}

	public void setImgC(String imgC)
	{
		this.imgC = imgC;
	}

	public void setImgD(String imgD)
	{
		this.imgD = imgD;
	}

	public void setImgEnunciado(String imgEnunciado)
	{
		this.imgEnunciado = imgEnunciado;
	}

	public void setItensRespondidos(Set<ItemRespondido> itensRespondidos)
	{
		this.itensRespondidos = itensRespondidos;
	}

	public void setNarracao(String narracao)
	{
		this.narracao = narracao;
	}

	public void setProvas(Set<Prova> provas)
	{
		this.provas = provas;
	}

	public void setUltimaUtilizacao(Date ultimaUtilizacao)
	{
		this.ultimaUtilizacao = ultimaUtilizacao;
	}
}