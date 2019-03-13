package co.sistemcobro.davivienda.dao;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Telefono;

public class TelefonoDAO extends BaseDAO {

	public TelefonoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(TelefonoDAO.class);

	private String SQL_TELEFONOS_EN_LA_ASIGNACION = "select telefono, etiqueta "
			+ " from davivienda.telefonos  where " + " identificacion = ? and telefono is not null "
			+ " and telefono not in ('1', '1,00', '0') order by orden desc";
	
	/**
	 * listaTelefonosAsignacion. método para buscar las telefonos asignados
	 * 
	 * @author Camilo Ochoa
	 * @param String identificacion (cédula del cliente)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<Telefono> lista de telefonos 
	 * @see N/A
	 */
	public List<Telefono> listaTelefonosAsignacion(String identificacion) throws Exception {
		List<Telefono> telefonosAsignacion = new ArrayList<>();
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TELEFONOS_EN_LA_ASIGNACION, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, identificacion);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Telefono telefono = new Telefono();
				telefono.setTelefono(rs.getString(t++));
				telefono.setEtiqueta(rs.getString(t++));

				telefonosAsignacion.add(telefono);
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de listaTelefonosAsignacion Clase TelefonoDAO método listaTelefonosAsignacion"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... telefonos "
							+ "descripción de evento... lista listaTelefonosAsignacion" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultaObservacion ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de listaTelefonosAsignacion Clase TelefonoDAO método listaTelefonosAsignacion"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... telefonos "
					+ "descripción de evento... lista listaTelefonosAsignacion" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de listaTelefonosAsignacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao telefonos!");
		}
		return telefonosAsignacion;
	}
	
	
	private String SQL_TELEFONOS_CONTACTABILIDAD = "select case when len(xx.telefono) = 11 and xx.telefono like '456%' "
			+ " then '0' + convert(varchar(30), xx.telefono) else convert(varchar(30), xx.telefono) end telefono, "
			+ " (100*(xx.num_localizado-xx.num_ilocalizado)/(xx.num_localizado+xx.num_ilocalizado)) as probabilidad, "
			+ " xx.num_localizado, xx.num_ilocalizado from ( select tmp.cedula, tmp.telefono, "
			+ " (select count(g.telefonomarcado) from davivienda.gestion g  "
			+ " inner join davivienda.resultado_tipo_estandar t  on g.idresultado=t.id_tipo_resultado_estandar "
			+ " inner join davivienda.obligacion_gestion og  on og.id_gestion=g.idgestion "
			+ " inner join davivienda.obligacion o on  o.id_obligacion=og.id_obligacion "
			+ " where g.estado = 2 and t.localizacion=1 and o.identificacion=tmp.cedula "
			+ " and g.telefonomarcado=tmp.telefono) as num_localizado, (select count(g.telefonomarcado) "
			+ " from davivienda.gestion g  inner join davivienda.resultado_tipo_estandar t  on g.idresultado=t.id_tipo_resultado_estandar "
			+ " inner join davivienda.obligacion_gestion og  on og.id_gestion=g.idgestion "
			+ " inner join davivienda.obligacion o  on o.id_obligacion=og.id_obligacion where g.estado = 2 and t.localizacion=0 "
			+ " and o.identificacion=tmp.cedula and g.telefonomarcado=tmp.telefono) as num_ilocalizado from (select distinct o.identificacion as cedula, g.telefonomarcado as telefono "
			+ " from davivienda.gestion g  inner join davivienda.obligacion_gestion og  on og.id_gestion=g.idgestion "
			+ " inner join davivienda.obligacion o  on o.id_obligacion=og.id_obligacion "
			+ " where g.estado = 2 and o.identificacion= ?) tmp) as xx ";
	
	/**
	 * listaTelefonosContactabilidad. método para saber la contactabilidad de los clientes
	 * 
	 * @author Camilo Ochoa
	 * @param String identificacion (cédula del cliente)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<Telefono> lista de telefonos con contactabilidad 
	 * @see N/A
	 */
	public List<Telefono> listaTelefonosContactabilidad(String identificacion) throws Exception {
		List<Telefono> telefonosContactabilidad = new ArrayList<>();
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TELEFONOS_CONTACTABILIDAD, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, identificacion);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Telefono telefono = new Telefono();
				telefono.setTelefono(rs.getString(t++));
				telefono.setProbabilidad(rs.getString(t++));
				telefono.setCantLocalizado(rs.getInt(t++));
				telefono.setCantILocalizado(rs.getInt(t++));
				
				telefonosContactabilidad.add(telefono);
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de listaTelefonosContactabilidad Clase TelefonoDAO método listaTelefonosContactabilidad "
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... telefonos,resultado_tipo_estandar,obligacion_gestion "
							+ "descripción de evento... lista listaTelefonosContactabilidad" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de listaTelefonosContactabilidad ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de listaTelefonosContactabilidad Clase TelefonoDAO método listaTelefonosContactabilidad"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... telefonos,resultado_tipo_estandar,obligacion_gestion "
					+ "descripción de evento... lista listaTelefonosContactabilidad" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de listaTelefonosContactabilidad ");
		} finally {
			closeConexion();
			logger.info("finalizo dao listaTelefonosContactabilidad!");
		}
		return telefonosContactabilidad;
	}
	
	private String SQL_TELEFONOS_RETIRADOS = " select "
			+ " rt.id_retiro_telefono,rt.telefono ,rt.fecha_retiro,rt.motivo_retiro,rt.id_cargue "
			+ " from  davivienda.retiro_telefono rt "
			+ " inner join  davivienda.cargue c  on rt.id_cargue = c.id_cargue "
			+ " where identificacion = ?  and c.estado = 2 and rt.estado = 2 ";

	/**
	 * listaTelefonosRetirados. método para saber los telefonos retirados
	 * 
	 * @author Camilo Ochoa
	 * @param String identificacion (cédula del cliente)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<Telefono> lista de telefonos con contactabilidad 
	 * @see N/A
	 */
	public List<Telefono> listaTelefonosRetirados(String identificacion) throws Exception {
		List<Telefono> telefonosRetirados = new ArrayList<>();
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TELEFONOS_RETIRADOS, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, identificacion);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Telefono telefono = new Telefono();
				telefono.setIdTelefonoRetiro(rs.getInt(t++));
				telefono.setTelefono(rs.getString(t++));
				telefono.setFechaRetiro(rs.getTimestamp(t++));
				telefono.setMotivoRetiro(rs.getString(t++));
				telefono.setIdCargue(rs.getInt(t++));
				
				telefonosRetirados.add(telefono);
			}
		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de listaTelefonosRetirados Clase TelefonoDAO método listaTelefonosRetirados"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... telefonos,cargue "
							+ "descripción de evento... lista listaTelefonosRetirados" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de listaTelefonosRetirados ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de listaTelefonosRetirados Clase TelefonoDAO método listaTelefonosRetirados"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... telefonos,cargue  "
					+ "descripción de evento... lista listaTelefonosRetirados" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de listaTelefonosRetirados ");
		} finally {
			closeConexion();
			logger.info("finalizo dao listaTelefonosRetirados!");
		}
		return telefonosRetirados;
	}
	

}
