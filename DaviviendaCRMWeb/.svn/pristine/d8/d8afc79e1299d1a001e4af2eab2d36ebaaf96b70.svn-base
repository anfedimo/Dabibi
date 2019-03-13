package co.sistemcobro.davivienda.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.sistemcobro.davivienda.ejb.IClienteEJBLocal;

@ManagedBean(name = "busquedaBean")
@ViewScoped
public class BusquedaBean {

	private NavegacionBean navegacionBean;

	@EJB
	private IClienteEJBLocal ClienteEJB;

	private String buscar;
	private List<Cliente> clientes;
	private boolean tabla;
	private boolean sinResultados;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		navegacionBean = application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class);
	}

	public String getBuscar() {
		return buscar;
	}

	public void setBuscar(String buscar) {
		this.buscar = buscar;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void buscar() {

		try {
			this.clientes = ClienteEJB.listaClientes(buscar);

			if(clientes.isEmpty()){
				sinResultados=true;
				tabla=false;
			}else{
				tabla=true;
				sinResultados=false;
			}
			
			navegacionBean.redireccionBusquueda();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean isSinResultados() {
		return sinResultados;
	}

	public void setSinResultados(boolean sinResultados) {
		this.sinResultados = sinResultados;
	}

	public boolean isTabla() {
		return tabla;
	}

	public void setTabla(boolean tabla) {
		this.tabla = tabla;
	}
}
