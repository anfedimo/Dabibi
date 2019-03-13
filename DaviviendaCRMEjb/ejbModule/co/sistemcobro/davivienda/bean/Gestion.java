package co.sistemcobro.davivienda.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class Gestion {

	private Integer id;
	private Integer idtipificacion;
	private Integer idmotivo;
	private String idResultado;
	private String idNegociacion;
	private Integer idMotivoNoPago;
	private String registroTipo;
	private String descripcionAcuerdo;
	private Integer idMotivoNumPago;
	private BigDecimal idObligacion;
	private BigDecimal montoAbono;
	private BigDecimal montoBono;
	private BigDecimal abono;
	private BigDecimal bono;
	private BigDecimal saldoTotalreestruc;
	private BigDecimal pagoclienteReestruc;
	private BigDecimal abonoZanahoria;
	private BigDecimal bonoZanahoria;
	private Integer numeroCuotas;
	private Integer extension;
	private Double tasaMensual;
	private Integer plazo;
	private BigDecimal simuladoPrimeraCuota;
	private BigDecimal saldoCapital;
	private BigDecimal pagoClienteRediferido;
	private BigDecimal pagoCliente;
	private String rediferidoEspecial;
	private BigDecimal saldoTotal;
	private Integer idparentesco;
	private Integer idperiodicidad;
	private Integer idsucursal;
	private String mail;
	private Integer omitir;
	private String dirinmueble;
	private String nombreCampana;
	private Integer easyCodeAltitude;
	private String tipo;
	private String correoCliente;
	private String actividadEconomicaCliente;
	private String cargoCliente;
	private String departamentoCliente;
	private String direccionEmpresaCliente;
	private String empresaCliente;
	private String ciudad;
	private String telefonoEmpresaCliente;
	private String telefono1Cliente;
	private String telefono2Cliente;
	private String telefono3Cliente;
	private String telefono4Cliente;
	private String sectorCliente;
	private String accionTipo;
	private String codigoCampana;
	private String motivoRevocacion;
	private String ciudadinmueble;
	private String dircorrespondencia;
	private String mesajeTercero;
	private Integer afinidadTercero;
	private String nombrePolitica;
	private Integer idPolitica;
	private Timestamp fechainicio;
	private Timestamp fechafin;
	private Timestamp fechainiciollamada;
	private Timestamp fechafinllamada;
	private String telefonomarcado;
	private BigDecimal valorpromesa;
	private Timestamp fechapromesa;
	private Timestamp fechaDocumentacion;
	private String correoadicional;
	private String telefonoadicional;
	private String direccionadicional;
	private String observacion;
	private String pagovalor;
	private Timestamp pagofecha;
	private String pagolugar;
	private String pagocodigo;
	private String nombretercero;
	private String opcionEspecialRediferido;
	private Timestamp fechaagendamiento;
	private String telefonoagendamiento;
	private String numerodecaso;
	private Integer idusuarioaltitude;
	private String usernamealtitude;
	private String fullnamealtitude;
	private Integer idcampanaaltitude;
	private String campanaaltitude;
	private Integer easycodealtitude;
	private Integer idusuariocrea;
	private Timestamp fechacrea;
	private Integer estado;
	private String callkey;
	private String ani;
	private String vgVersion;
	private Long idcliente;
	private Integer idpais;
	private Integer identidad;
	private Integer idformapago;
	private String seccional;
	private String entidad_otro;
	private String formapago_otro;
	private Integer idcomite;
	private BigDecimal porcentaje_capital;
	private BigDecimal porcentaje_interes;
	private BigDecimal valor_capital;
	private BigDecimal valor_interes;
	private List<Cuota> cuotas;
	private List<Obligacion> obligaciones;
	private Comite comite;
	private BigDecimal valorFacturaAdicional;
	private String idCall;
	private Timestamp fechaPosible;

	public String getIdCall() {
		return idCall;
	}

	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdtipificacion() {
		return idtipificacion;
	}

	public void setIdtipificacion(Integer idtipificacion) {
		this.idtipificacion = idtipificacion;
	}

	public Integer getIdmotivo() {
		return idmotivo;
	}

	public void setIdmotivo(Integer idmotivo) {
		this.idmotivo = idmotivo;
	}

	public Integer getIdparentesco() {
		return idparentesco;
	}

	public void setIdparentesco(Integer idparentesco) {
		this.idparentesco = idparentesco;
	}

	public Integer getIdperiodicidad() {
		return idperiodicidad;
	}

	public void setIdperiodicidad(Integer idperiodicidad) {
		this.idperiodicidad = idperiodicidad;
	}

	public Integer getIdsucursal() {
		return idsucursal;
	}

	public void setIdsucursal(Integer idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDirinmueble() {
		return dirinmueble;
	}

	public void setDirinmueble(String dirinmueble) {
		this.dirinmueble = dirinmueble;
	}

	public String getCiudadinmueble() {
		return ciudadinmueble;
	}

	public void setCiudadinmueble(String ciudadinmueble) {
		this.ciudadinmueble = ciudadinmueble;
	}

	public String getDircorrespondencia() {
		return dircorrespondencia;
	}

	public void setDircorrespondencia(String dircorrespondencia) {
		this.dircorrespondencia = dircorrespondencia;
	}

	public Timestamp getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Timestamp getFechafin() {
		return fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainiciollamada() {
		return fechainiciollamada;
	}

	public void setFechainiciollamada(Timestamp fechainiciollamada) {
		this.fechainiciollamada = fechainiciollamada;
	}

	public Timestamp getFechafinllamada() {
		return fechafinllamada;
	}

	public void setFechafinllamada(Timestamp fechafinllamada) {
		this.fechafinllamada = fechafinllamada;
	}

	public String getTelefonomarcado() {
		return telefonomarcado;
	}

	public void setTelefonomarcado(String telefonomarcado) {
		this.telefonomarcado = telefonomarcado;
	}

	public BigDecimal getValorpromesa() {
		return valorpromesa;
	}

	public void setValorpromesa(BigDecimal valorpromesa) {
		this.valorpromesa = valorpromesa;
	}

	public Timestamp getFechapromesa() {
		return fechapromesa;
	}

	public void setFechapromesa(Timestamp fechapromesa) {
		this.fechapromesa = fechapromesa;
	}

	public String getCorreoadicional() {
		return correoadicional;
	}

	public void setCorreoadicional(String correoadicional) {
		this.correoadicional = correoadicional;
	}

	public String getTelefonoadicional() {
		return telefonoadicional;
	}

	public void setTelefonoadicional(String telefonoadicional) {
		this.telefonoadicional = telefonoadicional;
	}

	public String getDireccionadicional() {
		return direccionadicional;
	}

	public void setDireccionadicional(String direccionadicional) {
		this.direccionadicional = direccionadicional;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPagovalor() {
		return pagovalor;
	}

	public void setPagovalor(String pagovalor) {
		this.pagovalor = pagovalor;
	}

	public Timestamp getPagofecha() {
		return pagofecha;
	}

	public void setPagofecha(Timestamp pagofecha) {
		this.pagofecha = pagofecha;
	}

	public String getPagolugar() {
		return pagolugar;
	}

	public void setPagolugar(String pagolugar) {
		this.pagolugar = pagolugar;
	}

	public String getPagocodigo() {
		return pagocodigo;
	}

	public void setPagocodigo(String pagocodigo) {
		this.pagocodigo = pagocodigo;
	}

	public String getNombretercero() {
		return nombretercero;
	}

	public void setNombretercero(String nombretercero) {
		this.nombretercero = nombretercero;
	}

	public Timestamp getFechaagendamiento() {
		return fechaagendamiento;
	}

	public void setFechaagendamiento(Timestamp fechaagendamiento) {
		this.fechaagendamiento = fechaagendamiento;
	}

	public String getTelefonoagendamiento() {
		return telefonoagendamiento;
	}

	public void setTelefonoagendamiento(String telefonoagendamiento) {
		this.telefonoagendamiento = telefonoagendamiento;
	}

	public String getNumerodecaso() {
		return numerodecaso;
	}

	public void setNumerodecaso(String numerodecaso) {
		this.numerodecaso = numerodecaso;
	}

	public Integer getIdusuarioaltitude() {
		return idusuarioaltitude;
	}

	public void setIdusuarioaltitude(Integer idusuarioaltitude) {
		this.idusuarioaltitude = idusuarioaltitude;
	}

	public String getUsernamealtitude() {
		return usernamealtitude;
	}

	public void setUsernamealtitude(String usernamealtitude) {
		this.usernamealtitude = usernamealtitude;
	}

	public String getFullnamealtitude() {
		return fullnamealtitude;
	}

	public void setFullnamealtitude(String fullnamealtitude) {
		this.fullnamealtitude = fullnamealtitude;
	}

	public Integer getIdcampanaaltitude() {
		return idcampanaaltitude;
	}

	public void setIdcampanaaltitude(Integer idcampanaaltitude) {
		this.idcampanaaltitude = idcampanaaltitude;
	}

	public String getCampanaaltitude() {
		return campanaaltitude;
	}

	public void setCampanaaltitude(String campanaaltitude) {
		this.campanaaltitude = campanaaltitude;
	}

	public Integer getEasycodealtitude() {
		return easycodealtitude;
	}

	public void setEasycodealtitude(Integer easycodealtitude) {
		this.easycodealtitude = easycodealtitude;
	}

	public Integer getIdusuariocrea() {
		return idusuariocrea;
	}

	public void setIdusuariocrea(Integer idusuariocrea) {
		this.idusuariocrea = idusuariocrea;
	}

	public Timestamp getFechacrea() {
		return fechacrea;
	}

	public void setFechacrea(Timestamp fechacrea) {
		this.fechacrea = fechacrea;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getCallkey() {
		return callkey;
	}

	public void setCallkey(String callkey) {
		this.callkey = callkey;
	}

	public String getAni() {
		return ani;
	}

	public void setAni(String ani) {
		this.ani = ani;
	}

	public String getVgVersion() {
		return vgVersion;
	}

	public void setVgVersion(String vgVersion) {
		this.vgVersion = vgVersion;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public Integer getIdentidad() {
		return identidad;
	}

	public void setIdentidad(Integer identidad) {
		this.identidad = identidad;
	}

	public Integer getIdformapago() {
		return idformapago;
	}

	public void setIdformapago(Integer idformapago) {
		this.idformapago = idformapago;
	}

	public String getSeccional() {
		return seccional;
	}

	public void setSeccional(String seccional) {
		this.seccional = seccional;
	}

	public String getEntidad_otro() {
		return entidad_otro;
	}

	public void setEntidad_otro(String entidad_otro) {
		this.entidad_otro = entidad_otro;
	}

	public String getFormapago_otro() {
		return formapago_otro;
	}

	public void setFormapago_otro(String formapago_otro) {
		this.formapago_otro = formapago_otro;
	}

	public Integer getIdcomite() {
		return idcomite;
	}

	public void setIdcomite(Integer idcomite) {
		this.idcomite = idcomite;
	}

	public BigDecimal getPorcentaje_capital() {
		return porcentaje_capital;
	}

	public void setPorcentaje_capital(BigDecimal porcentaje_capital) {
		this.porcentaje_capital = porcentaje_capital;
	}

	public BigDecimal getPorcentaje_interes() {
		return porcentaje_interes;
	}

	public void setPorcentaje_interes(BigDecimal porcentaje_interes) {
		this.porcentaje_interes = porcentaje_interes;
	}

	public BigDecimal getValor_capital() {
		return valor_capital;
	}

	public void setValor_capital(BigDecimal valor_capital) {
		this.valor_capital = valor_capital;
	}

	public BigDecimal getValor_interes() {
		return valor_interes;
	}

	public void setValor_interes(BigDecimal valor_interes) {
		this.valor_interes = valor_interes;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public List<Obligacion> getObligaciones() {
		return obligaciones;
	}

	public void setObligaciones(List<Obligacion> obligaciones) {
		this.obligaciones = obligaciones;
	}

	public BigDecimal getValorFacturaAdicional() {
		return valorFacturaAdicional;
	}

	public void setValorFacturaAdicional(BigDecimal valorFacturaAdicional) {
		this.valorFacturaAdicional = valorFacturaAdicional;
	}

	public Comite getComite() {
		return comite;
	}

	public void setComite(Comite comite) {
		this.comite = comite;
	}

	public Timestamp getFechaPosible() {
		return fechaPosible;
	}

	public void setFechaPosible(Timestamp fechaPosible) {
		this.fechaPosible = fechaPosible;
	}

	public String getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(String idResultado) {
		this.idResultado = idResultado;
	}

	public String getIdNegociacion() {
		return idNegociacion;
	}

	public void setIdNegociacion(String idNegociacion) {
		this.idNegociacion = idNegociacion;
	}

	public String getRegistroTipo() {
		return registroTipo;
	}

	public void setRegistroTipo(String registroTipo) {
		this.registroTipo = registroTipo;
	}

	public Integer getIdMotivoNumPago() {
		return idMotivoNumPago;
	}

	public void setIdMotivoNumPago(Integer idMotivoNumPago) {
		this.idMotivoNumPago = idMotivoNumPago;
	}

	public BigDecimal getIdObligacion() {
		return idObligacion;
	}

	public void setIdObligacion(BigDecimal idObligacion) {
		this.idObligacion = idObligacion;
	}

	public String getMesajeTercero() {
		return mesajeTercero;
	}

	public void setMesajeTercero(String mesajeTercero) {
		this.mesajeTercero = mesajeTercero;
	}

	public Integer getAfinidadTercero() {
		return afinidadTercero;
	}

	public void setAfinidadTercero(Integer afinidadTercero) {
		this.afinidadTercero = afinidadTercero;
	}

	public String getNombrePolitica() {
		return nombrePolitica;
	}

	public void setNombrePolitica(String nombrePolitica) {
		this.nombrePolitica = nombrePolitica;
	}

	public BigDecimal getMontoAbono() {
		return montoAbono;
	}

	public void setMontoAbono(BigDecimal montoAbono) {
		this.montoAbono = montoAbono;
	}

	public BigDecimal getMontoBono() {
		return montoBono;
	}

	public void setMontoBono(BigDecimal montoBono) {
		this.montoBono = montoBono;
	}

	public BigDecimal getAbono() {
		return abono;
	}

	public void setAbono(BigDecimal abono) {
		this.abono = abono;
	}

	public BigDecimal getBono() {
		return bono;
	}

	public void setBono(BigDecimal bono) {
		this.bono = bono;
	}

	public BigDecimal getAbonoZanahoria() {
		return abonoZanahoria;
	}

	public void setAbonoZanahoria(BigDecimal abonoZanahoria) {
		this.abonoZanahoria = abonoZanahoria;
	}

	public BigDecimal getBonoZanahoria() {
		return bonoZanahoria;
	}

	public void setBonoZanahoria(BigDecimal bonoZanahoria) {
		this.bonoZanahoria = bonoZanahoria;
	}

	public Integer getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(Integer numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public Double getTasaMensual() {
		return tasaMensual;
	}

	public void setTasaMensual(Double tasaMensual) {
		this.tasaMensual = tasaMensual;
	}

	public BigDecimal getSaldoCapital() {
		return saldoCapital;
	}

	public void setSaldoCapital(BigDecimal saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	public BigDecimal getPagoCliente() {
		return pagoCliente;
	}

	public void setPagoCliente(BigDecimal pagoCliente) {
		this.pagoCliente = pagoCliente;
	}

	public BigDecimal getPagoClienteRediferido() {
		return pagoClienteRediferido;
	}

	public void setPagoClienteRediferido(BigDecimal pagoClienteRediferido) {
		this.pagoClienteRediferido = pagoClienteRediferido;
	}

	public String getRediferidoEspecial() {
		return rediferidoEspecial;
	}

	public void setRediferidoEspecial(String rediferidoEspecial) {
		this.rediferidoEspecial = rediferidoEspecial;
	}

	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public BigDecimal getSimuladoPrimeraCuota() {
		return simuladoPrimeraCuota;
	}

	public void setSimuladoPrimeraCuota(BigDecimal simuladoPrimeraCuota) {
		this.simuladoPrimeraCuota = simuladoPrimeraCuota;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Timestamp getFechaDocumentacion() {
		return fechaDocumentacion;
	}

	public void setFechaDocumentacion(Timestamp fechaDocumentacion) {
		this.fechaDocumentacion = fechaDocumentacion;
	}

	public String getAccionTipo() {
		return accionTipo;
	}

	public void setAccionTipo(String accionTipo) {
		this.accionTipo = accionTipo;
	}

	public String getCodigoCampana() {
		return codigoCampana;
	}

	public void setCodigoCampana(String codigoCampana) {
		this.codigoCampana = codigoCampana;
	}

	public String getMotivoRevocacion() {
		return motivoRevocacion;
	}

	public void setMotivoRevocacion(String motivoRevocacion) {
		this.motivoRevocacion = motivoRevocacion;
	}

	public String getNombreCampana() {
		return nombreCampana;
	}

	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}

	public Integer getEasyCodeAltitude() {
		return easyCodeAltitude;
	}

	public void setEasyCodeAltitude(Integer easyCodeAltitude) {
		this.easyCodeAltitude = easyCodeAltitude;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getActividadEconomicaCliente() {
		return actividadEconomicaCliente;
	}

	public void setActividadEconomicaCliente(String actividadEconomicaCliente) {
		this.actividadEconomicaCliente = actividadEconomicaCliente;
	}

	public String getCargoCliente() {
		return cargoCliente;
	}

	public void setCargoCliente(String cargoCliente) {
		this.cargoCliente = cargoCliente;
	}

	public String getDepartamentoCliente() {
		return departamentoCliente;
	}

	public void setDepartamentoCliente(String departamentoCliente) {
		this.departamentoCliente = departamentoCliente;
	}

	public String getDireccionEmpresaCliente() {
		return direccionEmpresaCliente;
	}

	public void setDireccionEmpresaCliente(String direccionEmpresaCliente) {
		this.direccionEmpresaCliente = direccionEmpresaCliente;
	}

	public String getEmpresaCliente() {
		return empresaCliente;
	}

	public void setEmpresaCliente(String empresaCliente) {
		this.empresaCliente = empresaCliente;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefonoEmpresaCliente() {
		return telefonoEmpresaCliente;
	}

	public void setTelefonoEmpresaCliente(String telefonoEmpresaCliente) {
		this.telefonoEmpresaCliente = telefonoEmpresaCliente;
	}

	public String getTelefono1Cliente() {
		return telefono1Cliente;
	}

	public void setTelefono1Cliente(String telefono1Cliente) {
		this.telefono1Cliente = telefono1Cliente;
	}

	public String getTelefono2Cliente() {
		return telefono2Cliente;
	}

	public void setTelefono2Cliente(String telefono2Cliente) {
		this.telefono2Cliente = telefono2Cliente;
	}

	public String getTelefono3Cliente() {
		return telefono3Cliente;
	}

	public void setTelefono3Cliente(String telefono3Cliente) {
		this.telefono3Cliente = telefono3Cliente;
	}

	public String getTelefono4Cliente() {
		return telefono4Cliente;
	}

	public void setTelefono4Cliente(String telefono4Cliente) {
		this.telefono4Cliente = telefono4Cliente;
	}

	public String getSectorCliente() {
		return sectorCliente;
	}

	public void setSectorCliente(String sectorCliente) {
		this.sectorCliente = sectorCliente;
	}

	public Integer getOmitir() {
		return omitir;
	}

	public void setOmitir(Integer omitir) {
		this.omitir = omitir;
	}

	public String getDescripcionAcuerdo() {
		return descripcionAcuerdo;
	}

	public void setDescripcionAcuerdo(String descripcionAcuerdo) {
		this.descripcionAcuerdo = descripcionAcuerdo;
	}

	public String getOpcionEspecialRediferido() {
		return opcionEspecialRediferido;
	}

	public void setOpcionEspecialRediferido(String opcionEspecialRediferido) {
		this.opcionEspecialRediferido = opcionEspecialRediferido;
	}

	public BigDecimal getSaldoTotalreestruc() {
		return saldoTotalreestruc;
	}

	public void setSaldoTotalreestruc(BigDecimal saldoTotalreestruc) {
		this.saldoTotalreestruc = saldoTotalreestruc;
	}

	public BigDecimal getPagoclienteReestruc() {
		return pagoclienteReestruc;
	}

	public void setPagoclienteReestruc(BigDecimal pagoclienteReestruc) {
		this.pagoclienteReestruc = pagoclienteReestruc;
	}

	public Integer getIdMotivoNoPago() {
		return idMotivoNoPago;
	}

	public void setIdMotivoNoPago(Integer idMotivoNoPago) {
		this.idMotivoNoPago = idMotivoNoPago;
	}

	public Integer getExtension() {
		return extension;
	}

	public void setExtension(Integer extension) {
		this.extension = extension;
	}

	public Integer getIdPolitica() {
		return idPolitica;
	}

	public void setIdPolitica(Integer idPolitica) {
		this.idPolitica = idPolitica;
	}
	
	
	
	
	
	

}
