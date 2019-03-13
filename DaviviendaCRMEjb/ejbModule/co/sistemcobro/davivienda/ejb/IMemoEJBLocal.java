package co.sistemcobro.davivienda.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Memo;

@Local
public interface IMemoEJBLocal {
	
	public List<Memo> listaGestion(String idcliente, List<Memo> gestion);
	
}
