package apresentacao.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import negocio.vo.AplicacaoListVO;
import negocio.vo.AplicacaoProvaVO;
import negocio.vo.CadastroAlunoVO;
import negocio.vo.CadastroAplicacaoProvaVO;
import negocio.vo.CadastroAplicadorVO;
import negocio.vo.CadastroElaboradorVO;
import negocio.vo.CadastroEscolaVO;
import negocio.vo.CadastroInepVO;
import negocio.vo.CadastroItemVO;
import negocio.vo.CadastroProvaVO;
import negocio.vo.CadastroProvaVO.CadastroProvaItemVO;
import negocio.vo.CadastroSecretariaVO;
import negocio.vo.CadastroTurmaVO;
import negocio.vo.DetalhesAplicacaoVO;
import negocio.vo.DetalhesInstanciaVO;
import negocio.vo.EscolaListVO;
import negocio.vo.ExibirItemVO;
import negocio.vo.InstanciaAlunoVO;
import negocio.vo.LoginVO;
import negocio.vo.ProvaListVO;
import negocio.vo.RelatorioAlunoVO;
import negocio.vo.TurmaListVO;
import util.dto.ServiceDTO;
import util.exception.LayerException;
import apresentacao.delegate.BusinessDelegate;

public class Service
{
	public boolean alunoEfetuarCadastro(CadastroAlunoVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("alunoVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.alunoEfetuarCadastro(request).get("resposta");
	}

	public InstanciaAlunoVO alunoEfetuarLogin(LoginVO login)
			throws RemoteException, LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("loginVO", login);
		return (InstanciaAlunoVO) BusinessDelegate.getInstance()
				.alunoEfetuarLogin(request).get("resposta");
	}

	public boolean alunoFinalizarInstancia(InstanciaAlunoVO instancia)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("instanciaAlunoVO", instancia);

		return (Boolean) BusinessDelegate.getInstance()
				.alunoFinalizarAplicacao(request).get("resposta");
	}

	public boolean alunoProcessarResposta(ExibirItemVO vo)
			throws RemoteException, LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("exibirItemVO", vo);

		return (Boolean) BusinessDelegate.getInstance()
				.alunoProcessarResposta(request).get("resposta");
	}

	public CadastroAplicacaoProvaVO aplicacaoProvaEfetuarCadastro(
			CadastroAplicacaoProvaVO selectedProva) throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("cadastroAplicacaoProvaVO", selectedProva);
		return (CadastroAplicacaoProvaVO) BusinessDelegate.getInstance()
				.aplicacaoProvaEfetuarCadastro(request).get("resposta");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<AplicacaoListVO> aplicacoesListar(LoginVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("loginVO", vo);

		return (ArrayList<AplicacaoListVO>) BusinessDelegate.getInstance()
				.aplicacoesListar(request).get("resposta");
	}

	public boolean aplicadorEfetuarCadastro(CadastroAplicadorVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("aplicadorVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.aplicadorEfetuarCadastro(request).get("resposta");
	}

	public AplicacaoProvaVO atualizarTela(int aplicacaoProvaId)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("aplicacaoProvaId", aplicacaoProvaId);
		return (AplicacaoProvaVO) BusinessDelegate.getInstance()
				.atualizarTela(request).get("resposta");
	}

	public boolean elaboradorEfetuarCadastro(CadastroElaboradorVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("elaboradorVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.elaboradorEfetuarCadastro(request).get("resposta");
	}

	public boolean escolaEfetuarCadastro(CadastroEscolaVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("escolaVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.escolaEfetuarCadastro(request).get("resposta");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<EscolaListVO> escolaListar() throws LayerException
	{
		return (ArrayList<EscolaListVO>) BusinessDelegate.getInstance()
				.escolaListar().get("resposta");
	}

	public DetalhesAplicacaoVO getDetalhesAplicacao(int aplicacaoId)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("aplicacaoId", aplicacaoId);
		return (DetalhesAplicacaoVO) BusinessDelegate.getInstance()
				.aplicacaoDetalhes(request).get("resposta");
	}

	public DetalhesInstanciaVO getDetalhesInstancia(int instanciaId)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("instanciaId", instanciaId);
		return (DetalhesInstanciaVO) BusinessDelegate.getInstance()
				.instanciaDetalhes(request).get("resposta");
	}

	public Object getEscolaListVO(int id) throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("id", id);

		return BusinessDelegate.getInstance().getEscolaListVO(request)
				.get("resposta");
	}

	public Object getProvaListVO(int id) throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("id", id);

		return BusinessDelegate.getInstance().getProvaListVO(request)
				.get("resposta");
	}

	public Object getTurmaListVO(int id) throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("id", id);

		return BusinessDelegate.getInstance().getTurmaListVO(request)
				.get("resposta");
	}

	public boolean inepEfetuarCadastro(CadastroInepVO vo) throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("inepVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.inepEfetuarCadastro(request).get("resposta");
	}

	public boolean itemAlterar(CadastroItemVO vo) throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("cadastroItemVO", vo);
		return (Boolean) BusinessDelegate.getInstance().itemAlterar(request)
				.get("resposta");
	}

	public CadastroItemVO itemEfetuarCadastro(CadastroItemVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("itemVO", vo);
		return (CadastroItemVO) BusinessDelegate.getInstance()
				.itemEfetuarCadastro(request).get("resposta");
	}

	public RelatorioAlunoVO prepararRelatorioAluno(int id)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("instanciaId", id);

		return (RelatorioAlunoVO) BusinessDelegate.getInstance()
				.prepararRelatorioAluno(request).get("resposta");
	}

	public boolean provaEfetuarCadastro(CadastroProvaVO vo)
			throws RemoteException, LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("provaVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.provaEfetuarCadastro(request).get("resposta");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ProvaListVO> provaListar(int aplicadorId)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("aplicadorId", aplicadorId);
		return (ArrayList<ProvaListVO>) BusinessDelegate.getInstance()
				.provaListar(request).get("resposta");
	}

	@SuppressWarnings("unchecked")
	public List<CadastroProvaItemVO> provaRecuperarItensParaEscolha()
			throws RemoteException, LayerException
	{
		return (ArrayList<CadastroProvaItemVO>) BusinessDelegate.getInstance()
				.provaRecuperarItensParaEscolha().get("resposta");
	}

	public boolean secretariaEfetuarCadastro(CadastroSecretariaVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("secretariaVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.secretariaEfetuarCadastro(request).get("resposta");
	}

	public boolean turmaEfetuarCadastro(CadastroTurmaVO vo)
			throws LayerException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("turmaVO", vo);
		return (Boolean) BusinessDelegate.getInstance()
				.turmaEfetuarCadastro(request).get("resposta");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TurmaListVO> turmaListar() throws LayerException
	{
		return (ArrayList<TurmaListVO>) BusinessDelegate.getInstance()
				.turmaListar().get("resposta");
	}

	public LoginVO usuarioEfetuarLogin(LoginVO vo) throws LayerException,
			RemoteException
	{
		ServiceDTO request = new ServiceDTO();
		request.set("loginVO", vo);

		return (LoginVO) BusinessDelegate.getInstance()
				.usuarioEfetuarLogin(request).get("loginVO");
	}
}