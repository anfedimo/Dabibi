package co.sistemcobro.davivienda.bean;

import java.io.IOException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.ejb.IClienteEJBLocal;
import co.sistemcobro.davivienda.ejb.IPagoEJBLocal;
import co.sistemcobro.davivienda.session.LoginBean;

@ManagedBean(name = "pagoBean")
@ViewScoped
public class PagoBean {

	private Obligacion obligacion;
	private Timestamp fechaPago;
	private String valorPagado;
	private String descripcionPago;
	private String nombreSucursal;
	private String idCargue;
	private String idIdentificacion;

	public List<Obligacion> getObligaciones() {
		return obligaciones;
	}

	public String getIdIdentificacion() {
		return idIdentificacion;
	}

	public void setIdIdentificacion(String idIdentificacion) {
		this.idIdentificacion = idIdentificacion;
	}

	private List<Obligacion> obligaciones;

	@EJB
	private IClienteEJBLocal clienteEJB;

	@EJB
	private IPagoEJBLocal pagoEJB;

	private ClienteBean clienteBean;
	private LoginBean loginBean;

	@ManagedProperty(value = "#{navegacionBean}")
	private NavegacionBean navegacionBean;

	private Logger logger = Logger.getLogger(PagoBean.class);
	

	


	@PostConstruct
	public void init() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
		    Application application = context.getApplication();
		    setClienteBean(application.evaluateExpressionGet(context,"#{clienteBean}", ClienteBean.class));
			idIdentificacion = new String();
			idCargue = new String();
			nombreSucursal = new String();
			obligaciones = new ArrayList<>();
			descripcionPago = new String();
			valorPagado = new String();
			fechaPago = null;
			obligacion = new Obligacion();
			this.pago();
			
		} catch (Exception e) {
			logger.error("No se puede inicializar el  pago del cliente: " + e.getMessage());
		}

	}

	public void pago() throws Exception {
		obligaciones = new ArrayList<>();
		String ididentificacion = idIdentificacion;
		obligaciones = pagoEJB.buscarPagoCliente(clienteBean.getCliente().getIdentificacion(), obligaciones);
		RequestContext.getCurrentInstance().update("frmPago:pnlPago");

	}

	public IClienteEJBLocal getClienteEJB() {
		return clienteEJB;
	}

	public void setClienteEJB(IClienteEJBLocal clienteEJB) {
		this.clienteEJB = clienteEJB;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public void reHacerGestion() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("www.google.com");
	}

	public Obligacion getObligacion() {
		return obligacion;
	}

	public void setObligacion(Obligacion obligacion) {
		this.obligacion = obligacion;
	}

	public Timestamp getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Timestamp fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getValorPagado() {
		return valorPagado;
	}

	public void setValorPagado(String valorPagado) {
		this.valorPagado = valorPagado;
	}

	public String getDescripcionPago() {
		return descripcionPago;
	}

	public void setDescripcionPago(String descripcionPago) {
		this.descripcionPago = descripcionPago;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getIdCargue() {
		return idCargue;
	}

	public void setIdCargue(String idCargue) {
		this.idCargue = idCargue;
	}

	public IPagoEJBLocal getPagoEJB() {
		return pagoEJB;
	}

	public void setPagoEJB(IPagoEJBLocal pagoEJB) {
		this.pagoEJB = pagoEJB;
	}

	public NavegacionBean getNavegacionBean() {
		return navegacionBean;
	}

	public void setNavegacionBean(NavegacionBean navegacionBean) {
		this.navegacionBean = navegacionBean;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	

	public void setObligaciones(List<Obligacion> obligaciones) {
		this.obligaciones = obligaciones;
	}

}
