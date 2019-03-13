package co.sistemcobro.davivienda.dao;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import co.sistemcobro.davivienda.bean.Tipificacion;

import org.apache.log4j.Logger;

public class TipificacionDAO extends BaseDAO {

	public TipificacionDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(TipificacionDAO.class);


	/**
	 * obtenerTipificacion. método para buscar todas la tipificacion
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return Objeto tipo Tipificacion
	 * @see N/A
	 */
	private String SQL_TIPIFICACION = "select (cast(rte.nombre as nvarchar) + ' | ' + rte.id_tipo_resultado_estandar) as nombre "
			+ "from davivienda.resultado_tipo_estandar rte WITH (NOLOCK) " + " where rte.contacto = 'Sí' ";

	public Tipificacion obtenerTipificacion() throws Exception {

		Tipificacion tipificacion = new Tipificacion();
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TIPIFICACION);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				tipificacion = new Tipificacion();
				tipificacion.setNombre(rs.getString(t++));

			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de obtenerTipificacion Clase TipificacionDAO método obtenerTipificacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... resultado_tipo_estandar"+"descripción de evento... objeto obtenerTipificacion"+" ip..... "+address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de obtenerTipificacion ");
		} catch (Exception e) {
			logger.error("Exception al tratar de obtenerTipificacion Clase TipificacionDAO método obtenerTipificacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... resultado_tipo_estandar"+"descripción de evento... objeto obtenerTipificacion"+" ip..... "+address.getHostAddress());
			throw new Exception("Exception al tratar de obtenerTipificacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao obtenerTipificacion!");
		}
		return tipificacion;
	}

	private String SQL_TIPO_TIPIFICACION = " select id_tipo_resultado_estandar as idtipificacion, "
			+ " (cast(id_tipo_resultado_estandar as nvarchar) + ' | ' + nombre) as nombre, 2 estado "
			+ " from  davivienda.resultado_tipo_estandar WITH (NOLOCK) ";
	// + " where id_tipo_resultado_estandar = ? ";
	
	/**
	 * obtenerTipoTipificacion. método para buscar los tipos de tipificaciones
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<Tipificacion> tipos de tipificación
	 * @see N/A
	 */
	public List<Tipificacion> obtenerTipoTipificacion() throws Exception {

		Tipificacion tipificacion = new Tipificacion();
		List<Tipificacion> tipificaciones = new ArrayList<>();
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TIPO_TIPIFICACION);

			// ps.setString(1, tipo);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				tipificacion = new Tipificacion();
				tipificacion.setIdTipificacionTipo(rs.getString(t++));
				tipificacion.setNombreTipificacion(rs.getString(t++));
				tipificacion.setEstado(rs.getInt(t++));

				tipificaciones.add(tipificacion);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de obtenerTipoTipificacion Clase TipificacionDAO método obtenerTipoTipificacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... resultado_tipo_estandar"+"descripción de evento... lista obtenerTipoTipificacion"+" ip..... "+address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de obtenerTipoTipificacion  ");
		} catch (Exception e) {
			logger.error("Exception al tratar de obtenerTipificacion Clase TipificacionDAO método obtenerTipoTipificacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... resultado_tipo_estandar"+"descripción de evento... lista obtenerTipoTipificacion"+" ip..... "+address.getHostAddress());
			throw new Exception("Exception al tratar de obtenerTipoTipificacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao obtenerTipoTipificacion!");
		}
		return tipificaciones;
	}

}
