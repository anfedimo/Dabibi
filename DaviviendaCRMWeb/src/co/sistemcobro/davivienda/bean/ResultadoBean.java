package co.sistemcobro.davivienda.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import co.sistemcobro.davivienda.ejb.IClienteEJBLocal;

@ManagedBean(name = "resultadoBean")
@SessionScoped
public class ResultadoBean implements Serializable {

	/**
	 * David Esguerra
	 */
	private static final long serialVersionUID = 8032580748179949883L;
	private String valor;
	private List<Cliente> clientes;
	
	@EJB
	private IClienteEJBLocal ClienteEJB;
	
	private BusquedaBean busquedaBean;
	
	@PostConstruct
	public void init(){
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		busquedaBean = application.evaluateExpressionGet(context, "#{busquedaBean}", BusquedaBean.class);
		clientes=ClienteEJB.listaClientes(busquedaBean.getBuscar());
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
