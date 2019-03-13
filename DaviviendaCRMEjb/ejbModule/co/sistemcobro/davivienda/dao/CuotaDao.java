package co.sistemcobro.davivienda.dao;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Cuota;
import co.sistemcobro.davivienda.bean.DatosAdicionales;

public class CuotaDao extends BaseDAO {

	public CuotaDao(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(CuotaDao.class);

	private String SQL_INSERTAR_CUOTA = "insert into publicar.cuota (idgestion, numero, monto, fechavencimiento, idusuariocrea, fechacrea, estado) values (?, ?,?,?,?, getdate() ,2)";

	public DatosAdicionales insertarcuotas(Cuota cuota) throws Exception {
		int total = 0;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_INSERTAR_CUOTA);
			ps.setInt(1, cuota.getIdgestion());
			ps.setInt(2, cuota.getNumeroCuota());
			ps.setBigDecimal(3, cuota.getValor());
			ps.setTimestamp(4, new Timestamp(cuota.getFechaCuota().getTime()));
			ps.setInt(5, cuota.getIdusuariocrea());
			total = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("Error SQL insertando las cuotas", e);
			throw new Exception("Error SQL insertando las cuotas", e);
		} catch (Exception e) {
			logger.error("Error insetrtando las cuotas", e);
			throw new Exception("Error insertando datos adicionales : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao insertar cuotas ! Inserto :" + total);
		}
		return null;

	}

}
