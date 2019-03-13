package co.sistemcobro.davivienda.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Dolar;
import co.sistemcobro.davivienda.dao.DolarDAO;
import co.sistemcobro.davivienda.ejb.IDolarEJBLocal;

@Stateless
public class DolarEJB extends BaseEJB implements IDolarEJBLocal{

	@Override
	public Dolar consultarDolar() throws Exception {
		DolarDAO dolarDAO = new DolarDAO(dc_davivienda);
		return dolarDAO.consultarDolar();
	}

}
