package co.sistemcobro.davivienda.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "agendamientoBean")
@ViewScoped
public class AgendamientoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date horaUbicacion;
	private Date fecha;
	
	////****** get y set*****//////
	
	public Date getHoraUbicacion() {
		return horaUbicacion;
	}
	public void setHoraUbicacion(Date horaUbicacion) {
		this.horaUbicacion = horaUbicacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
