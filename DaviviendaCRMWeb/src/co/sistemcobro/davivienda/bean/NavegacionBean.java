package co.sistemcobro.davivienda.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.session.LoginBean;

@ManagedBean(name = "navegacionBean")
@SessionScoped
public class NavegacionBean implements Serializable {
	private static final long serialVersionUID = 4545919119678482516L;

	private String ruta;
	private Integer pagina;
	private Integer tipificacion;
	private boolean render;

	public static final String redireccionInicio = "/pages/inicio/inicio.xhmtl?faces-redirect=true";
	public static final String redireccionInicio2 = "/DaviviendaCRMWeb/pages/inicio/inicio.xhmtl";
	public static final String redireccionGestion = "/pages/inicio/inicio.xhmtl?faces-redirect=true";
	public static final String redireccionUrl = "../../pages/obligacion/obligacion.xhtml";
	public static final String redireccionUrlBeneficiosObligacion = "../../pages/detalleObligacion/beneficiosObligacion.xhtml";

	@PostConstruct
	public void init() {
		pagina = 2;
		render = false;
	}

	public void redireccionarDatosCliente(String idCliente) throws Exception{
	    FacesContext.getCurrentInstance().getExternalContext().redirect(redireccionUrl+"?idcliente="+idCliente);
	}
	
	public void redireccionarBusquedaCliente() throws Exception{
	    FacesContext.getCurrentInstance().getExternalContext().redirect(redireccionInicio2);
	}
	
	public void redireccionarBeneficiosObligacion() throws Exception{
	    FacesContext.getCurrentInstance().getExternalContext().redirect(redireccionUrlBeneficiosObligacion);
	}
	
	
	public void redireccionFinGestion() throws Exception {
		tipificacion=0;
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		LoginBean loginBean = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("../../pages/finGestion/finGestion.xhtml?faces-redirect=true");
		// FacesContext.getCurrentInstance().getExternalContext().redirect("http://"+loginBean.getIpCliente()+":80/apiagentbox?action=chur&cod=LE&comm=FIN_LLAMADA");

	}

	public void redireccionBusquueda() throws Exception {
		pagina = 1;
		RequestContext.getCurrentInstance().update("frmBuscar:contenidoBusqueda");
	}

	public void redireccionFinNC() throws Exception {
		pagina = 8;
		RequestContext.getCurrentInstance().update("frmNoContacto:pnlNoContacto");
	}

	public void redireccionObligacion() throws Exception {
		pagina = 2;
		RequestContext.getCurrentInstance().update("contenido");
	}

	public void redireccionGestionNoContacto() throws Exception {
		tipificacion = 1;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionPromesa() throws Exception {
		tipificacion = 2;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionYaPago() throws Exception {
		tipificacion = 3;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionReclamo() throws Exception {
		tipificacion = 4;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionOtro() throws Exception {
		tipificacion = 5;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionTercero() throws Exception {
		tipificacion = 6;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionAcuerdoComite() throws Exception {
		tipificacion = 7;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public void redireccionGestionComite() throws Exception {
		tipificacion = 8;
		RequestContext.getCurrentInstance().update("pnlTipificacion");
		render = true;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getTipificacion() {
		return tipificacion;
	}

	public void setTipificacion(Integer tipificacion) {
		this.tipificacion = tipificacion;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

}
