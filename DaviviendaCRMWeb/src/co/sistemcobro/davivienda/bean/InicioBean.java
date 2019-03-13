package co.sistemcobro.davivienda.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "inicioBean")
@ViewScoped
public class InicioBean {
	
	public String regresarInicio(){
		return "/pages/inicio/inicio.xhmtl?faces-redirect=true";
	}

}
