package co.sistemcobro.davivienda.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Cliente;
import co.sistemcobro.davivienda.bean.Obligacion;
import co.sistemcobro.davivienda.bean.ObligacionHoy;

public class ClienteDAOImplDavivienda extends BaseDAO {

	public ClienteDAOImplDavivienda(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(ClienteDAOImplDavivienda.class);

	private String SQL_BUSCAR_CLIENTES = " select distinct o.identificacion as id_cliente,o.titular as nombre_cliente,o.identificacion as identificacion "
                                         +" from davivienda.obligacion  o WITH (NOLOCK)"
										 +" left join davivienda.info_titular it WITH (NOLOCK) on it.identificacion = o.identificacion "
										 +" left join davivienda.cargue c WITH (NOLOCK) on o.id_cargue = c.id_cargue and c.estado = 2 "
										 +" left join davivienda.base b WITH (NOLOCK) on b.id_base = c.base and b.estado = 2 "
										 +" left  join davivienda.ciudad ci WITH (NOLOCK) on ci.id = it.id_ciudad "
			                             +" where  (o.identificacion like  ? )"
			                             //+ "	or  o.factura like  ?  or  o.contrato like  ? or o.nombre_cliente like ?) "
			                             + " order by o.identificacion desc ";

	public List<Cliente> buscarClientes(String filtro) throws Exception {

		ArrayList<Cliente> clienteD = new ArrayList<>();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_CLIENTES);
			ps.setString(1, "%" + filtro + "%");
			
			logger.info("query buscarClientes ");
			logger.info(SQL_BUSCAR_CLIENTES);
			//ps.setString(2, "%" + filtro + "%");
			//ps.setString(3, "%" + filtro + "%");
			//ps.setString(4, "%" + filtro + "%");
			//ps.setString(5, "%" + filtro + "%");

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				Cliente cl = new Cliente();
				cl.setIdcliente(rs.getString(t++));
				cl.setNombre(rs.getString(t++));
				cl.setIdentificacion(rs.getString(t++));
				
				clienteD.add(cl);
			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Clientes ", e);
			throw new SQLException("Error SQL al tratar de leer  los Clientes ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los Clientes ", e);
			throw new Exception("Error al tratar de leer  los Clientes : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao buscarClientes!");
		}
		return clienteD;
	}

	private String SQL_DETALLE_CLIENTE = "select top 1 "
			+ " o.identificacion as id_cliente, "
			+ " o.identificacion as identificacion, "
			+ " o.titular as nombre_cliente, "
			+ " it.correo as email, "
			+ " o.direccion_referencia, "
			+ " ci.nombre as ciudad "
			+ " from davivienda.obligacion  o WITH (NOLOCK) "
			+ " left join davivienda.info_titular it WITH (NOLOCK) on it.identificacion = o.identificacion "
			+ " left join davivienda.cargue c WITH (NOLOCK) on o.id_cargue = c.id_cargue and c.estado = 2 " 
			+ " left join davivienda.base b WITH (NOLOCK) on b.id_base = c.base and b.estado = 2 "
			+ " left  join davivienda.ciudad ci WITH (NOLOCK) on ci.id = it.id_ciudad"
			+ " where c.estado=2 and b.estado=2  and o.titular is not null "
			+ " and  o.identificacion =? order by o.identificacion desc ";

	public Cliente buscarDetalleClientes(Cliente cliente) throws Exception {

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_DETALLE_CLIENTE);
			ps.setString(1, cliente.getIdcliente());
			
			logger.info("query detalle");
			logger.info(SQL_DETALLE_CLIENTE);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				cliente.setIdcliente(rs.getString(t++));
				cliente.setIdentificacion(rs.getString(t++));
				cliente.setNombre(rs.getString(t++));								
				cliente.setCorreo(rs.getString(t++));
				cliente.setDireccion(rs.getString(t++));
				cliente.setCiudad(rs.getString(t++));

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  el detalle del cliente ", e);
			throw new SQLException("Error SQL al tratar de leer el detalle del cliente ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer el detalle del cliente ", e);
			throw new Exception("Error al tratar de leer  el detalle del cliente : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return cliente;
	}

	private String SQL_OBLIGACIONES_CLIENTE = "SELECT cantidad,pago_minimo,saldo_mora,saldo_capital,pago_total,intereses_corrientes,intereses_mora, "
			+ " honorarios,pg_min_mas_honorarios,pago_minimo_honorarios_total,saldo_mora_honorarios_total,dias_mora_dolares,saldo_dolares, "
			+ " saldo_mora_dolares,pago_minimo_dolares,numero_altitude as campana "
			+ " FROM davivienda.consolidado_obligaciones_deudor cod WITH (NOLOCK) where cod.identificacion = ? ";
			//+ " and cod.numero_altitude = ? ";--se deja pendiente por si hay que buscar por campaña

	public Cliente buscarObligacionesCLiente(Cliente cliente) throws Exception {

		ArrayList<Obligacion> obligaciones = new ArrayList<>();
		Obligacion obligacion = new Obligacion();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_OBLIGACIONES_CLIENTE);
			ps.setString(1, cliente.getIdcliente());

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				obligacion = new Obligacion();
				
				obligacion.setCantidad(rs.getInt(t++));
				obligacion.setPagoMinimo(rs.getBigDecimal(t++));
				obligacion.setSaldoMora(rs.getBigDecimal(t++));
				obligacion.setSaldoCapital(rs.getBigDecimal(t++));
				obligacion.setPagoTotal(rs.getBigDecimal(t++));
				obligacion.setInteresCorriente(rs.getBigDecimal(t++));
				obligacion.setInteresMora(rs.getBigDecimal(t++));
				obligacion.setHonorarios(rs.getBigDecimal(t++));
				obligacion.setPagMinMasHonorarios(rs.getBigDecimal(t++));
				obligacion.setPagMinHonorariosTotal(rs.getBigDecimal(t++));
				obligacion.setSaldoMoraHonorariosTotal(rs.getBigDecimal(t++));
				obligacion.setDiasMoraDolar(rs.getBigDecimal(t++));
				obligacion.setSaldoDolar(rs.getBigDecimal(t++));
				obligacion.setSaldoMoraDolar(rs.getBigDecimal(t++));
				obligacion.setPagoMinDolar(rs.getBigDecimal(t++));
				obligacion.setCampana(rs.getInt(t++));
				
				obligaciones.add(obligacion);
			}
			cliente.setObligaciones(obligaciones);
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Clientes ", e);
			throw new Exception("Error SQL al tratar de leer  los Clientes ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los Clientes ", e);
			throw new Exception("Error al tratar de leer  los Clientes : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return cliente;
	}
	
	private String SQL_OBLIGACIONES_HOY_CLIENTE = " SELECT DISTINCT o.identificacion, o.id_obligacion, o.nro_credito, "
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
			+ " o.saldo_mora_dolares,o.pago_min_dolares FROM davivienda.obligacion_detalle_hoy o WITH (NOLOCK) "
			+ " inner join davivienda.status_por_campana sc WITH (NOLOCK) on o.status = sc.id_status "
			+ " inner join davivienda.campana c WITH (NOLOCK) on c.id_campana = sc.id_campana "
			+ " where o.identificacion = ? "
			//+ " and c.numero_altitude = @(cpCodigoCampana) ";
	        + "  and o.estado_registro<>1 "
	        + " order by o.id_obligacion asc ";
	
	public Cliente buscarObligacionesHoyCliente(Cliente cliente) throws Exception {

		ArrayList<ObligacionHoy> obligaciones = new ArrayList<>();
		ObligacionHoy obligacion = new ObligacionHoy();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_OBLIGACIONES_HOY_CLIENTE);
			ps.setString(1, cliente.getIdcliente());

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				obligacion = new ObligacionHoy();
				
				obligacion.setIdCliente(rs.getString(t++));
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
				
				obligaciones.add(obligacion);
			}
			cliente.setObligacionesHoy(obligaciones);
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Clientes ", e);
			throw new Exception("Error SQL al tratar de leer  los Clientes ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los Clientes ", e);
			throw new Exception("Error al tratar de leer  los Clientes : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return cliente;
	}
}
