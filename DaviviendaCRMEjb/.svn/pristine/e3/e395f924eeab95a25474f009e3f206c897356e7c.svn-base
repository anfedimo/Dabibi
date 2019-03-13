package co.sistemcobro.davivienda.dao;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.HistoricoObligacion;

public class HistoricoObligacionDAO extends BaseDAO {
	
	public HistoricoObligacionDAO(DataSource ds) {
		super(ds);
	}
	
	private static Logger logger = Logger.getLogger(TipificacionDAO.class);
	
	private String SQL_HISTORICO_OBLIGACION = "select fechacrea, fechapromesa, valorpromesa, politica,"
			+ " estado, fullnamealtitude from davivienda.acuerdos_obligacion WITH (NOLOCK) "
			+ "where obligacion = ? order by fechacrea desc ";
	
	/**
	 * historicoObligacion. método para buscar el historico de obligaciones
	 * @author Camilo Ochoa
	 * @param String numeroObligacion (número de obligación)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return List<HistoricoObligacion> lista de historico de obligaciones
	 * @see N/A
	 */
	public List<HistoricoObligacion> historicoObligacion(String numeroObligacion) throws Exception {
		List<HistoricoObligacion> historicoObligaciones = new ArrayList<HistoricoObligacion>();
		HistoricoObligacion historico = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_HISTORICO_OBLIGACION, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, numeroObligacion);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				historico = new HistoricoObligacion();
				
				historico.setFechaCrea(rs.getTimestamp(t++));
				historico.setFechaPromesa(rs.getTimestamp(t++));
				historico.setValorPromesa(rs.getBigDecimal(t++));
				historico.setPolitica(rs.getString(t++));
				historico.setEstado(rs.getString(t++));
				historico.setFullNameAltitude(rs.getString(t++));
				
				historicoObligaciones.add(historico);
				
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de listar historicoObligacion Clase HistoricoObligacionDAO método historicoObligacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... acuerdos_obligacion"+"descripción de evento... lista historicoObligacion"+" ip..... "+address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de listar historicoObligacion ");
		} catch (Exception e) {
			logger.error("Exception al tratar de listar historicoObligacion Clase HistoricoObligacionDAO método historicoObligacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... acuerdos_obligacion"+"descripción de evento... lista historicoObligacion"+" ip..... "+address.getHostAddress());
			throw new Exception("Exception al tratar de listar historicoObligacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao historicoObligacion!");
		}
		return historicoObligaciones;
	}

}
