package co.sistemcobro.davivienda.ejb.impl;

import java.util.List;
import javax.ejb.Stateless;
import co.sistemcobro.davivienda.bean.HistoricoObligacion;
import co.sistemcobro.davivienda.dao.HistoricoObligacionDAO;
import co.sistemcobro.davivienda.ejb.IHistoricoObligacionEJBLocal;

@Stateless
public class HistoricoObligacionEJB extends BaseEJB implements	IHistoricoObligacionEJBLocal {

	@Override
	public List<HistoricoObligacion> historico(String numeroObligacion) throws Exception {
		HistoricoObligacionDAO historicoDAO  = new HistoricoObligacionDAO(dc_davivienda);
		return historicoDAO.historicoObligacion(numeroObligacion);
	}

}
