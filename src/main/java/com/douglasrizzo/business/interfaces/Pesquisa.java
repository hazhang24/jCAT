package com.douglasrizzo.business.interfaces;

import java.rmi.RemoteException;

import com.douglasrizzo.util.dto.ServiceDTO;
import com.douglasrizzo.util.exception.LayerException;

public interface Pesquisa
{
	ServiceDTO aplicacoesListar(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO detalharAplicacao(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO detalharInstancia(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO finalizarInstancia(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO getEscolaListVO(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO getProvaListVO(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO getTurmaListVO(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO listarAplicadores() throws LayerException, RemoteException;

	ServiceDTO listarElaboradores() throws LayerException, RemoteException;

	ServiceDTO listarEscolas() throws LayerException, RemoteException;

	ServiceDTO listarProvas(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO listarSecretarias() throws LayerException, RemoteException;

	ServiceDTO listarTiposUsuario() throws LayerException, RemoteException;

	ServiceDTO listarTurmas() throws LayerException, RemoteException;

	ServiceDTO localizarEscola(ServiceDTO request) throws LayerException,
			RemoteException;

	ServiceDTO preencherAplicacaoProva(ServiceDTO request)
			throws LayerException, RemoteException;

	ServiceDTO recuperarItensParaEscolha() throws LayerException,
			RemoteException;
}