package co.sistemcobro.davivienda.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.davivienda.bean.Ciudad;
import co.sistemcobro.davivienda.bean.DatosAdicionales;
import co.sistemcobro.davivienda.bean.Departamento;
import co.sistemcobro.davivienda.bean.InformacionComplementaria;

@Local
public interface IDatosAdicionalesEJBLocal {
	public List<DatosAdicionales> listaDatosAdicionales(String idcliente);

	public List<InformacionComplementaria> listaInformacionComplementaria(String idcliente);

	public List<InformacionComplementaria> listaInformacionComplementaria2(String idcliente);

	public List<Departamento> buscarDepartamentos() throws Exception;

	public List<Ciudad> listadeciudades(String departamento);

	public DatosAdicionales detalleDatosAdicionales(DatosAdicionales datosAdicionales) throws Exception;

	List<InformacionComplementaria> buscarInformacionComplentariaPorId(String idcliente);
	
	public List<DatosAdicionales> listaAdicionales(String valor) throws Exception;

}
