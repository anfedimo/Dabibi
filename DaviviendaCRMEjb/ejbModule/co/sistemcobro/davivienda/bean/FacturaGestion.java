package co.sistemcobro.davivienda.bean;

import java.math.BigDecimal;

public class FacturaGestion {

	private String factura;
	private Integer idcolumna;
	private BigDecimal Valor;

	public BigDecimal getValor() {
		return Valor;
	}

	public void setValor(BigDecimal valor) {
		Valor = valor;
	}

	public Integer getIdcolumna() {
		return idcolumna;
	}

	public void setIdcolumna(Integer idcolumna) {
		this.idcolumna = idcolumna;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

}
