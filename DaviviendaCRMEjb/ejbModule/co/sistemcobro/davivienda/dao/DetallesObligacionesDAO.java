package co.sistemcobro.davivienda.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.ObligacionHoy;

public class DetallesObligacionesDAO extends BaseDAO {

	public DetallesObligacionesDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(DetallesObligacionesDAO.class);

	private String SQL_BUSCAR_DETALLES_OBLIGACION = " SELECT DISTINCT o.cod_trunc, o.id_rediferido, o.id_obligacion, o.nro_credito, "
			+ " o.nombre_status,o.nombre_producto,o.clase, o.banda, o.pago_minimo, "
			+ " o.pago_minimo_inicial, o.saldo_mora, o.saldo_capital, o.saldo_total_inicial, o.saldo_total, "
			+ " o.intereses_corrientes, o.intereses_mora, o.honorarios, o.fecha_limite, o.estado, bloqueo, "
			+ " o.bloqueo_evolucion, o.rango, o.rango_inicial,o.dias_mora_calculado_hoy,"
			+ " o.fecha_corte_archivo as dia_corte, o.descripcion_del_ciclo, o.cuadrante, "
			+ " o.pg_tot_pago_cliente, o.rediferido, o.opciones_de_rediferido, o.reestructuracion, "
			+ " o.tasa_preferencial,o.davi_bono,o.davi_abono,o.bono_zan,o.abono_zan,o.pago_en_mes, "
			+ " o.pago_ultimos_15_dias,o.fecha_acuerdo,o.estrategia_gestion, o.estado_seguimiento, "
			+ " o.fecha_seguimiento, CASE WHEN dias_mora_calculado_hoy>=11 and "
			+ " dias_mora_calculado_hoy<=30  THEN pago_minimo*1.0137 WHEN dias_mora_calculado_hoy>=31 "
			+ " and dias_mora_calculado_hoy<=60  THEN pago_minimo*1.06 ELSE 0 END as pago_minimo_honorarios, "
			+ " CASE  WHEN dias_mora_calculado_hoy>=11 and dias_mora_calculado_hoy<=30  THEN saldo_mora*1.0137 "
			+ " WHEN dias_mora_calculado_hoy>=31 and dias_mora_calculado_hoy<=60  THEN saldo_mora*1.06 ELSE 0 "
			+ " END as saldo_mora_honorarios, o.cabeza_para_30 ,o.dias_mora_dolares, o.saldo_dolares, "
			+ " o.saldo_mora_dolares,o.pago_min_dolares FROM davivienda.obligacion_detalle_hoy o WITH (NOLOCK)"
			+ " inner join davivienda.status_por_campana sc WITH (NOLOCK) on o.status = sc.id_status  "
			+ " inner join davivienda.campana c WITH (NOLOCK) on c.id_campana = sc.id_campana "
			+ " where o.identificacion = ? and o.obligacion = ? "
			// + " and c.numero_altitude = @(cpCodigoCampana) ";
			+ "  and o.estado_registro<>1 " + " order by id_obligacion asc ";

	public ObligacionHoy buscarDetallesObligacion(String idCliente,BigDecimal idObligacion) {
		
		ObligacionHoy obligacion = new ObligacionHoy();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_DETALLES_OBLIGACION);
			ps.setString(1, idCliente);
			ps.setBigDecimal(2, idObligacion);
			

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				obligacion = new ObligacionHoy();
				
				obligacion.setCodTrunc(rs.getString(t++));
				obligacion.setIdRediferido(rs.getInt(t++));
				obligacion.setIdObligacion(rs.getBigDecimal(t++));
				obligacion.setNumeroCredito(rs.getBigDecimal(t++));
				obligacion.setNombreStatus(rs.getString(t++));
				obligacion.setNombreProducto(rs.getString(t++));
				obligacion.setClase(rs.getString(t++));
				obligacion.setBanda(rs.getString(t++));
				obligacion.setPagoMinimo(rs.getBigDecimal(t++));
				obligacion.setPagoMinimoInicial(rs.getBigDecimal(t++));
				obligacion.setSaldoMora(rs.getBigDecimal(t++));
				obligacion.setSaldoCapital(rs.getBigDecimal(t++));
				obligacion.setSaldoTotalInicial(rs.getBigDecimal(t++));
				obligacion.setSaldoTotal(rs.getBigDecimal(t++));
				obligacion.setInteresCorriente(rs.getBigDecimal(t++));
				obligacion.setInteresesMora(rs.getBigDecimal(t++));
				obligacion.setHonorarios(rs.getBigDecimal(t++));
				obligacion.setFechaLimite(rs.getTimestamp(t++));
				obligacion.setEstado(rs.getString(t++));
				obligacion.setBloqueo(rs.getString(t++));
				obligacion.setBloqueoEvolucion(rs.getString(t++));
				obligacion.setRango(rs.getString(t++));
				obligacion.setRangoInicial(rs.getInt(t++));
				obligacion.setDiaMoraCalculoHoy(rs.getInt(t++));
				obligacion.setFechaCorteArchivo(rs.getTimestamp(t++));
				obligacion.setDescripcionCiclo(rs.getString(t++));
				obligacion.setCuadrante(rs.getString(t++));
				obligacion.setPagoTotal(rs.getBigDecimal(t++));
				obligacion.setRediferido(rs.getInt(t++));
				obligacion.setOpcionesRediferido(rs.getString(t++));
				obligacion.setReestructuracion(rs.getString(t++));
				obligacion.setTasaPreferencial(rs.getString(t++));
				obligacion.setDaviBono(rs.getBigDecimal(t++));
				obligacion.setDaviABono(rs.getBigDecimal(t++));
				obligacion.setBonoZanahoria(rs.getBigDecimal(t++));
				obligacion.setAbonoZanahoria(rs.getBigDecimal(t++));
				obligacion.setPagoMes(rs.getBigDecimal(t++));
				obligacion.setPagoUltimos15Dias(rs.getBigDecimal(t++));
				obligacion.setFechaAcuerdo(rs.getTimestamp(t++));
				obligacion.setEstrategiaGestion(rs.getString(t++));
				obligacion.setEstadoSeguimiento(rs.getString(t++));
				obligacion.setFechaSeguimiento(rs.getTimestamp(t++));
				obligacion.setPagMinHonorariosTotal(rs.getBigDecimal(t++));
				obligacion.setSaldoMoraHonorariosTotal(rs.getBigDecimal(t++));
				obligacion.setCabeceraPara30(rs.getBigDecimal(t++));
				obligacion.setDiasMoraDolar(rs.getBigDecimal(t++));
				obligacion.setSaldoDolar(rs.getBigDecimal(t++));
				obligacion.setSaldoMoraDolar(rs.getBigDecimal(t++));
				obligacion.setPagoMinDolar(rs.getBigDecimal(t++));

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Clientes ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los Clientes ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return obligacion;
	}
	private String SQL_OBLIGACIONES_EN_OTRAS_CAMPANAS = " select top 10 o.obligacion, o.nombre_status "
			+ " from davivienda.obligacion_detalle_hoy o WITH (NOLOCK) where o.status not in ( "
			+ " select id_status from davivienda.status_por_campana sc WITH (NOLOCK) "
			+ " inner join davivienda.campana c WITH (NOLOCK) on sc.id_campana = c.id_campana "
			+ " where identificacion = ?) order by o.obligacion desc ";

	public List<ObligacionHoy> obligacionesEnOtrasCampanas(String identificacion) {
		
		ObligacionHoy obligacion = null;
		List<ObligacionHoy> obligacionesOtrasCampanas = new ArrayList<>();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_OBLIGACIONES_EN_OTRAS_CAMPANAS);
			ps.setString(1, identificacion);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				obligacion = new ObligacionHoy();	
				
				obligacion.setObligacion(rs.getString(t++));
				obligacion.setNombreStatus(rs.getString(t++));
				
				obligacionesOtrasCampanas.add(obligacion);
			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Clientes ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los Clientes ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return obligacionesOtrasCampanas;
	}

}
