package co.sistemcobro.davivienda.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;


import co.sistemcobro.davivienda.bean.Obligacion;
import co.sistemcobro.davivienda.dao.PagoDAO;
import co.sistemcobro.davivienda.ejb.IPagoEJBLocal;

@Stateless(name = "PagoEJB")
public class PagoEJB extends BaseEJB implements IPagoEJBLocal {
@Override
	public List<Obligacion> buscarPagoCliente(String idpago, List<Obligacion> pago) {
		List<Obligacion> listaPagoDTO = null;
		List<Obligacion> listapago = null;
		PagoDAO pagoDao = new PagoDAO(dc_davivienda);
		try {
			listaPagoDTO = pagoDao.buscarPagoCliente(idpago);

			for (Obligacion m : listaPagoDTO) {
				if (m.getObligacion().equals("9") || m.getObligacion().equals("10")) {
					listapago = pagoDao.buscarPagoCliente(m.getDescripcionPago());
					m.setObigaciones(listapago);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaPagoDTO;
	}

}