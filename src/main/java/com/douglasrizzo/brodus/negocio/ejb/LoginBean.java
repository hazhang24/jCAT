package negocio.ejb;

import java.rmi.RemoteException;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import negocio.dao.DaoFactory;
import negocio.ejb.interfaces.LoginLocal;
import negocio.ejb.interfaces.LoginRemote;
import negocio.entity.Aplicador;
import negocio.entity.Elaborador;
import negocio.entity.Inep;
import negocio.entity.Instancia;
import negocio.entity.Item;
import negocio.entity.Secretaria;
import negocio.entity.Usuario;
import negocio.vo.ExibirItemVO;
import negocio.vo.InstanciaAlunoVO;
import negocio.vo.LoginVO;
import util.TipoUsuarioEnum;
import util.Util;
import util.dto.ServiceDTO;
import util.exception.LayerException;

public @Stateful
class LoginBean implements LoginRemote, LoginLocal
{
	@PersistenceContext(unitName = "Brodus")
	EntityManager em;

	@Override
	public ServiceDTO efetuarLogin(ServiceDTO request) throws LayerException,
			RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		LoginVO vo = (LoginVO) request.get("loginVO");
		Usuario usuario = DaoFactory.getUsuarioDAO(em).localizarPorEmail(
				vo.getEmail());
		boolean resposta = false;

		if (usuario != null
				&& usuario.getSenha().equals(Util.encrypt(vo.getSenha())))
		{
			resposta = true;
			vo.setId(usuario.getId());
			vo.setNome(usuario.getNome() + " " + usuario.getSobrenome());

			if (usuario instanceof Aplicador)
			{
				vo.setTipo(TipoUsuarioEnum.APLICADOR);
			}
			else if (usuario instanceof Elaborador)
			{
				vo.setTipo(TipoUsuarioEnum.ELABORADOR);
			}
			else if (usuario instanceof Secretaria)
			{
				vo.setTipo(TipoUsuarioEnum.SECRETARIA);
			}
			else if (usuario instanceof Inep)
			{
				vo.setTipo(TipoUsuarioEnum.INEP);
			}
		}

		response.set("loginVO", vo);
		response.set("resposta", resposta);
		return response;
	}

	@Override
	public ServiceDTO efetuarLoginAluno(ServiceDTO request)
			throws LayerException, RemoteException
	{
		ServiceDTO response = new ServiceDTO();
		LoginVO vo = (LoginVO) request.get("loginVO");

		Instancia instancia = DaoFactory.getInstanciaDAO(em).localizar(
				vo.getId());

		if (instancia != null)
		{
			instancia.setIniciada(true);
			DaoFactory.getInstanciaDAO(em).alterar(instancia);

			InstanciaAlunoVO aux = new InstanciaAlunoVO(instancia.getId(), 0,
					instancia.getTempo(), instancia.getData(), instancia
							.getAluno().getNome(), instancia.getAplicacao()
							.getProva().getTitulo(), instancia.getAplicacao()
							.getProva().getDescricao());

			int count = 0;
			for (Item item : instancia.getAplicacao().getProva().getItens())
			{
				aux.getItens().add(
						new ExibirItemVO(item.getId(), instancia.getId(),
								++count, item.getAltA(), item.getAltB(), item
										.getAltC(), item.getAltD(), "", item
										.getImgEnunciado(), item.getImgA(),
								item.getImgB(), item.getImgC(), item.getImgD(),
								item.getNarracao(), 'E'));
			}

			response.set("resposta", aux);
		}

		return response;
	}
}