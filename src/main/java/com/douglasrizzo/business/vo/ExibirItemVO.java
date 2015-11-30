package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class ExibirItemVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, instanciaId, numero;
	private String altA, altB, altC, altD, msgBotao, imgEnunciado, imgA, imgB,
			imgC, imgD, narracao;
	private char escolha;

	public ExibirItemVO()
	{}

	public ExibirItemVO(int id, int instanciaId, int numero, String altA,
			String altB, String altC, String altD, String msgBotao,
			String imgEnunciado, String imgA, String imgB, String imgC,
			String imgD, String narracao, char escolha)
	{
		this.id = id;
		this.instanciaId = instanciaId;
		this.numero = numero;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.msgBotao = msgBotao;
		this.imgEnunciado = imgEnunciado;
		this.imgA = imgA;
		this.imgB = imgB;
		this.imgC = imgC;
		this.imgD = imgD;
		this.narracao = narracao;
		this.escolha = escolha;
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

	public char getEscolha()
	{
		return escolha;
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

	public int getInstanciaId()
	{
		return instanciaId;
	}

	public String getMsgBotao()
	{
		return msgBotao;
	}

	public String getNarracao()
	{
		return narracao;
	}

	public int getNumero()
	{
		return numero;
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

	public void setEscolha(char escolha)
	{
		this.escolha = escolha;
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

	public void setInstanciaId(int instanciaId)
	{
		this.instanciaId = instanciaId;
	}

	public void setMsgBotao(String msgBotao)
	{
		this.msgBotao = msgBotao;
	}

	public void setNarracao(String narracao)
	{
		this.narracao = narracao;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}
}