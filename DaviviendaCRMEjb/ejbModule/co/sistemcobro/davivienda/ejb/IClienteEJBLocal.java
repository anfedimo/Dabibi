package co.sistemcobro.davivienda.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Cliente;
import co.sistemcobro.davivienda.bean.Comite;
import co.sistemcobro.davivienda.bean.Obligacion;

/**
 * @author garaque
 *
 */
@Local
public interface IClienteEJBLocal {
	public List<Cliente> listaClientes(String filtro);

	public Cliente detalleCliente(Cliente cliente) throws Exception;

	public Cliente obligacionesCliente(Cliente cliente) throws Exception;
	
	public Cliente obligacionesClienteHoy(Cliente cliente) throws Exception;

	public Cliente getClienteById(int id);

}
