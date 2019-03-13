/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sistemcobro.davivienda.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author jhurtado
 */
public class Comite implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private List<Obligacion> obligacionesComite;
	
	private Integer idcomiterevision;

	private String identificacion;
	private String estado;
	
	private Date fechaActualizacion;
	
	private Date fechaPago;
	
	private String numeroCuotas;
	
	private String observacion;
	
	private Date comiteActualizado;
	
	private Date comitePendiente;
	
	private String propuesta;
	
	private String tipoCliente;
	
	private BigDecimal valorPago;
	
	private String apellido1;
	
	private String apellido2;
	
	private Date asesorActualizado1;
	
	private Date asesorPendiente1;
	
	private BigDecimal capital;
	
	private BigDecimal interes;
	
	private BigDecimal capitalpropuesto;
	
	private BigDecimal interespropuesto;
	
	private String cedula;
	
	private String ciudad;
	
	private Date comiteActualizado1;
	
	private Date comitePendiente1;

	
	private BigDecimal interesMora;

	
	private BigDecimal totalDeuda;
	
	private BigDecimal valorAvaluo;
	
	private BigDecimal valorPolitica;
	
	private String tipo;
	
	private Short aprobado;
	
	private String shortName;
	
	private String asesor;
	private String cartera;
	private String deudor;
	
	private int idestado;
	
	

	
	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getDeudor() {
		return deudor;
	}

	public void setDeudor(String deudor) {
		this.deudor = deudor;
	}

	private List<Obligacion> obligacionList;
	
	
	private ComiteEstado estadoComite;

	
	private Asignacion asignacion;
	
	private String nombreDeudor;
	private List<Factura> listafactura;
	

	
	public String getCartera() {
		return cartera;
	}

	public void setCartera(String cartera) {
		this.cartera = cartera;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public List<Factura> getListafactura() {
		return listafactura;
	}

	public void setListafactura(List<Factura> listafactura) {
		this.listafactura = listafactura;
	}

	public Asignacion getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}

	public String getNombreDeudor() {
		return nombreDeudor;
	}

	public void setNombreDeudor(String nombreDeudor) {
		this.nombreDeudor = nombreDeudor;
	}

	private List<Acuerdo> acuerdos;
	
	private Integer idgestion;

	
	private Date fechacrea;
	
	/**
	 * 
	 */
	private String judicializado;
	
	private int cantComites;
	
	private String hipotecario;
	
	private Integer titulosJudiciales;

	public Comite() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdcomiterevision() {
		return idcomiterevision;
	}

	public void setIdcomiterevision(Integer idcomiterevision) {
		this.idcomiterevision = idcomiterevision;
	}

	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ComiteEstado getEstadoComite() {
		return estadoComite;
	}

	public void setEstadoComite(ComiteEstado estadoComite) {
		this.estadoComite = estadoComite;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaPago() {
	
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(String numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getComiteActualizado() {
		return comiteActualizado;
	}

	public void setComiteActualizado(Date comiteActualizado) {
		this.comiteActualizado = comiteActualizado;
	}

	public Date getComitePendiente() {
		return comitePendiente;
	}

	public void setComitePendiente(Date comitePendiente) {
		this.comitePendiente = comitePendiente;
	}

	public String getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getAsesorActualizado1() {
		return asesorActualizado1;
	}

	public void setAsesorActualizado1(Date asesorActualizado1) {
		this.asesorActualizado1 = asesorActualizado1;
	}

	public Date getAsesorPendiente1() {
		return asesorPendiente1;
	}

	public void setAsesorPendiente1(Date asesorPendiente1) {
		this.asesorPendiente1 = asesorPendiente1;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public BigDecimal getCapitalpropuesto() {
		return capitalpropuesto;
	}

	public void setCapitalpropuesto(BigDecimal capitalpropuesto) {
		this.capitalpropuesto = capitalpropuesto;
	}

	public BigDecimal getInterespropuesto() {
		return interespropuesto;
	}

	public void setInterespropuesto(BigDecimal interespropuesto) {
		this.interespropuesto = interespropuesto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Date getComiteActualizado1() {
		return comiteActualizado1;
	}

	public void setComiteActualizado1(Date comiteActualizado1) {
		this.comiteActualizado1 = comiteActualizado1;
	}

	public Date getComitePendiente1() {
		return comitePendiente1;
	}

	public void setComitePendiente1(Date comitePendiente1) {
		this.comitePendiente1 = comitePendiente1;
	}

	public BigDecimal getInteresMora() {
		return interesMora;
	}

	public void setInteresMora(BigDecimal interesMora) {
		this.interesMora = interesMora;
	}

	public BigDecimal getTotalDeuda() {
		return totalDeuda;
	}

	public void setTotalDeuda(BigDecimal totalDeuda) {
		this.totalDeuda = totalDeuda;
	}

	public BigDecimal getValorAvaluo() {
		return valorAvaluo;
	}

	public void setValorAvaluo(BigDecimal valorAvaluo) {
		this.valorAvaluo = valorAvaluo;
	}

	public BigDecimal getValorPolitica() {
		return valorPolitica;
	}

	public void setValorPolitica(BigDecimal valorPolitica) {
		this.valorPolitica = valorPolitica;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Short getAprobado() {
		return aprobado;
	}

	public void setAprobado(Short aprobado) {
		this.aprobado = aprobado;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public List<Obligacion> getObligacionList() {
		return obligacionList;
	}

	public void setObligacionList(List<Obligacion> obligacionList) {
		this.obligacionList = obligacionList;
	}


	public List<Acuerdo> getAcuerdos() {
		return acuerdos;
	}

	public void setAcuerdos(List<Acuerdo> acuerdos) {
		this.acuerdos = acuerdos;
	}

	public Integer getIdgestion() {
		return idgestion;
	}

	public void setIdgestion(Integer idgestion) {
		this.idgestion = idgestion;
	}

	public Date getFechacrea() {
		return fechacrea;
	}

	public void setFechacrea(Date fechacrea) {
		this.fechacrea = fechacrea;
	}

	public String getJudicializado() {
		return judicializado;
	}

	public void setJudicializado(String judicializado) {
		this.judicializado = judicializado;
	}

	public int getCantComites() {
		return cantComites;
	}

	public void setCantComites(int cantComites) {
		this.cantComites = cantComites;
	}

	public String getHipotecario() {
		return hipotecario;
	}

	public void setHipotecario(String hipotecario) {
		this.hipotecario = hipotecario;
	}

	public Integer getTitulosJudiciales() {
		return titulosJudiciales;
	}

	public void setTitulosJudiciales(Integer titulosJudiciales) {
		this.titulosJudiciales = titulosJudiciales;
	}

	public List<Obligacion> getObligacionesComite() {
		return obligacionesComite;
	}

	public void setObligacionesComite(List<Obligacion> obligacionesComite) {
		this.obligacionesComite = obligacionesComite;
	}


	
}
