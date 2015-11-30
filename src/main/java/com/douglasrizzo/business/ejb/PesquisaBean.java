package com.douglasrizzo.business.ejb;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.douglasrizzo.business.dao.DaoFactory;
import com.douglasrizzo.business.ejb.interfaces.PesquisaLocal;
import com.douglasrizzo.business.ejb.interfaces.PesquisaRemote;
import com.douglasrizzo.business.entity.Aplicacao;
import com.douglasrizzo.business.entity.Aplicador;
import com.douglasrizzo.business.entity.Classificacao;
import com.douglasrizzo.business.entity.Elaborador;
import com.douglasrizzo.business.entity.Escola;
import com.douglasrizzo.business.entity.Instancia;
import com.douglasrizzo.business.entity.Item;
import com.douglasrizzo.business.entity.ItemRespondido;
import com.douglasrizzo.business.entity.Prova;
import com.douglasrizzo.business.entity.Secretaria;
import com.douglasrizzo.business.entity.TipoUsuario;
import com.douglasrizzo.business.entity.Turma;
import com.douglasrizzo.business.vo.AplicacaoListVO;
import com.douglasrizzo.business.vo.AplicacaoProvaVO;
import com.douglasrizzo.business.vo.CadastroAplicadorVO;
import com.douglasrizzo.business.vo.CadastroElaboradorVO;
import com.douglasrizzo.business.vo.CadastroEscolaVO;
import com.douglasrizzo.business.vo.CadastroProvaVO;
import com.douglasrizzo.business.vo.CadastroTipoUsuarioVO;
import com.douglasrizzo.business.vo.DetalhesAplicacaoVO;
import com.douglasrizzo.business.vo.DetalhesInstanciaVO;
import com.douglasrizzo.business.vo.EscolaListVO;
import com.douglasrizzo.business.vo.IntCharPairVO;
import com.douglasrizzo.business.vo.LoginVO;
import com.douglasrizzo.business.vo.ProvaListVO;
import com.douglasrizzo.business.vo.RelatorioAlunoVO;
import com.douglasrizzo.business.vo.SecretariaListVO;
import com.douglasrizzo.business.vo.TurmaListVO;
import com.douglasrizzo.business.vo.AplicacaoProvaVO.AplicacaoProvaItemVO;
import com.douglasrizzo.business.vo.CadastroProvaVO.CadastroProvaItemVO;
import com.douglasrizzo.util.TipoUsuarioEnum;
import com.douglasrizzo.util.dto.ServiceDTO;
import com.douglasrizzo.util.exception.LayerException;

@Stateless
public class PesquisaBean implements PesquisaRemote, PesquisaLocal
{
	@PersistenceContext(unitName = "Brodus")
	EntityManager em;

	@Override
	public ServiceDTO aplicacoesListar(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		LoginVO vo = (LoginVO) request.get("loginVO");
		ArrayList<Aplicacao> aplicacoes;
		ArrayList<AplicacaoListVO> lista = new ArrayList<AplicacaoListVO>();
		;

		if (vo.getTipo() == TipoUsuarioEnum.INEP)
		{
			aplicacoes = (ArrayList<Aplicacao>) DaoFactory.getAplicacaoDAO(em)
					.listar();
		}
		else
		{
			aplicacoes = (ArrayList<Aplicacao>) DaoFactory.getAplicacaoDAO(em)
					.listByEscola(
							DaoFactory.getSecretariaDAO(em)
									.localizar(vo.getId()).getEscola().getId());
		}

		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
				DateFormat.MEDIUM, new Locale("pt", "br"));

		for (Aplicacao aplicacao : aplicacoes)
		{
			AplicacaoListVO apVO = new AplicacaoListVO(aplicacao.getId(),
					df.format(aplicacao.getData()), aplicacao.getTurma()
							.getNome(), aplicacao.getProva().getTitulo(),
					aplicacao.getTurma().getAlunos().size(), aplicacao
							.getProva().getItens().size());

			for (Instancia instancia : aplicacao.getInstancias())
			{
				if (!instancia.isIniciada())
				{
					int acertos = 0;

					for (ItemRespondido ir : instancia.getItensRespondidos())
					{
						if (ir.isAcerto())
						{
							acertos++;
						}
					}

					apVO.getInstancias().add(
							new AplicacaoListVO().new AplicacaoListItemVO(
									instancia.getId(), acertos, instancia
											.getAplicacao().getProva()
											.getItens().size()
											- acertos, instancia.getAplicacao()
											.getProva().getItens().size(),
									instancia.getAluno().getNome(), 0,
									instancia.getClassificacao().getValor()));
				}
			}

			lista.add(apVO);
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO detalharAplicacao(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		Aplicacao ap = DaoFactory.getAplicacaoDAO(em).localizar(
				(Integer) request.get("aplicacaoId"));
		DetalhesAplicacaoVO vo = new DetalhesAplicacaoVO(ap.getId(), ap
				.getTurma().getAlunos().size(),
				ap.getProva().getItens().size(), DateFormat
						.getDateTimeInstance(DateFormat.MEDIUM,
								DateFormat.MEDIUM, new Locale("pt", "br"))
						.format(ap.getData()), ap.getTurma().getNome(), ap
						.getProva().getTitulo(), 0);

		HashMap<Integer, Integer> respostas = new HashMap<Integer, Integer>();

		double mediaClassificacao = 0;

		retorno: for (Instancia instancia : ap.getInstancias())
		{
			int count = 0;
			for (ItemRespondido ir : instancia.getItensRespondidos())
			{
				respostas.put(++count, 0);
			}

			break retorno;
		}

		for (Instancia instancia : ap.getInstancias())
		{
			DetalhesAplicacaoVO.DetalhesAplicacaoInstanciaVO vozinho = new DetalhesAplicacaoVO().new DetalhesAplicacaoInstanciaVO(
					instancia.getId(), 0, 0, instancia.getItensRespondidos()
							.size(), instancia.getClassificacao().getValor(),
					instancia.getAluno().getNome(), 0, instancia
							.getClassificacao().getDescricao());

			int acertos = 0;
			HashMap<Integer, Character> resp = new HashMap<Integer, Character>();

			int count = 0;
			for (ItemRespondido ir : instancia.getItensRespondidos())
			{
				resp.put(++count, ir.isAcerto() ? 'X' : ' ');

				if (ir.isAcerto())
				{
					acertos++;
					respostas.put(count, respostas.get(count) + 1);
				}
			}

			Integer[] chavesOrdenadas = resp.keySet().toArray(new Integer[0]);

			Arrays.sort(chavesOrdenadas);

			for (Integer chave2 : chavesOrdenadas)
			{
				vozinho.getRespostas().add(
						new IntCharPairVO(chave2, resp.get(chave2)));
			}

			vozinho.setAcertos(acertos);
			vozinho.setErros(instancia.getItensRespondidos().size() - acertos);
			vo.getInstancias().add(vozinho);

			mediaClassificacao += instancia.getClassificacao().getValor();
		}

		Integer[] chavesOrdenadas = respostas.keySet().toArray(new Integer[0]);
		Arrays.sort(chavesOrdenadas);
		for (Integer chave1 : chavesOrdenadas)
		{
			vo.getAcertosItem().add(respostas.get(chave1));
		}

		vo.setMediaClassificacao(mediaClassificacao / vo.getInstancias().size());
		for (Classificacao c : DaoFactory.getClassificacaoDAO(em).listar())
		{
			vo.getClassificacoes().add(c.getValor());
		}

		response.set("resposta", vo);

		return response;
	}

	@Override
	public ServiceDTO detalharInstancia(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		Instancia instancia = DaoFactory.getInstanciaDAO(em).localizar(
				(Integer) request.get("instanciaId"));
		DetalhesInstanciaVO vo = new DetalhesInstanciaVO(instancia.getId(), 0,
				0, instancia.getItensRespondidos().size(), instancia
						.getClassificacao().getValor(), instancia.getAluno()
						.getNome(), instancia.getTempo(), instancia
						.getClassificacao().getDescricao());

		int acertos = 0;

		HashMap<Integer, Character> respostas = new HashMap<Integer, Character>();

		for (ItemRespondido ir : instancia.getItensRespondidos())
		{
			respostas.put(ir.getItem().getId(), ir.isAcerto() ? 'X' : ' ');
			if (ir.isAcerto())
			{
				acertos++;
			}
		}

		Integer[] chavesOrdenadas = respostas.keySet().toArray(new Integer[0]);
		Arrays.sort(chavesOrdenadas);

		for (Integer i : chavesOrdenadas)
		{
			vo.getAcertos().add(new IntCharPairVO(i, respostas.get(i)));
		}

		vo.setQtdAcertos(acertos);
		vo.setErros(instancia.getItensRespondidos().size() - acertos);
		response.set("resposta", vo);
		return response;
	}

	@Override
	public ServiceDTO finalizarInstancia(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		int instanciaId = (Integer) request.get("instanciaId");
		Instancia ins = DaoFactory.getInstanciaDAO(em).localizar(instanciaId);

		int acertos = 0;
		for (ItemRespondido item : ins.getItensRespondidos())
		{
			if (item.isAcerto())
			{
				acertos++;
			}
		}

		response.set("resposta", new RelatorioAlunoVO(ins.getId(), acertos, ins
				.getItensRespondidos().size() - acertos, ins
				.getItensRespondidos().size(), ins.getAluno().getNome(), ins
				.getClassificacao().getValor(), ins.getClassificacao()
				.getDescricao()));

		return response;
	}

	@Override
	public ServiceDTO getEscolaListVO(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		Escola e = DaoFactory.getEscolaDAO(em).localizar(
				(Integer) request.get("id"));

		response.set("resposta",
				e != null ? new EscolaListVO(e.getId(), e.getNome()) : null);

		return response;
	}

	@Override
	public ServiceDTO getProvaListVO(ServiceDTO request) throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		Prova p = DaoFactory.getProvaDAO(em).localizar(
				(Integer) request.get("id"));

		response.set("resposta",
				p != null ? new ProvaListVO(p.getId(), p.getTitulo()) : null);

		return response;
	}

	@Override
	public ServiceDTO getTurmaListVO(ServiceDTO request) throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		Turma t = DaoFactory.getTurmaDAO(em).localizar(
				(Integer) request.get("id"));

		response.set("resposta",
				t != null ? new TurmaListVO(t.getId(), t.getNome()) : null);

		return response;
	}

	@Override
	public ServiceDTO listarAplicadores() throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<CadastroAplicadorVO> lista = new ArrayList<CadastroAplicadorVO>();
		List<Aplicador> aux = DaoFactory.getAplicadorDAO(em).listar();

		for (Aplicador aplicador : aux)
		{
			lista.add(new CadastroAplicadorVO(aplicador.getId(), aplicador
					.getNome(), aplicador.getSobrenome(), aplicador.getEmail(),
					aplicador.getSenha(), aplicador.getTipoUsuario().getId(),
					aplicador.getTurma() != null ? aplicador.getTurma().getId()
							: 0));
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO listarElaboradores() throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<CadastroElaboradorVO> lista = new ArrayList<CadastroElaboradorVO>();
		List<Elaborador> aux = DaoFactory.getElaboradorDAO(em).listar();

		for (Elaborador elaborador : aux)
		{
			lista.add(new CadastroElaboradorVO(elaborador.getId(), elaborador
					.getNome(), elaborador.getSobrenome(), elaborador
					.getEmail(), elaborador.getSenha(), elaborador
					.getTipoUsuario().getId()));
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO listarEscolas() throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<CadastroEscolaVO> lista = new ArrayList<CadastroEscolaVO>();
		List<Escola> aux = DaoFactory.getEscolaDAO(em).listar();

		for (Escola escola : aux)
		{
			lista.add(new CadastroEscolaVO(escola.getId(), escola.getCodigo(),
					escola.getNome()));
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO listarProvas(ServiceDTO request) throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<ProvaListVO> lista = new ArrayList<ProvaListVO>();
		List<Prova> aux = DaoFactory.getProvaDAO(em).listar();

		for (Prova prova : aux)
		{
			lista.add(new ProvaListVO(prova.getId(), prova.getTitulo()));
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO listarSecretarias() throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<SecretariaListVO> lista = new ArrayList<SecretariaListVO>();
		List<Secretaria> aux = DaoFactory.getSecretariaDAO(em).listar();

		for (Secretaria secretaria : aux)
		{
			lista.add(new SecretariaListVO(secretaria.getId(), secretaria
					.getNome() + " " + secretaria.getSobrenome()));
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO listarTiposUsuario() throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<CadastroTipoUsuarioVO> lista = new ArrayList<CadastroTipoUsuarioVO>();
		List<TipoUsuario> aux = DaoFactory.getTipoUsuarioDAO(em).listar();

		for (TipoUsuario tipoUsuario : aux)
		{
			lista.add(new CadastroTipoUsuarioVO(tipoUsuario.getId(),
					tipoUsuario.getDescricao()));
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO listarTurmas() throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<TurmaListVO> lista = new ArrayList<TurmaListVO>();
		List<Turma> aux = DaoFactory.getTurmaDAO(em).listar();

		for (Turma turma : aux)
		{
			lista.add(new TurmaListVO(turma.getId(), turma.getNome()));
		}

		response.set("resposta", lista);
		return response;
	}

	@Override
	public ServiceDTO localizarEscola(ServiceDTO request) throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		Escola ent = DaoFactory.getEscolaDAO(em).localizar(
				(Integer) request.get("id"));
		CadastroEscolaVO vo = null;
		if (ent != null)
		{
			vo = new CadastroEscolaVO(ent.getId(), ent.getCodigo(),
					ent.getNome());
		}

		response.set("resposta", vo);

		return response;
	}

	@Override
	public ServiceDTO preencherAplicacaoProva(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		int aplicacaoId = (Integer) request.get("aplicacaoProvaId");
		AplicacaoProvaVO vo = null;
		Aplicacao aplicacao = DaoFactory.getAplicacaoDAO(em).localizar(
				aplicacaoId);

		if (aplicacao != null)
		{
			vo = new AplicacaoProvaVO(aplicacao.getTurma().getNome(), aplicacao
					.getData().toString());
			for (Instancia inst : aplicacao.getInstancias())
			{
				AplicacaoProvaItemVO aux = new AplicacaoProvaVO().new AplicacaoProvaItemVO(
						inst.getId(), inst.getAluno().getNome(),
						Boolean.toString(inst.isIniciada()), Long.toString(inst
								.getTempo()),
						inst.getItensRespondidos().size(), 0, 0, aplicacao
								.getProva().getItens().size());

				for (ItemRespondido item : inst.getItensRespondidos())
				{
					if (item.isAcerto())
					{
						aux.setAcertos(aux.getAcertos() + 1);
					}
					else
					{
						aux.setErros(aux.getErros() + 1);
					}
				}

				vo.getItens().add(aux);
			}
		}

		response.set("resposta", vo);
		return response;
	}

	@Override
	public ServiceDTO recuperarItensParaEscolha() throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ArrayList<CadastroProvaItemVO> lista = new ArrayList<CadastroProvaItemVO>();

		List<Item> aux = DaoFactory.getItemDAO(em).listar();

		for (Item item : aux)
		{
			lista.add(new CadastroProvaVO().new CadastroProvaItemVO(item
					.getId(), item.getDescritor() != null ? item.getDescritor()
					.length() > 30 ? item.getDescritor().substring(0, 28)
					+ "..." : item.getDescritor() : "(sem enunciado)", item
					.getElaborador().getNome(),
					item.getUltimaUtilizacao() != null ? item
							.getUltimaUtilizacao().toString() : "---"));
		}
		response.set("resposta", lista);
		return response;
	}
}