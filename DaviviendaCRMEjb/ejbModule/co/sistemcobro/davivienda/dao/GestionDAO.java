package co.sistemcobro.davivienda.dao;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import co.sistemcobro.davivienda.bean.Gestion;

public class GestionDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(GestionDAO.class);

	public GestionDAO(DataSource ds) {
		super(ds);
	}

	/**
	 * insertarGestionRediferido. m�todo para registrar la gestion
	 * @author Camilo Ochoa
	 * @param Gestion gestion 
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return boolean bandera con desici�n true o false
	 * @see N/A
	 */
	public boolean insertarGestionRediferido(Gestion gestion) throws Exception {
		logger.info("Insertando");
		System.out.println("insertando");
		boolean insertado = false;
		Date fecha = null;
		InetAddress address = null;
		try {
			fecha = new Date();
			address = InetAddress.getLocalHost();
			con = ds.getConnection();

			StringBuffer query = new StringBuffer();
			query.append(" EXEC [davivienda].[guarda_gestion2]  ");
			query.append(" @idresultado = ?, ");// 1
			query.append(" @idnegociacion = ?,	 ");// 2
			query.append(" @idsucursal = ?, 	 ");// 3
			query.append(" @registrotipo = ?, 	 ");// 4
			query.append(" @fechainicio = ?, ");// 5
			query.append(" @fechainiciollamada =  ?,   ");// 6
			query.append(" @fechafinllamada =  ?,   ");// 7
			query.append(" @telefonomarcado = ?,  ");// 8
			query.append(" @fechapromesa = ?,   ");// 9
			query.append(" @valorpromesa = ?, 	 ");// 10
			query.append(" @fechaagendamiento = ?,   ");// 11
			query.append(" @telefonoagendamiento = ?,  ");// 12
			query.append(" @idusuarioaltitude = ?, ");// 13
			query.append(" @usernamealtitude = ?, ");// 14
			query.append(" @fullnamealtitude = ?,  ");// 15
			query.append(" @observacion = ?,  ");// 16
			query.append(" @idusuariocrea = ?, ");// 17
			query.append(" @estado = ?, ");// 18
			query.append(" @id_motivo_no_pago = ?, 	 ");// 19
			query.append(" @idobligacion = ?, ");// 20
			query.append(" @mensaje_tercero = ?,   ");// 21
			query.append(" @nombre_tercero = ?, ");// 22
			query.append(" @afinidad_tercero = ?, ");// 23
			query.append(" @extension = ?,	 ");// 24
			query.append(" @descripcion_acuerdo = ?, ");// 25
			query.append(" @pago_total_abono = ?,  ");// 26
			query.append(" @pago_total_bono = ?,  ");// 27
			query.append(" @daviabono = ?,	 ");// 28
			query.append(" @davibono = ?,  ");// 29
			query.append(" @abono_zanahoria = ?, 	 ");// 30
			query.append(" @bono_zanahoria = ?, 	 ");// 31
			query.append(" @plazo_rediferido = ?, 	 ");// 32
			query.append(" @tasa_rediferido = ?, 	 ");// 33
			query.append(" @saldo_total_rediferido = ?,  ");// 34
			query.append(" @saldo_cliente_rediferido = ?,		 ");// 35
			query.append(" @opcion_especial_rediferido = ?, 	 ");// 36
			query.append(" @saldo_total_reestruc = ?,		 ");// 37
			query.append(" @pago_cliente_reestruc = ?,		 ");// 38
			query.append(" @reestructuracion_tipo = ?,  ");// 39
			query.append(" @plazo_reestructuracion = ?, 	 ");// 40
			query.append(" @simulado_primera_cuota_reestruct = ?, 	 ");// 41
			query.append(" @fecha_promesa_envio_documentacion = ?,  ");// 42
			query.append(" @accion_tipo = ?,  ");// 43
			query.append(" @cpCodigoCampana = ?, 	 ");// 44
			query.append(" @motivoRevocacion = ?, 	 ");// 45
			query.append(" @nombre_campana = ?,  ");// 46
			query.append(" @easycodealtitude = ?,   ");// 47
			query.append(" @actividad_economica = ?,  ");// 48
			query.append(" @cargo = ?,   ");// 49
			query.append(" @correo = ?,  ");// 50
			query.append(" @departamento = ?,  ");// 51
			query.append(" @direccion_empresa = ?,  ");// 52
			query.append(" @empresa = ?,  ");// 53
			query.append(" @ciudad = ?, 	 ");// 54
			query.append(" @telefono_empresa = ?,  ");// 55
			query.append(" @telefono1 = ?,	 ");// 56
			query.append(" @telefono2 = ?,  ");// 57
			query.append(" @telefono3 = ?,	  ");// 58
			query.append(" @telefono4 = ?,  ");// 59
			query.append(" @sector = ?,  ");// 60
			query.append(" @omitir = ?, ");// 61
			query.append(" @idCall = ? ");//62

			ps = con.prepareStatement(query.toString());

			int t = 1;
			// idresultado 1
			if (gestion.getIdResultado() != null) {
				ps.setString(t++, gestion.getIdResultado());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// idnegociacion 2
			if (gestion.getIdNegociacion() != null) {
				ps.setString(t++, gestion.getIdNegociacion());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// idsucursal 3
			if (gestion.getIdsucursal() != null) {
				ps.setInt(t++, gestion.getIdsucursal());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}
			// registrotipo 4
			if (gestion.getRegistroTipo() != null) {
				ps.setString(t++, gestion.getRegistroTipo());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// fechainicio 5
			if (gestion.getFechainicio() != null) {
				ps.setTimestamp(t++, gestion.getFechainicio());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}
			// fechainicio llamada 6
			if (gestion.getFechainiciollamada() != null) {
				ps.setTimestamp(t++, gestion.getFechainiciollamada());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}
			// fechafinllamada 7
			if (gestion.getFechafinllamada() != null) {
				ps.setTimestamp(t++, gestion.getFechafinllamada());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}
			// telefonomarcado 8
			if (gestion.getTelefonomarcado() != null) {
				ps.setString(t++, gestion.getTelefonomarcado());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// fechapromesa 9
			if (gestion.getFechapromesa() != null) {
				ps.setTimestamp(t++, gestion.getFechapromesa());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}
			// valorpromesa 10
			if (gestion.getValorpromesa() != null) {
				ps.setBigDecimal(t++, gestion.getValorpromesa());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}
			// fechaagendamiento 11
			if (gestion.getFechaagendamiento() != null) {
				ps.setTimestamp(t++, gestion.getFechaagendamiento());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}
			// telefonoagendamiento 12
			if (gestion.getTelefonoagendamiento() != null) {
				ps.setString(t++, gestion.getTelefonoagendamiento());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idusuarioaltitude 13
			if (gestion.getIdusuarioaltitude() != null) {
				ps.setInt(t++, gestion.getIdusuarioaltitude());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}
			// usernamealtitude 14
			if (gestion.getUsernamealtitude() != null) {
				ps.setString(t++, gestion.getUsernamealtitude());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// fullnamealtitude 15
			if (gestion.getFullnamealtitude() != null) {
				ps.setString(t++, gestion.getFullnamealtitude());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// observacion 16
			if (gestion.getObservacion() != null) {
				ps.setString(t++, gestion.getObservacion());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// idusuariocrea 17
			if (gestion.getIdusuariocrea() != null) {
				ps.setInt(t++, gestion.getIdusuariocrea());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}
			// estado 18
			if (gestion.getEstado() != null) {
				ps.setInt(t++, gestion.getEstado());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}
			// id_motivo_no_pago 19
			if (gestion.getIdMotivoNoPago() != null) {
				ps.setInt(t++, gestion.getIdMotivoNoPago());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}
			// idobligacion 20
			if (gestion.getIdObligacion() != null) {
				ps.setBigDecimal(t++, gestion.getIdObligacion());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// mensaje_tercero 21
			if (gestion.getMesajeTercero() != null) {
				ps.setString(t++, gestion.getMesajeTercero());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// nombre_tercero 22
			if (gestion.getNombretercero() != null) {
				ps.setString(t++, gestion.getNombretercero());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// afinidad_tercero 23
			if (gestion.getAfinidadTercero() != null && gestion.getAfinidadTercero() != 0 ) {
				ps.setInt(t++, gestion.getAfinidadTercero());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// nombre_politica 24
			if (gestion.getExtension() != null) {
				ps.setInt(t++, gestion.getExtension());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// descripcion acuerdo 25
			if (gestion.getDescripcionAcuerdo() != null) {
				ps.setString(t++, gestion.getDescripcionAcuerdo());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// monto_abono 26
			if (gestion.getMontoAbono() != null) {
				ps.setBigDecimal(t++, gestion.getMontoAbono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// monto_bono 27
			if (gestion.getMontoBono() != null) {
				ps.setBigDecimal(t++, gestion.getMontoBono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// abono 28
			if (gestion.getAbono() != null) {
				ps.setBigDecimal(t++, gestion.getAbono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}
			// bono 29
			if (gestion.getBono() != null) {
				ps.setBigDecimal(t++, gestion.getBono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// abono zanahoria 30
			if (gestion.getAbonoZanahoria() != null) {
				ps.setBigDecimal(t++, gestion.getAbonoZanahoria());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}
			// bono zanahoria 31
			if (gestion.getBonoZanahoria() != null) {
				ps.setBigDecimal(t++, gestion.getBonoZanahoria());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// n_cuotas 32
			if (gestion.getNumeroCuotas() != null) {
				ps.setInt(t++, gestion.getNumeroCuotas());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// tasa_mensual 33
			if (gestion.getTasaMensual() != null) {
				ps.setDouble(t++, gestion.getTasaMensual());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// saldo_capital 34
			if (gestion.getSaldoCapital() != null) {
				ps.setBigDecimal(t++, gestion.getSaldoCapital());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// pago_cliente rediferido 35
			if (gestion.getPagoClienteRediferido() != null) {
				ps.setBigDecimal(t++, gestion.getPagoClienteRediferido());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// opcion_especial_rediferido 36
			if (gestion.getOpcionEspecialRediferido() != null) {
				ps.setString(t++, gestion.getOpcionEspecialRediferido());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// saldo_total_reestruc 37
			if (gestion.getSaldoTotalreestruc() != null) {
				ps.setBigDecimal(t++, gestion.getSaldoTotalreestruc());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// pago_cliente_reestruc 38
			if (gestion.getPagoclienteReestruc() != null) {
				ps.setBigDecimal(t++, gestion.getPagoclienteReestruc());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// tipo 39
			if (gestion.getTipo() != null) {
				ps.setString(t++, gestion.getTipo());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// plazo 40
			if (gestion.getPlazo() != null) {
				ps.setInt(t++, gestion.getPlazo());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// simulado_primera_cuota 41
			if (gestion.getSimuladoPrimeraCuota() != null) {
				ps.setBigDecimal(t++, gestion.getSimuladoPrimeraCuota());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// fecha_documentacion 42
			if (gestion.getFechaDocumentacion() != null) {
				ps.setTimestamp(t++, new Timestamp(gestion.getFechaDocumentacion().getTime()));

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// AccionTipo 43
			if (gestion.getAccionTipo() != null) {
				ps.setString(t++, gestion.getAccionTipo());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// CodigoCampana 44
			if (gestion.getCodigoCampana() != null) {
				ps.setString(t++, gestion.getCodigoCampana());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// motivo_revocacion 45
			if (gestion.getMotivoRevocacion() != null) {
				ps.setString(t++, gestion.getMotivoRevocacion());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// NombreCampana 46
			if (gestion.getNombreCampana() != null) {
				ps.setString(t++, gestion.getNombreCampana());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// easycodealtitude 47
			if (gestion.getEasyCodeAltitude() != null) {
				ps.setInt(t++, gestion.getEasyCodeAltitude());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// actividad_economica 48
			if (gestion.getActividadEconomicaCliente() != null) {
				ps.setString(t++, gestion.getActividadEconomicaCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// cargo 49
			if (gestion.getCargoCliente() != null) {
				ps.setString(t++, gestion.getCargoCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// correo 50
			if (gestion.getCorreoCliente() != null) {
				ps.setString(t++, gestion.getCorreoCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// departamento 51
			if (gestion.getDepartamentoCliente() != null) {
				ps.setString(t++, gestion.getDepartamentoCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// direccion_empresa 52
			if (gestion.getDireccionEmpresaCliente() != null) {
				ps.setString(t++, gestion.getDireccionEmpresaCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// empresa 53
			if (gestion.getEmpresaCliente() != null) {
				ps.setString(t++, gestion.getEmpresaCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// ciudad 54
			if (gestion.getCiudad() != null) {
				ps.setString(t++, gestion.getCiudad());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// telefono_empresa 55
			if (gestion.getTelefonoEmpresaCliente() != null) {
				ps.setString(t++, gestion.getTelefonoEmpresaCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// telefono1 56
			if (gestion.getTelefono1Cliente() != null) {
				ps.setString(t++, gestion.getTelefono1Cliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// telefono2 57
			if (gestion.getTelefono2Cliente() != null) {
				ps.setString(t++, gestion.getTelefono2Cliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// telefono3 58
			if (gestion.getTelefono3Cliente() != null) {
				ps.setString(t++, gestion.getTelefono3Cliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// telefono4 59
			if (gestion.getTelefono4Cliente() != null) {
				ps.setString(t++, gestion.getTelefono4Cliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// sector 60
			if (gestion.getSectorCliente() != null) {
				ps.setString(t++, gestion.getSectorCliente());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// omitir 61
			if (gestion.getOmitir() != null) {
				ps.setInt(t++, gestion.getOmitir());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}
			// idcall 62
			if (gestion.getIdCall() != null) {
				ps.setString(t++, gestion.getIdCall());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			ps.executeUpdate();
			insertado = true;
			closeConexion();
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de insertarGestionRediferido Clase GestionDAO m�todo insertarGestionRediferido "
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... vista memo_3 "
							+ "descripci�n de evento... insertarGestionRediferido" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de insertarGestionRediferido Clase GestionDAO m�todo insertarGestionRediferido ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de insertarGestionRediferido Clase GestionDAO m�todo insertarGestionRediferido"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... vista memo_3 "
					+ "descripci�n de evento... insertarGestionRediferido" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de insertarGestionRediferido ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...insertarGestionRediferido");
		}
		return insertado;
	}
	
	/**
	 * consultarObligacionIdentificacion. m�todo para buscar la obligaci�n de un cliente
	 * @author Camilo Ochoa
	 * @param String identificacion (c�dula del cliente)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return String idObligacion
	 * @throws Exception 
	 * @see N/A
	 */
	public String consultarObligacionIdentificacion(String identificacion) throws Exception{
		logger.info("consultado");
		System.out.println("consultado");
		String idObligacion = "";
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {			
			con = ds.getConnection();
			
			StringBuffer query = new StringBuffer();
			
			query.append("   select  id_obligacion from davivienda.obligacion_hoy WITH (NOLOCK) "
					+ " where identificacion = ? ");
			
			ps = con.prepareStatement(query.toString(),  Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, identificacion);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				idObligacion = rs.getString(t++);
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de consultarObligacionIdentificacion Clase GestionDAO m�todo consultarObligacionIdentificacion"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... obligacion_hoy "
							+ "descripci�n de evento... lista consultarObligacionIdentificacion" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de buscarMemo ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultarObligacionIdentificacion Clase GestionDAO m�todo consultarObligacionIdentificacion"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... obligacion_hoy "
					+ "descripci�n de evento... lista consultarObligacionIdentificacion" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de consultarObligacionIdentificacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarObligacionIdentificacion");
		}
		return idObligacion;
	}

	/**
	 * insertarObligacionGestion. m�todo para insertar la obligaci�n
	 * @author Camilo Ochoa
	 * @param String idObligacion 
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return boolean con desici�n
	 * @throws Exception 
	 * @see N/A
	 */
	public boolean insertarObligacionGestion(String idObligacion) throws Exception {
		logger.info("Insertando");
		System.out.println("insertando");
		boolean insertado = false;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			StringBuffer query = new StringBuffer();

			query.append(" insert  into davivienda.obligacion_gestion ");
			query.append(" (id_gestion, id_obligacion, dias_mora,pago_minimo," );
			query.append(" pago_total, saldo_capital, saldo_mora ) ");
			query.append(" select (select top 1 idgestion from davivienda.gestion  order by idgestion desc) as id_gestion, ");
			query.append(" id_obligacion, dias_mora_calculado_hoy, pago_minimo_actual,"
					+ " saldo_total_actual, saldo_capital, saldo_mora_actual ");
			query.append(" from davivienda.obligacion_hoy ");
			query.append(" where id_obligacion = ? ");
			
			ps = con.prepareStatement(query.toString());
			
			ps.setString(1, idObligacion);

			ps.executeUpdate();
			insertado = true;
			closeConexion();
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de insertarObligacionGestion Clase GestionDAO m�todo insertarObligacionGestion"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... obligacion_gestion "
							+ "descripci�n de evento...  insertarObligacionGestion" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de buscarMemo ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de insertarObligacionGestion Clase GestionDAO m�todo insertarObligacionGestion"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... obligacion_gestion "
					+ "descripci�n de evento... insertarObligacionGestion" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de insertarObligacionGestion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...insertarObligacionGestion");
		}
		return insertado;
	}

	public boolean insertarGestionNoContacto(Gestion gestion) {
		logger.info("Insertando");
		System.out.println("insertando");
		boolean insertado = false;
		try {
			con = ds.getConnection();

			StringBuffer query = new StringBuffer();
			query.append(" EXEC [davivienda].[davivienda.guarda_gestiones_sin_contacto]  ");
			query.append(" @idresultado = ?,  ");// 1
			query.append(" @idsucursal = ?, ");// 2
			query.append(" @registrotipo = ?, ");// 3
			query.append(" @fechainicio = ?, ");// 4
			query.append(" @fechainiciollamada = ?, ");// 5
			query.append(" @fechafinllamada = ?, ");// 6
			query.append(" @telefonomarcado = ?, ");// 7
			query.append(" @fechapromesa = ?, ");// 8
			query.append(" @idusuarioaltitude = ?, ");// 9
			query.append(" @usernamealtitude = ?, ");// 10
			query.append(" @fullnamealtitude = ?, ");// 11
			query.append(" @observacion = ?, ");// 12
			query.append(" @idusuariocrea = ?, ");// 13
			query.append(" @estado = ?,  ");// 14
			// 15
			query.append(" @extension = ?, ");// 16
			query.append(" @accion_tipo = ?, ");// 17
			query.append(" @valorpromesa = ?, ");// 18
			query.append(" @fechaagendamiento = ?, ");// 19
			query.append(" @telefonoagendamiento = ?, ");// 20
			query.append(" @id_motivo_no_pago = ?, ");// 21
			query.append(" @idnegociacion = ?, ");// 22
			query.append(" @mensaje_tercero  = ?, ");// 23
			query.append(" @nombre_tercero = ?, ");// 24
			query.append(" @afinidad_tercero = ?, ");// 25
			query.append(" @pago_total_abono = ?, ");// 26
			query.append(" @pago_total_bono = ?, ");// 27
			query.append(" @daviabono = ?, ");// 28
			query.append(" @davibono = ?, ");// 29
			query.append(" @abono_zanahoria = ?, ");// 30
			query.append(" @bono_zanahoria = ?, ");// 31
			query.append(" @plazo_rediferido = ?, ");// 32
			query.append(" @tasa_rediferido = ?, ");// 33
			query.append(" @saldo_total_rediferido = ?, ");// 34
			query.append(" @saldo_cliente_rediferido = ?, ");// 35
			query.append(" @opcion_especial_rediferido = ?, ");// 36
			query.append(" @saldo_total_reestruc = ?, ");// 37
			query.append(" @pago_cliente_reestruc = ?, ");// 38
			query.append(" @reestructuracion_tipo = ?, ");// 39
			query.append(" @plazo_reestructuracion = ?, ");// 40
			query.append(" @id_politica = ?, ");// 41
			query.append(" @simulado_primera_cuota_reestruct = ?, ");// 42
			query.append(" @cpCodigoCampana = ?,  ");// 43
			query.append(" @nombre_campana = ?, ");// 44
			query.append(" @easycodealtitude = ? ");// 45

			ps = con.prepareStatement(query.toString());

			int t = 1;

			// idresultado 1
			if (gestion.getIdResultado() != null) {
				ps.setString(t++, gestion.getIdResultado());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idsucursal 2
			if (gestion.getIdsucursal() != null) {
				ps.setInt(t++, gestion.getIdsucursal());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// registrotipo 3
			if (gestion.getRegistroTipo() != null) {
				ps.setString(t++, gestion.getRegistroTipo());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fechainicio 4
			if (gestion.getFechainicio() != null) {
				ps.setTimestamp(t++, gestion.getFechainicio());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// fechainicio llamada 5
			if (gestion.getFechainiciollamada() != null) {
				ps.setTimestamp(t++, gestion.getFechainiciollamada());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// fechafinllamada 6
			if (gestion.getFechafinllamada() != null) {
				ps.setTimestamp(t++, gestion.getFechafinllamada());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// telefonomarcado 7
			if (gestion.getTelefonomarcado() != null) {
				ps.setString(t++, gestion.getTelefonomarcado());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fechapromesa 8
			if (gestion.getFechapromesa() != null) {
				ps.setTimestamp(t++, gestion.getFechapromesa());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// idusuarioaltitude 9
			if (gestion.getIdusuarioaltitude() != null) {
				ps.setInt(t++, gestion.getIdusuarioaltitude());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// usernamealtitude 10
			if (gestion.getUsernamealtitude() != null) {
				ps.setString(t++, gestion.getUsernamealtitude());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fullnamealtitude 11
			if (gestion.getFullnamealtitude() != null) {
				ps.setString(t++, gestion.getFullnamealtitude());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// observacion 12
			if (gestion.getObservacion() != null) {
				ps.setString(t++, gestion.getObservacion());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idusuariocrea 13
			if (gestion.getIdusuariocrea() != null) {
				ps.setInt(t++, gestion.getIdusuariocrea());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// estado 14
			if (gestion.getEstado() != null) {
				ps.setInt(t++, gestion.getEstado());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// hubo_contacto 15

			// extension 16
			if (gestion.getExtension() != null) {
				ps.setInt(t++, gestion.getExtension());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// accion_tipo 17
			if (gestion.getAccionTipo() != null) {
				ps.setString(t++, gestion.getAccionTipo());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// valorpromesa 18
			if (gestion.getValorpromesa() != null) {
				ps.setBigDecimal(t++, gestion.getValorpromesa());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// fechaagendamiento 19
			if (gestion.getFechaagendamiento() != null) {
				ps.setTimestamp(t++, gestion.getFechaagendamiento());
			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// telefonoagendamiento 20
			if (gestion.getTelefonoagendamiento() != null) {
				ps.setString(t++, gestion.getTelefonoagendamiento());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// id_motivo_no_pago 21
			if (gestion.getIdMotivoNoPago() != null) {
				ps.setInt(t++, gestion.getIdMotivoNoPago());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// idnegociacion 22
			if (gestion.getIdNegociacion() != null) {
				ps.setString(t++, gestion.getIdNegociacion());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// mensaje_tercero 23
			if (gestion.getMesajeTercero() != null) {
				ps.setString(t++, gestion.getMesajeTercero());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// nombre_tercero 24
			if (gestion.getNombretercero() != null) {
				ps.setString(t++, gestion.getNombretercero());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}
			// afinidad_tercero 25
			if (gestion.getAfinidadTercero() != null) {
				ps.setInt(t++, gestion.getAfinidadTercero());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// monto_abono//pago_total_abono 26
			if (gestion.getMontoAbono() != null) {
				ps.setBigDecimal(t++, gestion.getMontoAbono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// monto_bono//pago_total_bono 27
			if (gestion.getMontoBono() != null) {
				ps.setBigDecimal(t++, gestion.getMontoBono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// abono//daviabono 28
			if (gestion.getAbono() != null) {
				ps.setBigDecimal(t++, gestion.getAbono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}
			// bono//davibono 29
			if (gestion.getBono() != null) {
				ps.setBigDecimal(t++, gestion.getBono());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// abono zanahoria 30
			if (gestion.getAbonoZanahoria() != null) {
				ps.setBigDecimal(t++, gestion.getAbonoZanahoria());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// bono zanahoria 31
			if (gestion.getBonoZanahoria() != null) {
				ps.setBigDecimal(t++, gestion.getBonoZanahoria());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// n_cuotas/plazo_rediferido 32
			if (gestion.getNumeroCuotas() != null) {
				ps.setInt(t++, gestion.getNumeroCuotas());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// tasa_mensual/tasa_rediferido 33
			if (gestion.getTasaMensual() != null) {
				ps.setDouble(t++, gestion.getTasaMensual());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// saldo_capital/saldo_total_rediferido 34
			if (gestion.getSaldoCapital() != null) {
				ps.setBigDecimal(t++, gestion.getSaldoCapital());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// pago_cliente rediferido//saldo_cliente_rediferido 35
			if (gestion.getPagoClienteRediferido() != null) {
				ps.setBigDecimal(t++, gestion.getPagoClienteRediferido());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// opcion_especial_rediferido 36
			if (gestion.getOpcionEspecialRediferido() != null) {
				ps.setString(t++, gestion.getOpcionEspecialRediferido());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// saldo_total_reestruc 37
			if (gestion.getSaldoTotalreestruc() != null) {
				ps.setBigDecimal(t++, gestion.getSaldoTotalreestruc());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// pago_cliente_reestruc 38
			if (gestion.getPagoclienteReestruc() != null) {
				ps.setBigDecimal(t++, gestion.getPagoclienteReestruc());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// tipo/reestructuracion_tipo 39
			if (gestion.getTipo() != null) {
				ps.setString(t++, gestion.getTipo());
			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// plazo/plazo_reestructuracion 40
			if (gestion.getPlazo() != null) {
				ps.setInt(t++, gestion.getPlazo());
			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// id_politica -- pendiente 41
			if (gestion.getIdPolitica() != null) {
				ps.setBigDecimal(t++, gestion.getSimuladoPrimeraCuota());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// simulado_primera_cuota/simulado_primera_cuota_reestruct 42
			if (gestion.getSimuladoPrimeraCuota() != null) {
				ps.setBigDecimal(t++, gestion.getSimuladoPrimeraCuota());
			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// CodigoCampana/cpCodigoCampana 43
			if (gestion.getCodigoCampana() != null) {
				ps.setString(t++, gestion.getCodigoCampana());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// NombreCampana/nombre_campana 44
			if (gestion.getNombreCampana() != null) {
				ps.setString(t++, gestion.getNombreCampana());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// easycodealtitude 45
			if (gestion.getEasyCodeAltitude() != null) {
				ps.setInt(t++, gestion.getEasyCodeAltitude());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			ps.executeUpdate();
			insertado = true;
		} catch (SQLException e) {
			logger.error(e.toString(), e.fillInStackTrace());
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			closeConexion();
		}
		return insertado;
	}

}
