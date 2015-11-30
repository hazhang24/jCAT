package com.douglasrizzo.view.pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import com.douglasrizzo.business.vo.CadastroItemVO;
import com.douglasrizzo.business.vo.LoginVO;
import com.douglasrizzo.util.TipoUsuarioEnum;
import com.douglasrizzo.util.Util;
import com.douglasrizzo.util.exception.LayerException;
import com.douglasrizzo.view.service.Service;

@ManagedBean
@ViewScoped
public class CadastroItemBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private CadastroItemVO item;
	private UploadedFile enunciado, imgA, imgB, imgC, imgD, som;

	public CadastroItemBean() throws IOException
	{
		if (!TelasUtil.checaLogin(TipoUsuarioEnum.ELABORADOR))
		{
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("Login.xhtml");
			return;
		}
		if (item == null)
		{
			item = new CadastroItemVO();
		}
	}

	public UploadedFile getEnunciado()
	{
		return enunciado;
	}

	public UploadedFile getImgA()
	{
		return imgA;
	}

	public UploadedFile getImgB()
	{
		return imgB;
	}

	public UploadedFile getImgC()
	{
		return imgC;
	}

	public UploadedFile getImgD()
	{
		return imgD;
	}

	public CadastroItemVO getItem()
	{
		return item;
	}

	public UploadedFile getSom()
	{
		return som;
	}

	private boolean inserir(byte[] binary, String fullpath)
	{
		try
		{
			FileOutputStream ofs = new FileOutputStream(new File(fullpath));
			ofs.write(binary);
			ofs.flush();
			ofs.close();

			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public void setEnunciado(UploadedFile enunciado)
	{
		this.enunciado = enunciado;
	}

	public void setImgA(UploadedFile imgA)
	{
		this.imgA = imgA;
	}

	public void setImgB(UploadedFile imgB)
	{
		this.imgB = imgB;
	}

	public void setImgC(UploadedFile imgC)
	{
		this.imgC = imgC;
	}

	public void setImgD(UploadedFile imgD)
	{
		this.imgD = imgD;
	}

	public void setItem(CadastroItemVO item)
	{
		this.item = item;
	}

	public void setSom(UploadedFile som)
	{
		this.som = som;
	}

	public void upload() throws IOException, LayerException
	{
		LoginVO vo = TelasUtil.getLogin();

		item.setElaboradorId(vo.getId());

		if ((item = new Service().itemEfetuarCadastro(item)) != null)
		{
			new File(Util.FILE_SAVE_PATH + File.separator + item.getId())
					.mkdirs();
			String aux;

			if (enunciado != null)
			{
				aux = Util.FILE_SAVE_PATH
						+ item.getId()
						+ File.separator
						+ "N"
						+ enunciado.getFileName().substring(
								enunciado.getFileName().lastIndexOf("."));
				inserir(IOUtils.toByteArray(enunciado.getInputstream()), aux);
				item.setImgEnunciado(Util.FILE_ONLINE_PATH
						+ aux.replace('\\', '/').substring(
								Util.FILE_SAVE_PATH.length()));
			}
			if (imgA != null)
			{
				aux = Util.FILE_SAVE_PATH
						+ item.getId()
						+ File.separator
						+ "A"
						+ imgA.getFileName().substring(
								imgA.getFileName().lastIndexOf("."));
				inserir(IOUtils.toByteArray(imgA.getInputstream()), aux);
				item.setImgA(Util.FILE_ONLINE_PATH
						+ aux.replace('\\', '/').substring(
								Util.FILE_SAVE_PATH.length()));
			}
			if (imgB != null)
			{
				aux = Util.FILE_SAVE_PATH
						+ item.getId()
						+ File.separator
						+ "B"
						+ imgB.getFileName().substring(
								imgB.getFileName().lastIndexOf("."));
				inserir(IOUtils.toByteArray(imgB.getInputstream()), aux);
				item.setImgB(Util.FILE_ONLINE_PATH
						+ aux.replace('\\', '/').substring(
								Util.FILE_SAVE_PATH.length()));
			}
			if (imgC != null)
			{
				aux = Util.FILE_SAVE_PATH
						+ item.getId()
						+ File.separator
						+ "C"
						+ imgC.getFileName().substring(
								imgC.getFileName().lastIndexOf("."));
				inserir(IOUtils.toByteArray(imgC.getInputstream()), aux);
				item.setImgC(Util.FILE_ONLINE_PATH
						+ aux.replace('\\', '/').substring(
								Util.FILE_SAVE_PATH.length()));
			}
			if (imgD != null)
			{
				aux = Util.FILE_SAVE_PATH
						+ item.getId()
						+ File.separator
						+ "D"
						+ imgD.getFileName().substring(
								imgD.getFileName().lastIndexOf("."));
				inserir(IOUtils.toByteArray(imgD.getInputstream()), aux);
				item.setImgD(Util.FILE_ONLINE_PATH
						+ aux.replace('\\', '/').substring(
								Util.FILE_SAVE_PATH.length()));
			}
			if (som != null)
			{
				aux = Util.FILE_SAVE_PATH
						+ item.getId()
						+ File.separator
						+ "narracao"
						+ som.getFileName().substring(
								som.getFileName().lastIndexOf("."));
				inserir(IOUtils.toByteArray(som.getInputstream()), aux);
				item.setNarracao(Util.FILE_ONLINE_PATH
						+ aux.replace('\\', '/').substring(
								Util.FILE_SAVE_PATH.length()));
			}

			new Service().itemAlterar(item);
			item = new CadastroItemVO();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("Sucesso!",
							"Cadastro efetuado com sucesso!"));
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Falha...", "Falha no cadastro!"));
		}
	}
}