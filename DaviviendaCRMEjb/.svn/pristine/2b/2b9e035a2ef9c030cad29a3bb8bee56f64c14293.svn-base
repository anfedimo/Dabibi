package co.sistemcobro.davivienda.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Ciudad;

public class CiudadDAO extends BaseDAO {

	public CiudadDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(CiudadDAO.class);

	private String SQL_BUSCAR_Ciudad = " select c.id as id, "
			+ "(cast(c.id as nvarchar) + ' | ' + c.codigo) as nombre  "
			+ " from davivienda.ciudad c WITH (NOLOCK) where c.departamento = ? "
			+ " and c.estado = 1 ";
	

	public List<Ciudad> buscarCiudadespordepartamento(String departamento) throws Exception {

		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_Ciudad);
			ps.setString(1, departamento);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Ciudad ciudad = new Ciudad();
				ciudad.setIdciudad(rs.getInt(t++));
				ciudad.setNombre_ciudad(rs.getString(t++));
				ciudades.add(ciudad);

			}
		
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  las ciudades ", e);
			throw new Exception("Error SQL al tratar de leer  las ciudades ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  ciudades ", e);
			throw new Exception("Error al tratar de leer las ciudades : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao ciudades !");

		}
		return ciudades;
	}

}
