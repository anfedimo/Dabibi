package co.sistemcobro.davivienda.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Tipificacion;

@Local
public interface ITipificacionEJBLocal {
		
	public Tipificacion obtenerTipificacion() throws Exception;
	
	public List<Tipificacion> obtenerTipoTipificacion() throws Exception;

}
