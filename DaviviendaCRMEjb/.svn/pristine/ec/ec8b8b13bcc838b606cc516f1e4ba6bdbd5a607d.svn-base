package co.sistemcobro.davivienda.ejb.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Global;
import co.sistemcobro.davivienda.dao.GlobalDAO;
import co.sistemcobro.davivienda.ejb.IGlobalEJBLocal;

@Stateless
public class GlobalEJB extends BaseEJB implements IGlobalEJBLocal {

	@Override
	public Global consultaObservacion(BigDecimal numeroObligacion) throws Exception {
		GlobalDAO global = new GlobalDAO(dc_davivienda);
		return global.consultaObservacion(numeroObligacion);
	}

	@Override
	public Global consultarFecha() throws Exception {
		GlobalDAO global = new GlobalDAO(dc_davivienda);
		return global.consultarFecha();
	}

	@Override
	public List<Global> consultarSimulador(Integer numCuotas, Integer idRediferido) throws Exception {
		GlobalDAO global = new GlobalDAO(dc_davivienda);
		return global.consultarSimulador(numCuotas, idRediferido);
	}

	@Override
	public List<Global> consultarAfinidad() throws Exception {
		GlobalDAO global = new GlobalDAO(dc_davivienda);
		return global.consultarAfinidad();
	}

	@Override
	public List<Global> consultarMotivosNoPago() throws Exception {
		GlobalDAO global = new GlobalDAO(dc_davivienda);
		return global.consultarMotivosNoPago();
	}

	@Override
	public Global consultarSimuladorCuota(Integer numCuotas, Integer idRediferido) throws Exception {
		GlobalDAO global = new GlobalDAO(dc_davivienda);
		return global.consultarSimuladorCuota(numCuotas, idRediferido);
	}

}
