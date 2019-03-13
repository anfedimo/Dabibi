package co.sistemcobro.davivienda.dao;

import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Dolar;

public class DolarDAO extends BaseDAO{
	
	public DolarDAO(DataSource ds) {
		super(ds);
	}
	
	private static Logger logger = Logger.getLogger(DolarDAO.class);

	private String SQL_DOLAR = "select top 1 "
			+ " valorDolar from davivienda.dolarHistorico WITH (NOLOCK) order by idDolar desc ";
	
	/**
	 * consultarDolar. método para buscar los dólares
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return objeto tipo Dolar 
	 * @see N/A
	 */
	public Dolar consultarDolar() throws Exception{
		Dolar dolar = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_DOLAR);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				dolar = new Dolar();
				
				dolar.setValor(rs.getBigDecimal(t++));
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarDolar Clase DolarDAO método consultarDolar"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... dolarHistorico "+"descripción de evento... objeto consultarDolar"+" ip..... "+address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarDolar ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultarDolar Clase DolarDAO método consultarDolar"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... dolarHistorico "+"descripción de evento... objeto consultarDolar"+" ip..... "+address.getHostAddress());
			throw new Exception("Exception al tratar de consultarDolar ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarDolar");
		}
		return dolar;
	}

}
