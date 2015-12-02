package com.douglasrizzo.business.ejb;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.douglasrizzo.business.dao.DaoFactory;
import com.douglasrizzo.business.ejb.interfaces.CadastroLocal;
import com.douglasrizzo.business.ejb.interfaces.CadastroRemote;
import com.douglasrizzo.business.entity.Aluno;
import com.douglasrizzo.business.entity.Aplicacao;
import com.douglasrizzo.business.entity.Aplicador;
import com.douglasrizzo.business.entity.Classificacao;
import com.douglasrizzo.business.entity.Elaborador;
import com.douglasrizzo.business.entity.Escola;
import com.douglasrizzo.business.entity.Inep;
import com.douglasrizzo.business.entity.Instancia;
import com.douglasrizzo.business.entity.Item;
import com.douglasrizzo.business.entity.ItemRespondido;
import com.douglasrizzo.business.entity.Prova;
import com.douglasrizzo.business.entity.Secretaria;
import com.douglasrizzo.business.entity.TipoUsuario;
import com.douglasrizzo.business.entity.Turma;
import com.douglasrizzo.business.entity.Usuario;
import com.douglasrizzo.business.vo.CadastroAlunoVO;
import com.douglasrizzo.business.vo.CadastroAplicacaoProvaVO;
import com.douglasrizzo.business.vo.CadastroAplicadorVO;
import com.douglasrizzo.business.vo.CadastroClassificacaoVO;
import com.douglasrizzo.business.vo.CadastroElaboradorVO;
import com.douglasrizzo.business.vo.CadastroEscolaVO;
import com.douglasrizzo.business.vo.CadastroInepVO;
import com.douglasrizzo.business.vo.CadastroItemVO;
import com.douglasrizzo.business.vo.CadastroProvaVO;
import com.douglasrizzo.business.vo.CadastroSecretariaVO;
import com.douglasrizzo.business.vo.CadastroTipoUsuarioVO;
import com.douglasrizzo.business.vo.CadastroTurmaVO;
import com.douglasrizzo.business.vo.ExibirItemVO;
import com.douglasrizzo.business.vo.InstanciaAlunoVO;
import com.douglasrizzo.util.Util;
import com.douglasrizzo.util.dto.ServiceDTO;
import com.douglasrizzo.util.exception.LayerException;

public @Stateless
class CadastroBean implements CadastroRemote, CadastroLocal
{
	@PersistenceContext(unitName = "jCAT")
	EntityManager em;

	@Override
	public ServiceDTO alterarAplicador(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroAplicadorVO vo = (CadastroAplicadorVO) request
				.get("aplicadorVO");
		Aplicador aux = DaoFactory.getAplicadorDAO(em).localizar(vo.getId()), aplicador = new Aplicador(
				vo.getId(), vo.getNome(), vo.getSobrenome(), vo.getEmail(),
				vo.getSenha(), DaoFactory.getTipoUsuarioDAO(em).localizar(
						vo.getTipoUsuarioId()), DaoFactory.getTurmaDAO(em)
						.localizar(vo.getTurmaId()));

		if (aux != null && aux.getSenha().equals(Util.encrypt(vo.getSenha())))
		{
			aplicador.setSenha(Util.encrypt(vo.getSenha()));
		}

		response.set("resposta",
				DaoFactory.getAplicadorDAO(em).alterar(aplicador));
		return response;
	}

	@Override
	public ServiceDTO alterarItem(ServiceDTO request) throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroItemVO vo = (CadastroItemVO) request.get("cadastroItemVO");

		Item item = DaoFactory.getItemDAO(em).localizar(vo.getId());
		item.setImgA(vo.getImgA());
		item.setImgB(vo.getImgB());
		item.setImgC(vo.getImgC());
		item.setImgD(vo.getImgD());
		item.setImgEnunciado(vo.getImgEnunciado());
		item.setNarracao(vo.getNarracao());

		response.set("resposta", DaoFactory.getItemDAO(em).alterar(item));
		return response;
	}

	@Override
	public ServiceDTO alterarTurma(ServiceDTO request) throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroTurmaVO vo = (CadastroTurmaVO) request.get("turmaVO");
		Turma turma = new Turma(vo.getId(), vo.getNome(), DaoFactory
				.getSecretariaDAO(em).localizar(vo.getSecretariaId())
				.getEscola(), DaoFactory.getAplicadorDAO(em).localizar(
				vo.getAplicadorId()));
		response.set("resposta", DaoFactory.getTurmaDAO(em).alterar(turma));
		return response;
	}

	@Override
	public ServiceDTO cadastrarAluno(ServiceDTO request) throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroAlunoVO vo = (CadastroAlunoVO) request.get("alunoVO");
		Aluno aluno = new Aluno(vo.getId(), vo.getNome(),
				vo.isEnsinoInfantil(), vo.getNascimento(), DaoFactory
						.getTurmaDAO(em).localizar(vo.getTurmaId()));

		response.set("resposta", DaoFactory.getAlunoDAO(em).inserir(aluno));
		return response;
	}

	@Override
	public ServiceDTO cadastrarAplicacao(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroAplicacaoProvaVO vo = (CadastroAplicacaoProvaVO) request
				.get("cadastroAplicacaoProvaVO");

		Aplicacao ap = DaoFactory.getAplicacaoDAO(em).insereRetorna(
				new Aplicacao(0, new Date(), DaoFactory.getTurmaDAO(em)
						.localizar(
								DaoFactory.getAplicadorDAO(em)
										.localizar(vo.getAplicadorId())
										.getTurma().getId()), DaoFactory
						.getProvaDAO(em).localizar(vo.getProvaId()), DaoFactory
						.getAplicadorDAO(em).localizar(vo.getAplicadorId())));

		if (ap != null)
		{
			for (Aluno aluno : ap.getTurma().getAlunos())
			{
				DaoFactory.getInstanciaDAO(em)
						.inserir(
								new Instancia(0, 0, false, new Date(), aluno,
										ap, null));
			}

			response.set("resposta", new CadastroAplicacaoProvaVO(ap.getId(),
					ap.getAplicador().getId(), ap.getProva().getId(), ap
							.getProva().getTitulo()));
		}
		return response;
	}

	@Override
	public ServiceDTO cadastrarAplicador(ServiceDTO request)
			throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroAplicadorVO vo = (CadastroAplicadorVO) request
				.get("aplicadorVO");
		Aplicador aplicador = new Aplicador(vo.getId(), vo.getNome(),
				vo.getSobrenome(), vo.getEmail(), Util.encrypt(vo.getSenha()),
				DaoFactory.getTipoUsuarioDAO(em).localizar(
						vo.getTipoUsuarioId()), DaoFactory.getTurmaDAO(em)
						.localizar(vo.getTurmaId()));
		response.set("resposta",
				DaoFactory.getAplicadorDAO(em).inserir(aplicador));
		return response;
	}

	@Override
	public ServiceDTO cadastrarClassificacao(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroClassificacaoVO vo = (CadastroClassificacaoVO) request
				.get("classificacaoVO");
		Classificacao classificacao = new Classificacao(0, vo.getValor(),
				vo.getAcertos(), vo.getDescricao());

		response.set("resposta",
				DaoFactory.getClassificacaoDAO(em).inserir(classificacao));

		return response;
	}

	@Override
	public ServiceDTO cadastrarElaborador(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroElaboradorVO vo = (CadastroElaboradorVO) request
				.get("elaboradorVO");
		Elaborador elaborador = new Elaborador(0, vo.getNome(),
				vo.getSobrenome(), vo.getEmail(), Util.encrypt(vo.getSenha()),
				DaoFactory.getTipoUsuarioDAO(em).localizar(
						vo.getTipoUsuarioId()));

		response.set("resposta",
				DaoFactory.getElaboradorDAO(em).inserir(elaborador));
		return response;
	}

	@Override
	public ServiceDTO cadastrarEscola(ServiceDTO request) throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroEscolaVO vo = (CadastroEscolaVO) request.get("escolaVO");
		Escola escola = new Escola(vo.getId(), vo.getCodigo(), vo.getNome());
		response.set("resposta", DaoFactory.getEscolaDAO(em).inserir(escola));
		return response;
	}

	@Override
	public ServiceDTO cadastrarInep(ServiceDTO request) throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroInepVO vo = (CadastroInepVO) request.get("inepVO");
		Inep inep = new Inep(0, vo.getNome(), vo.getSobrenome(), vo.getEmail(),
				Util.encrypt(vo.getSenha()), DaoFactory.getTipoUsuarioDAO(em)
						.localizar(vo.getTipoUsuarioId()), false);

		response.set("resposta", DaoFactory.getInepDAO(em).inserir(inep));

		return response;
	}

	@Override
	public ServiceDTO cadastrarItem(ServiceDTO request) throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroItemVO vo = (CadastroItemVO) request.get("itemVO");

		Item item = new Item(vo.getId(), vo.getEnunciado(), vo.getAltA(),
				vo.getAltB(), vo.getAltC(), vo.getAltD(), null, null, null,
				null, null, null, vo.getCorreta(), null, DaoFactory
						.getElaboradorDAO(em).localizar(vo.getElaboradorId()));

		if ((item = DaoFactory.getItemDAO(em).insereRetorna(item)) != null)
		{
			vo.setId(item.getId());
			response.set("resposta", vo);
		}

		return response;
	}

	@Override
	public ServiceDTO cadastrarItemRespondido(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		ExibirItemVO vo = (ExibirItemVO) request.get("exibirItemVO");

		Instancia ins = DaoFactory.getInstanciaDAO(em).localizar(
				vo.getInstanciaId());

		if (!ins.isIniciada())
		{
			ins.setIniciada(true);
			DaoFactory.getInstanciaDAO(em).alterar(ins);
		}

		Item item = DaoFactory.getItemDAO(em).localizar(vo.getId());

		response.set(
				"resposta",
				DaoFactory.getItemRespondidoDAO(em).inserir(
						new ItemRespondido(0, vo.getEscolha() == item
								.getCorreta(), ins, item)));
		return response;
	}

	@Override
	public ServiceDTO cadastrarProva(ServiceDTO request) throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroProvaVO vo = (CadastroProvaVO) request.get("provaVO");

		Prova prova = new Prova(vo.getId(), vo.getTitulo(), vo.getDescricao());

		for (int itemId : vo.getItens())
		{
			Item item = DaoFactory.getItemDAO(em).localizar(itemId);
			item.setUltimaUtilizacao(new Date());
			prova.getItens().add(DaoFactory.getItemDAO(em).insereRetorna(item));
		}

		response.set("resposta", DaoFactory.getProvaDAO(em).inserir(prova));
		return response;
	}

	@Override
	public ServiceDTO cadastrarSecretaria(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroSecretariaVO vo = (CadastroSecretariaVO) request
				.get("secretariaVO");
		Secretaria secretaria = new Secretaria(0, vo.getNome(),
				vo.getSobrenome(), vo.getEmail(), Util.encrypt(vo.getSenha()),
				DaoFactory.getTipoUsuarioDAO(em).localizar(
						vo.getTipoUsuarioId()), DaoFactory.getEscolaDAO(em)
						.localizar(vo.getEscolaId()));

		response.set("resposta",
				DaoFactory.getSecretariaDAO(em).inserir(secretaria));

		return response;
	}

	@Override
	public ServiceDTO cadastrarTipoUsuario(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroTipoUsuarioVO vo = (CadastroTipoUsuarioVO) request
				.get("tipoUsuarioVO");
		TipoUsuario tipoUsuario = new TipoUsuario(vo.getId(), vo.getDescricao());

		response.set("resposta",
				DaoFactory.getTipoUsuarioDAO(em).inserir(tipoUsuario));
		return response;
	}

	@Override
	public ServiceDTO cadastrarTurma(ServiceDTO request) throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroTurmaVO vo = (CadastroTurmaVO) request.get("turmaVO");
		Turma turma = new Turma(vo.getId(), vo.getNome(), DaoFactory
				.getSecretariaDAO(em).localizar(vo.getSecretariaId())
				.getEscola(), DaoFactory.getAplicadorDAO(em).localizar(
				vo.getAplicadorId()));
		response.set("resposta", DaoFactory.getTurmaDAO(em).inserir(turma));
		return response;
	}

	@Override
	public ServiceDTO cadastrarUsuario(ServiceDTO request)
			throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroElaboradorVO vo = (CadastroElaboradorVO) request
				.get("usuarioVO");
		Usuario usuario = new Usuario(vo.getId(), vo.getNome(),
				vo.getSobrenome(), vo.getEmail(), Util.encrypt(vo.getSenha()),
				DaoFactory.getTipoUsuarioDAO(em).localizar(
						vo.getTipoUsuarioId()));
		response.set("resposta", DaoFactory.getUsuarioDAO(em).inserir(usuario));
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ServiceDTO emailCadastrado(ServiceDTO request) throws LayerException
	{
		ServiceDTO response = new ServiceDTO();
		CadastroElaboradorVO vo = (CadastroElaboradorVO) request
				.get("usuarioVO");
		Usuario usuario = new Usuario(vo.getId(), vo.getNome(),
				vo.getSobrenome(), vo.getEmail(), vo.getSenha(), null);
		response.set("resposta", ((List<Usuario>) DaoFactory.getUsuarioDAO(em)
				.localizarPorEmail(usuario.getEmail())).size() > 0);
		return response;
	}

	@Override
	public ServiceDTO finalizarInstancia(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		InstanciaAlunoVO vo = (InstanciaAlunoVO) request
				.get("instanciaAlunoVO");

		Instancia ins = DaoFactory.getInstanciaDAO(em).localizar(vo.getId());
		ins.setIniciada(false);

		int acertos = 0;
		for (ItemRespondido item : ins.getItensRespondidos())
		{
			if (item.isAcerto())
			{
				acertos++;
				/*
				 * Nível 1: até 04 acertos Nível 2: de 05 a 09 acertos Nível 3:
				 * de 10 a 15 acertos Nível 4: de 16 a 18 acertos Nível 5: de 19
				 * a 20 acertos
				 */
			}
		}

		Classificacao clas;
		if (acertos <= 4)
		{
			clas = DaoFactory.getClassificacaoDAO(em).findByValor(1);
		}
		else if (acertos <= 9)
		{
			clas = DaoFactory.getClassificacaoDAO(em).findByValor(2);
		}
		else if (acertos <= 15)
		{
			clas = DaoFactory.getClassificacaoDAO(em).findByValor(3);
		}
		else if (acertos <= 18)
		{
			clas = DaoFactory.getClassificacaoDAO(em).findByValor(4);
		}
		else
		{
			clas = DaoFactory.getClassificacaoDAO(em).findByValor(5);
		}

		ins.setClassificacao(clas);

		response.set("resposta", DaoFactory.getInstanciaDAO(em).alterar(ins));
		return response;
	}
}