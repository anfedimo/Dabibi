package co.sistemcobro.davivienda.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Gestion;
import co.sistemcobro.davivienda.dao.GestionDAO;
import co.sistemcobro.davivienda.ejb.IGestionEJBLocal;

@Stateless
public class GestionEJB extends BaseEJB implements IGestionEJBLocal {

	

	@Override
	public boolean insertarGestionRediferido(Gestion gestion) throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dg_davivienda);
		return gestionDAO.insertarGestionRediferido(gestion);
	}
	
	@Override
	public boolean insertarObligacionGestion(String idObligacion) throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dg_davivienda);
		return gestionDAO.insertarObligacionGestion(idObligacion);
	}
	
	@Override
	public String consultarObligacionIdentificacion(String identificacion) throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dc_davivienda);
		return gestionDAO.consultarObligacionIdentificacion(identificacion);
	}


}
