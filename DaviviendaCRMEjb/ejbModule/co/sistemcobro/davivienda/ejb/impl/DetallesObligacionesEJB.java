package co.sistemcobro.davivienda.ejb.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.ObligacionHoy;
import co.sistemcobro.davivienda.dao.DetallesObligacionesDAO;
import co.sistemcobro.davivienda.ejb.IDetallesObligacionesEJBLocal;

@Stateless
public class DetallesObligacionesEJB extends BaseEJB implements IDetallesObligacionesEJBLocal {

	@Override
	public ObligacionHoy buscarDetallesObligacion(String idCliente, BigDecimal idObligacion) throws Exception {
		DetallesObligacionesDAO detallesObligacionesDAO = new DetallesObligacionesDAO(dc_davivienda);
		return detallesObligacionesDAO.buscarDetallesObligacion(idCliente, idObligacion);
	}

	@Override
	public List<ObligacionHoy> obligacionesEnOtrasCampanas(String identificacion) throws Exception {
		DetallesObligacionesDAO detallesObligacionesDAO = new DetallesObligacionesDAO(dc_davivienda);
		return detallesObligacionesDAO.obligacionesEnOtrasCampanas(identificacion);
	}

}
