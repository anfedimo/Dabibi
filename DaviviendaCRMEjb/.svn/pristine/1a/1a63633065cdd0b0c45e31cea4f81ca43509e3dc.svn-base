package co.sistemcobro.davivienda.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.ObligacionHoy;

@Local
public interface IDetallesObligacionesEJBLocal {
	public ObligacionHoy buscarDetallesObligacion(String idCliente, BigDecimal idObligacion) throws Exception;	
	public List<ObligacionHoy> obligacionesEnOtrasCampanas(String identificacion) throws Exception;
}
