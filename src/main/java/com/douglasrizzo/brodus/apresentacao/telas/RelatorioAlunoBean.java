package apresentacao.telas;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import negocio.vo.InstanciaAlunoVO;
import negocio.vo.LoginVO;
import negocio.vo.RelatorioAlunoVO;

import org.primefaces.model.chart.PieChartModel;

import util.exception.LayerException;
import apresentacao.service.Service;

@ManagedBean
@ViewScoped
public class RelatorioAlunoBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel;
	private RelatorioAlunoVO relatorio;

	public RelatorioAlunoBean() throws LayerException
	{
		relatorio = new Service()
				.prepararRelatorioAluno(((InstanciaAlunoVO) TelasUtil
						.getSession().getAttribute("aplicacao")).getId());

		pieModel = new PieChartModel();
		pieModel.set("Acertos", relatorio.getAcertos());
		pieModel.set("Erros", relatorio.getErros());
	}

	@SuppressWarnings("unchecked")
	public void finalizar() throws IOException
	{
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		Set<Integer> alunosLogados = (HashSet<Integer>) context
				.getApplicationMap().get("alunosLogados");
		LoginVO vo = (LoginVO) ((HttpSession) context.getSession(true))
				.getAttribute("loginAluno");

		if (alunosLogados != null && alunosLogados.contains(vo.getId()))
		{
			alunosLogados.remove(vo.getId());
			context.getApplicationMap().put("logados", alunosLogados);

			((HttpSession) context.getSession(true))
					.removeAttribute("loginAluno");
			((HttpSession) context.getSession(true))
					.removeAttribute("aplicacao");
		}

		context.redirect("Login.xhtml");
	}

	public PieChartModel getPieModel()
	{
		return pieModel;
	}

	public RelatorioAlunoVO getRelatorio()
	{
		return relatorio;
	}

	public void setPieModel(PieChartModel pieModel)
	{
		this.pieModel = pieModel;
	}

	public void setRelatorio(RelatorioAlunoVO relatorio)
	{
		this.relatorio = relatorio;
	}
}