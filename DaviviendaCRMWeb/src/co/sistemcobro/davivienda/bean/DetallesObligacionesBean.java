package co.sistemcobro.davivienda.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.session.LoginBean;
import co.sistemcobro.davivienda.ejb.IClienteEJBLocal;
import co.sistemcobro.davivienda.ejb.IDetallesObligacionesEJBLocal;
import co.sistemcobro.davivienda.ejb.ITelefonoEJBLocal;

@ManagedBean(name = "DetallesObligacionesBean")
@ViewScoped
public class DetallesObligacionesBean {

	private Cliente cliente;
	private List<Departamento> departamentos;
	private List<Ciudad> ciudades;
	private String nombre;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String telefono3;
	private String telefono4;
	private String email;
	private String datosAdicionales;
	private String idDepartamento;
	private String idCiudad;
	private String idTipoDireccion;
	private Integer contactoTipo;
	private String identificacion;
	private String valor;
	private String observacion;
	private String estado;
	private String idgrupotipo;
	private ObligacionHoy obligacionHoy;
	private List<DireccionTipo> tipodireccion;
	private List<DatosAdicionales> listaDatosAdiconales;
	List<Telefono> telefonos;
	List<InformacionComplementaria> informacionComplementaria;
	List<InformacionComplementaria> detalle;
	private boolean tablaDetalle;
	private int opcion;
	private String idObligacion;
	
	private int opcionPrincipal;

	private InformacionComplementaria informacionComplementaria_selected;

	@EJB
	private IClienteEJBLocal clienteEJB;
	@EJB
	private ITelefonoEJBLocal telefono;
	@EJB
	private IDetallesObligacionesEJBLocal detalleObligacionEJB;

	private ClienteBean clienteBean;
	private LoginBean loginBean;

	private UsuarioAplicacion usuarioAplicacion;
	

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setClienteBean(application.evaluateExpressionGet(context,"#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context,	"#{loginBean}", LoginBean.class));
			//mostrarDatosAdicionales();
			cliente = new Cliente();
			opcion = 0;
			try {
				//informacionComplementaria();
				this.detalleObligacionesCliente();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void detalleObligacionesCliente() throws Exception {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String idCliente = (String)request.getParameter("idcliente");
		
		cliente.setIdcliente(idCliente);
		clienteEJB.detalleCliente(cliente);
		clienteEJB.obligacionesCliente(cliente);
		clienteEJB.obligacionesClienteHoy(cliente);
		//obligacionHoy = detalleObligacionEJB.buscarDetallesObligacion(cliente.getIdcliente(), cliente.getObligacionesHoy().get(1).getIdObligacion());
		//RequestContext.getCurrentInstance().update("frmDetallesObligacion:pnldetalleObligacion");
	}
	
	
	public void establecerOpcion(int opcion){
		this.opcion = opcion;
	}
	

	
	public void rediferidoTasaPreferencial(int opcion2){
		this.opcion = opcion2;
	}	
	
	public void rediferidoNormalDolares(int opcion3){
		this.opcion = opcion3;		
	}
	
	public void daviacuerdo(int opcion4){
		this.opcion = opcion4;		
	}
	
	public void pagoTotalConsumo(int opcion5){
		this.opcion = opcion5;
	}
	
	public void pagoTotalConsumoCastigado(int opcion6){
		this.opcion = opcion6;
	}
	
	
	public void bonoZanahoria(int opcion){
		this.opcion = opcion;
	}
	
	public void normalizacion(int opcion){
		this.opcion = opcion;
	}
	
	public void normalizacionTasaEscalonada(int opcion){
		this.opcion = opcion;
	}
	
	public void acuerdoPagoCarteraCastigadaConsumo(int opcion){
		this.opcion = opcion;
	}
	
	public void normalizacionVirtual(int opcion){
		this.opcion = opcion;
	}
	
	
		
	public void detalleObligacion(String idCliente, BigDecimal idObligacion) throws Exception {
		obligacionHoy = detalleObligacionEJB.buscarDetallesObligacion(idCliente, idObligacion);		
		RequestContext.getCurrentInstance().update("frmDetallesObligacion");
		this.verPrincipal(1);
	}
	
	public void verPrincipal(int opcion){
		opcionPrincipal = opcion;
		RequestContext.getCurrentInstance().update("principal");
	}

	public Cliente getCliente() {
		return cliente;
	}
	

	public int getOpcion() {
		return opcion;
	}
	
	
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getIdTipoDireccion() {
		return idTipoDireccion;
	}

	public void setIdTipoDireccion(String idTipoDireccion) {
		this.idTipoDireccion = idTipoDireccion;
	}

	public List<DireccionTipo> getTipodireccion() {
		return tipodireccion;
	}

	public void setTipodireccion(List<DireccionTipo> tipodireccion) {
		this.tipodireccion = tipodireccion;
	}

	public IClienteEJBLocal getClienteEJB() {
		return clienteEJB;
	}

	public void setClienteEJB(IClienteEJBLocal clienteEJB) {
		this.clienteEJB = clienteEJB;
	}

	public ITelefonoEJBLocal getTelefono() {
		return telefono;
	}

	public void setTelefono(ITelefonoEJBLocal telefono) {
		this.telefono = telefono;
	}


	public IDetallesObligacionesEJBLocal getDetalleObligacionesEJB() {
		return detalleObligacionEJB;
	}

	public void setDetalleObligacionesEJB(IDetallesObligacionesEJBLocal detalleObligacionEJB) {
		this.detalleObligacionEJB = detalleObligacionEJB;
	}


	public Integer getContactoTipo() {
		return contactoTipo;
	}

	public void setContactoTipo(Integer contactoTipo) {
		this.contactoTipo = contactoTipo;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public List<DatosAdicionales> getListaDatosAdiconales() {
		return listaDatosAdiconales;
	}

	public void setListaDatosAdiconales(
			List<DatosAdicionales> listaDatosAdiconales) {
		this.listaDatosAdiconales = listaDatosAdiconales;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdgrupotipo() {
		return idgrupotipo;
	}

	public void setIdgrupotipo(String idgrupotipo) {
		this.idgrupotipo = idgrupotipo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public String getTelefono4() {
		return telefono4;
	}

	public void setTelefono4(String telefono4) {
		this.telefono4 = telefono4;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
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

	public UsuarioAplicacion getUsuarioAplicacion() {
		return usuarioAplicacion;
	}

	public void setUsuarioAplicacion(UsuarioAplicacion usuarioAplicacion) {
		this.usuarioAplicacion = usuarioAplicacion;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public InformacionComplementaria getInformacionComplementaria_selected() {
		return informacionComplementaria_selected;
	}

	public void setInformacionComplementaria_selected(
			InformacionComplementaria informacionComplementaria_selected) {
		this.informacionComplementaria_selected = informacionComplementaria_selected;
	}

	public List<InformacionComplementaria> getInformacionComplementaria() {
		return informacionComplementaria;
	}

	public void setInformacionComplementaria(
			List<InformacionComplementaria> informacionComplementaria) {
		this.informacionComplementaria = informacionComplementaria;
	}

	public List<InformacionComplementaria> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<InformacionComplementaria> detalle) {
		this.detalle = detalle;
	}

	public boolean isTablaDetalle() {
		return tablaDetalle;
	}

	public void setTablaDetalle(boolean tablaDetalle) {
		this.tablaDetalle = tablaDetalle;
	}

	public ObligacionHoy getObligacionHoy() {
		return obligacionHoy;
	}

	public void setObligacionHoy(ObligacionHoy obligacionHoy) {
		this.obligacionHoy = obligacionHoy;
	}

	public IDetallesObligacionesEJBLocal getDetalleObligacionEJB() {
		return detalleObligacionEJB;
	}

	public void setDetalleObligacionEJB(IDetallesObligacionesEJBLocal detalleObligacionEJB) {
		this.detalleObligacionEJB = detalleObligacionEJB;
	}

	public String getIdObligacion() {
		return idObligacion;
	}

	public void setIdObligacion(String idObligacion) {
		this.idObligacion = idObligacion;
	}

	public int getOpcionPrincipal() {
		return opcionPrincipal;
	}

	public void setOpcionPrincipal(int opcionPrincipal) {
		this.opcionPrincipal = opcionPrincipal;
	}

	

}
