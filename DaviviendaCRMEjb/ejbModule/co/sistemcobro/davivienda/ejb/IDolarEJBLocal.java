package co.sistemcobro.davivienda.ejb;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Dolar;

@Local
public interface IDolarEJBLocal {
	
	public Dolar consultarDolar() throws Exception; 
}
