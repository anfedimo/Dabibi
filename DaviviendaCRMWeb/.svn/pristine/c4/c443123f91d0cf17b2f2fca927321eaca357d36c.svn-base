package co.sistemcobro.davivienda.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.session.LoginBean;
import co.sistemcobro.davivienda.ejb.IClienteEJBLocal;
import co.sistemcobro.davivienda.ejb.IDatosAdicionalesEJBLocal;
import co.sistemcobro.davivienda.ejb.ITelefonoEJBLocal;

@ManagedBean(name = "DatosAdicionalesBean")
@ViewScoped
public class DatosAdicionalesBean {

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
	private List<DireccionTipo> tipodireccion;
	private List<DatosAdicionales> listaDatosAdiconales;
	private List<DatosAdicionales> listaAdiconales;
	List<Telefono> telefonos;
	List<InformacionComplementaria> informacionComplementaria;
	List<InformacionComplementaria> detalle;
	private String valorBuscar;

	private boolean tablaDetalle;

	private InformacionComplementaria informacionComplementaria_selected;

	@EJB
	private IClienteEJBLocal clienteEJB;
	@EJB
	private ITelefonoEJBLocal telefono;
	@EJB
	private IDatosAdicionalesEJBLocal datosAdicionalesEJB;

	private ClienteBean clienteBean;
	private LoginBean loginBean;

	private UsuarioAplicacion usuarioAplicacion;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			// mostrarDatosAdicionales();
			try {
				informacionComplementaria();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setearCampos() {
		nombre = "";
		idDepartamento = "";
		idCiudad = "";
		direccion = "";
		telefono1 = "";
		telefono2 = "";
		telefono3 = "";
		telefono4 = "";
		email = "";
		observacion = "";
	}

	public void buscarCliente() throws Exception {
		String dato = valorBuscar;
		listaAdiconales = datosAdicionalesEJB.listaAdicionales(dato);
		RequestContext.getCurrentInstance().update("frminformacionComplementaria:tablaDatos");
	}

	public void buscarClienteP(String dato) throws Exception {
		listaAdiconales = datosAdicionalesEJB.listaAdicionales(dato);
		RequestContext.getCurrentInstance().update("frminformacionComplementaria:tablaDatos");
	}

	public void limpiarCliente() throws Exception {
		valorBuscar = "";
		listaAdiconales = null;
		RequestContext.getCurrentInstance().update("frminformacionComplementaria:datoBuscar");
	}

	public void datosAdicionales() throws Exception {	
		departamentos = new ArrayList<Departamento>();
		departamentos = datosAdicionalesEJB.buscarDepartamentos();
		RequestContext.getCurrentInstance().update("frmDatosAdicion:pnlDatosAdicionales");
	}

	public void informacionComplementaria() throws Exception {
		informacionComplementaria = new ArrayList<InformacionComplementaria>();
		informacionComplementaria = datosAdicionalesEJB
				.listaInformacionComplementaria(clienteBean.getCliente().getIdcliente());
		detalle = new ArrayList<InformacionComplementaria>();
		detalle = datosAdicionalesEJB.listaInformacionComplementaria2(clienteBean.getCliente().getIdcliente());
		RequestContext.getCurrentInstance().update("frminformacionComplementaria:pnlinformacioncomplementaria");

		if (!informacionComplementaria.isEmpty()) {
			// mostrarDetallebyId(informacionComplementaria.get(0).getIdcargue());
		}
	}

	// informacionComplementaria_selected

	public void mostrarDatosAdicionales() {
		if (clienteBean != null && clienteBean.getCliente() != null) {
			informacionComplementaria = new ArrayList<InformacionComplementaria>();
			informacionComplementaria = datosAdicionalesEJB
					.buscarInformacionComplentariaPorId(clienteBean.getCliente().getIdcliente());

			listaDatosAdiconales = new ArrayList<DatosAdicionales>();
			listaDatosAdiconales = datosAdicionalesEJB.listaDatosAdicionales(clienteBean.getCliente().getIdcliente());
			RequestContext.getCurrentInstance().update("frmDatosAdicion:pnlTablaDatosAdicionales");
		}
	}

	public void onChangeDepartamento() throws Exception {
		ciudades = new ArrayList<Ciudad>();
		ciudades = datosAdicionalesEJB.listadeciudades(idDepartamento);
	}

	public void telefonos() throws Exception {
		//telefonos = telefono.listaTelefono(clienteBean.getCliente().getIdcliente());
		RequestContext.getCurrentInstance().update("pnlTelefonos");
	}

	public void capturarDatosAdicionales() throws Exception {
		System.out.println("usuario hermes : " + loginBean.getUsuarioHermes().getCodusuario());

		try {
			DatosAdicionales datos = new DatosAdicionales();
			datos.setIdentificacion(clienteBean.getCliente().getIdcliente());
			datos.setNombre(nombre);
			datos.setIdDepartamento(idDepartamento);
			datos.setIdCiudad(idCiudad);
			datos.setDireccion(direccion);
			datos.setTelefono1(telefono1);
			datos.setTelefono2(telefono2);
			datos.setTelefono3(telefono3);
			datos.setTelefono4(telefono4);
			datos.setEmail(email);
			datos.setObservacion(observacion);
			UsuarioAplicacion usuarioAplicacion = new UsuarioAplicacion();
			usuarioAplicacion.setIdusuario(loginBean.getUsuarioHermes().getCodusuario());
			datos.setUsuarioAplicacion(usuarioAplicacion);
			datosAdicionalesEJB.detalleDatosAdicionales(datos);
			mostrarDatosAdicionales();
		} catch (Exception e) {
			e.getMessage();
		} finally {

		}
		this.setearCampos();
		this.buscarClienteP(nombre);
//		FacesContext.getCurrentInstance().addMessage(null,
//				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se Insertaron Correctamente los Datos"));
		RequestContext.getCurrentInstance().update("frmDatosAdicion:pnlTablaDatosAdicionales");

	}

	public Cliente getCliente() {
		return cliente;
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

	public IDatosAdicionalesEJBLocal getDatosAdicionalesEJB() {
		return datosAdicionalesEJB;
	}

	public void setDatosAdicionalesEJB(IDatosAdicionalesEJBLocal datosAdicionalesEJB) {
		this.datosAdicionalesEJB = datosAdicionalesEJB;
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

	public void setListaDatosAdiconales(List<DatosAdicionales> listaDatosAdiconales) {
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

	public void setInformacionComplementaria_selected(InformacionComplementaria informacionComplementaria_selected) {
		this.informacionComplementaria_selected = informacionComplementaria_selected;
	}

	public List<InformacionComplementaria> getInformacionComplementaria() {
		return informacionComplementaria;
	}

	public void setInformacionComplementaria(List<InformacionComplementaria> informacionComplementaria) {
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

	public List<DatosAdicionales> getListaAdiconales() {
		return listaAdiconales;
	}

	public void setListaAdiconales(List<DatosAdicionales> listaAdiconales) {
		this.listaAdiconales = listaAdiconales;
	}

	public String getValorBuscar() {
		return valorBuscar;
	}

	public void setValorBuscar(String valorBuscar) {
		this.valorBuscar = valorBuscar;
	}

}
