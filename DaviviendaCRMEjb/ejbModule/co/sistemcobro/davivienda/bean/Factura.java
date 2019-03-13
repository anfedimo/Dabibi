/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sistemcobro.davivienda.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 *
 * @author forjuela
 */
public class Factura {
    
   public Factura() {
    }
private String factura;
private String material;
private String region_fac;
private String ciuda_factura;
private String fecha_factura;
private Long contrato;
private String edicion;
private String direccion;
private String ciudad_direccion;
private Long id_factura_contrato;
private BigDecimal valor_factura_iva;
private BigDecimal cartera_corriente;
private BigDecimal cartera_vencida;
private BigDecimal total_cartera;
private BigDecimal intereses_mora;
private BigDecimal honorarios_cobrados;
private BigDecimal total_mora_honorarios;
private BigDecimal total_obligacion_int_hon;
private Integer cuotas_factura;
private String estado_cartera;
private String inicio_vigencia;
private String fincontrato;
private String servicio_prestado;
private String fecha_venc_cuota;
private Integer dias_mora ;
private BigDecimal valor_pago ;
private String valor_aplicado;
private BigDecimal valor_castigo;
private String valor_prox_venc;


public BigDecimal getCartera_vencida() {
	return cartera_vencida;
}
public void setCartera_vencida(BigDecimal cartera_vencida) {
	this.cartera_vencida = cartera_vencida;
}



public String getFactura() {
	return factura;
}
public void setFactura(String factura) {
	this.factura = factura;
}
public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
}
public String getRegion_fac() {
	return region_fac;
}
public void setRegion_fac(String region_fac) {
	this.region_fac = region_fac;
}
public String getCiuda_factura() {
	return ciuda_factura;
}
public void setCiuda_factura(String ciuda_factura) {
	this.ciuda_factura = ciuda_factura;
}



public String getFecha_factura() {
	return fecha_factura;
}
public void setFecha_factura(String fecha_factura) {
	this.fecha_factura = fecha_factura;
}
public Long getContrato() {
	return contrato;
}
public void setContrato(Long contrato) {
	this.contrato = contrato;
}
public String getEdicion() {
	return edicion;
}
public void setEdicion(String edicion) {
	this.edicion = edicion;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getCiudad_direccion() {
	return ciudad_direccion;
}
public void setCiudad_direccion(String ciudad_direccion) {
	this.ciudad_direccion = ciudad_direccion;
}
public Long getId_factura_contrato() {
	return id_factura_contrato;
}
public void setId_factura_contrato(Long id_factura_contrato) {
	this.id_factura_contrato = id_factura_contrato;
}
public BigDecimal getValor_factura_iva() {
	return valor_factura_iva;
}
public void setValor_factura_iva(BigDecimal valor_factura_iva) {
	this.valor_factura_iva = valor_factura_iva;
}
public BigDecimal getCartera_corriente() {
	return cartera_corriente;
}
public void setCartera_corriente(BigDecimal cartera_corriente) {
	this.cartera_corriente = cartera_corriente;
}
public BigDecimal getTotal_cartera() {
	return total_cartera;
}
public void setTotal_cartera(BigDecimal total_cartera) {
	this.total_cartera = total_cartera;
}
public BigDecimal getIntereses_mora() {
	return intereses_mora;
}
public void setIntereses_mora(BigDecimal intereses_mora) {
	this.intereses_mora = intereses_mora;
}
public BigDecimal getHonorarios_cobrados() {
	return honorarios_cobrados;
}
public void setHonorarios_cobrados(BigDecimal honorarios_cobrados) {
	this.honorarios_cobrados = honorarios_cobrados;
}
public BigDecimal getTotal_mora_honorarios() {
	return total_mora_honorarios;
}
public void setTotal_mora_honorarios(BigDecimal total_mora_honorarios) {
	this.total_mora_honorarios = total_mora_honorarios;
}
public BigDecimal getTotal_obligacion_int_hon() {
	return total_obligacion_int_hon;
}
public void setTotal_obligacion_int_hon(BigDecimal total_obligacion_int_hon) {
	this.total_obligacion_int_hon = total_obligacion_int_hon;
}
public Integer getCuotas_factura() {
	return cuotas_factura;
}
public void setCuotas_factura(Integer cuotas_factura) {
	this.cuotas_factura = cuotas_factura;
}
public String getEstado_cartera() {
	return estado_cartera;
}
public void setEstado_cartera(String estado_cartera) {
	this.estado_cartera = estado_cartera;
}
public String getInicio_vigencia() {
	return inicio_vigencia;
}
public void setInicio_vigencia(String inicio_vigencia) {
	this.inicio_vigencia = inicio_vigencia;
}
public String getFincontrato() {
	return fincontrato;
}
public void setFincontrato(String fincontrato) {
	this.fincontrato = fincontrato;
}
public String getServicio_prestado() {
	return servicio_prestado;
}
public void setServicio_prestado(String servicio_prestado) {
	this.servicio_prestado = servicio_prestado;
}
public String getFecha_venc_cuota() {
	return fecha_venc_cuota;
}
public void setFecha_venc_cuota(String fecha_venc_cuota) {
	this.fecha_venc_cuota = fecha_venc_cuota;
}
public Integer getDias_mora() {
	return dias_mora;
}
public void setDias_mora(Integer dias_mora) {
	this.dias_mora = dias_mora;
}
public BigDecimal getValor_pago() {
	return valor_pago;
}
public void setValor_pago(BigDecimal valor_pago) {
	this.valor_pago = valor_pago;
}
public String getValor_aplicado() {
	return valor_aplicado;
}
public void setValor_aplicado(String valor_aplicado) {
	this.valor_aplicado = valor_aplicado;
}
public BigDecimal getValor_castigo() {
	return valor_castigo;
}
public void setValor_castigo(BigDecimal valor_castigo) {
	this.valor_castigo = valor_castigo;
}
public String getValor_prox_venc() {
	return valor_prox_venc;
}
public void setValor_prox_venc(String valor_prox_venc) {
	this.valor_prox_venc = valor_prox_venc;
}


        
}
