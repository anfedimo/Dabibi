package co.sistemcobro.davivienda.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Global;

@Local
public interface IGlobalEJBLocal {
	
	public Global consultaObservacion(BigDecimal numeroObligacion) throws Exception;
	
	public Global consultarFecha() throws Exception;
	
	public List<Global> consultarSimulador(Integer numCuotas, Integer idRediferido) throws Exception;
	
	public Global consultarSimuladorCuota(Integer numCuotas, Integer idRediferido) throws Exception;
	
	public List<Global> consultarAfinidad() throws Exception;
	
	public List<Global> consultarMotivosNoPago() throws Exception;
	
}
