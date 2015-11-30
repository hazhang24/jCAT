package com.douglasrizzo.business.interfaces;

import java.rmi.RemoteException;

import com.douglasrizzo.util.dto.ServiceDTO;
import com.douglasrizzo.util.exception.LayerException;

public interface Login
{
	ServiceDTO efetuarLogin(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO efetuarLoginAluno(ServiceDTO request) throws LayerException,
			RemoteException;
}
