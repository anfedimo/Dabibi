package co.sistemcobro.davivienda.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.DatosAdicionales;
import co.sistemcobro.davivienda.bean.InformacionComplementaria;

public class DatosAdicionalesDAO extends BaseDAO {

	public DatosAdicionalesDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(DatosAdicionalesDAO.class);

	// Consulta que inserta los Datos Adicionales

	private String SQL_INSERTAR_DATOS = ""
			+ "INSERT INTO davivienda.contacto_adicional ([idcontactotipo] ,[cedula],[valor],[observacion] ,[idusuariocrea],[fechacrea] ,[estado]) "
			+ "	VALUES (?,?,?,?,?,getdate(),?)";
		

	public DatosAdicionales insertarDatosAdicionales(DatosAdicionales DatosAdicionales, Integer idcontactotipo)
			throws Exception {
		int total = 0;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_INSERTAR_DATOS);
			ps.setInt(1, idcontactotipo);
			ps.setString(2, DatosAdicionales.getIdentificacion());
			switch (idcontactotipo) {
			case 20:
				ps.setString(3, DatosAdicionales.getNombre());
				break;
			case 22:
				ps.setString(3, DatosAdicionales.getIdDepartamento());
				break;
			case 17:
				ps.setString(3, DatosAdicionales.getIdCiudad());
				break;
			case 19:
				ps.setString(3, DatosAdicionales.getTelefono1());
				break;
			case 11:
				ps.setString(3, DatosAdicionales.getTelefono2());
				break;
			case 12:
				ps.setString(3, DatosAdicionales.getTelefono3());
				break;
			case 13:
				ps.setString(3, DatosAdicionales.getTelefono4());
				break;
			case 4:
				ps.setString(3, DatosAdicionales.getEmail());
				break;
			case 21:
				ps.setString(3, DatosAdicionales.getDatosAdicionales());
				break;
			default:
				logger.info("");

			}

			ps.setString(4, DatosAdicionales.getObservacion());
			ps.setString(5, DatosAdicionales.getUsuarioAplicacion().getIdusuario());
			ps.setInt(6, 2);
			
			total = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("Error SQL insertando los datos Adicionales ", e);
			throw new Exception("Error SQL insertando los datos Adicionales ", e);
		} catch (Exception e) {
			logger.error("Error insetrtando los datos adicionales ", e);
			throw new Exception("Error insertando datos adicionales : ", e);
		} finally {
			closeConexion();

			logger.info("finalizo dao insertar Datos Adicionales ! Inserto :" + total);

		}
		return null;

	}

	// Trae los datos de la consulta de la tabla Teléfonos

	private String SQL_BUSCAR_INFORMACION_COMPLEMENTARIA = ""
			+ "SELECT t.identificacion,t.telefono , 'telefono' as Tipo_dato "
			+ "	FROM davivienda.telefono_adicional t WITH (NOLOCK) "
			+ "	INNER JOIN davivienda.cargue c WITH (NOLOCK) ON c.id_cargue=t.id_cargue "
			+ "	INNER JOIN davivienda.base b WITH (NOLOCK) ON b.id_base=c.base " + "	WHERE c.estado = 2 "
			+ "	AND b.estado = 2 " + "	AND t.identificacion = ? ";

	public List<InformacionComplementaria> buscarInformacionComplentaria(String idcliente) throws Exception {

		ArrayList<InformacionComplementaria> ListinformacionComplementearia = new ArrayList<InformacionComplementaria>();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_INFORMACION_COMPLEMENTARIA);
			ps.setString(1, idcliente);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				InformacionComplementaria informacionComplementaria = new InformacionComplementaria();
				informacionComplementaria.setIdentificacion(rs.getString(t++));
				informacionComplementaria.setTelefono(rs.getString(t++));
				informacionComplementaria.setTipoDato1(rs.getString(t++));
				ListinformacionComplementearia.add(informacionComplementaria);

			}

		} catch (SQLException e) {
			logger.error("Error SQL al t ", e);
			throw new Exception("Error SQL al tratar informacion complementaria ", e);
		} catch (Exception e) {
			logger.error("Error al tratar informacion complementaria  ", e);
			throw new Exception("Error al tratar de mostrar tratar informacion complementaria  : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao informacion complementaria !");

		}

		return ListinformacionComplementearia;

	}

	// Trae los datos de la tabla Direcciones

	private String SQL_BUSCAR_INFORMACION_ADICIONAL = ""
			+ "SELECT d.identificacion,d.direccion , 'direccion' as direccion "
			+ "	FROM davivienda.direccion_adicional d WITH (NOLOCK) "
			+ "	INNER JOIN davivienda.cargue c WITH (NOLOCK) ON c.id_cargue=d.id_cargue "
			+ "	INNER JOIN davivienda.base b WITH (NOLOCK) ON b.id_base=c.base " + "	WHERE c.estado = 2 "
			+ "	AND b.estado = 2 " + "	AND d.identificacion = ? ";

	public List<InformacionComplementaria> buscarInformacionComplentaria2(String idcliente) throws Exception {

		ArrayList<InformacionComplementaria> ListinformacionComplementearia = new ArrayList<InformacionComplementaria>();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_INFORMACION_ADICIONAL);
			ps.setString(1, idcliente);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				InformacionComplementaria informacionComplementaria = new InformacionComplementaria();
				informacionComplementaria.setIdentificacion(rs.getString(t++));
				informacionComplementaria.setDireccion(rs.getString(t++));
				informacionComplementaria.setTipoDato2(rs.getString(t++));
				ListinformacionComplementearia.add(informacionComplementaria);

			}

		} catch (SQLException e) {
			logger.error("Error SQL al t ", e);
			throw new Exception("Error SQL al tratar informacion complementaria ", e);
		} catch (Exception e) {
			logger.error("Error al tratar informacion complementaria  ", e);
			throw new Exception("Error al tratar de mostrar tratar informacion complementaria  : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao informacion complementaria !");

		}

		return ListinformacionComplementearia;

	}

	// Trae los datos de Consultar Datos Actualizados

	public List<DatosAdicionales> buscarDatosAdicionales(String valor) throws Exception {

		List<DatosAdicionales> adicionales = new ArrayList<>();
		try {
			con = ds.getConnection();

			StringBuffer sql = new StringBuffer();

			sql.append(" select top (50) " + "	    c.idcontactoadicional " + "	  , ct.nombre " + "	  , c.valor "
					+ "	  , c.observacion " + "	  , c.fechacrea " + "	 from davivienda.contacto_adicional c WITH (NOLOCK) "
					+ "	 inner join davivienda.contacto_tipo ct WITH (NOLOCK) on ct.idcontactotipo = c.idcontactotipo "
					+ "	 where  c.estado=2 and c.cedula= '" + valor + "'  or  c.valor like '%" + valor + "%' "
					+ " order by c.fechacrea desc ");

			ps = con.prepareStatement(sql.toString());

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				DatosAdicionales datoAdicional = new DatosAdicionales();
				datoAdicional.setContactoTipo(rs.getInt(t++));
				datoAdicional.setNombre(rs.getString(t++));
				datoAdicional.setValor(rs.getString(t++));
				datoAdicional.setObservacion(rs.getString(t++));
				datoAdicional.setFechaCrea(rs.getString(t));
				adicionales.add(datoAdicional);

			}

		} catch (SQLException e) {
			logger.error("Error SQL al tratar de mostrar los datos Adicionales ", e);
			throw new Exception("Error SQL al tratar de mostrar los datos Adicionales ", e);
		} catch (Exception e) {
			logger.error("Error al tratar demostrar los datos Adicionales ", e);
			throw new Exception("Error al tratar de mostrar los datos Adicionales : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao DatosAdicionales !");

		}

		return adicionales;

	}

}
