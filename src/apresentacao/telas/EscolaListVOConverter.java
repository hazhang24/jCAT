package apresentacao.telas;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import negocio.vo.EscolaListVO;
import util.exception.LayerException;
import apresentacao.service.Service;

@FacesConverter(value = "EscolaListVOConverter", forClass = EscolaListVO.class)
public class EscolaListVOConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		try
		{
			return new Service().getEscolaListVO(Integer.parseInt(arg2));
		}
		catch (LayerException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
	{
		if (arg2 instanceof EscolaListVO)
		{
			return Integer.toString(((EscolaListVO) arg2).getId());
		}
		return "";
	}

}