package apresentacao.telas;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import negocio.vo.TurmaListVO;
import util.exception.LayerException;
import apresentacao.service.Service;

@FacesConverter(value = "TurmaListVOConverter", forClass = TurmaListVO.class)
public class TurmaListVOConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		try
		{
			return new Service().getTurmaListVO(Integer.parseInt(arg2));
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
		if (arg2 instanceof TurmaListVO)
		{
			return Integer.toString(((TurmaListVO) arg2).getId());
		}
		return "";
	}

}