package co.sistemcobro.davivienda.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Telefono;

@Local
public interface ITelefonoEJBLocal {
	
	
	public List<Telefono> listaTelefonosAsignacion(String identificacion) throws Exception;
	
	public List<Telefono> listaTelefonosContactabilidad(String identificacion) throws Exception;
	
	public List<Telefono> listaTelefonosRetirados(String identificacion) throws Exception;
	
}
