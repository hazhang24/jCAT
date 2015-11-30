package com.douglasrizzo.business.dao;

import javax.persistence.EntityManager;

import com.douglasrizzo.util.exception.SysException;

public final class DaoFactory
{
	private static DaoFactory myInstance = null;

	private static AlunoDAO alunoDAO_instance;

	private static AplicacaoDAO aplicacaoProvaDAO_instance;

	private static ElaboradorDAO elaboradorDAO_instance;

	private static ClassificacaoDAO classificacaoDAO_instance;

	private static EscolaDAO escolaDAO_instance;

	private static ItemDAO itemDAO_instance;

	private static ItemRespondidoDAO itemRespondidoDAO_instance;

	private static AplicadorDAO aplicadorDAO_instance;

	private static ProvaDAO provaDAO_instance;

	private static TurmaDAO turmaDAO_instance;

	private static UsuarioDAO usuarioDAO_instance;

	private static TipoUsuarioDAO tipoUsuarioDAO_instance;

	private static SecretariaDAO secretariaDAO_instance;

	private static FileDAO fileDAO_instance;

	private static InepDAO inepDAO_instance;

	private static InstanciaDAO instanciaDAO_instance;

	public static AlunoDAO getAlunoDAO(EntityManager em) throws SysException
	{
		initialize();
		return alunoDAO_instance == null ? alunoDAO_instance = new AlunoDAO(em)
				: alunoDAO_instance;
	}

	public static AplicacaoDAO getAplicacaoDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return aplicacaoProvaDAO_instance == null ? aplicacaoProvaDAO_instance = new AplicacaoDAO(
				em) : aplicacaoProvaDAO_instance;
	}

	public static AplicadorDAO getAplicadorDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return aplicadorDAO_instance == null ? aplicadorDAO_instance = new AplicadorDAO(
				em) : aplicadorDAO_instance;
	}

	public static ClassificacaoDAO getClassificacaoDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return classificacaoDAO_instance == null ? classificacaoDAO_instance = new ClassificacaoDAO(
				em) : classificacaoDAO_instance;
	}

	public static ElaboradorDAO getElaboradorDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return elaboradorDAO_instance == null ? elaboradorDAO_instance = new ElaboradorDAO(
				em) : elaboradorDAO_instance;
	}

	public static EscolaDAO getEscolaDAO(EntityManager em) throws SysException
	{
		initialize();
		return escolaDAO_instance == null ? escolaDAO_instance = new EscolaDAO(
				em) : escolaDAO_instance;
	}

	public static FileDAO getFileDAO() throws SysException
	{
		initialize();
		return fileDAO_instance == null ? fileDAO_instance = new FileDAO()
				: fileDAO_instance;
	}

	public static InepDAO getInepDAO(EntityManager em) throws SysException
	{
		initialize();
		return inepDAO_instance == null ? inepDAO_instance = new InepDAO(em)
				: inepDAO_instance;
	}

	public static InstanciaDAO getInstanciaDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return instanciaDAO_instance == null ? instanciaDAO_instance = new InstanciaDAO(
				em) : instanciaDAO_instance;
	}

	public static ItemDAO getItemDAO(EntityManager em) throws SysException
	{
		initialize();
		return itemDAO_instance == null ? itemDAO_instance = new ItemDAO(em)
				: itemDAO_instance;
	}

	public static ItemRespondidoDAO getItemRespondidoDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return itemRespondidoDAO_instance == null ? itemRespondidoDAO_instance = new ItemRespondidoDAO(
				em) : itemRespondidoDAO_instance;
	}

	public static ProvaDAO getProvaDAO(EntityManager em) throws SysException
	{
		initialize();
		return provaDAO_instance == null ? provaDAO_instance = new ProvaDAO(em)
				: provaDAO_instance;
	}

	public static SecretariaDAO getSecretariaDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return secretariaDAO_instance == null ? secretariaDAO_instance = new SecretariaDAO(
				em) : secretariaDAO_instance;
	}

	public static TipoUsuarioDAO getTipoUsuarioDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return tipoUsuarioDAO_instance == null ? tipoUsuarioDAO_instance = new TipoUsuarioDAO(
				em) : tipoUsuarioDAO_instance;
	}

	public static TurmaDAO getTurmaDAO(EntityManager em) throws SysException
	{
		initialize();

		return turmaDAO_instance == null ? turmaDAO_instance = new TurmaDAO(em)
				: turmaDAO_instance;
	}

	public static UsuarioDAO getUsuarioDAO(EntityManager em)
			throws SysException
	{
		initialize();
		return usuarioDAO_instance == null ? usuarioDAO_instance = new UsuarioDAO(
				em) : usuarioDAO_instance;
	}

	private synchronized static void initialize() throws SysException
	{
		if (myInstance == null)
		{
			myInstance = new DaoFactory();
		}
	}

	private DaoFactory() throws SysException
	{}
}
