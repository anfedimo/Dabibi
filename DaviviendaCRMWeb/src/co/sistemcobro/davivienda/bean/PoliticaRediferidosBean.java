package co.sistemcobro.davivienda.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;

import org.apache.log4j.Logger;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.primefaces.context.RequestContext;

import co.sistemcobro.davivienda.ejb.IDolarEJBLocal;
import co.sistemcobro.davivienda.ejb.IGlobalEJBLocal;
import co.sistemcobro.davivienda.ejb.IHistoricoObligacionEJBLocal;
import co.sistemcobro.davivienda.ejb.IRediferidoEJBLocal;
import co.sistemcobro.davivienda.ejb.ITipificacionEJBLocal;
import co.sistemcobro.davivienda.session.LoginBean;

@ManagedBean(name = "politicaRediferidoBean")
@ViewScoped
public class PoliticaRediferidosBean implements Serializable {

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

	private Tipificacion tipificacion;
	private List<Tipificacion> tipificacion2;
	private TasaRediferido tasa;
	private UsuarioHermes usuarioHermes;
	private ObligacionHoy obligacionHoy;
	private Global global;
	private Rediferido rediferido;
	private List<HistoricoObligacion> historicoObligaciones;
	private List<Global> simuladorCuotas;
	private Global simuladorCuota;

	private int aceptoRediferido;
	private int esDaviacuerdo;
	private int esPagoTotal;
	private int esPagoZanahoria;
	private int aceptoAgendamiento;
	private int aceptoAgendamientoContacto;
	private int opcionRediferido;
	private int opcionReestructuracion;
	private int opcionSinAcuerdo;
	private int opcionSinAcuerdoRediferido;
	private int opcionDetalles;
	private int opcionNormalizacion;
	private int opcionRediferidoNormal;
	private int opcionNormalizacionVirtual;
	private int agendo;
	private int noContacto;
	private int opcionMensajeTercero;
	private int opcionContactoTitular;
	private String negociacion;
	private int idPolitica;

	// campos
	private List<Integer> plazoMeses;
	private int selectedMeses;
	private String selectedTipificacion;
	private List<Tipificacion> listaTipificaciones;
	private List<String> tipoReestructuracion;
	private String selectedReestructuracion;
	private List<Float> tasaMensual;
	private float selectedTasas;
	private int selectedAfinidad;
	private List<Global> listaAfinidades;
	private int selectedMotivoNoPago;
	private List<Global> listaMotivoNoPago;
	private BigDecimal trm;
	private BigDecimal pagoMinInicial;
	private BigDecimal cuotaMinInicial;
	private BigDecimal saldoTotal;
	private BigDecimal saldoTotalPesos;
	private BigDecimal pagoMinPesos;
	private BigDecimal moraDolares;
	private BigDecimal moraPesos;
	private BigDecimal pagoCliente;
	private BigDecimal pagoClientePesos;
	private Double tasaMenusal;

	// campos promesa
	private BigDecimal valorPromesa;
	private String observacion;
	private String observaciones;
	private Date fechaPromesa;
	private String fechaUltimoAcuerdo;

	// campos agenda llamada
	private String telefonoLlamar;
	private Date date11;
	private Date fechaUbicacion;

	// daviacuerdo
	private BigDecimal daviBono;
	private BigDecimal daviAbono;
	private BigDecimal montoAbono;
	private BigDecimal bonoDescuento;
	private BigDecimal abonoZanahoria;
	private BigDecimal bonoZanahoria;

	private BigDecimal numeroObligacion;
	private Dolar dolar;
	private BigDecimal valorSaldoDolar;
	private BigDecimal valorMinDolar;
	private BigDecimal valorMoraDolar;
	private LoginBean login;
	private AgendamientoBean agendamiento;
	private String fullNameAltitude;
	private DetallesObligacionesBean detalle;

	// contacto
	private String nombreTercero;
	private Integer afinidadTercero;
	private String mensajeTercero;

	// reestructuracion
	private BigDecimal simuladoPrimeraCuota;
	private BigDecimal pagoclienteReestruc;
	private Date fechaDocumentacion;
	private BigDecimal saldoTotalreestruc;

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(PoliticaRediferidosBean.class);

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			detalle = application.evaluateExpressionGet(context, "#{DetallesObligacionesBean}",
					DetallesObligacionesBean.class);
			login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
			agendamiento = application.evaluateExpressionGet(context, "#{agendamientoBean}", AgendamientoBean.class);
			usuarioHermes = new UsuarioHermes();
			try {
				fullNameAltitude = usuarioHermes.getNombre();
				tasa = rediferidoEJB.consultarTasaRediferido();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ********M�todos opciones ****************///

	/**
	 * setearTodo. m�todo para setear campos utilizados en el bean
	 * 
	 * @author Camilo Ochoa
	 * @param ninguno
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido
	 *      PoliticaRediferidosBean
	 */
	public void setearTodo() {
		try {
			this.setearValoresPanelOtrosDatos();
			this.setearPanelRediferido();
			aceptoAgendamiento = 0;
			aceptoAgendamientoContacto = 0;
			noContacto = 0;
			opcionMensajeTercero = 0;
			opcionContactoTitular = 0;
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
			RequestContext.getCurrentInstance().update("opcionesContacto");
			RequestContext.getCurrentInstance().update("obligacion");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo setearTodo");
		}

	}

	/**
	 * obtenerSimulador. m�todo para buscar las cuotas segun rediferido
	 * 
	 * @author Camilo Ochoa
	 * @param idRediferido
	 *            Integer (id del rediferido)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return cuotas del simulador
	 * @see EJB globalEJB, m�todo simuladorCuota
	 */
	public void obtenerSimulador(Integer idRediferido) {
		try {
			if (idRediferido != 0) {
				Integer numCuotas = selectedMeses;
				selectedMeses = numCuotas;
				if (numCuotas == 0 || numCuotas == null) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Por favor seleccione el plazo"));
				} else {
					simuladorCuotas = globalEJB.consultarSimulador(numCuotas, idRediferido);
					simuladorCuota = globalEJB.consultarSimuladorCuota(numCuotas, idRediferido);
					cuotaMinInicial = simuladorCuota.getCuota();
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "No hay informaci�n"));
			}
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo obtenerSimulador");
		}
	}

	/**
	 * acepto. m�todo para revisar si se acepto
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (decisi�n), String numero (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido, EJB
	 *      tipificacionEJB
	 */
	public void acepto(int acepto, String numero) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			aceptoRediferido = acepto;
			listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();
			numeroObligacion = new BigDecimal(numero);
			this.setearValoresCompartidos(numeroObligacion);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo acepto");
		}
	}

	/**
	 * aceptoReestructuracion. m�todo para revisar si se acepto la
	 * reestructuraci�n
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (decisi�n), String numero (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido, EJB
	 *      tipificacionEJB
	 */
	public void aceptoReestructuracion(int acepto, String numero) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			aceptoRediferido = acepto;
			listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();
			numeroObligacion = new BigDecimal(numero);
			this.setearValoresCompartidos(numeroObligacion);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoReestructuracion");
		}
	}

	/**
	 * aceptoReddiferido. m�todo para revisar si se acepto el rediferido
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (decisi�n), String numero (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido,
	 *      setearValoresCompartidos, EJB tipificacionEJB
	 */
	public void aceptoReddiferido(int acepto, String numero) {
		try {
			if (selectedMeses != 0) {
				if (valorPromesa != null) {
					this.setearPanelRediferido();
					this.setearValoresPanelOtrosDatos();
					aceptoRediferido = acepto;
					listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();
					numeroObligacion = new BigDecimal(numero);
					this.setearValoresCompartidos(numeroObligacion);
					RequestContext.getCurrentInstance().update("pnlOtrosDatos");

				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos "));
				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos  "));
			}
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo aceptoReddiferido");
		}
	}

	/**
	 * aceptoNormalizacion. m�todo para revisar si se acepto la normalizaci�n
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (decisi�n), String numero (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido,
	 *      setearValoresCompartidos, EJB tipificacionEJB
	 */
	public void aceptoNormalizacion(int acepto, String numero) {
		try {
			if (selectedMeses != 0) {
				if (valorPromesa != null) {
					if (tasaMenusal != null) {
						this.setearPanelRediferido();
						this.setearValoresPanelOtrosDatos();
						aceptoRediferido = acepto;
						listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();
						numeroObligacion = new BigDecimal(numero);
						this.setearValoresCompartidos(numeroObligacion);
						RequestContext.getCurrentInstance().update("pnlOtrosDatos");
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error", "Por favor diligencie los campos 3"));
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 4 "));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos  5 "));
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoNormalizacion");
		}
	}

	/**
	 * metodoDaviacuerdo. m�todo para revisar si se acepto daviacuerdo
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (decisi�n), String numero (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido,
	 *      setearValoresCompartidos, EJB tipificacionEJB
	 */
	public void metodoDaviacuerdo(int acepto, String numero, String nego, int politica) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			esDaviacuerdo = acepto;
			aceptoRediferido = acepto;
			negociacion = nego;
			idPolitica = politica;
			listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();

			daviBono = detalle.getObligacionHoy().getDaviBono();
			numeroObligacion = new BigDecimal(numero);
			this.setearValoresCompartidos(numeroObligacion);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
			RequestContext.getCurrentInstance().update("pnlCampos");
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo metodoDaviacuerdo");
		}
	}

	/**
	 * metodoPagoTotalConsumo. m�todo para revisar si se acepto el pago total de
	 * consumo
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (decisi�n), String numero (n�mero de obligaci�n),
	 *            String nego (negociaci�n realizada), int politica (politica
	 *            gestionada)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido,
	 *      setearValoresCompartidos, EJB tipificacionEJB
	 */
	public void metodoPagoTotalConsumo(int acepto, String numero, String nego, int politica) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			aceptoRediferido = acepto;
			listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();
			esPagoTotal = acepto;
			negociacion = nego;
			idPolitica = politica;
			montoAbono = detalle.getObligacionHoy().getMontoAbono();
			numeroObligacion = new BigDecimal(numero);
			this.setearValoresCompartidos(numeroObligacion);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
			RequestContext.getCurrentInstance().update("pnlCampos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo metodoPagoTotalConsumo");
		}
	}

	/**
	 * metodoZanahoria. m�todo para revisar si se acepto el plan zanahoria
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (decisi�n), String numero (n�mero de obligaci�n),
	 *            String nego (negociaci�n realizada), int politica (politica
	 *            gestionada)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos, setearPanelRediferido,
	 *      setearValoresCompartidos, EJB tipificacionEJB
	 */
	public void metodoZanahoria(int acepto, String numero, String nego, int politica) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			aceptoRediferido = acepto;
			esPagoZanahoria = acepto;
			negociacion = nego;
			idPolitica = politica;
			listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();
			bonoZanahoria = detalle.getObligacionHoy().getBonoZanahoria();
			numeroObligacion = new BigDecimal(numero);
			this.setearValoresCompartidos(numeroObligacion);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
			RequestContext.getCurrentInstance().update("pnlCampos");
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo metodoZanahoria");
		}
	}

	/**
	 * setearValoresCompartidos. m�todo para revisar valores compartidas
	 * 
	 * @author Camilo Ochoa
	 * @param BigDecimal
	 *            numeroO (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see EJB globalEJB, m�todo obtenerHistoricoObligacion
	 */
	public void setearValoresCompartidos(BigDecimal numeroO) {
		try {
			global = globalEJB.consultaObservacion(numeroO);
			observaciones = global.getObservacion();
			global = globalEJB.consultarFecha();
			fechaUltimoAcuerdo = global.getFechaFormateada();
			this.obtenerHistoricoObligacion(numeroO.toString());
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo setearValoresCompartidos");
		}
	}

	/**
	 * obtenerHistoricoObligacion. m�todo para revisar valores compartidas
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            numeroObligacion (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see EJB historicoObligacionEJB
	 */
	public void obtenerHistoricoObligacion(String numeroObligacion) {
		try {
			historicoObligaciones = historicoObligacionEJB.historico(numeroObligacion);
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo obtenerHistoricoObligacion");
		}
	}

	/**
	 * aceptoAgendamientoMetodoContacto. m�todo para revisar si se acepto
	 * agendamiento
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto String numeroObligacion (n�mero de obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see EJB historicoObligacionEJB
	 */
	public void aceptoAgendamientoMetodoContacto(int acepto, String numero) {
		try {
			if (selectedTipificacion != "") {
				if (!observacion.isEmpty()) {
					this.setearPanelRediferido();
					this.setearValoresPanelOtrosDatos();
					aceptoAgendamientoContacto = acepto;
					usuarioHermes = login.getUsuarioHermes();
					fullNameAltitude = usuarioHermes.getNombre();
					this.verDetalleObligacion(1);
					RequestContext.getCurrentInstance().update("obligacion");
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 6 "));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 7 "));
			}

		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoAgendamientoMetodoContacto");
		}
	}

	/**
	 * aceptoAgendamientoMetodoDaviacuerdo. m�todo para revisar si se acepto el
	 * daviacuerdo
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos, Bean
	 *      login
	 */
	public void aceptoAgendamientoMetodoDaviacuerdo(int acepto, String numero) {
		try {
			if (daviAbono != null) {
				if (fechaPromesa != null) {
					if (valorPromesa != null) {
						if (!observacion.isEmpty()) {
							this.setearPanelRediferido();
							this.setearValoresPanelOtrosDatos();
							aceptoAgendamiento = acepto;
							usuarioHermes = login.getUsuarioHermes();
							fullNameAltitude = usuarioHermes.getNombre();
							this.verDetalleObligacion(1);
							RequestContext.getCurrentInstance().update("obligacion");
						} else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 8"));
						}
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error", "Por favor diligencie los campos 9"));
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 10 "));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 11"));
			}

		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoAgendamientoMetodoDaviacuerdo");
		}
	}

	/**
	 * aceptoAgendamientoMetodoPagoTotal. m�todo para revisar si se acepto el
	 * pago total
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos,
	 *      verDetalleObligacion, Bean login
	 */
	public void aceptoAgendamientoMetodoPagoTotal(int acepto, String numero) {
		try {
			if (montoAbono != null) {
				if (fechaPromesa != null) {
					if (valorPromesa != null) {
						if (!observacion.isEmpty()) {
							this.setearPanelRediferido();
							this.setearValoresPanelOtrosDatos();
							aceptoAgendamiento = acepto;
							usuarioHermes = login.getUsuarioHermes();
							fullNameAltitude = usuarioHermes.getNombre();
							this.verDetalleObligacion(1);
							RequestContext.getCurrentInstance().update("obligacion");
						} else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 12 "));
						}
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error", "Por favor diligencie los campos 13 "));
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 14 "));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 15"));
			}

		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoAgendamientoMetodoPagoTotal");
		}
	}

	/**
	 * aceptoAgendamientoMetodoPagoZanahoria. m�todo para revisar si se acepto
	 * el pago zanahoria
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos,
	 *      verDetalleObligacion, Bean login
	 */
	public void aceptoAgendamientoMetodoPagoZanahoria(int acepto, String numero) {
		try {
			if (abonoZanahoria != null) {
				if (fechaPromesa != null) {
					if (valorPromesa != null) {
						if (!observacion.isEmpty()) {
							this.setearPanelRediferido();
							this.setearValoresPanelOtrosDatos();
							aceptoAgendamiento = acepto;
							usuarioHermes = login.getUsuarioHermes();
							fullNameAltitude = usuarioHermes.getNombre();
							this.verDetalleObligacion(1);
							RequestContext.getCurrentInstance().update("obligacion");
						} else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 16 "));
						}
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error", "Por favor diligencie los campos 17"));
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 18"));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 19"));
			}

		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoAgendamientoMetodoPagoZanahoria");
		}
	}

	/**
	 * aceptoAgendamientoMetodo. m�todo para revisar si se acepto el
	 * agendamiento
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos,
	 *      verDetalleObligacion, Bean login
	 */
	public void aceptoAgendamientoMetodo(int acepto, String numero) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			aceptoAgendamiento = acepto;
			usuarioHermes = login.getUsuarioHermes();
			fullNameAltitude = usuarioHermes.getNombre();
			this.verDetalleObligacion(1);
			RequestContext.getCurrentInstance().update("obligacion");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoAgendamientoMetodo");
		}
	}

	/**
	 * aceptoAgendamientoMetodoConValidacion. m�todo para revisar si se acepto
	 * el agendamiento con validaciones
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos,
	 *      verDetalleObligacion, Bean login
	 */
	public void aceptoAgendamientoMetodoConValidacion(int acepto, String numero) {
		try {
			if (fechaPromesa != null) {
				if (valorPromesa != null) {
					if (!observacion.isEmpty()) {
						this.setearPanelRediferido();
						this.setearValoresPanelOtrosDatos();
						aceptoAgendamiento = acepto;
						usuarioHermes = login.getUsuarioHermes();
						fullNameAltitude = usuarioHermes.getNombre();
						this.verDetalleObligacion(1);
						RequestContext.getCurrentInstance().update("obligacion");
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error", "Por favor diligencie los campos 20 "));
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 21 "));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 22 "));
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo aceptoAgendamientoMetodoConValidacion");
		}
	}

	/**
	 * setearPanelRediferido. m�todo para setear opciones a 0
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcionSinAcuerdoRediferido,agendo,aceptoAgendamiento,
	 *            aceptoAgendamientoContacto, aceptoRediferido, esPagoTotal,
	 *            esDaviacuerdo, esPagoZanahoria
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see N/A
	 */
	public void setearPanelRediferido() {
		opcionSinAcuerdoRediferido = 0;
		agendo = 0;
		aceptoAgendamiento = 0;
		aceptoAgendamientoContacto = 0;
		aceptoRediferido = 0;
		esPagoTotal = 0;
		esDaviacuerdo = 0;
		esPagoZanahoria = 0;
	}

	/**
	 * agendamiento. m�todo para revisar si se acepto el agendamiento
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos,
	 *      verDetalleObligacion
	 */
	public void agendamiento(int acepto, String numero) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			agendo = acepto;
			this.verDetalleObligacion(1);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");

		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo agendamiento");
		}
	}

	/**
	 * agendamientoLlamada. m�todo para revisar si se acepto el agendamiento de
	 * llamada
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos,
	 *      verDetalleObligacion
	 */
	public void agendamientoLlamada(int acepto, String numero) {
		try {
				if (!telefonoLlamar.isEmpty()) {
					this.setearPanelRediferido();
					this.setearValoresPanelOtrosDatos();
					agendo = acepto;
					this.verDetalleObligacion(1);
					RequestContext.getCurrentInstance().update("pnlOtrosDatos");
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos  "));
				}
			
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo agendamientoLlamada");
		}
	}

	/**
	 * agendamientoMensaje. m�todo para revisar si se acepto el agendamiento del
	 * tercero
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            acepto (desici�n), String numeroObligacion (n�mero de
	 *            obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearPanelRediferido,setearValoresPanelOtrosDatos,
	 *      verDetalleObligacion
	 */
	public void agendamientoMensaje(int acepto, String numero) {
		try {
			if (!nombreTercero.isEmpty()) {
				if (selectedAfinidad != 0) {
					if (!mensajeTercero.isEmpty()) {
						if (!observacion.isEmpty()) {
							this.setearPanelRediferido();
							this.setearValoresPanelOtrosDatos();
							agendo = acepto;
							this.verDetalleObligacion(1);
							RequestContext.getCurrentInstance().update("pnlOtrosDatos");
						} else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 25"));
						}
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error", "Por favor diligencie los campos 26"));
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 27"));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 28"));
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo agendamientoMensaje");
		}

	}

	/**
	 * verDetalleObligacion. m�todo para update en JSF
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see N/A
	 */
	public void verDetalleObligacion(int opcion) {
		opcionDetalles = opcion;
		RequestContext.getCurrentInstance().update("obligacion");
		RequestContext.getCurrentInstance().update("principal");
	}

	/**
	 * verDetalleObligacion. m�todo para update en JSF
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see N/A
	 */
	public void verDetalleObligacionMotivoNoPago(int opcion) {
		try {
			if (selectedMotivoNoPago != 0) {
				opcionDetalles = opcion;
				RequestContext.getCurrentInstance().update("obligacion");
				RequestContext.getCurrentInstance().update("principal");
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor diligencie los campos 29"));
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo verDetalleObligacionMotivoNoPago");
		}
	}

	/**
	 * verReestructuracionSimplificada. m�todo para validar la reestructuraci�n
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos listaMeses, listaTiposReestructuracion,
	 *      setearValoresPanelOtrosDatos
	 */
	public void verReestructuracionSimplificada(int opcion, String nego) {
		try {
			this.setearValoresPanelOtrosDatos();
			opcionReestructuracion = opcion;
			negociacion = nego;
			this.listaMeses();
			this.listaTiposReestructuracion();
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo verReestructuracionSimplificada");
		}
	}

	/**
	 * listaTiposReestructuracion. m�todo para listar los tipos de
	 * reesctructuraci�n
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see N/A
	 */
	public void listaTiposReestructuracion() {
		try {
			// se cargan valores a los campos
			tipoReestructuracion = new ArrayList<>();
			tipoReestructuracion.add("Reestructuraci�n");
			tipoReestructuracion.add("Normalizaci�n");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo listaTiposReestructuracion");
		}
	}

	/**
	 * listaMeses. m�todo para listar los meses
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see N/A
	 */
	public void listaMeses() {
		try {
			// se cargan valores a los campos
			plazoMeses = new ArrayList<>();
			plazoMeses.add(6);
			plazoMeses.add(12);
			plazoMeses.add(18);
			plazoMeses.add(24);
			plazoMeses.add(36);
			plazoMeses.add(48);
			plazoMeses.add(72);
			plazoMeses.add(84);
			plazoMeses.add(92);
			plazoMeses.add(108);
			plazoMeses.add(120);
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo listaMeses");
		}
	}

	/**
	 * verSinAcuerdo. m�todo para validar la opci�n sin acuerdo
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todo setearValoresPanelOtrosDatos
	 */
	public void verSinAcuerdo(int opcion) {
		try {
			this.setearValoresPanelOtrosDatos();
			opcionSinAcuerdo = opcion;
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo listaMeses");
		}
	}

	/**
	 * verSinAcuerdoRediferido. m�todo para validar la opci�n sin acuerdo
	 * rediferido
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos,setearPanelRediferido
	 */
	public void verSinAcuerdoRediferido(int opcion) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			opcionSinAcuerdoRediferido = opcion;
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo verSinAcuerdoRediferido");
		}
	}

	/**
	 * verSinAcuerdoNormalizacion. m�todo para validar la opci�n sin acuerdo
	 * normalizaci�n
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todos setearValoresPanelOtrosDatos,setearPanelRediferido
	 */
	public void verSinAcuerdoNormalizacion(int opcion) {
		try {
			this.setearPanelRediferido();
			this.setearValoresPanelOtrosDatos();
			opcionSinAcuerdoRediferido = opcion;
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo verSinAcuerdoNormalizacion");
		}
	}

	/**
	 * verNoContacto. m�todo para validar la opci�n no contacto
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see EJB tipificacionEJB
	 */
	public void verNoContacto(String idTipoResultado, int opcion) {
		try {
			opcionMensajeTercero = 0;
			opcionContactoTitular = 0;
			noContacto = opcion;
			listaTipificaciones = tipificacionEJB.obtenerTipoTipificacion();
			RequestContext.getCurrentInstance().update("opcionesContacto");
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo verNoContacto");
		}
	}

	/**
	 * verMensajeTercero. m�todo para validar la opci�n mensaje a tercero
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            idTipoResultado (tipo de resultado), int opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todo listaAfinidadesTerceros
	 */
	public void verMensajeTercero(String idTipoResultado, int opcion) {
		try {
			noContacto = 0;
			opcionContactoTitular = 0;
			opcionMensajeTercero = opcion;
			selectedTipificacion = idTipoResultado;
			this.listaAfinidadesTerceros();
			RequestContext.getCurrentInstance().update("opcionesContacto");
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo verMensajeTercero");
		}
	}

	/**
	 * listaAfinidadesTerceros. m�todo para listar afinidades de terceros
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see EJB globalEJB
	 */
	public void listaAfinidadesTerceros() {
		try {
			// se cargan valores a los campos
			listaAfinidades = new ArrayList<>();
			listaAfinidades = globalEJB.consultarAfinidad();
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo verMensajeTercero");
		}
	}

	/**
	 * listaMotivosNoPago. m�todo para listar motivos de no pago
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see EJB globalEJB
	 */
	public void listaMotivosNoPago() {
		try {
			// se cargan valores a los campos
			listaMotivoNoPago = new ArrayList<>();
			listaMotivoNoPago = globalEJB.consultarMotivosNoPago();
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo listaMotivosNoPago");
		}
	}

	/**
	 * verContactoTitular. m�todo para visualizar la opci�n contacto con titular
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            idTipoResultado (tipo de resultado), int opcion (desici�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todo listaMotivosNoPago
	 */
	public void verContactoTitular(String idTipoResultado, int opcion) {
		try {
			noContacto = 0;
			opcionMensajeTercero = 0;
			opcionContactoTitular = opcion;
			this.listaMotivosNoPago();
			RequestContext.getCurrentInstance().update("opcionesContacto");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo verContactoTitular");
		}
	}

	/**
	 * verRediferido. m�todo para visualizar la opci�n rediferido
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion1 (desici�n), String numero (n�mero obligaci�n), String
	 *            nego (negociaci�n), int politica (p�litica seleccionada)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todo obtenerRediferidoPorObligacion, listaMeses,
	 *      obtenerTasaRediferido, EJB dolarEJB
	 */
	public void verRediferido(int opcion1, String numero, String nego, int politica) {
		try {
			this.setearValoresPanelOtrosDatos();
			opcionRediferido = opcion1;
			negociacion = nego;
			idPolitica = politica;
			numeroObligacion = new BigDecimal(numero);
			this.obtenerRediferidoPorObligacion(numeroObligacion);
			this.obtenerTasaRediferido();
			dolar = dolarEJB.consultarDolar();

			this.listaMeses();

			saldoTotal = rediferido.getSaldoDolares();
			pagoMinInicial = rediferido.getPagoMinDolares();
			tasaMenusal = tasa.getValor();
			trm = dolar.getValor();
			valorSaldoDolar = detalle.getObligacionHoy().getSaldoTotal();
			// this.valorSaldoDolar = ((rediferido.getSaldoDolares().intValue())
			// *
			// (dolar.getValor().intValue()));
			saldoTotalPesos = valorSaldoDolar;
			valorMinDolar = detalle.getObligacionHoy().getPagoMinimoInicial();
			// valorMinDolar = ((rediferido.getPagoMinDolares().intValue()) *
			// (dolar.getValor().intValue()));
			// pagoMinPesos = valorMinDolar;
			pagoMinPesos = detalle.getObligacionHoy().getPagoMinimoInicial();
			valorMoraDolar = detalle.getObligacionHoy().getInteresesMora();
			// this.valorMoraDolar =
			// ((rediferido.getSaldoMoraDolares().intValue())
			// * (dolar.getValor().intValue()));
			// moraPesos = valorMoraDolar;
			moraPesos = new BigDecimal(0);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo verRediferido");
		}
	}

	/**
	 * obtenerRediferidoPorObligacion. m�todo para validar el rediferido de la
	 * obligaci�n
	 * 
	 * @author Camilo Ochoa
	 * @param BigDecimal
	 *            numeroObligacion (n�mero obligaci�n)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return objeto tipo Rediferido
	 * @see EJB rediferidoEJB
	 */
	public void obtenerRediferidoPorObligacion(BigDecimal numeroObligacion) {
		try {
			rediferido = rediferidoEJB.consultarRediferidoPorObligacion(numeroObligacion);
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo obtenerRediferidoPorObligacion");
		}
	}

	/**
	 * obtenerTasaRediferido. m�todo para consultar las tasas de rediferido
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return objeto tipo TasaRediferido
	 * @see EJB rediferidoEJB
	 */
	public void obtenerTasaRediferido() {
		try {
			tasa = rediferidoEJB.consultarTasaRediferido();
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo obtenerTasaRediferido");
		}
	}

	/**
	 * verRediferidoNormal. m�todo para visualizar la opci�n rediferido
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion1 (desici�n), String numero (n�mero obligaci�n), String
	 *            nego (negociaci�n), int politica (p�litica seleccionada)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todo obtenerRediferidoPorObligacion, listaMeses,
	 *      obtenerTasaRediferido, EJB dolarEJB
	 */
	public void verRediferidoNormal(int opcion1, String numero, String nego, int politica) {
		try {
			this.setearValoresPanelOtrosDatos();
			opcionRediferidoNormal = opcion1;
			negociacion = nego;
			numeroObligacion = new BigDecimal(numero);
			this.obtenerRediferidoPorObligacion(numeroObligacion);
			this.obtenerTasaRediferido();
			dolar = dolarEJB.consultarDolar();
			idPolitica = politica;

			this.listaMeses();

			saldoTotal = rediferido.getSaldoDolares();
			pagoMinInicial = rediferido.getPagoMinDolares();
			tasaMenusal = tasa.getValor();
			trm = dolar.getValor();
			valorSaldoDolar = detalle.getObligacionHoy().getSaldoTotal();
			// this.valorSaldoDolar = ((rediferido.getSaldoDolares().intValue())
			// *
			// (dolar.getValor().intValue()));
			saldoTotalPesos = valorSaldoDolar;
			valorMinDolar = detalle.getObligacionHoy().getPagoMinimoInicial();
			// valorMinDolar = ((rediferido.getPagoMinDolares().intValue()) *
			// (dolar.getValor().intValue()));
			// pagoMinPesos = valorMinDolar;
			pagoMinPesos = detalle.getObligacionHoy().getPagoMinimoInicial();
			valorMoraDolar = detalle.getObligacionHoy().getInteresesMora();
			// this.valorMoraDolar =
			// ((rediferido.getSaldoMoraDolares().intValue())
			// * (dolar.getValor().intValue()));
			// moraPesos = valorMoraDolar;
			moraPesos = new BigDecimal(0);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo verRediferidoNormal");
		}
	}

	/**
	 * verNormalizacion. m�todo para visualizar la opci�n normalizaci�n
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion1 (desici�n), String numero (n�mero obligaci�n), String
	 *            nego (negociaci�n), int politica (p�litica seleccionada)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todo obtenerRediferidoPorObligacion, listaMeses,
	 *      obtenerTasaRediferido, EJB dolarEJB
	 */
	public void verNormalizacion(int opcion1, String numero, String nego, int politica) {
		try {
			this.setearValoresPanelOtrosDatos();
			opcionNormalizacion = opcion1;
			negociacion = nego;
			numeroObligacion = new BigDecimal(numero);
			this.obtenerRediferidoPorObligacion(numeroObligacion);
			this.obtenerTasaRediferido();
			dolar = dolarEJB.consultarDolar();
			idPolitica = politica;

			this.listaMeses();

			saldoTotal = rediferido.getSaldoDolares();
			pagoMinInicial = rediferido.getPagoMinDolares();
			tasaMenusal = tasa.getValor();
			trm = dolar.getValor();
			valorSaldoDolar = detalle.getObligacionHoy().getSaldoTotal();
			// this.valorSaldoDolar = ((rediferido.getSaldoDolares().intValue())
			// *
			// (dolar.getValor().intValue()));
			saldoTotalPesos = valorSaldoDolar;
			valorMinDolar = detalle.getObligacionHoy().getPagoMinimoInicial();
			// valorMinDolar = ((rediferido.getPagoMinDolares().intValue()) *
			// (dolar.getValor().intValue()));
			// pagoMinPesos = valorMinDolar;
			pagoMinPesos = detalle.getObligacionHoy().getPagoMinimoInicial();
			valorMoraDolar = detalle.getObligacionHoy().getInteresesMora();
			// this.valorMoraDolar =
			// ((rediferido.getSaldoMoraDolares().intValue())
			// * (dolar.getValor().intValue()));
			// moraPesos = valorMoraDolar;
			moraPesos = new BigDecimal(0);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error(
					"Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo verNormalizacion");
		}
	}

	/**
	 * setearValoresPanelOtrosDatos. m�todo para asignar valores en cero
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcionRediferido, opcionNormalizacion,
	 *            opcionNormalizacionVirtual, opcionReestructuracion,
	 *            opcionSinAcuerdo, opcionRediferidoNormal,
	 *            opcionSinAcuerdoRediferido, agendo, aceptoAgendamiento,
	 *            aceptoAgendamientoContacto, aceptoRediferido, esPagoTotal,
	 *            esDaviacuerdo, esPagoZanahoria
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see N/A
	 */
	public void setearValoresPanelOtrosDatos() {
		opcionRediferido = 0;
		opcionNormalizacion = 0;
		opcionNormalizacionVirtual = 0;
		opcionReestructuracion = 0;
		opcionSinAcuerdo = 0;
		opcionRediferidoNormal = 0;
		opcionSinAcuerdoRediferido = 0;
		agendo = 0;
		aceptoAgendamiento = 0;
		aceptoAgendamientoContacto = 0;
		aceptoRediferido = 0;
		esPagoTotal = 0;
		esDaviacuerdo = 0;
		esPagoZanahoria = 0;
	}

	/**
	 * listaTasas. m�todo para listar tasas
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see N/A
	 */
	public void listaTasas() {
		try {
			// se cargan valores a los campos
			tasaMensual = new ArrayList<>();
			tasaMensual.add((float) 0.7);
			tasaMensual.add((float) 1);
			tasaMensual.add((float) 1.3);
			tasaMensual.add((float) 1.6);
			tasaMensual.add((float) 1.7);
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage() + " clase PoliticaRediferidosBean m�todo listaTasas");
		}
	}

	/**
	 * verNormalizacionVirtual. m�todo para visualizar la opci�n normalizaci�n
	 * virtual
	 * 
	 * @author Camilo Ochoa
	 * @param int
	 *            opcion1 (desici�n), String numero (n�mero obligaci�n), String
	 *            nego (negociaci�n), int politica (p�litica seleccionada)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return updates al JSF
	 * @see m�todo obtenerRediferidoPorObligacion, listaMeses,
	 *      obtenerTasaRediferido, EJB dolarEJB
	 */
	public void verNormalizacionVirtual(int opcion1, String numero, String nego, int politica) {
		try {
			this.setearValoresPanelOtrosDatos();
			opcionNormalizacionVirtual = opcion1;
			negociacion = nego;
			numeroObligacion = new BigDecimal(numero);
			this.obtenerRediferidoPorObligacion(numeroObligacion);
			this.obtenerTasaRediferido();
			dolar = dolarEJB.consultarDolar();
			idPolitica = politica;

			this.listaMeses();

			saldoTotal = rediferido.getSaldoDolares();
			pagoMinInicial = rediferido.getPagoMinDolares();
			tasaMenusal = tasa.getValor();
			trm = dolar.getValor();
			valorSaldoDolar = detalle.getObligacionHoy().getSaldoTotal();
			// this.valorSaldoDolar = ((rediferido.getSaldoDolares().intValue())
			// *
			// (dolar.getValor().intValue()));
			saldoTotalPesos = valorSaldoDolar;
			valorMinDolar = detalle.getObligacionHoy().getPagoMinimoInicial();
			// valorMinDolar = ((rediferido.getPagoMinDolares().intValue()) *
			// (dolar.getValor().intValue()));
			// pagoMinPesos = valorMinDolar;
			pagoMinPesos = detalle.getObligacionHoy().getPagoMinimoInicial();
			valorMoraDolar = detalle.getObligacionHoy().getInteresesMora();
			// this.valorMoraDolar =
			// ((rediferido.getSaldoMoraDolares().intValue())
			// * (dolar.getValor().intValue()));
			// moraPesos = valorMoraDolar;
			moraPesos = new BigDecimal(0);
			RequestContext.getCurrentInstance().update("pnlOtrosDatos");
		} catch (Exception e) {
			logger.error("Ocurrio un error..." + e.getMessage()
					+ " clase PoliticaRediferidosBean m�todo verNormalizacionVirtual");
		}

	}

	//// *** get y set ******////
	public String getTelefonoLlamar() {
		return telefonoLlamar;
	}

	public void setTelefonoLlamar(String telefonoLlamar) {
		this.telefonoLlamar = telefonoLlamar;
	}

	public void obtenerTipificacion() throws Exception {
		tipificacion = tipificacionEJB.obtenerTipificacion();
	}

	public Tipificacion getTipificacion() {
		return tipificacion;
	}

	public void setTipificacion(Tipificacion tipificacion) {
		this.tipificacion = tipificacion;
	}

	public ITipificacionEJBLocal getTipificacionEJB() {
		return tipificacionEJB;
	}

	public void setTipificacionEJB(ITipificacionEJBLocal tipificacionEJB) {
		this.tipificacionEJB = tipificacionEJB;
	}

	public int getAceptoRediferido() {
		return aceptoRediferido;
	}

	public void setAceptoRediferido(int aceptoRediferido) {
		this.aceptoRediferido = aceptoRediferido;
	}

	public int getOpcionRediferido() {
		return opcionRediferido;
	}

	public IRediferidoEJBLocal getRediferidoEJB() {
		return rediferidoEJB;
	}

	public void setRediferidoEJB(IRediferidoEJBLocal rediferidoEJB) {
		this.rediferidoEJB = rediferidoEJB;
	}

	public Rediferido getRediferido() {
		return rediferido;
	}

	public void setRediferido(Rediferido rediferido) {
		this.rediferido = rediferido;
	}

	public void setOpcionRediferido(int opcionRediferido) {
		this.opcionRediferido = opcionRediferido;
	}

	public BigDecimal getNumeroObligacion() {
		return numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public IHistoricoObligacionEJBLocal getHistoricoObligacionEJB() {
		return historicoObligacionEJB;
	}

	public void setHistoricoObligacionEJB(IHistoricoObligacionEJBLocal historicoObligacionEJB) {
		this.historicoObligacionEJB = historicoObligacionEJB;
	}

	public List<HistoricoObligacion> getHistoricoObligaciones() {
		return historicoObligaciones;
	}

	public void setHistoricoObligaciones(List<HistoricoObligacion> historicoObligaciones) {
		this.historicoObligaciones = historicoObligaciones;
	}

	public TasaRediferido getTasa() {
		return tasa;
	}

	public void setTasa(TasaRediferido tasa) {
		this.tasa = tasa;
	}

	public IDolarEJBLocal getDolarEJB() {
		return dolarEJB;
	}

	public void setDolarEJB(IDolarEJBLocal dolarEJB) {
		this.dolarEJB = dolarEJB;
	}

	public Dolar getDolar() {
		return dolar;
	}

	public void setDolar(Dolar dolar) {
		this.dolar = dolar;
	}

	public BigDecimal getValorSaldoDolar() {
		return valorSaldoDolar;
	}

	public void setValorSaldoDolar(BigDecimal valorSaldoDolar) {
		this.valorSaldoDolar = valorSaldoDolar;
	}

	public BigDecimal getValorMinDolar() {
		return valorMinDolar;
	}

	public void setValorMinDolar(BigDecimal valorMinDolar) {
		this.valorMinDolar = valorMinDolar;
	}

	public BigDecimal getValorMoraDolar() {
		return valorMoraDolar;
	}

	public void setValorMoraDolar(BigDecimal valorMoraDolar) {
		this.valorMoraDolar = valorMoraDolar;
	}

	public int getAceptoAgendamiento() {
		return aceptoAgendamiento;
	}

	public void setAceptoAgendamiento(int aceptoAgendamiento) {
		this.aceptoAgendamiento = aceptoAgendamiento;
	}

	public int getAgendo() {
		return agendo;
	}

	public void setAgendo(int agendo) {
		this.agendo = agendo;
	}

	public BigDecimal getTrm() {
		return trm;
	}

	public void setTrm(BigDecimal trm) {
		this.trm = trm;
	}

	public BigDecimal getPagoMinInicial() {
		return pagoMinInicial;
	}

	public void setPagoMinInicial(BigDecimal pagoMinInicial) {
		this.pagoMinInicial = pagoMinInicial;
	}

	public BigDecimal getSaldoTotalPesos() {
		return saldoTotalPesos;
	}

	public void setSaldoTotalPesos(BigDecimal saldoTotalPesos) {
		this.saldoTotalPesos = saldoTotalPesos;
	}

	public BigDecimal getMoraDolares() {
		return moraDolares;
	}

	public void setMoraDolares(BigDecimal moraDolares) {
		this.moraDolares = moraDolares;
	}

	public BigDecimal getMoraPesos() {
		return moraPesos;
	}

	public void setMoraPesos(BigDecimal moraPesos) {
		this.moraPesos = moraPesos;
	}

	public BigDecimal getPagoCliente() {
		return pagoCliente;
	}

	public void setPagoCliente(BigDecimal pagoCliente) {
		this.pagoCliente = pagoCliente;
	}

	public BigDecimal getPagoClientePesos() {
		return pagoClientePesos;
	}

	public void setPagoClientePesos(BigDecimal pagoClientePesos) {
		this.pagoClientePesos = pagoClientePesos;
	}

	public Double getTasaMenusal() {
		return tasaMenusal;
	}

	public void setTasaMenusal(Double tasaMenusal) {
		this.tasaMenusal = tasaMenusal;
	}

	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public BigDecimal getPagoMinPesos() {
		return pagoMinPesos;
	}

	public void setPagoMinPesos(BigDecimal pagoMinPesos) {
		this.pagoMinPesos = pagoMinPesos;
	}

	public void setPlazoMeses(List<Integer> plazoMeses) {
		this.plazoMeses = plazoMeses;
	}

	public List<Integer> getPlazoMeses() {
		return plazoMeses;
	}

	public int getSelectedMeses() {
		return selectedMeses;
	}

	public void setSelectedMeses(int selectedMeses) {
		this.selectedMeses = selectedMeses;
	}

	public BigDecimal getValorPromesa() {
		return valorPromesa;
	}

	public void setValorPromesa(BigDecimal valorPromesa) {
		this.valorPromesa = valorPromesa;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaPromesa() {
		return fechaPromesa;
	}

	public void setFechaPromesa(Date fechaPromesa) {
		this.fechaPromesa = fechaPromesa;
	}

	public Date getDate11() {
		return date11;
	}

	public void setDate11(Date date11) {
		this.date11 = date11;
	}

	public Date getFechaUbicacion() {
		return fechaUbicacion;
	}

	public void setFechaUbicacion(Date fechaUbicacion) {
		this.fechaUbicacion = fechaUbicacion;
	}

	public IGlobalEJBLocal getGlobalEJB() {
		return globalEJB;
	}

	public void setGlobalEJB(IGlobalEJBLocal globalEJB) {
		this.globalEJB = globalEJB;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Global getGlobal() {
		return global;
	}

	public void setGlobal(Global global) {
		this.global = global;
	}

	public String getFechaUltimoAcuerdo() {
		return fechaUltimoAcuerdo;
	}

	public void setFechaUltimoAcuerdo(String fechaUltimoAcuerdo) {
		this.fechaUltimoAcuerdo = fechaUltimoAcuerdo;
	}

	public String getFullNameAltitude() {
		return fullNameAltitude;
	}

	public void setFullNameAltitude(String fullNameAltitude) {
		this.fullNameAltitude = fullNameAltitude;
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

	public int getEsDaviacuerdo() {
		return esDaviacuerdo;
	}

	public void setEsDaviacuerdo(int esDaviacuerdo) {
		this.esDaviacuerdo = esDaviacuerdo;
	}

	public BigDecimal getDaviBono() {
		return daviBono;
	}

	public void setDaviBono(BigDecimal daviBono) {
		this.daviBono = daviBono;
	}

	public ObligacionHoy getObligacionHoy() {
		return obligacionHoy;
	}

	public void setObligacionHoy(ObligacionHoy obligacionHoy) {
		this.obligacionHoy = obligacionHoy;
	}

	public BigDecimal getDaviAbono() {
		return daviAbono;
	}

	public void setDaviAbono(BigDecimal daviAbono) {
		this.daviAbono = daviAbono;
	}

	public int getEsPagoTotal() {
		return esPagoTotal;
	}

	public void setEsPagoTotal(int esPagoTotal) {
		this.esPagoTotal = esPagoTotal;
	}

	public DetallesObligacionesBean getDetalle() {
		return detalle;
	}

	public void setDetalle(DetallesObligacionesBean detalle) {
		this.detalle = detalle;
	}

	public BigDecimal getBonoDescuento() {
		return bonoDescuento;
	}

	public void setBonoDescuento(BigDecimal bonoDescuento) {
		this.bonoDescuento = bonoDescuento;
	}

	public BigDecimal getMontoAbono() {
		return montoAbono;
	}

	public void setMontoAbono(BigDecimal montoAbono) {
		this.montoAbono = montoAbono;
	}

	public BigDecimal getAbonoZanahoria() {
		return abonoZanahoria;
	}

	public void setAbonoZanahoria(BigDecimal abonoZanahoria) {
		this.abonoZanahoria = abonoZanahoria;
	}

	public BigDecimal getBonoZanahoria() {
		return bonoZanahoria;
	}

	public void setBonoZanahoria(BigDecimal bonoZanahoria) {
		this.bonoZanahoria = bonoZanahoria;
	}

	public int getEsPagoZanahoria() {
		return esPagoZanahoria;
	}

	public void setEsPagoZanahoria(int esPagoZanahoria) {
		this.esPagoZanahoria = esPagoZanahoria;
	}

	public int getOpcionNormalizacion() {
		return opcionNormalizacion;
	}

	public void setOpcionNormalizacion(int opcionNormalizacion) {
		this.opcionNormalizacion = opcionNormalizacion;
	}

	public List<Float> getTasaMensual() {
		return tasaMensual;
	}

	public void setTasaMensual(List<Float> tasaMensual) {
		this.tasaMensual = tasaMensual;
	}

	public float getSelectedTasas() {
		return selectedTasas;
	}

	public void setSelectedTasas(float selectedTasas) {
		this.selectedTasas = selectedTasas;
	}

	public List<Global> getSimuladorCuotas() {
		return simuladorCuotas;
	}

	public void setSimuladorCuotas(List<Global> simuladorCuotas) {
		this.simuladorCuotas = simuladorCuotas;
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

	public List<Tipificacion> getTipificacion2() {
		return tipificacion2;
	}

	public void setTipificacion2(List<Tipificacion> tipificacion2) {
		this.tipificacion2 = tipificacion2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNoContacto() {
		return noContacto;
	}

	public void setNoContacto(int noContacto) {
		this.noContacto = noContacto;
	}

	public int getSelectedAfinidad() {
		return selectedAfinidad;
	}

	public void setSelectedAfinidad(int selectedAfinidad) {
		this.selectedAfinidad = selectedAfinidad;
	}

	public List<Global> getListaAfinidades() {
		return listaAfinidades;
	}

	public void setListaAfinidades(List<Global> listaAfinidades) {
		this.listaAfinidades = listaAfinidades;
	}

	public String getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public Integer getAfinidadTercero() {
		return afinidadTercero;
	}

	public void setAfinidadTercero(Integer afinidadTercero) {
		this.afinidadTercero = afinidadTercero;
	}

	public int getOpcionMensajeTercero() {
		return opcionMensajeTercero;
	}

	public void setopcionMensajeTercero(int opcionMensajeTercero) {
		this.opcionMensajeTercero = opcionMensajeTercero;
	}

	public String getMensajeTercero() {
		return mensajeTercero;
	}

	public void setMensajeTercero(String mensajeTercero) {
		this.mensajeTercero = mensajeTercero;
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

	public int getSelectedMotivoNoPago() {
		return selectedMotivoNoPago;
	}

	public void setSelectedMotivoNoPago(int selectedMotivoNoPago) {
		this.selectedMotivoNoPago = selectedMotivoNoPago;
	}

	public List<Global> getListaMotivoNoPago() {
		return listaMotivoNoPago;
	}

	public void setListaMotivoNoPago(List<Global> listaMotivoNoPago) {
		this.listaMotivoNoPago = listaMotivoNoPago;
	}

	public List<String> getTipoReestructuracion() {
		return tipoReestructuracion;
	}

	public void setTipoReestructuracion(List<String> tipoReestructuracion) {
		this.tipoReestructuracion = tipoReestructuracion;
	}

	public String getSelectedReestructuracion() {
		return selectedReestructuracion;
	}

	public void setSelectedReestructuracion(String selectedReestructuracion) {
		this.selectedReestructuracion = selectedReestructuracion;
	}

	public BigDecimal getSimuladoPrimeraCuota() {
		return simuladoPrimeraCuota;
	}

	public void setSimuladoPrimeraCuota(BigDecimal simuladoPrimeraCuota) {
		this.simuladoPrimeraCuota = simuladoPrimeraCuota;
	}

	public BigDecimal getPagoclienteReestruc() {
		return pagoclienteReestruc;
	}

	public void setPagoclienteReestruc(BigDecimal pagoclienteReestruc) {
		this.pagoclienteReestruc = pagoclienteReestruc;
	}

	public Date getFechaDocumentacion() {
		return fechaDocumentacion;
	}

	public void setFechaDocumentacion(Date fechaDocumentacion) {
		this.fechaDocumentacion = fechaDocumentacion;
	}

	public BigDecimal getSaldoTotalreestruc() {
		return saldoTotalreestruc;
	}

	public void setSaldoTotalreestruc(BigDecimal saldoTotalreestruc) {
		this.saldoTotalreestruc = saldoTotalreestruc;
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

	public Global getSimuladorCuota() {
		return simuladorCuota;
	}

	public void setSimuladorCuota(Global simuladorCuota) {
		this.simuladorCuota = simuladorCuota;
	}

	public BigDecimal getCuotaMinInicial() {
		return cuotaMinInicial;
	}

	public void setCuotaMinInicial(BigDecimal cuotaMinInicial) {
		this.cuotaMinInicial = cuotaMinInicial;
	}

	public String getSelectedTipificacion() {
		return selectedTipificacion;
	}

	public void setSelectedTipificacion(String selectedTipificacion) {
		this.selectedTipificacion = selectedTipificacion;
	}

	public List<Tipificacion> getListaTipificaciones() {
		return listaTipificaciones;
	}

	public void setListaTipificaciones(List<Tipificacion> listaTipificaciones) {
		this.listaTipificaciones = listaTipificaciones;
	}

	public int getAceptoAgendamientoContacto() {
		return aceptoAgendamientoContacto;
	}

	public void setAceptoAgendamientoContacto(int aceptoAgendamientoContacto) {
		this.aceptoAgendamientoContacto = aceptoAgendamientoContacto;
	}

	public int getOpcionSinAcuerdoRediferido() {
		return opcionSinAcuerdoRediferido;
	}

	public void setOpcionSinAcuerdoRediferido(int opcionSinAcuerdoRediferido) {
		this.opcionSinAcuerdoRediferido = opcionSinAcuerdoRediferido;
	}

	public String getNegociacion() {
		return negociacion;
	}

	public void setNegociacion(String negociacion) {
		this.negociacion = negociacion;
	}

	public int getIdPolitica() {
		return idPolitica;
	}

	public void setIdPolitica(int idPolitica) {
		this.idPolitica = idPolitica;
	}

	public AgendamientoBean getAgendamiento() {
		return agendamiento;
	}

	public void setAgendamiento(AgendamientoBean agendamiento) {
		this.agendamiento = agendamiento;
	}

	public int getOpcionRediferidoNormal() {
		return opcionRediferidoNormal;
	}

	public void setOpcionRediferidoNormal(int opcionRediferidoNormal) {
		this.opcionRediferidoNormal = opcionRediferidoNormal;
	}

}
