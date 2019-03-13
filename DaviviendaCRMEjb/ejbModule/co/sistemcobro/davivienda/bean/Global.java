package co.sistemcobro.davivienda.bean;

import java.math.BigDecimal;

import java.sql.Timestamp;

public class Global {

	 private String pago_total_30_prctg;
	 private String nombre_politica;
	 private String observacion;
	 private BigDecimal idObligacion;
	 private Timestamp fecha;	 
	 private String fechaFormateada;
	 private Integer numeroCuota;
	 private BigDecimal capitalaAbonadoPorCuota;
	 private BigDecimal interesesAbonarPorCuota;
	 private BigDecimal cuota;	 
	 private Integer idAfinidad;
	 private String nombreAfinidad;
	 private Integer idMotivoNoPago;
	 private String nombreMotivoNoPago;
	 
	public String getPago_total_30_prctg() {
		return pago_total_30_prctg;
	}
	public void setPago_total_30_prctg(String pago_total_30_prctg) {
		this.pago_total_30_prctg = pago_total_30_prctg;
	}
	public String getNombre_politica() {
		return nombre_politica;
	}
	public void setNombre_politica(String nombre_politica) {
		this.nombre_politica = nombre_politica;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public BigDecimal getIdObligacion() {
		return idObligacion;
	}
	public void setIdObligacion(BigDecimal idObligacion) {
		this.idObligacion = idObligacion;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp timestamp) {
		this.fecha = timestamp;
	}
	public String getFechaFormateada() {
		return fechaFormateada;
	}
	public void setFechaFormateada(String fechaFormateada) {
		this.fechaFormateada = fechaFormateada;
	}
	public Integer getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public BigDecimal getCapitalaAbonadoPorCuota() {
		return capitalaAbonadoPorCuota;
	}
	public void setCapitalaAbonadoPorCuota(BigDecimal capitalaAbonadoPorCuota) {
		this.capitalaAbonadoPorCuota = capitalaAbonadoPorCuota;
	}
	public BigDecimal getInteresesAbonarPorCuota() {
		return interesesAbonarPorCuota;
	}
	public void setInteresesAbonarPorCuota(BigDecimal interesesAbonarPorCuota) {
		this.interesesAbonarPorCuota = interesesAbonarPorCuota;
	}
	public BigDecimal getCuota() {
		return cuota;
	}
	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}
	public Integer getIdAfinidad() {
		return idAfinidad;
	}
	public void setIdAfinidad(Integer idAfinidad) {
		this.idAfinidad = idAfinidad;
	}
	public String getNombreAfinidad() {
		return nombreAfinidad;
	}
	public void setNombreAfinidad(String nombreAfinidad) {
		this.nombreAfinidad = nombreAfinidad;
	}
	public Integer getIdMotivoNoPago() {
		return idMotivoNoPago;
	}
	public void setIdMotivoNoPago(Integer idMotivoNoPago) {
		this.idMotivoNoPago = idMotivoNoPago;
	}
	public String getNombreMotivoNoPago() {
		return nombreMotivoNoPago;
	}
	public void setNombreMotivoNoPago(String nombreMotivoNoPago) {
		this.nombreMotivoNoPago = nombreMotivoNoPago;
	}
	 
	
	
	 
	 
}
