package co.sistemcobro.davivienda.ejb;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Gestion;
@Local
public interface IGestionEJBLocal {
	
	//public void actualizarGestion(Gestion gestion) throws Exception;
	
	public boolean insertarGestionRediferido(Gestion gestion) throws Exception;
	
	public boolean insertarObligacionGestion(String idObligacion) throws Exception;
	
	public String consultarObligacionIdentificacion(String identificacion) throws Exception;

}
