package co.sistemcobro.davivienda.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class HistoricoObligacion {

	private String obligacion;
	private Timestamp fechaCrea;
	private Timestamp fechaPromesa;
	private BigDecimal valorPromesa;
	private String politica;
	private String estado;
	private String fullNameAltitude;
	
	
	public String getObligacion() {
		return obligacion;
	}
	public void setObligacion(String obligacion) {
		this.obligacion = obligacion;
	}
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Timestamp getFechaPromesa() {
		return fechaPromesa;
	}
	public void setFechaPromesa(Timestamp fechaPromesa) {
		this.fechaPromesa = fechaPromesa;
	}
	public BigDecimal getValorPromesa() {
		return valorPromesa;
	}
	public void setValorPromesa(BigDecimal valorPromesa) {
		this.valorPromesa = valorPromesa;
	}
	public String getPolitica() {
		return politica;
	}
	public void setPolitica(String politica) {
		this.politica = politica;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFullNameAltitude() {
		return fullNameAltitude;
	}
	public void setFullNameAltitude(String fullNameAltitude) {
		this.fullNameAltitude = fullNameAltitude;
	}
	
	
	
}
