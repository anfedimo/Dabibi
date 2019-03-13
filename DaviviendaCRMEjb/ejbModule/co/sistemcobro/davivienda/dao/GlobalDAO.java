package co.sistemcobro.davivienda.dao;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Global;

public class GlobalDAO extends BaseDAO {

	public GlobalDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(DolarDAO.class);

	private String SQL_OBSERVACION = " select top 1 pago_total_30_prctg, fuente_politica_30_prct, planchoque_observacion"
			+ "	from davivienda.obligacion_detalle_hoy WITH (NOLOCK) " + " where obligacion = ? ";

	/**
	 * consultaObservacion. método para buscar las observaciones
	 * 
	 * @author Camilo Ochoa
	 * @param BigDecimal
	 *            numeroObligacion (número de obligación)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return objeto tipo Global
	 * @see N/A
	 */
	public Global consultaObservacion(BigDecimal numeroObligacion) throws Exception {
		Global global = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_OBSERVACION, Statement.RETURN_GENERATED_KEYS);
			ps.setBigDecimal(1, numeroObligacion);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				global = new Global();
				global.setPago_total_30_prctg(rs.getString(t++));
				global.setNombre_politica(rs.getString(t++));
				global.setObservacion(rs.getString(t++));
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de consultaObservacion Clase GlobalDAO método consultaObservacion"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... obligacion_detalle_hoy "
							+ "descripción de evento... objeto consultaObservacion" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultaObservacion ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultaObservacion Clase GlobalDAO método consultaObservacion"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... obligacion_detalle_hoy "
					+ "descripción de evento... objeto consultaObservacion" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de consultaObservacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultaObservacion");
		}
		return global;
	}

	private String SQL_FECHA = " SELECT top 1 f.fecha, convert(varchar(10), f.fecha, 103) as fechaFormateada"
			+ " FROM davivienda.ultima_fecha_compromiso_autorizado f WITH (NOLOCK) " + " order by id_ultima_fecha desc ";

	/**
	 * consultarFecha. método para buscar fechas de los compromisos
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return objeto tipo Global
	 * @see N/A
	 */
	public Global consultarFecha() throws Exception {
		Global global = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_FECHA, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				global = new Global();
				global.setFecha(rs.getTimestamp(t++));
				global.setFechaFormateada(rs.getString(t++));
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultaObservacion Clase GlobalDAO método consultarFecha"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... ultima_fecha_compromiso_autorizado "
					+ "descripción de evento... objeto consultarFecha" + " ip..... " + address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarFecha ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultaObservacion Clase GlobalDAO método consultarFecha"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... ultima_fecha_compromiso_autorizado "
					+ "descripción de evento... objeto consultarFecha" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de consultarFecha ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarFecha");
		}
		return global;
	}

	private String SQL_AFINIDAD = " SELECT id_afinidad, nombre FROM davivienda.afinidad_relacional WITH (NOLOCK)";

	/**
	 * consultarAfinidad. método que lista las afinidades
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<Global> lista de afinidades
	 * @see N/A
	 */
	public List<Global> consultarAfinidad() throws Exception {
		List<Global> listaAfinidades = new ArrayList<>();
		Global global = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_AFINIDAD, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();

			int t = 1;
			while (rs.next()) {
				t = 1;
				global = new Global();
				global.setIdAfinidad(rs.getInt(t++));
				global.setNombreAfinidad(rs.getString(t++));

				listaAfinidades.add(global);
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de consultaObservacion Clase GlobalDAO método consultarAfinidad"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada .... afinidad_relacional "
							+ "descripción de evento... lista consultarAfinidad" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarAfinidad ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultaObservacion Clase GlobalDAO método consultarAfinidad"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... afinidad_relacional "
					+ "descripción de evento... lista consultarAfinidad" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de consultarAfinidad ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarAfinidad");
		}
		return listaAfinidades;
	}

	/**
	 * consultarMotivosNoPago. método que lista los motivos de no pago
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<Global> lista de afinidades
	 * @see N/A
	 */
	private String SQL_MOTIVOS_NO_PAGO = " select str(mnp.id_motivo, 2) id_motivo, "
			+ " (cast(mnp.id_motivo as varchar) + ' | ' + mnp.nombre) as nombre_y_codigo "
			+ " from  davivienda.motivo_no_pago mnp WITH (NOLOCK) " + " where estado = 2 ";

	public List<Global> consultarMotivosNoPago() throws Exception {
		List<Global> listaMotivosNoPago = new ArrayList<>();
		Global global = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_MOTIVOS_NO_PAGO, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();

			int t = 1;
			while (rs.next()) {
				t = 1;
				global = new Global();
				global.setIdMotivoNoPago(rs.getInt(t++));
				global.setNombreMotivoNoPago(rs.getString(t++));

				listaMotivosNoPago.add(global);
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de consultaObservacion Clase GlobalDAO método consultarMotivosNoPago"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... motivo_no_pago "
							+ "descripción de evento... lista consultarMotivosNoPago" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarMotivosNoPago ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultaObservacion Clase GlobalDAO método consultarAfinidad"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... motivo_no_pago "
					+ "descripción de evento... lista consultarMotivosNoPago" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de consultarMotivosNoPago ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarMotivosNoPago");
		}
		return listaMotivosNoPago;
	}

	/**
	 * consultarSimulador. método que simula las cuotas 
	 * @author Camilo Ochoa
	 * @param Integer numCuotas, Integer idRediferido
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<Global> lista de afinidades
	 * @see N/A
	 */
	private String SQL_SIMULADOR = " select numero_cuota, capital_abonado_por_cuota, " + " intereses_abonar_por_cuota, "
			+ " (capital_abonado_por_cuota +intereses_abonar_por_cuota) as cuota from ( "
			+ " select c.numero numero_cuota, src.capital_abonado_por_cuota, "
			+ " (? +1 - c.numero) * capital_abonado_por_cuota * tasa.valor / 100  intereses_abonar_por_cuota"
			+ " from davivienda.simulador_rediferidos_capital src WITH (NOLOCK) , "
			+ " davivienda.cuota c WITH (NOLOCK) , davivienda.tasa_por_politica tasa WITH (NOLOCK),"
			+ " davivienda.politica_cobro p WITH (NOLOCK) where src.numero = ? and id_rediferido = ? "
			+ " and c.numero <= ? and tasa.id_politica = p.id_politica and p.nombre = 'Rediferido') v ";

	public List<Global> consultarSimulador(Integer numCuotas, Integer idRediferido) throws Exception {
		List<Global> simulaciones = new ArrayList<Global>();
		Global global = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {

			con = ds.getConnection();			
			
			ps = con.prepareStatement(SQL_SIMULADOR, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, numCuotas);
			ps.setInt(2, numCuotas);
			ps.setInt(3, idRediferido);
			ps.setInt(4, numCuotas);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				global = new Global();
				global.setNumeroCuota(rs.getInt(t++));
				global.setCapitalaAbonadoPorCuota(rs.getBigDecimal(t++));
				global.setInteresesAbonarPorCuota(rs.getBigDecimal(t++));
				global.setCuota(rs.getBigDecimal(t++));

				simulaciones.add(global);
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de consultarSimulador Clase GlobalDAO método consultarSimulador"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... simulador_rediferidos_capital, cuota , tasa_por_politica, politica_cobro  "
							+ "descripción de evento... lista consultarSimulador" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarMotivosNoPago ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultaObservacion Clase GlobalDAO método consultarSimulador"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... simulador_rediferidos_capital, cuota , tasa_por_politica, politica_cobro "
					+ "descripción de evento... lista consultarSimulador" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de consultarSimulador ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarSimulador");
		}
		return simulaciones;
	}
	
	/**
	 * consultarSimuladorCuota. método que simula las cuotas 
	 * @author Camilo Ochoa
	 * @param Integer numCuotas, Integer idRediferido
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return objeto tipo Global
	 * @see N/A
	 */
	public Global consultarSimuladorCuota(Integer numCuotas, Integer idRediferido) throws Exception {
		Global global = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {

			con = ds.getConnection();			
			
			ps = con.prepareStatement(SQL_SIMULADOR, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, numCuotas);
			ps.setInt(2, numCuotas);
			ps.setInt(3, idRediferido);
			ps.setInt(4, numCuotas);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				global = new Global();
				global.setNumeroCuota(rs.getInt(t++));
				global.setCapitalaAbonadoPorCuota(rs.getBigDecimal(t++));
				global.setInteresesAbonarPorCuota(rs.getBigDecimal(t++));
				global.setCuota(rs.getBigDecimal(t++));
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de consultarSimuladorCuota Clase GlobalDAO método consultarSimuladorCuota"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... simulador_rediferidos_capital, cuota , tasa_por_politica, politica_cobro  "
							+ "descripción de evento... lista consultarSimuladorCuota" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarMotivosNoPago ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultarSimuladorCuota Clase GlobalDAO método consultarSimuladorCuota"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... simulador_rediferidos_capital, cuota , tasa_por_politica, politica_cobro "
					+ "descripción de evento... lista consultarSimuladorCuota" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de consultarSimuladorCuota ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarSimuladorCuota");
		}
		return global;
	}

}
