package co.sistemcobro.davivienda.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Memo;
import co.sistemcobro.davivienda.dao.MemoDAO;
import co.sistemcobro.davivienda.ejb.IMemoEJBLocal;

@Stateless(name = "MemoEJB")
public class MemoEJB extends BaseEJB implements IMemoEJBLocal {

	@Override
	public List<Memo> listaGestion(String idcliente, List<Memo> gestion) {
		List<Memo> listaGestionDTO = null;
		List<Memo> listaCompromisos = null;
		try {

			MemoDAO memoDao = new MemoDAO(dc_davivienda);

			listaGestionDTO = memoDao.buscarMemo(idcliente, gestion);

			for (Memo m : listaGestionDTO) {
				if (m.getIdTipificacion().equals("9") || m.getIdTipificacion().equals("10")) {					
					m.setFacturas(listaCompromisos);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

		return listaGestionDTO;
	}

}
