package co.sistemcobro.davivienda.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.ejb.IDolarEJBLocal;
import co.sistemcobro.davivienda.ejb.IGlobalEJBLocal;
import co.sistemcobro.davivienda.ejb.IHistoricoObligacionEJBLocal;
import co.sistemcobro.davivienda.ejb.IRediferidoEJBLocal;
import co.sistemcobro.davivienda.ejb.ITipificacionEJBLocal;
import co.sistemcobro.davivienda.session.LoginBean;

@ManagedBean(name = "opcionesBean")
@ViewScoped
public class OpcionesBean implements Serializable {

	@EJB
	private ITipificacionEJBLocal tipificacionEJB;

	@EJB
	private IHistoricoObligacionEJBLocal historicoObligacionEJB;

	@EJB
	private IRediferidoEJBLocal rediferidoEJB;

	@EJB
	private IDolarEJBLocal dolarEJB;

	@EJB
	private IGlobalEJBLocal globalEJB;

	/// ******variables****///
	private String fullNameAltitude;
	private BigDecimal daviBono;
	private BigDecimal numeroObligacion;
	private BigDecimal montoAbono;
	private BigDecimal bonoZanahoria;
	private String observaciones;
	private String fechaUltimoAcuerdo;
	private List<HistoricoObligacion> historicoObligaciones;
	private BigDecimal saldoTotal;
	private BigDecimal pagoMinInicial;
	private long saldoTotalPesos;
	private BigDecimal tasaMenusal;
	private long valorSaldoDolar;
	private long valorMinDolar;
	private long pagoMinPesos;
	private long valorMoraDolar;
	private long moraPesos;

	private List<Integer> plazoMeses;
	private List<String> tipoReestructuracion;
	private List<Float> tasaMensual;
	private List<Global> listaAfinidades;
	private List<Tipificacion> listaTipificaciones;
	private List<Global> listaMotivoNoPago;
	private BigDecimal trm;

	// ***opciones de botones***//
	private int aceptoRediferido;
	private int esDaviacuerdo;
	private int esPagoTotal;
	private int esPagoZanahoria;
	private int aceptoAgendamiento;
	private int opcionRediferido;
	private int opcionReestructuracion;
	private int opcionSinAcuerdo;
	private int opcionDetalles;
	private int opcionNormalizacion;
	private int opcionNormalizacionVirtual;
	private int agendo;
	private int noContacto;
	private int opcionMensajeTercero;
	private int opcionContactoTitular;

	// ***traer beans****////
	private DetallesObligacionesBean detalle;
	private UsuarioHermes usuarioHermes;
	private LoginBean login;
	private TasaRediferido tasa;
	private Global global;
	private List<Tipificacion> tipificacion2;
	private Rediferido rediferido;
	private Dolar dolar;

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {

		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			detalle = application.evaluateExpressionGet(context, "#{DetallesObligacionesBean}",
					DetallesObligacionesBean.class);
			login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
			try {
				fullNameAltitude = usuarioHermes.getNombre();
				tasa = rediferidoEJB.consultarTasaRediferido();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ********Métodos opciones ****************///

	public void acepto(int acepto, String numero) throws Exception {		
		this.setearPanelRediferido();
		aceptoRediferido = acepto;
		numeroObligacion = new BigDecimal(numero);
		this.setearValoresCompartidos(numeroObligacion);
		RequestContext.getCurrentInstance().update("pnlAceptoRediferido");
		
	}

	public void metodoDaviacuerdo(int acepto, String numero) throws Exception {
		this.setearPanelRediferido();
		esDaviacuerdo = acepto;
		aceptoRediferido = acepto;
		daviBono = detalle.getObligacionHoy().getDaviBono();
		numeroObligacion = new BigDecimal(numero);
		this.setearValoresCompartidos(numeroObligacion);
		RequestContext.getCurrentInstance().update("pnlAceptoRediferido");
		RequestContext.getCurrentInstance().update("pnlCampos");
	}

	public void metodoPagoTotalConsumo(int acepto, String numero) throws Exception {
		this.setearPanelRediferido();
		aceptoRediferido = acepto;
		esPagoTotal = acepto;
		montoAbono = detalle.getObligacionHoy().getMontoAbono();
		numeroObligacion = new BigDecimal(numero);
		this.setearValoresCompartidos(numeroObligacion);
		RequestContext.getCurrentInstance().update("pnlAceptoRediferido");
		RequestContext.getCurrentInstance().update("pnlCampos");
	}

	public void metodoZanahoria(int acepto, String numero) throws Exception {
		this.setearPanelRediferido();
		aceptoRediferido = acepto;
		esPagoZanahoria = acepto;
		bonoZanahoria = detalle.getObligacionHoy().getBonoZanahoria();
		numeroObligacion = new BigDecimal(numero);
		this.setearValoresCompartidos(numeroObligacion);
		RequestContext.getCurrentInstance().update("pnlAceptoRediferido");
		RequestContext.getCurrentInstance().update("pnlCampos");
	}

	public void setearValoresCompartidos(BigDecimal numeroO) throws Exception {
		global = globalEJB.consultaObservacion(numeroO);
		observaciones = global.getObservacion();
		global = globalEJB.consultarFecha();
		fechaUltimoAcuerdo = global.getFechaFormateada();
		this.obtenerHistoricoObligacion(numeroO.toString());
	}

	public void obtenerHistoricoObligacion(String numeroObligacion) throws Exception {
		historicoObligaciones = historicoObligacionEJB.historico(numeroObligacion);
	}

	public void aceptoAgendamientoMetodo(int acepto, String numero) throws Exception {		
		this.setearPanelRediferido();
		aceptoAgendamiento = acepto;
		usuarioHermes = login.getUsuarioHermes();
		fullNameAltitude = usuarioHermes.getNombre();
		this.verDetalleObligacion(1);
		RequestContext.getCurrentInstance().update("pnlAceptoRediferido");
	}

	public void setearPanelRediferido() {
		agendo = 0;
		aceptoAgendamiento = 0;
		aceptoRediferido = 0;
		agendo = 0;
		esPagoTotal = 0;
		esDaviacuerdo = 0;
		esPagoZanahoria = 0;
	}

	public void agendamiento(int acepto, String numero) throws Exception {
		this.setearPanelRediferido();
		agendo = acepto;
		RequestContext.getCurrentInstance().update("pnlAceptoRediferido");
	}

	public void verDetalleObligacion(int opcion) {
		opcionDetalles = opcion;
		RequestContext.getCurrentInstance().update("obligacion");
		RequestContext.getCurrentInstance().update("principal");
	}

	public void verReestructuracionSimplificada(int opcion) {
		this.setearValoresPanelOtrosDatos();
		opcionReestructuracion = opcion;
		this.listaMeses();
		this.listaTiposReestructuracion();
		RequestContext.getCurrentInstance().update("pnlOtrosDatos");
	}

	public void listaTiposReestructuracion() {
		// se cargan valores a los campos
		tipoReestructuracion = new ArrayList<>();
		tipoReestructuracion.add("Reestructuración");
		tipoReestructuracion.add("Normalización");
	}

	public void listaMeses() {
		// se cargan valores a los campos
		plazoMeses = new ArrayList<>();
		plazoMeses.add(6);
		plazoMeses.add(12);
		plazoMeses.add(18);
		plazoMeses.add(24);
		plazoMeses.add(36);
		plazoMeses.add(48);
		plazoMeses.add(72);
	}

	public void verSinAcuerdo(int opcion) {
		this.setearValoresPanelOtrosDatos();
		opcionSinAcuerdo = opcion;
		RequestContext.getCurrentInstance().update("pnlOtrosDatos");
	}

	public void verNoContacto(String idTipoResultado, int opcion) throws Exception {
		opcionMensajeTercero = 0;
		opcionContactoTitular = 0;
		noContacto = opcion;
	//listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion(idTipoResultado);
		RequestContext.getCurrentInstance().update("opcionesContacto");
	}

	public void verMensajeTercero(String idTipoResultado, int opcion) throws Exception {
		noContacto = 0;
		opcionContactoTitular = 0;
		opcionMensajeTercero = opcion;
		this.listaAfinidadesTerceros();
		RequestContext.getCurrentInstance().update("opcionesContacto");
	}

	public void listaAfinidadesTerceros() throws Exception {
		// se cargan valores a los campos
		listaAfinidades = new ArrayList<>();
		listaAfinidades = globalEJB.consultarAfinidad();
	}

	public void listaMotivosNoPago() throws Exception {
		// se cargan valores a los campos
		listaMotivoNoPago = new ArrayList<>();
		listaMotivoNoPago = globalEJB.consultarMotivosNoPago();
	}

	public void verContactoTitular(String idTipoResultado, int opcion) throws Exception {
		noContacto = 0;
		opcionMensajeTercero = 0;
		opcionContactoTitular = opcion;
		this.listaMotivosNoPago();
		RequestContext.getCurrentInstance().update("opcionesContacto");
	}

	public void verRediferido(int opcion1, String numero) throws Exception {
		this.setearValoresPanelOtrosDatos();
		opcionRediferido = opcion1;

		numeroObligacion = new BigDecimal(numero);
		this.obtenerRediferidoPorObligacion(numeroObligacion);
		this.obtenerTasaRediferido();
		dolar = dolarEJB.consultarDolar();

		this.listaMeses();

		saldoTotal = rediferido.getSaldoDolares();
		pagoMinInicial = rediferido.getPagoMinDolares();
		//tasaMenusal = tasa.getValor();
		trm = dolar.getValor();
		this.valorSaldoDolar = ((rediferido.getSaldoDolares().intValue()) * (dolar.getValor().intValue()));
		saldoTotalPesos = valorSaldoDolar;
		this.valorMinDolar = ((rediferido.getPagoMinDolares().intValue()) * (dolar.getValor().intValue()));
		pagoMinPesos = valorMinDolar;
		this.valorMoraDolar = ((rediferido.getSaldoMoraDolares().intValue()) * (dolar.getValor().intValue()));
		moraPesos = valorMoraDolar;

		RequestContext.getCurrentInstance().update("pnlOtrosDatos");
	}

	public void obtenerRediferidoPorObligacion(BigDecimal numeroObligacion) throws Exception {
		rediferido = rediferidoEJB.consultarRediferidoPorObligacion(numeroObligacion);
	}

	public void obtenerTasaRediferido() throws Exception {
		tasa = rediferidoEJB.consultarTasaRediferido();
	}

	public void verNormalizacion(int opcion1, String numero) throws Exception {
		this.setearValoresPanelOtrosDatos();
		opcionNormalizacion = opcion1;
		numeroObligacion = new BigDecimal(numero);
		this.obtenerRediferidoPorObligacion(numeroObligacion);
		this.obtenerTasaRediferido();
		dolar = dolarEJB.consultarDolar();

		this.listaMeses();

		saldoTotal = rediferido.getSaldoDolares();
		pagoMinInicial = rediferido.getPagoMinDolares();

		this.listaTasas();

		//tasaMenusal = tasa.getValor();
		trm = dolar.getValor();
		this.valorSaldoDolar = ((rediferido.getSaldoDolares().intValue()) * (dolar.getValor().intValue()));
		saldoTotalPesos = valorSaldoDolar;
		this.valorMinDolar = ((rediferido.getPagoMinDolares().intValue()) * (dolar.getValor().intValue()));
		pagoMinPesos = valorMinDolar;
		this.valorMoraDolar = ((rediferido.getSaldoMoraDolares().intValue()) * (dolar.getValor().intValue()));
		moraPesos = valorMoraDolar;

		RequestContext.getCurrentInstance().update("pnlOtrosDatos");
	}

	public void setearValoresPanelOtrosDatos() {
		opcionRediferido = 0;
		opcionNormalizacion = 0;
		opcionNormalizacionVirtual = 0;
		opcionReestructuracion = 0;
		opcionSinAcuerdo = 0;
	}

	public void listaTasas() {
		// se cargan valores a los campos
		tasaMensual = new ArrayList<>();
		tasaMensual.add((float) 0.7);
		tasaMensual.add((float) 1);
		tasaMensual.add((float) 1.3);
		tasaMensual.add((float) 1.6);
		tasaMensual.add((float) 1.7);
	}

	public void verNormalizacionVirtual(int opcion1, String numero) throws Exception {
		this.setearValoresPanelOtrosDatos();
		opcionNormalizacionVirtual = opcion1;
		numeroObligacion = new BigDecimal(numero);
		this.obtenerRediferidoPorObligacion(numeroObligacion);
		this.obtenerTasaRediferido();
		dolar = dolarEJB.consultarDolar();

		this.listaMeses();

		saldoTotal = rediferido.getSaldoDolares();
		pagoMinInicial = rediferido.getPagoMinDolares();

		this.listaTasas();

		//tasaMenusal = tasa.getValor();
		trm = dolar.getValor();
		this.valorSaldoDolar = ((rediferido.getSaldoDolares().intValue()) * (dolar.getValor().intValue()));
		saldoTotalPesos = valorSaldoDolar;
		this.valorMinDolar = ((rediferido.getPagoMinDolares().intValue()) * (dolar.getValor().intValue()));
		pagoMinPesos = valorMinDolar;
		this.valorMoraDolar = ((rediferido.getSaldoMoraDolares().intValue()) * (dolar.getValor().intValue()));
		moraPesos = valorMoraDolar;

		RequestContext.getCurrentInstance().update("pnlOtrosDatos");
	}

	/// **********get y set *****************///

	public int getAceptoAgendamiento() {
		return aceptoAgendamiento;
	}

	public int getAgendo() {
		return agendo;
	}

	public int getOpcionNormalizacionVirtual() {
		return opcionNormalizacionVirtual;
	}

	public void setOpcionNormalizacionVirtual(int opcionNormalizacionVirtual) {
		this.opcionNormalizacionVirtual = opcionNormalizacionVirtual;
	}

	public int getOpcionDetalles() {
		return opcionDetalles;
	}

	public void setOpcionDetalles(int opcionDetalles) {
		this.opcionDetalles = opcionDetalles;
	}

	public int getNoContacto() {
		return noContacto;
	}

	public void setNoContacto(int noContacto) {
		this.noContacto = noContacto;
	}

	public int getOpcionMensajeTercero() {
		return opcionMensajeTercero;
	}

	public void setopcionMensajeTercero(int opcionMensajeTercero) {
		this.opcionMensajeTercero = opcionMensajeTercero;
	}

	public void setOpcionMensajeTercero(int opcionMensajeTercero) {
		this.opcionMensajeTercero = opcionMensajeTercero;
	}

	public int getOpcionContactoTitular() {
		return opcionContactoTitular;
	}

	public void setOpcionContactoTitular(int opcionContactoTitular) {
		this.opcionContactoTitular = opcionContactoTitular;
	}

	public int getOpcionReestructuracion() {
		return opcionReestructuracion;
	}

	public void setOpcionReestructuracion(int opcionReestructuracion) {
		this.opcionReestructuracion = opcionReestructuracion;
	}

	public int getOpcionSinAcuerdo() {
		return opcionSinAcuerdo;
	}

	public void setOpcionSinAcuerdo(int opcionSinAcuerdo) {
		this.opcionSinAcuerdo = opcionSinAcuerdo;
	}

	public ITipificacionEJBLocal getTipificacionEJB() {
		return tipificacionEJB;
	}

	public void setTipificacionEJB(ITipificacionEJBLocal tipificacionEJB) {
		this.tipificacionEJB = tipificacionEJB;
	}

	public IHistoricoObligacionEJBLocal getHistoricoObligacionEJB() {
		return historicoObligacionEJB;
	}

	public void setHistoricoObligacionEJB(IHistoricoObligacionEJBLocal historicoObligacionEJB) {
		this.historicoObligacionEJB = historicoObligacionEJB;
	}

	public IRediferidoEJBLocal getRediferidoEJB() {
		return rediferidoEJB;
	}

	public void setRediferidoEJB(IRediferidoEJBLocal rediferidoEJB) {
		this.rediferidoEJB = rediferidoEJB;
	}

	public IDolarEJBLocal getDolarEJB() {
		return dolarEJB;
	}

	public void setDolarEJB(IDolarEJBLocal dolarEJB) {
		this.dolarEJB = dolarEJB;
	}

	public IGlobalEJBLocal getGlobalEJB() {
		return globalEJB;
	}

	public void setGlobalEJB(IGlobalEJBLocal globalEJB) {
		this.globalEJB = globalEJB;
	}

	public String getFullNameAltitude() {
		return fullNameAltitude;
	}

	public void setFullNameAltitude(String fullNameAltitude) {
		this.fullNameAltitude = fullNameAltitude;
	}

	public BigDecimal getDaviBono() {
		return daviBono;
	}

	public void setDaviBono(BigDecimal daviBono) {
		this.daviBono = daviBono;
	}

	public BigDecimal getNumeroObligacion() {
		return numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public BigDecimal getMontoAbono() {
		return montoAbono;
	}

	public void setMontoAbono(BigDecimal montoAbono) {
		this.montoAbono = montoAbono;
	}

	public BigDecimal getBonoZanahoria() {
		return bonoZanahoria;
	}

	public void setBonoZanahoria(BigDecimal bonoZanahoria) {
		this.bonoZanahoria = bonoZanahoria;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getFechaUltimoAcuerdo() {
		return fechaUltimoAcuerdo;
	}

	public void setFechaUltimoAcuerdo(String fechaUltimoAcuerdo) {
		this.fechaUltimoAcuerdo = fechaUltimoAcuerdo;
	}

	public List<HistoricoObligacion> getHistoricoObligaciones() {
		return historicoObligaciones;
	}

	public void setHistoricoObligaciones(List<HistoricoObligacion> historicoObligaciones) {
		this.historicoObligaciones = historicoObligaciones;
	}

	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public BigDecimal getPagoMinInicial() {
		return pagoMinInicial;
	}

	public void setPagoMinInicial(BigDecimal pagoMinInicial) {
		this.pagoMinInicial = pagoMinInicial;
	}

	public long getSaldoTotalPesos() {
		return saldoTotalPesos;
	}

	public void setSaldoTotalPesos(long saldoTotalPesos) {
		this.saldoTotalPesos = saldoTotalPesos;
	}

	public BigDecimal getTasaMenusal() {
		return tasaMenusal;
	}

	public void setTasaMenusal(BigDecimal tasaMenusal) {
		this.tasaMenusal = tasaMenusal;
	}

	public long getValorSaldoDolar() {
		return valorSaldoDolar;
	}

	public void setValorSaldoDolar(long valorSaldoDolar) {
		this.valorSaldoDolar = valorSaldoDolar;
	}

	public long getValorMinDolar() {
		return valorMinDolar;
	}

	public void setValorMinDolar(long valorMinDolar) {
		this.valorMinDolar = valorMinDolar;
	}

	public long getPagoMinPesos() {
		return pagoMinPesos;
	}

	public void setPagoMinPesos(long pagoMinPesos) {
		this.pagoMinPesos = pagoMinPesos;
	}

	public long getValorMoraDolar() {
		return valorMoraDolar;
	}

	public void setValorMoraDolar(long valorMoraDolar) {
		this.valorMoraDolar = valorMoraDolar;
	}

	public long getMoraPesos() {
		return moraPesos;
	}

	public void setMoraPesos(long moraPesos) {
		this.moraPesos = moraPesos;
	}

	public List<Integer> getPlazoMeses() {
		return plazoMeses;
	}

	public void setPlazoMeses(List<Integer> plazoMeses) {
		this.plazoMeses = plazoMeses;
	}


	public List<String> getTipoReestructuracion() {
		return tipoReestructuracion;
	}

	public void setTipoReestructuracion(List<String> tipoReestructuracion) {
		this.tipoReestructuracion = tipoReestructuracion;
	}

	
	public List<Float> getTasaMensual() {
		return tasaMensual;
	}

	public void setTasaMensual(List<Float> tasaMensual) {
		this.tasaMensual = tasaMensual;
	}

	
	public List<Global> getListaAfinidades() {
		return listaAfinidades;
	}

	public void setListaAfinidades(List<Global> listaAfinidades) {
		this.listaAfinidades = listaAfinidades;
	}

	
	public List<Global> getListaMotivoNoPago() {
		return listaMotivoNoPago;
	}

	public void setListaMotivoNoPago(List<Global> listaMotivoNoPago) {
		this.listaMotivoNoPago = listaMotivoNoPago;
	}

	public BigDecimal getTrm() {
		return trm;
	}

	public void setTrm(BigDecimal trm) {
		this.trm = trm;
	}

	public int getAceptoRediferido() {
		return aceptoRediferido;
	}

	public void setAceptoRediferido(int aceptoRediferido) {
		this.aceptoRediferido = aceptoRediferido;
	}

	public int getEsDaviacuerdo() {
		return esDaviacuerdo;
	}

	public void setEsDaviacuerdo(int esDaviacuerdo) {
		this.esDaviacuerdo = esDaviacuerdo;
	}

	public int getEsPagoTotal() {
		return esPagoTotal;
	}

	public void setEsPagoTotal(int esPagoTotal) {
		this.esPagoTotal = esPagoTotal;
	}

	public int getEsPagoZanahoria() {
		return esPagoZanahoria;
	}

	public void setEsPagoZanahoria(int esPagoZanahoria) {
		this.esPagoZanahoria = esPagoZanahoria;
	}

	public int getOpcionRediferido() {
		return opcionRediferido;
	}

	public void setOpcionRediferido(int opcionRediferido) {
		this.opcionRediferido = opcionRediferido;
	}

	public int getOpcionNormalizacion() {
		return opcionNormalizacion;
	}

	public void setOpcionNormalizacion(int opcionNormalizacion) {
		this.opcionNormalizacion = opcionNormalizacion;
	}

	public DetallesObligacionesBean getDetalle() {
		return detalle;
	}

	public void setDetalle(DetallesObligacionesBean detalle) {
		this.detalle = detalle;
	}

	public UsuarioHermes getUsuarioHermes() {
		return usuarioHermes;
	}

	public void setUsuarioHermes(UsuarioHermes usuarioHermes) {
		this.usuarioHermes = usuarioHermes;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public TasaRediferido getTasa() {
		return tasa;
	}

	public void setTasa(TasaRediferido tasa) {
		this.tasa = tasa;
	}

	public Global getGlobal() {
		return global;
	}

	public void setGlobal(Global global) {
		this.global = global;
	}
	
	public List<Tipificacion> getTipificacion2() {
		return tipificacion2;
	}

	public void setTipificacion2(List<Tipificacion> tipificacion2) {
		this.tipificacion2 = tipificacion2;
	}

	public Rediferido getRediferido() {
		return rediferido;
	}

	public void setRediferido(Rediferido rediferido) {
		this.rediferido = rediferido;
	}

	public Dolar getDolar() {
		return dolar;
	}

	public void setDolar(Dolar dolar) {
		this.dolar = dolar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAceptoAgendamiento(int aceptoAgendamiento) {
		this.aceptoAgendamiento = aceptoAgendamiento;
	}

	public void setAgendo(int agendo) {
		this.agendo = agendo;
	}


	public List<Tipificacion> getListaTipificaciones() {
		return listaTipificaciones;
	}

	public void setListaTipificaciones(List<Tipificacion> listaTipificaciones) {
		this.listaTipificaciones = listaTipificaciones;
	}
	
	
	
	

}
