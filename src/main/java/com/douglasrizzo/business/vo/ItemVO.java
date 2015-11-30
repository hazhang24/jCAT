package com.douglasrizzo.business.vo;

import java.io.Serializable;

public class ItemVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private String enunciado, imgEnunciado, altA, altB, altC, altD, imgA, imgB,
			imgC, imgD, msgBotao;
	private int escolha;

	public ItemVO()
	{}

	public ItemVO(int numero, String enunciado, String imgEnunciado,
			String altA, String altB, String altC, String altD, String imgA,
			String imgB, String imgC, String imgD, String msgBotao, char escolha)
	{
		this.numero = numero;
		this.enunciado = enunciado;
		this.imgEnunciado = imgEnunciado;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.imgA = imgA;
		this.imgB = imgB;
		this.imgC = imgC;
		this.imgD = imgD;
		this.msgBotao = msgBotao;
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

	public String getEnunciado()
	{
		return enunciado;
	}

	public int getEscolha()
	{
		return escolha;
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

	public String getMsgBotao()
	{
		return msgBotao;
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

	public void setEnunciado(String enunciado)
	{
		this.enunciado = enunciado;
	}

	public void setEscolha(int escolha)
	{
		this.escolha = escolha;
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

	public void setMsgBotao(String msgBotao)
	{
		this.msgBotao = msgBotao;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}

}