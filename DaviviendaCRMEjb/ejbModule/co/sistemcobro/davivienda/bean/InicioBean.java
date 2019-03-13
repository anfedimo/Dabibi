package co.sistemcobro.davivienda.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "inicioBean")
@ViewScoped
public class InicioBean {

	private Integer tabActivo;

	@PostConstruct
	public void init() {
		tabActivo = 1;
		
	}

	public String regresarInicio() {
		tabActivo = 1;

		RequestContext.getCurrentInstance().update("contenido");
		return "/pages/inicio/inicio.xhmtl?faces-redirect=true";
	}

	public Integer getTabActivo() {
		return tabActivo;
	}

	public void setTabActivo(Integer tabActivo) {
		this.tabActivo = tabActivo;
	}

}
