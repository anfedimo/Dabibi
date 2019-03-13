package co.sistemcobro.davivienda.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Memo {

	private String idgestion;
	private String fechainicio;
	private String nombreAsesor;
	private String usuarioAsesor;
	private String telefonoMarcado;
	private String observacion;
	private String fechaAgendamiento;
	private String nombreTercero;
	private String telefonoAgendamiento;
	private String valorPromesa;
	private String campanaAltitude;
	private Integer idcampanaAltitude;
	private String correoAdicional;
	private String telefonoAdicional;
	private String direccionAdicional;
	private String pagoValor;
	private String pagoFecha;
	private String pagoLugar;
	private String pagoCodigo;
	private Integer numeroCuotas;
	private String ultimaCuota;
	private String tipificacion;
	private String identificacion;
	private String nombre;
	private String nombreMotivo;
	private String parentesco;
	private String porcentajeCapital;
	private String porcentajeInteres;
	private String valorCapital;
	private BigDecimal valorCapitalI;
	private String valorInteres;
	private BigDecimal valorInteresI;
	private String idTipificacion;
	private List<Memo> facturas;
	private String factura;
	private String capitalDescuento;
	private BigDecimal capitalDescuentoI;
	private String interesDescuento;
	private BigDecimal interesDescuentoI;
	private String totalCobro;
	private BigDecimal totalCobroI;
	private String fechaposible;
	private Timestamp fechaPromesa;


	private String fechafin;
	private String mensaje;
	private String obligacion;
	private String Asesor;
	private String Teléfono_marcado;
	private String Tipificacion;
	private String texto_agendado;
	private String texto_tercero;
	private String dias_de_mora;
	private String pago_minimo;
	private String saldo_total;
	private String saldo_capital;
	private String saldo_mora;
	private String texto_negociacion;
	private String texto_reestructuracion;
	private String texto_rediferido;
	private String texto_motivo_no_pago;

	public String getIdTipificacion() {
		return idTipificacion;
	}

	public void setIdTipificacion(String idTipificacion) {
		this.idTipificacion = idTipificacion;
	}

	public String getIdgestion() {
		return idgestion;
	}

	public void setIdgestion(String idgestion) {
		this.idgestion = idgestion;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getNombreAsesor() {
		return nombreAsesor;
	}

	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	public String getUsuarioAsesor() {
		return usuarioAsesor;
	}

	public void setUsuarioAsesor(String usuarioAsesor) {
		this.usuarioAsesor = usuarioAsesor;
	}

	public String getTelefonoMarcado() {
		return telefonoMarcado;
	}

	public void setTelefonoMarcado(String telefonoMarcado) {
		this.telefonoMarcado = telefonoMarcado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getFechaAgendamiento() {
		return fechaAgendamiento;
	}

	public void setFechaAgendamiento(String fechaAgendamiento) {
		this.fechaAgendamiento = fechaAgendamiento;
	}

	public String getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public String getTelefonoAgendamiento() {
		return telefonoAgendamiento;
	}

	public void setTelefonoAgendamiento(String telefonoAgendamiento) {
		this.telefonoAgendamiento = telefonoAgendamiento;
	}

	public String getValorPromesa() {
		return valorPromesa;
	}

	public void setValorPromesa(String valorPromesa) {
		this.valorPromesa = valorPromesa;
	}

	public String getCampanaAltitude() {
		return campanaAltitude;
	}

	public void setCampanaAltitude(String campanaAltitude) {
		this.campanaAltitude = campanaAltitude;
	}

	public Integer getIdcampanaAltitude() {
		return idcampanaAltitude;
	}

	public void setIdcampanaAltitude(Integer idcampanaAltitude) {
		this.idcampanaAltitude = idcampanaAltitude;
	}

	public String getCorreoAdicional() {
		return correoAdicional;
	}

	public void setCorreoAdicional(String correoAdicional) {
		this.correoAdicional = correoAdicional;
	}

	public String getTelefonoAdicional() {
		return telefonoAdicional;
	}

	public void setTelefonoAdicional(String telefonoAdicional) {
		this.telefonoAdicional = telefonoAdicional;
	}

	public String getDireccionAdicional() {
		return direccionAdicional;
	}

	public void setDireccionAdicional(String direccionAdicional) {
		this.direccionAdicional = direccionAdicional;
	}

	public String getPagoValor() {
		return pagoValor;
	}

	public void setPagoValor(String pagoValor) {
		this.pagoValor = pagoValor;
	}

	public String getPagoFecha() {
		return pagoFecha;
	}

	public void setPagoFecha(String pagoFecha) {
		this.pagoFecha = pagoFecha;
	}

	public String getPagoLugar() {
		return pagoLugar;
	}

	public void setPagoLugar(String pagoLugar) {
		this.pagoLugar = pagoLugar;
	}

	public String getPagoCodigo() {
		return pagoCodigo;
	}

	public void setPagoCodigo(String pagoCodigo) {
		this.pagoCodigo = pagoCodigo;
	}

	public Integer getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(Integer numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public String getUltimaCuota() {
		return ultimaCuota;
	}

	public void setUltimaCuota(String ultimaCuota) {
		this.ultimaCuota = ultimaCuota;
	}

	public String getTipificacion() {
		return tipificacion;
	}

	public void setTipificacion(String tipificacion) {
		this.tipificacion = tipificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreMotivo() {
		return nombreMotivo;
	}

	public void setNombreMotivo(String nombreMotivo) {
		this.nombreMotivo = nombreMotivo;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getPorcentajeCapital() {
		return porcentajeCapital;
	}

	public void setPorcentajeCapital(String porcentajeCapital) {
		this.porcentajeCapital = porcentajeCapital;
	}

	public String getPorcentajeInteres() {
		return porcentajeInteres;
	}

	public void setPorcentajeInteres(String porcentajeInteres) {
		this.porcentajeInteres = porcentajeInteres;
	}

	public String getValorCapital() {
		return valorCapital;
	}

	public void setValorCapital(String valorCapital) {
		this.valorCapital = valorCapital;
	}

	public String getValorInteres() {
		return valorInteres;
	}

	public void setValorInteres(String valorInteres) {
		this.valorInteres = valorInteres;
	}

	public List<Memo> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Memo> facturas) {
		this.facturas = facturas;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getCapitalDescuento() {
		return capitalDescuento;
	}

	public void setCapitalDescuento(String capitalDescuento) {
		this.capitalDescuento = capitalDescuento;
	}

	public String getInteresDescuento() {
		return interesDescuento;
	}

	public void setInteresDescuento(String interesDescuento) {
		this.interesDescuento = interesDescuento;
	}

	public String getTotalCobro() {
		return totalCobro;
	}

	public void setTotalCobro(String totalCobro) {
		this.totalCobro = totalCobro;
	}

	public BigDecimal getCapitalDescuentoI() {
		BigDecimal capitalDescuentoB = new BigDecimal(capitalDescuento);

		return capitalDescuentoB;
	}

	public void setCapitalDescuentoI(BigDecimal capitalDescuentoI) {
		this.capitalDescuentoI = capitalDescuentoI;
	}

	public BigDecimal getValorCapitalI() {
		BigDecimal valorCapitalB = new BigDecimal(valorCapital);
		return valorCapitalB;
	}

	public void setValorCapitalI(BigDecimal valorCapitalI) {
		this.valorCapitalI = valorCapitalI;
	}

	public BigDecimal getValorInteresI() {
		BigDecimal valorInteresB = new BigDecimal(valorInteres);
		return valorInteresB;
	}

	public void setValorInteresI(BigDecimal valorInteresI) {
		this.valorInteresI = valorInteresI;
	}

	public BigDecimal getInteresDescuentoI() {
		BigDecimal interesDescuentoB = new BigDecimal(interesDescuento);
		return interesDescuentoB;
	}

	public void setInteresDescuentoI(BigDecimal interesDescuentoI) {
		this.interesDescuentoI = interesDescuentoI;
	}

	public BigDecimal getTotalCobroI() {
		BigDecimal totalCobroB = new BigDecimal(totalCobro);
		return totalCobroB;
	}

	public void setTotalCobroI(BigDecimal totalCobroI) {
		this.totalCobroI = totalCobroI;
	}

	public String getFechaposible() {
		return fechaposible;
	}

	public void setFechaposible(String fechaposible) {
		this.fechaposible = fechaposible;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getObligacion() {
		return obligacion;
	}

	public void setObligacion(String obligacion) {
		this.obligacion = obligacion;
	}

	public String getAsesor() {
		return Asesor;
	}

	public void setAsesor(String asesor) {
		Asesor = asesor;
	}

	public String getTeléfono_marcado() {
		return Teléfono_marcado;
	}

	public void setTeléfono_marcado(String teléfono_marcado) {
		Teléfono_marcado = teléfono_marcado;
	}

	public String getTexto_agendado() {
		return texto_agendado;
	}

	public void setTexto_agendado(String texto_agendado) {
		this.texto_agendado = texto_agendado;
	}

	public String getTexto_tercero() {
		return texto_tercero;
	}

	public void setTexto_tercero(String texto_tercero) {
		this.texto_tercero = texto_tercero;
	}

	

	public String getDias_de_mora() {
		return dias_de_mora;
	}

	public void setDias_de_mora(String dias_de_mora) {
		this.dias_de_mora = dias_de_mora;
	}

	public String getPago_minimo() {
		return pago_minimo;
	}

	public void setPago_minimo(String pago_minimo) {
		this.pago_minimo = pago_minimo;
	}

	public String getSaldo_total() {
		return saldo_total;
	}

	public void setSaldo_total(String saldo_total) {
		this.saldo_total = saldo_total;
	}

	public String getSaldo_capital() {
		return saldo_capital;
	}

	public void setSaldo_capital(String saldo_capital) {
		this.saldo_capital = saldo_capital;
	}

	public String getSaldo_mora() {
		return saldo_mora;
	}

	public void setSaldo_mora(String saldo_mora) {
		this.saldo_mora = saldo_mora;
	}

	public String getTexto_negociacion() {
		return texto_negociacion;
	}

	public void setTexto_negociacion(String texto_negociacion) {
		this.texto_negociacion = texto_negociacion;
	}

	public String getTexto_reestructuracion() {
		return texto_reestructuracion;
	}

	public void setTexto_reestructuracion(String texto_reestructuracion) {
		this.texto_reestructuracion = texto_reestructuracion;
	}

	public String getTexto_rediferido() {
		return texto_rediferido;
	}

	public void setTexto_rediferido(String texto_rediferido) {
		this.texto_rediferido = texto_rediferido;
	}

	public String getTexto_motivo_no_pago() {
		return texto_motivo_no_pago;
	}

	public void setTexto_motivo_no_pago(String texto_motivo_no_pago) {
		this.texto_motivo_no_pago = texto_motivo_no_pago;
	}

	public Timestamp getFechaPromesa() {
		return fechaPromesa;
	}

	public void setFechaPromesa(Timestamp fechaPromesa) {
		this.fechaPromesa = fechaPromesa;
	}
	
	
	
	
}
