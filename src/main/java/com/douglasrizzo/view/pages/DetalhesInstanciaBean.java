package com.douglasrizzo.view.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import com.douglasrizzo.business.vo.DetalhesInstanciaVO;
import com.douglasrizzo.util.exception.LayerException;
import com.douglasrizzo.view.service.Service;

@ViewScoped
@ManagedBean
public class DetalhesInstanciaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pie;
	private DetalhesInstanciaVO detalhes;

	public DetalhesInstanciaBean() throws LayerException
	{
		detalhes = new Service().getDetalhesInstancia((Integer) TelasUtil
				.getSession().getAttribute("instanciaId"));

		pie = new PieChartModel();
		pie.set("Acertos", detalhes.getQtdAcertos());
		pie.set("Erros", detalhes.getErros());
	}

	public DetalhesInstanciaVO getDetalhes()
	{
		return detalhes;
	}

	public PieChartModel getPie()
	{
		return pie;
	}

	public void setDetalhes(DetalhesInstanciaVO detalhes)
	{
		this.detalhes = detalhes;
	}

	public void setPie(PieChartModel pie)
	{
		this.pie = pie;
	}
}