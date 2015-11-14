package negocio.interfaces;

import java.rmi.RemoteException;

import util.dto.ServiceDTO;
import util.exception.LayerException;

public interface Login
{
	ServiceDTO efetuarLogin(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO efetuarLoginAluno(ServiceDTO request) throws LayerException,
			RemoteException;
}
