package co.sistemcobro.davivienda.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.davivienda.bean.Cliente;
import co.sistemcobro.davivienda.bean.Comite;
import co.sistemcobro.davivienda.bean.Obligacion;

import co.sistemcobro.davivienda.dao.ClienteDAOImplDavivienda;
import co.sistemcobro.davivienda.ejb.IClienteEJBLocal;

/**
 * @author garaque
 *
 */
@Stateless(name = "ClienteEJB")
public class ClienteEJB extends BaseEJB implements IClienteEJBLocal {

	public ClienteEJB() {

	}

	/**
	 * <p>
	 * Metodo que retorna una lista al bean de todos los clientes de la tabla
	 * priorizacion.cliente
	 * </p>
	 * 
	 * @author Nestor Leonel Osorio Tovar- Sistemcobro S.A.S (21/09/2016)
	 * @param priorizacionDTO-
	 *            objeto DTO a insertar
	 * @return
	 * @throws DatoException-
	 *             Se lanza cuando hay un error al consultar en la BD
	 */
	@Override
	public List<Cliente> listaClientes(String filtro) {
		List<Cliente> listaClienteDTO = null;
		ClienteDAOImplDavivienda ClienteDao = new ClienteDAOImplDavivienda(dc_davivienda);
		try {
			listaClienteDTO = ClienteDao.buscarClientes(filtro);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaClienteDTO;
	}

	@Override
	public Cliente getClienteById(int id) {

		return null;
	}

	@Override
	public Cliente detalleCliente(Cliente cliente) throws Exception {

		ClienteDAOImplDavivienda ClienteDao = new ClienteDAOImplDavivienda(dc_davivienda);
				
		return ClienteDao.buscarDetalleClientes(cliente);
	}

	@Override
	public Cliente obligacionesCliente(Cliente cliente) throws Exception {
		ClienteDAOImplDavivienda ClienteDao = new ClienteDAOImplDavivienda(dc_davivienda);

		return ClienteDao.buscarObligacionesCLiente(cliente);
	}



	@Override
	public Cliente obligacionesClienteHoy(Cliente cliente) throws Exception {
		ClienteDAOImplDavivienda ClienteDao = new ClienteDAOImplDavivienda(dc_davivienda);
	    return ClienteDao.buscarObligacionesHoyCliente(cliente);
	}

	

}
