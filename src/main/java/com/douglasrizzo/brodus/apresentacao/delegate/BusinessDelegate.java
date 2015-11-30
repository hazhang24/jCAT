package apresentacao.delegate;

import java.rmi.RemoteException;

import negocio.interfaces.Cadastro;
import negocio.interfaces.Login;
import negocio.interfaces.Pesquisa;
import util.dto.ServiceDTO;
import util.exception.LayerException;
import util.exception.SysExceptionFactory;
import util.locator.ServiceLocator;
import util.locator.ServiceLocatorException;
import util.locator.ServiceLocatorFactory;

public class BusinessDelegate
{
	private static BusinessDelegate instance = null;

	public synchronized static BusinessDelegate getInstance()
			throws LayerException
	{
		if (instance == null)
		{
			try
			{
				instance = new BusinessDelegate();
			}
			catch (Exception exception)
			{
				throw SysExceptionFactory.getException(exception);
			}
		}
		return instance;
	}

	private ServiceLocator serviceLocator;

	private BusinessDelegate() throws Exception
	{
		setServiceLocator();
	}

	public ServiceDTO alunoEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarAluno(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO alunoEfetuarLogin(ServiceDTO request)
			throws LayerException, RemoteException
	{
		try
		{
			return ((Login) serviceLocator.getService("LoginBean/remote"))
					.efetuarLoginAluno(request);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO alunoFinalizarAplicacao(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.finalizarInstancia(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO alunoProcessarResposta(ServiceDTO request)
			throws LayerException, RemoteException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarItemRespondido(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO aplicacaoDetalhes(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.detalharAplicacao(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO aplicacaoProvaEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarAplicacao(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO aplicacoesListar(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.aplicacoesListar(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO aplicadorEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarAplicador(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO atualizarTela(ServiceDTO request) throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.preencherAplicacaoProva(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO elaboradorEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarUsuario(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO escolaEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarEscola(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO escolaListar() throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.listarEscolas();
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO getEscolaListVO(ServiceDTO request) throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.getEscolaListVO(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO getProvaListVO(ServiceDTO request) throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.getProvaListVO(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO getTurmaListVO(ServiceDTO request) throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.getTurmaListVO(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO inepEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarInep(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO instanciaDetalhes(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.detalharInstancia(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO itemAlterar(ServiceDTO request) throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.alterarItem(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO itemEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarItem(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO prepararRelatorioAluno(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.finalizarInstancia(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO provaEfetuarCadastro(ServiceDTO request)
			throws LayerException, RemoteException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarProva(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO provaListar(ServiceDTO request) throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.listarProvas(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO provaRecuperarItensParaEscolha() throws LayerException,
			RemoteException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.recuperarItensParaEscolha();
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO secretariaEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarSecretaria(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	private void setServiceLocator() throws Exception
	{
		serviceLocator = ServiceLocatorFactory
				.getServiceLocator("serviceLocator");
	}

	public ServiceDTO turmaEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarTurma(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO turmaListar() throws LayerException
	{
		try
		{
			return ((Pesquisa) serviceLocator.getService("PesquisaBean/remote"))
					.listarTurmas();
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO usuarioEfetuarCadastro(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Cadastro) serviceLocator.getService("CadastroBean/remote"))
					.cadastrarUsuario(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}

	public ServiceDTO usuarioEfetuarLogin(ServiceDTO request)
			throws LayerException
	{
		try
		{
			return ((Login) serviceLocator.getService("LoginBean/remote"))
					.efetuarLogin(request);
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException(remoteException);
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
	}
}