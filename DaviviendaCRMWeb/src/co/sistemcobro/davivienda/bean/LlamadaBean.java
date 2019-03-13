package co.sistemcobro.davivienda.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.ejb.IDetallesObligacionesEJBLocal;
import co.sistemcobro.davivienda.ejb.ITelefonoEJBLocal;
import co.sistemcobro.davivienda.session.LoginBean;

@ManagedBean(name = "llamadaBean")
@ViewScoped
public class LlamadaBean implements Serializable {

	@EJB
	private ITelefonoEJBLocal telefonoEJB;
	@EJB
	private IDetallesObligacionesEJBLocal detalleObligacionEJB;

	private static final long serialVersionUID = 1L;
	private ClienteBean clienteBean;
	private LoginBean loginBean;

	private Telefono telefono;
	private int opcionLlamada;
	private String telefonoContactabilidad;
	private String telefonoAsignacion;
	private List<ObligacionHoy> obligacionesOtrasCampanas;
	private List<Telefono> telefonosAsignacion;
	private List<Telefono> telefonosContactabilidad;
	private List<Telefono> telefonosRetirados;

	private ClienteBean cliente;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			cliente = application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class);

			try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// **************métodos********************//////
	public void metodoLlamada(int opcion) {
		String identificacion = cliente.getCliente().getIdentificacion();
		try {
			opcionLlamada = opcion;
			telefonosAsignacion = telefonoEJB.listaTelefonosAsignacion(identificacion);
			telefonosContactabilidad = telefonoEJB.listaTelefonosContactabilidad(identificacion);
			telefonosRetirados = telefonoEJB.listaTelefonosRetirados(identificacion);
			// obligacionesOtrasCampanas =
			// detalleObligacionEJB.obligacionesEnOtrasCampanas(identificacion);

			RequestContext.getCurrentInstance().update("frmLlamar");
			RequestContext.getCurrentInstance().update("llamadas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiarCampoContactabilidad(){
		telefonoContactabilidad = "";
		RequestContext.getCurrentInstance().update("frmLlamar:panelLlamar");
	}

	public void pasarTelefonoContactabilidad(String telefono) {
		telefonoContactabilidad = telefono;
		RequestContext.getCurrentInstance().update("frmLlamar:panelLlamar");
	}

	public void pasarTelefonoAsignacion(String telefono) {
		telefonoAsignacion = telefono;
		RequestContext.getCurrentInstance().update("frmLlamar:panelLlamar");
	}

	//// ************get and set*****************/////
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

	public ITelefonoEJBLocal getTelefonoEJB() {
		return telefonoEJB;
	}

	public void setTelefonoEJB(ITelefonoEJBLocal telefonoEJB) {
		this.telefonoEJB = telefonoEJB;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Telefono> getTelefonosAsignacion() {
		return telefonosAsignacion;
	}

	public void setTelefonosAsignacion(List<Telefono> telefonosAsignacion) {
		this.telefonosAsignacion = telefonosAsignacion;
	}

	public List<Telefono> getTelefonosContactabilidad() {
		return telefonosContactabilidad;
	}

	public void setTelefonosContactabilidad(List<Telefono> telefonosContactabilidad) {
		this.telefonosContactabilidad = telefonosContactabilidad;
	}

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	public List<Telefono> getTelefonosRetirados() {
		return telefonosRetirados;
	}

	public void setTelefonosRetirados(List<Telefono> telefonosRetirados) {
		this.telefonosRetirados = telefonosRetirados;
	}

	public IDetallesObligacionesEJBLocal getDetalleObligacionEJB() {
		return detalleObligacionEJB;
	}

	public void setDetalleObligacionEJB(IDetallesObligacionesEJBLocal detalleObligacionEJB) {
		this.detalleObligacionEJB = detalleObligacionEJB;
	}

	public List<ObligacionHoy> getObligacionesOtrasCampanas() {
		return obligacionesOtrasCampanas;
	}

	public void setObligacionesOtrasCampanas(List<ObligacionHoy> obligacionesOtrasCampanas) {
		this.obligacionesOtrasCampanas = obligacionesOtrasCampanas;
	}

	public int getOpcionLlamada() {
		return opcionLlamada;
	}

	public void setOpcionLlamada(int opcionLlamada) {
		this.opcionLlamada = opcionLlamada;
	}

	public String getTelefonoContactabilidad() {
		return telefonoContactabilidad;
	}

	public void setTelefonoContactabilidad(String telefonoContactabilidad) {
		this.telefonoContactabilidad = telefonoContactabilidad;
	}

	public String getTelefonoAsignacion() {
		return telefonoAsignacion;
	}

	public void setTelefonoAsignacion(String telefonoAsignacion) {
		this.telefonoAsignacion = telefonoAsignacion;
	}

}
