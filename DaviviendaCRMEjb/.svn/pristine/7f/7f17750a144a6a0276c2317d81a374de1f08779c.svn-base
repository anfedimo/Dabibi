package co.sistemcobro.davivienda.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

import co.sistemcobro.davivienda.bean.Ciudad;
import co.sistemcobro.davivienda.bean.DatosAdicionales;
import co.sistemcobro.davivienda.bean.Departamento;
import co.sistemcobro.davivienda.bean.InformacionComplementaria;
import co.sistemcobro.davivienda.constante.DatosAdicionalesEnum;
import co.sistemcobro.davivienda.dao.CiudadDAO;
import co.sistemcobro.davivienda.dao.DatosAdicionalesDAO;
import co.sistemcobro.davivienda.dao.DepartamentoDAO;
import co.sistemcobro.davivienda.ejb.IDatosAdicionalesEJBLocal;

@Stateless
public class DatosAdicionalesEJB extends BaseEJB implements IDatosAdicionalesEJBLocal {

	
	// @Override
	// public List<InformacionComplementaria> listaDatosAdicionales(String
	// idcliente) {
	// List<InformacionComplementaria> listaDatosAdicional = null;
	// DatosAdicionalesDAO datosAdicionalesDAO = new
	// DatosAdicionalesDAO(dc_davivienda);
	// try {
	// listaDatosAdicional =
	// datosAdicionalesDAO.buscarInformacionComplentariaPorId(idcliente);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return listaDatosAdicional;
	// }
	@Override
	public List<InformacionComplementaria> listaInformacionComplementaria(String idcliente) {
		List<InformacionComplementaria> listaInfo = null;

		DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dc_davivienda);
		try {
			listaInfo = datosAdicionalesDAO.buscarInformacionComplentaria(idcliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaInfo;
	}

	@Override
	public List<InformacionComplementaria> listaInformacionComplementaria2(String idcliente) {
		List<InformacionComplementaria> listaInfo = null;

		DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dc_davivienda);
		try {
			listaInfo = datosAdicionalesDAO.buscarInformacionComplentaria2(idcliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaInfo;
	}

	//
	@Override
	public List<InformacionComplementaria> buscarInformacionComplentariaPorId(String idcliente) {
		List<InformacionComplementaria> listaInfo = null;

	//	DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dc_davivienda);
		try {
		//listaInfo = datosAdicionalesDAO.buscarInformacionComplentariaPorId(idcliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaInfo;
	}

	@Override
	public List<Ciudad> listadeciudades(String departamento) {
		List<Ciudad> ciudades = null;
		CiudadDAO ciudadDAO = new CiudadDAO(dc_davivienda);

		try {
			ciudades = ciudadDAO.buscarCiudadespordepartamento(departamento);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ciudades;
	}

	@Override
	public DatosAdicionales detalleDatosAdicionales(DatosAdicionales datosAdicionales) throws Exception {
		DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dg_davivienda);

		if (StringUtils.isNotBlank(datosAdicionales.getNombre())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Nombre.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getIdDepartamento())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales,
					DatosAdicionalesEnum.Departamento.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getIdCiudad())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Ciudad.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getIdTipoDireccion())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales,
					DatosAdicionalesEnum.DireccionTipo.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getDireccion())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Direccion.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getTelefono1())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Telefono1.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getTelefono2())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Telefono2.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getTelefono3())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Telefono3.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getTelefono4())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Telefono4.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getEmail())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales, DatosAdicionalesEnum.Email.getIndex());
		}
		if (StringUtils.isNotBlank(datosAdicionales.getDatosAdicionales())) {
			datosAdicionalesDAO.insertarDatosAdicionales(datosAdicionales,
					DatosAdicionalesEnum.AutorizacionDatos.getIndex());
		}

		return null;
	}

	@Override
	public List<DatosAdicionales> listaDatosAdicionales(String idcliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DatosAdicionales> listaAdicionales(String valor) throws Exception {
		DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dc_davivienda);
		return datosAdicionalesDAO.buscarDatosAdicionales(valor);
	}

	@Override
	public List<Departamento> buscarDepartamentos() throws Exception {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO(dc_davivienda);
		return departamentoDAO.buscarDepartamentos();
	}

}
