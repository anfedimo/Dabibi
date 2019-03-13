package co.sistemcobro.davivienda.dao;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import co.sistemcobro.davivienda.bean.Rediferido;
import co.sistemcobro.davivienda.bean.TasaRediferido;

public class RediferidoDAO extends BaseDAO {

	public RediferidoDAO(DataSource ds) {
		super(ds);
	}
	
	private static Logger logger = Logger.getLogger(RediferidoDAO.class);
	
	private String SQL_REDIFERIDO_POR_OBLIGACION = " select rediferido, saldo_dolares,  saldo_total, id_rediferido, "
			+ " rediferido_especial, opciones_de_rediferido, pago_minimo_inicial, pago_min_dolares ,saldo_mora_dolares"
			+ " from davivienda.obligacion_detalle_hoy WITH (NOLOCK) where obligacion = ? ";
	
	
	/**
	 * consultarRediferidoPorObligacion. método para buscar rediferidos por obligación
	 * @author Camilo Ochoa
	 * @param BigDecimal numeroObligacion (número de obligación)
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return objeto tipo Rediferido 
	 * @see N/A
	 */
	public Rediferido consultarRediferidoPorObligacion(BigDecimal numeroObligacion) throws Exception{
		Rediferido rediferido = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_REDIFERIDO_POR_OBLIGACION);
			ps.setBigDecimal(1, numeroObligacion);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				rediferido = new Rediferido();
				rediferido.setRediferido(rs.getBigDecimal(t++));
				rediferido.setSaldoDolares(rs.getBigDecimal(t++));
				rediferido.setSaldoTotal(rs.getBigDecimal(t++));
				rediferido.setIdRediferido(rs.getBigDecimal(t++));
				rediferido.setRediferidoEspecial(rs.getString(t++));
				rediferido.setOpcionesRediferido(rs.getString(t++));
				rediferido.setPagoMinimoInicial(rs.getBigDecimal(t++));
				rediferido.setPagoMinDolares(rs.getBigDecimal(t++));
				rediferido.setSaldoMoraDolares(rs.getBigDecimal(t++));
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarRediferidoPorObligacion Clase RediferidoDAO método consultarRediferidoPorObligacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion_detalle_hoy"+"descripción de evento... objeto consultarRediferidoPorObligacion"+" ip..... "+address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarRediferidoPorObligacion ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultarRediferidoPorObligacion Clase RediferidoDAO método consultarRediferidoPorObligacion"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion_detalle_hoy"+"descripción de evento... objeto consultarRediferidoPorObligacion"+" ip..... "+address.getHostAddress());
			throw new Exception("Exception al tratar de listar historicoObligacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao... consultarRediferidoPorObligacion");
		}
		return rediferido;
	}
	
	private String SQL_TASA_REDIFERIDO= "select t.valor,p.nombre from davivienda.tasa_por_politica t WITH (NOLOCK) "
			+ "	inner join davivienda.politica_cobro p WITH (NOLOCK) on t.id_politica = p.id_politica "
			+ " where p.nombre = 'Rediferido' ";
	
	/**
	 * consultarTasaRediferido. método para buscar las tasas de rediferidos
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws IllegalArgumentException
	 *             si se encuentra null, está vacío o contiene sólo espacios.
	 * @return objeto tipo TasaRediferido 
	 * @see N/A
	 */
	public TasaRediferido consultarTasaRediferido() throws Exception{
		TasaRediferido tasa = null;
		Date fecha = new Date();
		InetAddress address = InetAddress.getLocalHost();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TASA_REDIFERIDO);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				tasa = new TasaRediferido();
				
				tasa.setValor(rs.getDouble(t++));
				tasa.setNombre(rs.getString(t++));
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarTasaRediferido Clase RediferidoDAO método consultarTasaRediferido"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... politica_cobro,tasa_por_politica "+"descripción de evento... objeto consultarTasaRediferido"+" ip..... "+address.getHostAddress());
			throw new Exception("SQLException Error SQL al tratar de consultarTasaRediferido ");
		} catch (Exception e) {
			logger.error("Exception al tratar de de consultarRediferidoPorObligacion Clase RediferidoDAO método consultarTasaRediferido"
					+" fecha...."+fecha+" id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... politica_cobro,tasa_por_politica "+"descripción de evento... objeto consultarTasaRediferido"+" ip..... "+address.getHostAddress());
			throw new Exception("Exception al tratar de listar historicoObligacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao...consultarTasaRediferido");
		}
		return tasa;
	}
	
}
