package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class CadastroItemVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, elaboradorId;
	private String enunciado, altA, altB, altC, altD, imgA, imgB, imgC, imgD,
			imgEnunciado, narracao;
	private char correta;

	public CadastroItemVO()
	{}

	public CadastroItemVO(int id, int elaboradorId, String enunciado,
			String altA, String altB, String altC, String altD, String imgA,
			String imgB, String imgC, String imgD, String imgEnunciado,
			String narracao, char correta)
	{
		this.id = id;
		this.elaboradorId = elaboradorId;
		this.enunciado = enunciado;
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

	public int getElaboradorId()
	{
		return elaboradorId;
	}

	public String getEnunciado()
	{
		return enunciado;
	}

	public int getId()
	{
		return id;
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

	public String getNarracao()
	{
		return narracao;
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

	public void setElaboradorId(int elaboradorId)
	{
		this.elaboradorId = elaboradorId;
	}

	public void setEnunciado(String enunciado)
	{
		this.enunciado = enunciado;
	}

	public void setId(int id)
	{
		this.id = id;
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

	public void setNarracao(String narracao)
	{
		this.narracao = narracao;
	}
}