package com.douglasrizzo.view.pages;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;

import com.douglasrizzo.business.vo.DetalhesAplicacaoVO;
import com.douglasrizzo.business.vo.DetalhesAplicacaoVO.DetalhesAplicacaoInstanciaVO;
import com.douglasrizzo.util.exception.LayerException;

@ViewScoped
@ManagedBean
public class DetalhesAplicacaoBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DetalhesAplicacaoVO detalhes;
	private CartesianChartModel lineChartAcertos;
	private MeterGaugeChartModel meterGauge;
	private DetalhesAplicacaoInstanciaVO selectedInstancia;

	public DetalhesAplicacaoBean() throws LayerException
	{
		detalhes = new com.douglasrizzo.view.service.Service()
				.getDetalhesAplicacao((Integer) TelasUtil.getSession()
						.getAttribute("aplicacaoId"));

		lineChartAcertos = new CartesianChartModel();
		ChartSeries cs = new ChartSeries("Acertos/Item");
		for (int i = 0; i < detalhes.getAcertosItem().size(); i++)
		{
			cs.set(Integer.toString(i), detalhes.getAcertosItem().get(i));
		}
		lineChartAcertos.addSeries(cs);

		meterGauge = new MeterGaugeChartModel(detalhes.getMediaClassificacao(),
				detalhes.getClassificacoes());
	}

	public void detalhesInstancia() throws IOException
	{
		TelasUtil.getSession().setAttribute("instanciaId",
				selectedInstancia.getId());

		TelasUtil.getContext().redirect("DetalhesInstancia.xhtml");
	}

	public DetalhesAplicacaoVO getDetalhes()
	{
		return detalhes;
	}

	public CartesianChartModel getLineChart()
	{
		return lineChartAcertos;
	}

	public CartesianChartModel getLineChartAcertos()
	{
		return lineChartAcertos;
	}

	public MeterGaugeChartModel getMeterGauge()
	{
		return meterGauge;
	}

	public DetalhesAplicacaoInstanciaVO getSelectedInstancia()
	{
		return selectedInstancia;
	}

	public void setDetalhes(DetalhesAplicacaoVO detalhes)
	{
		this.detalhes = detalhes;
	}

	public void setLineChart(CartesianChartModel lineChart)
	{
		lineChartAcertos = lineChart;
	}

	public void setLineChartAcertos(CartesianChartModel lineChartAcertos)
	{
		this.lineChartAcertos = lineChartAcertos;
	}

	public void setMeterGauge(MeterGaugeChartModel meterGauge)
	{
		this.meterGauge = meterGauge;
	}

	public void setSelectedInstancia(
			DetalhesAplicacaoInstanciaVO selectedInstancia)
	{
		this.selectedInstancia = selectedInstancia;
	}
}
