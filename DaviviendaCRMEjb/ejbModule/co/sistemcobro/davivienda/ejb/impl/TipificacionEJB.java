package co.sistemcobro.davivienda.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Tipificacion;
import co.sistemcobro.davivienda.dao.TipificacionDAO;
import co.sistemcobro.davivienda.ejb.ITipificacionEJBLocal;

@Stateless
public class TipificacionEJB extends BaseEJB implements ITipificacionEJBLocal {

	@Override
	public Tipificacion obtenerTipificacion() throws Exception{
		TipificacionDAO tipificacionDAO = new TipificacionDAO(dc_davivienda);
		return tipificacionDAO.obtenerTipificacion();
	}
	@Override
	public List<Tipificacion> obtenerTipoTipificacion() throws Exception {
		TipificacionDAO tipificacionDAO = new TipificacionDAO(dc_davivienda);
		return tipificacionDAO.obtenerTipoTipificacion();
	}

}
