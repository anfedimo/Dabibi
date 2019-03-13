package co.sistemcobro.davivienda.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DatosAdicionales {
	private Integer contactoTipo;
	private String identificacion;
	private String valor;
	private String observacion;
	private String idusuarioCrea;
	private Integer estado;
	private String nombre;
	private String idDepartamento;
	private String idCiudad;
	private String idTipoDireccion;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String telefono3;
	private String telefono4;
	private String email;
	private String datosAdicionales;
	private String fechaCrea;
	private Date fechaCreacion;
	private String telefono;
	private String tipoDato;
	GrupoTipo grupoTipo;
	UsuarioAplicacion usuarioAplicacion;

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public GrupoTipo getGrupoTipo() {
		return grupoTipo;
	}

	public void setGrupoTipo(GrupoTipo grupoTipo) {
		this.grupoTipo = grupoTipo;
	}

	public UsuarioAplicacion getUsuarioAplicacion() {
		return usuarioAplicacion;
	}

	public void setUsuarioAplicacion(UsuarioAplicacion usuarioAplicacion) {
		this.usuarioAplicacion = usuarioAplicacion;
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

	public String getIdusuarioCrea() {
		return idusuarioCrea;
	}

	public void setIdusuarioCrea(String idusuarioCrea) {
		this.idusuarioCrea = idusuarioCrea;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public String getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(String fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public Date getFechaCreacion() throws ParseException {
		if (StringUtils.isNotBlank(fechaCrea)) {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			fechaCreacion = formato.parse(fechaCrea);
		}

		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
