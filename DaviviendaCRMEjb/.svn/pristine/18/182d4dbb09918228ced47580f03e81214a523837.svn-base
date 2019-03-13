package co.sistemcobro.davivienda.ejb.impl;

import java.math.BigDecimal;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Rediferido;
import co.sistemcobro.davivienda.bean.TasaRediferido;
import co.sistemcobro.davivienda.dao.RediferidoDAO;
import co.sistemcobro.davivienda.ejb.IRediferidoEJBLocal;

@Stateless
public class RediferidoEJB extends BaseEJB implements IRediferidoEJBLocal{

	@Override
	public Rediferido consultarRediferidoPorObligacion(BigDecimal numeroObligacion) throws Exception {
		RediferidoDAO rediferidoDAO  = new RediferidoDAO(dc_davivienda);
		return rediferidoDAO.consultarRediferidoPorObligacion(numeroObligacion);
	}

	@Override
	public TasaRediferido consultarTasaRediferido() throws Exception {
		RediferidoDAO rediferidoDAO  = new RediferidoDAO(dc_davivienda);
		return rediferidoDAO.consultarTasaRediferido();
	}
	
	

}
