package co.sistemcobro.davivienda.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.sistemcobro.davivienda.ejb.IGestionEJBLocal;
import co.sistemcobro.davivienda.session.LoginBean;

@ManagedBean(name = "gestionBean")
@ViewScoped
public class GestionBean {

	@EJB
	private IGestionEJBLocal gestionEJB;

	private Gestion gestion;

	private PoliticaRediferidosBean politica;
	private ClienteBean cliente;
	private LoginBean login;
	private AgendamientoBean agendamiento;

	@PostConstruct
	public void init() {

		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			politica = application.evaluateExpressionGet(context, "#{politicaRediferidoBean}",
					PoliticaRediferidosBean.class);
			cliente = application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class);
			login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
			agendamiento = application.evaluateExpressionGet(context, "#{agendamientoBean}", AgendamientoBean.class);
			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ---------------------------------------------------

	/*
	 * Metodos
	 */

	public void guardarGestion() throws Exception {
		try {
			
			if(cliente.getTelefonoMarcado() != null){
				// fecha actual
				Date ahora = new Date();
				gestion = new Gestion();
				boolean inserto = false;

				// idResultado 1
				if (politica.getSelectedTipificacion() != null) {
					gestion.setIdResultado(politica.getSelectedTipificacion());
				} else {
					gestion.setIdResultado("CC");
				}

				// idnegociacion 2
				gestion.setIdNegociacion("SN"); // pendiente con el tipo de opcion
				// idsucursal 3
				gestion.setIdsucursal(Integer.parseInt(login.getUsuarioHermes().getIdsucursal()));
				// registrotipo 4
				gestion.setRegistroTipo("");
				// fechainicio 5
				gestion.setFechainicio(new Timestamp(ahora.getTime()));
				// fechainicio 6
				gestion.setFechainiciollamada(new Timestamp(ahora.getTime()));
				// fechafinllamada 7
				gestion.setFechafinllamada(new Timestamp(ahora.getTime()));
				// telefonomarcado 8
				gestion.setTelefonomarcado(cliente.getTelefonoMarcado());
				// idusuarioaltitude 13
				gestion.setIdusuarioaltitude(0);
				// usernamealtitude 14
				gestion.setUsernamealtitude(login.getUsuarioHermes().getUsuario());
				// fullnamealtitude 15
				gestion.setFullnamealtitude(login.getUsuarioHermes().getNombre());
				// estado 18
				gestion.setEstado(Integer.parseInt(login.getUsuarioHermes().getEstado()));
				// extension 24
				gestion.setExtension(0);
				// AccionTipo 43
				gestion.setAccionTipo("LL");
				// idusuariocrea 17
				gestion.setIdusuariocrea(Integer.parseInt(login.getUsuarioHermes().getIdusuario()));

				// idPolitica
				gestion.setIdPolitica(politica.getIdPolitica());

				if (politica.getSelectedTipificacion() != null) {
					if (politica.getSelectedTipificacion().equals("NC")) {
						// observacion 16
						gestion.setObservacion(politica.getObservacion());
					}

					if (politica.getSelectedTipificacion().equals("ME")) {
						// observacion 16
						gestion.setObservacion(politica.getObservacion());
						// mensaje_tercero 21
						gestion.setMesajeTercero(politica.getMensajeTercero());
						// nombre_tercero 22
						gestion.setNombretercero(politica.getNombreTercero());
						// afinidad_tercero 23
						gestion.setAfinidadTercero(politica.getSelectedAfinidad());

					}
				}

				if (politica.getSelectedMotivoNoPago() != 0) {
					// idnegociacion 2

					if (politica.getNegociacion() != null) {
						gestion.setIdNegociacion(politica.getNegociacion()); // pendiente
																				// con
																				// el
																				// tipo
																				// de
																				// opcion
					}

					// fechapromesa 9
					if (politica.getFechaPromesa() != null) {
						gestion.setFechapromesa(new Timestamp(politica.getFechaPromesa().getTime()));
					}
					// valorpromesa 10
					if (politica.getValorPromesa() != null) {
						gestion.setValorpromesa(politica.getValorPromesa());
					}
					// fechaagendamiento 11
					if (agendamiento.getHoraUbicacion() != null) {
						gestion.setFechaagendamiento(new Timestamp(agendamiento.getHoraUbicacion().getTime()));
					}
					// telefonoagendamiento 12
					if (politica.getTelefonoLlamar() != null) {
						gestion.setTelefonoagendamiento(politica.getTelefonoLlamar());
					}
					// observacion 16
					gestion.setObservacion(politica.getObservacion());
					// id_motivo_no_pago 19
					if (politica.getSelectedMotivoNoPago() != 0) {
						gestion.setIdMotivoNoPago(politica.getSelectedMotivoNoPago());
					}
					// plazo plazo_rediferido 32
					if (politica.getSelectedMeses() != 0) {
						gestion.setNumeroCuotas(politica.getSelectedMeses());
					}
					// abono/daviabono 28
					if (politica.getDaviAbono() != null) {
						gestion.setAbono(politica.getDaviAbono());
					}

					// bono/davibono 29
					if (politica.getDaviBono() != null) {
						gestion.setBono(politica.getDaviBono());
					}
					// monto_abono/pago_total_abono 26
					if (politica.getMontoAbono() != null) {
						gestion.setMontoAbono(politica.getMontoAbono());
					}
					// monto_bono/pago_total_bono 27
					if (politica.getBonoDescuento() != null) {
						gestion.setMontoBono(politica.getBonoDescuento());
					}

					// abono zanahoria 30
					if (politica.getAbonoZanahoria() != null) {
						gestion.setAbonoZanahoria(politica.getAbonoZanahoria());
					}
					// bono zanahoria 31
					if (politica.getBonoZanahoria() != null) {
						gestion.setBonoZanahoria(politica.getBonoZanahoria());
					}

					// tasa_mensual 33
					if (politica.getTasaMenusal() != null) {
						gestion.setTasaMensual(politica.getTasaMenusal());
					}
					// fecha_documentacion/fecha_promesa_envio_documentacion 42
					if (politica.getFechaDocumentacion() != null) {
						gestion.setFechaDocumentacion(new Timestamp(politica.getFechaDocumentacion().getTime()));
					}

					// saldo total reestruc 37
					if (politica.getSaldoTotalreestruc() != null) {
						gestion.setSaldoTotalreestruc(politica.getSaldoTotalreestruc());
					}
					// pago cliente reestruc 38
					if (politica.getPagoclienteReestruc() != null) {
						gestion.setPagoclienteReestruc(politica.getPagoclienteReestruc());
					}

					// tipo/reestructuracion_tipo 39
					if (politica.getSelectedReestructuracion() != null) {
						gestion.setTipo(politica.getSelectedReestructuracion());
					}
					
					// n_cuotas/plazo_reestructuracion 40
					if (politica.getSelectedMeses() != 0) {
						gestion.setPlazo(politica.getSelectedMeses());
					}
					
					// observaci�n ?
					gestion.setObservacion(politica.getObservacion());
					
					// simulado_primera_cuota 41
					gestion.setSimuladoPrimeraCuota(politica.getSimuladoPrimeraCuota());
					
				}
				
				inserto = gestionEJB.insertarGestionRediferido(gestion);
				
				if (inserto == true) {
					String idGestion = gestionEJB.consultarObligacionIdentificacion(cliente.getCliente().getIdcliente());
					
					inserto = gestionEJB.insertarObligacionGestion(idGestion);
					
					if (inserto == true) {
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Gesti�n guardada �xitosamente."));
					}else{
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Gesti�n no guardada."));
					}
					
					
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Gesti�n no guardada. por favor verifique si realizo la marcaci�n"));
				}
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Por favor realice la marcaci�n y posterior guarde la gesti�n ", "Por favor realice la marcaci�n y posterior guarde la gesti�n"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	/*
	 * Get & set
	 */

	/// --------------------------------------------------

	public IGestionEJBLocal getGestionEJB() {
		return gestionEJB;
	}

	public void setGestionEJB(IGestionEJBLocal gestionEJB) {
		this.gestionEJB = gestionEJB;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

}
