package co.sistemcobro.davivienda.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Telefono;
import co.sistemcobro.davivienda.dao.TelefonoDAO;
import co.sistemcobro.davivienda.ejb.ITelefonoEJBLocal;

@Stateless(name = "TelefonoEJB")
public class TelefonoEJB extends BaseEJB implements ITelefonoEJBLocal {


	@Override
	public List<Telefono> listaTelefonosAsignacion(String identificacion) throws Exception {
		TelefonoDAO telefonoDAO = new TelefonoDAO(dc_davivienda);
		return telefonoDAO.listaTelefonosAsignacion(identificacion);
	}

	@Override
	public List<Telefono> listaTelefonosContactabilidad(String identificacion) throws Exception {
		TelefonoDAO telefonoDAO = new TelefonoDAO(dc_davivienda);
		return telefonoDAO.listaTelefonosContactabilidad(identificacion);
	}

	@Override
	public List<Telefono> listaTelefonosRetirados(String identificacion) throws Exception {
		TelefonoDAO telefonoDAO = new TelefonoDAO(dc_davivienda);
		return telefonoDAO.listaTelefonosRetirados(identificacion);
	}
	
	

	
}
