package negocio.interfaces;

import java.rmi.RemoteException;

import javax.ejb.Remote;

import util.dto.ServiceDTO;
import util.exception.LayerException;

@Remote
public interface Cadastro
{
	ServiceDTO alterarAplicador(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO alterarItem(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO alterarTurma(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarAluno(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarAplicacao(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarAplicador(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarClassificacao(ServiceDTO request)
			throws LayerException, RemoteException;

	ServiceDTO cadastrarElaborador(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarEscola(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarInep(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarItem(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarItemRespondido(ServiceDTO request)
			throws LayerException, RemoteException;

	ServiceDTO cadastrarProva(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarSecretaria(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarTipoUsuario(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarTurma(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO cadastrarUsuario(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO emailCadastrado(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO finalizarInstancia(ServiceDTO request) throws LayerException,
			RemoteException;
}
