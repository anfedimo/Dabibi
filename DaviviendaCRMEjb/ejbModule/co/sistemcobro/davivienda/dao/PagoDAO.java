package co.sistemcobro.davivienda.dao;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Obligacion;

public class PagoDAO extends BaseDAO {

	public PagoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(PagoDAO.class);
	
	private String SQL_BUSCAR_PAGO = ""
			+ " select distinct  o.obligacion, fecha_pago fecha, valor_pago, (Select max(da.descripcion_del_pago) from davivienda.pago da  "
			+ " where da.id_cargue = (Select  max (da.id_cargue) from davivienda.pago da " 
			+ " left join davivienda.obligacion do on do.obligacion = da.obligacion "
			+ " where do.identificacion = o.identificacion)) descripcion_del_pago,  "
			+ " nombre_sucursal, (Select  max (da.id_cargue) from davivienda.pago da  "
			+ " left join davivienda.obligacion do on do.obligacion = da.obligacion "
			+ " where do.identificacion = o.identificacion) as id_cargue " 
			+ " from davivienda.pago p WITH (NOLOCK)  "
			+ " left join davivienda.obligacion o WITH (NOLOCK) on p.obligacion = o.obligacion  "
			+ " left join davivienda.cargue co WITH (NOLOCK) on co.id_cargue = o.id_cargue and co.estado = 2 " 
			+ " left join davivienda.cargue cp WITH (NOLOCK) on cp.id_cargue = p.id_cargue and cp.estado = 2 "  
			+ " left join davivienda.base b WITH (NOLOCK) on co.base = cp.base and co.base = b.id_base and b.estado = 2 " 
			+ " where o.identificacion = ? order by  fecha desc ";
			

	/**
	 * buscarPagoCliente. m�todo para buscar os pagos del cliente
	 * 
	 * @author Camilo Ochoa
	 * @param String identificacion (c�dula del cliente)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, est� vac�o o contiene s�lo espacios.
	 * @return List<Obligacion> lista de pagos
	 * @see N/A
	 */
	public List<Obligacion> buscarPagoCliente(String ididentificacion) throws Exception {
		ArrayList<Obligacion> pago = new ArrayList<Obligacion>();
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_PAGO);
			ps.setString(1, ididentificacion);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;

				Obligacion obligacion = new Obligacion();
				obligacion.setObligacion(rs.getString(t++));
				obligacion.setFechaPago(rs.getTimestamp(t++));
				obligacion.setValorPagado(rs.getString(t++));
				obligacion.setDescripcionPago(rs.getString(t++));
				obligacion.setNombreSucursal(rs.getString(t++));
				obligacion.setIdCargue(rs.getString(t++));
				pago.add(obligacion);
			}

		} catch (SQLException e) {
			logger.error(
					"SQLException Error SQL al tratar de buscarPagoCliente Clase TelefonoDAO m�todo buscarPagoCliente"
							+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
							+ " tabla afectada.... obligacion, cargue, base "
							+ "descripci�n de evento... lista buscarPagoCliente" + " ip..... "
							+ address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de buscarPagoCliente ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de buscarPagoCliente Clase TelefonoDAO m�todo buscarPagoCliente"
					+" "+e.getMessage() + " fecha...." + fecha + " id del registro.... " + Statement.RETURN_GENERATED_KEYS
					+ " tabla afectada.... obligacion, cargue, base "
					+ "descripci�n de evento... lista buscarPagoCliente" + " ip..... " + address.getHostAddress());
			throw new Exception("Exception al tratar de buscarPagoCliente ");
		} finally {
			closeConexion();
			logger.info("finalizo dao buscarPagoCliente!");
		}
		return pago;
	}
}
