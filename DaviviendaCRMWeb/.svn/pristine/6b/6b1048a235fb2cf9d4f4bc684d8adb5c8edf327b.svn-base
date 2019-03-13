package co.sistemcobro.davivienda.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.constante.ColumnaValorEnum;
import co.sistemcobro.davivienda.ejb.IClienteEJBLocal;
import co.sistemcobro.davivienda.ejb.IDatosAdicionalesEJBLocal;
import co.sistemcobro.davivienda.ejb.IMemoEJBLocal;
import co.sistemcobro.davivienda.ejb.ITelefonoEJBLocal;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1250355351622573445L;

	private Cliente cliente;
	private Gestion gestion;
	private List<Memo> gestiones;
	private List<Departamento> departamentos;
	private List<Ciudad> ciudades;
	private String idDepartamento;
	private String idCiudad;
	private String idllamada;
	private String idTipoDireccion;
	private List<DireccionTipo> tipodireccion;
	private BigDecimal cobroAcuerdo;
	private String valorAnadir;
	private List<String> facturas;
	private BigDecimal valorCobro;
	private List<FacturaGestion> facturasGestion;
	private String idgestion;
	private String idcliente;
	private String mesajeError;
	private boolean comiteAbierto;
	private boolean comiteAprobado;
	private String telefonoMarcado;
	private Date fechaInicio;
	private String idCall;
	private String connected_call;
	private List<Obligacion> pagos;

	@EJB
	private IClienteEJBLocal clienteEJB;

	@EJB
	private IMemoEJBLocal memoEJB;
	@EJB
	private ITelefonoEJBLocal telefono;
	@EJB
	private IDatosAdicionalesEJBLocal datosAdicionalesEJB;

	@ManagedProperty(value = "#{navegacionBean}")
	private NavegacionBean navegacionBean;

	private Logger logger = Logger.getLogger(ClienteBean.class);

	@PostConstruct
	public void init() {
		try {
			comiteAbierto = false;
			comiteAprobado = false;
			facturasGestion = new ArrayList<>();
			valorCobro = new BigDecimal(0);
			fechaInicio = new Date();
			telefonoMarcado = null;
			cliente = new Cliente();
			gestion = new Gestion();
			this.datosCliente();
		} catch (Exception e) {
			logger.error("No se puede inicializar datos del cliente: " + e.getMessage());
		}

	}

	public void datosCliente() throws Exception {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String idCliente = (String) request.getParameter("idcliente");
		idgestion = (String) request.getParameter("idgestion");
		idCall = (String) request.getParameter("id_call");
		connected_call = (String) request.getParameter("connected_call");

		cliente.setIdcliente(idCliente);

		if (connected_call != null) {
			if (!connected_call.isEmpty()) {
				this.setTelefonoMarcado(connected_call.replace("9", ""));
			}
		}

		clienteEJB.detalleCliente(cliente);
		clienteEJB.obligacionesCliente(cliente);
		clienteEJB.obligacionesClienteHoy(cliente);
		valorCobro = new BigDecimal(0);
		

		// return navegacionBean.redireccionUrl;
	}

	public void calcularCobro() {
		valorCobro = new BigDecimal(0);

		for (String fac : facturas) {
			valorCobro = valorCobro.add(new BigDecimal(fac));

		}

	}

	public void error() {
		RequestContext.getCurrentInstance().execute("PF('dlg1').show();");
	}

	public void errorTotalCartera() {
		RequestContext.getCurrentInstance().execute("PF('dlg1').show();");
	}

	public void cambioValor2(Obligacion obligacion) {
		mesajeError = null;

		if (obligacion.istCartera()) {
			mesajeError = "No puede generar este cobro porque Total Cartera esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setcCorriente(false);
			return;
		}

		if (obligacion.istHonInt()) {
			mesajeError = "No puede generar este cobro porque Total Mora + Hon esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setcCorriente(false);
			return;
		}

		if (obligacion.iscCorriente()) {
			valorCobro = valorCobro.add(obligacion.getCarteraCorriente());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.CARTERACORRIENTE.getIndex());
			fc.setValor(obligacion.getCarteraCorriente());
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getCarteraCorriente());
			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.CARTERACORRIENTE.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}

	public void cambioValor3(Obligacion obligacion) {
		mesajeError = null;
		if (obligacion.istCartera()) {
			mesajeError = "No puede generar este cobro porque Total Cartera Esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setcVencida(false);
			return;
		}

		if (obligacion.istHonInt()) {
			mesajeError = "No puede generar este cobro porque Total Mora + Hon Esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setcVencida(false);
			return;
		}

		if (obligacion.iscVencida()) {
			valorCobro = valorCobro.add(obligacion.getCarteraVencida());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.CARTERAVENCIDA.getIndex());
			fc.setValor(obligacion.getCarteraVencida());
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getCarteraVencida());
			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.CARTERAVENCIDA.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}

	public void cambioValor4(Obligacion obligacion) {
		mesajeError = null;

		if (obligacion.istHonInt()) {
			mesajeError = "No puede generar este cobro porque Total Mora + Hon Esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.settCartera(false);
			return;
		}
		if (obligacion.iscCorriente() && obligacion.iscVencida()) {
			mesajeError = "No puede generar este cobro porque Cartera Corriente  y Cartera Vencida Esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.settCartera(false);
			return;

		} else {
			if (obligacion.iscCorriente()) {
				mesajeError = "No puede generar este cobro porque Cartera Corriente Esta cobrado!";
				error();
				RequestContext.getCurrentInstance().update("obligaciones");
				obligacion.settCartera(false);
				return;
			}
			if (obligacion.iscVencida()) {
				mesajeError = "No puede generar este cobro porque Cartera Vencida hace parte de la  Total Cartera !";
				error();
				RequestContext.getCurrentInstance().update("obligaciones");
				obligacion.settCartera(false);
				return;
			}
		}

		if (obligacion.istCartera()) {
			valorCobro = valorCobro.add(obligacion.getTotalCartera());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.TOTALCARTERA.getIndex());
			fc.setValor(obligacion.getTotalCartera());
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getTotalCartera());
			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.TOTALCARTERA.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}

	public void cambioValor5(Obligacion obligacion) {
		mesajeError = null;
		if (obligacion.istHonInt()) {
			mesajeError = "No puede generar este cobro porque Total Mora + Hon Esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setIntMora(false);
			return;
		}

		if (obligacion.isIntMora()) {
			valorCobro = valorCobro.add(obligacion.getInteresesMora());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.INTERESESMORA.getIndex());
			fc.setValor(obligacion.getInteresesMora());
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getInteresesMora());

			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.INTERESESMORA.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}

	public void cambioValor6(Obligacion obligacion) {

		if (obligacion.istHonInt()) {
			mesajeError = "No puede generar este cobro porque Total Mora + Hon Esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setVlrHon(false);
			return;
		}

		if (obligacion.isVlrHon()) {
			valorCobro = valorCobro.add(obligacion.getHonorariosCobrados());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.HONORARIOSCOBRADOS.getIndex());
			fc.setValor(obligacion.getHonorariosCobrados());
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getHonorariosCobrados());
			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.HONORARIOSCOBRADOS.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}

			else {
				if (obligacion.istCartera() == true && obligacion.istHonInt() == false) {
					obligacion.setVlrFactIva(false);
					obligacion.setcCorriente(false);
					obligacion.setcVencida(false);
					obligacion.settObl(false);
					RequestContext.getCurrentInstance().update("obligaciones");
					return;
				}
			}
		}
	}

	public void cambioValor7(Obligacion obligacion) {
		mesajeError = null;
		if (obligacion.istCartera()) {
			mesajeError = "No puede generar este cobro porque Total Cartera Esta cobrado!";
			obligacion.settHonInt(false);
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			return;
		}
		if (obligacion.iscCorriente()) {
			mesajeError = "No puede generar este cobro porque Cartera Corriente Esta cobrado!";
			obligacion.settHonInt(false);
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			return;
		}
		if (obligacion.iscVencida()) {
			mesajeError = "No puede generar este cobro porque Cartera Vencida Esta cobrado!";
			obligacion.settHonInt(false);
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			return;
		}
		//
		if (obligacion.isIntMora()) {
			mesajeError = "No puede generar este cobro porque Int Mora Esta cobrado!";
			obligacion.settHonInt(false);
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			return;

		}
		if (obligacion.isVlrHon()) {
			mesajeError = "No puede generar este cobro porque Honorarios Cobrados Esta cobrado!";
			obligacion.settHonInt(false);
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			return;

		}

		if (obligacion.istHonInt()) {
			valorCobro = valorCobro.add(obligacion.getTotalMoraHonorarios());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.TOTALMORAHONORARIOS.getIndex());
			fc.setValor(obligacion.getTotalMoraHonorarios());
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getTotalMoraHonorarios());
			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.TOTALMORAHONORARIOS.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}

	public void memo() throws Exception {
		gestiones = new ArrayList<>();
		memoEJB.listaGestion(cliente.getIdcliente(), gestiones);
		RequestContext.getCurrentInstance().update("frmMemo:pnlMemo");

	}

	public void reHacerGestion() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("www.google.com");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public NavegacionBean getNavegacionBean() {
		return navegacionBean;
	}

	public void setNavegacionBean(NavegacionBean navegacionBean) {
		this.navegacionBean = navegacionBean;
	}

	public List<Memo> getGestiones() {
		return gestiones;
	}

	public void setGestiones(List<Memo> gestiones) {
		this.gestiones = gestiones;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public String getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public List<DireccionTipo> getTipodireccion() {
		return tipodireccion;
	}

	public void setTipodireccion(List<DireccionTipo> tipodireccion) {
		this.tipodireccion = tipodireccion;
	}

	public String getIdTipoDireccion() {
		return idTipoDireccion;
	}

	public void setIdTipoDireccion(String idTipoDireccion) {
		this.idTipoDireccion = idTipoDireccion;
	}

	public BigDecimal getCobroAcuerdo() {
		return cobroAcuerdo;
	}

	public void setCobroAcuerdo(BigDecimal cobroAcuerdo) {
		this.cobroAcuerdo = cobroAcuerdo;
	}

	public String getValorAnadir() {
		return valorAnadir;
	}

	public void setValorAnadir(String valorAnadir) {
		this.valorAnadir = valorAnadir;
	}

	public List<String> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<String> facturas) {
		this.facturas = facturas;
	}

	public BigDecimal getValorCobro() {
		return valorCobro;
	}

	public void setValorCobro(BigDecimal valorCobro) {
		this.valorCobro = valorCobro;
	}

	public List<FacturaGestion> getFacturasGestion() {
		return facturasGestion;
	}

	public void setFacturasGestion(List<FacturaGestion> facturasGestion) {
		this.facturasGestion = facturasGestion;
	}

	public String getIdgestion() {
		return idgestion;
	}

	public void setIdgestion(String idgestion) {
		this.idgestion = idgestion;
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public ITelefonoEJBLocal getTelefono() {
		return telefono;
	}

	public void setTelefono(ITelefonoEJBLocal telefono) {
		this.telefono = telefono;
	}

	public String getMesajeError() {
		return mesajeError;
	}

	public void setMesajeError(String mesajeError) {
		this.mesajeError = mesajeError;
	}

	public boolean isComiteAprobado() {
		return comiteAprobado;
	}

	public void setComiteAprobado(boolean comiteAprobado) {
		this.comiteAprobado = comiteAprobado;
	}

	public boolean isComiteAbierto() {
		return comiteAbierto;
	}

	public void setComiteAbierto(boolean comiteAbierto) {
		this.comiteAbierto = comiteAbierto;
	}

	public String getTelefonoMarcado() {
		return telefonoMarcado;
	}

	public void setTelefonoMarcado(String telefonoMarcado) {
		this.telefonoMarcado = telefonoMarcado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getIdllamada() {
		return idllamada;
	}

	public void setIdllamada(String idllamada) {
		this.idllamada = idllamada;
	}

	public String getIdCall() {
		return idCall;
	}

	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}

	public String getConnected_call() {
		return connected_call;
	}

	public void setConnected_call(String connected_call) {
		this.connected_call = connected_call;
	}

	public List<Obligacion> getPagos() {
		return pagos;
	}

	public void setPagos(List<Obligacion> pagos) {
		this.pagos = pagos;
	}

}