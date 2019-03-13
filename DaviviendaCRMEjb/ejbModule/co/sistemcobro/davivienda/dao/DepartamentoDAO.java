package co.sistemcobro.davivienda.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.davivienda.bean.Departamento;

public class DepartamentoDAO extends BaseDAO {

	public DepartamentoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(DepartamentoDAO.class);

	private String SQL_BUSCAR_Departamento = ""
			+ " select d.id as id, (cast(d.id as nvarchar) + ' | ' + d.codigo) as nombre "
			+ " from davivienda.departamento d WITH (NOLOCK) where d.estado = 1 order by d.codigo ";

	public List<Departamento> buscarDepartamentos() throws Exception {

		ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();

		try {
			con = ds.getConnection(); 
			ps = con.prepareStatement(SQL_BUSCAR_Departamento);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Departamento departamento = new Departamento();
				departamento.setId(rs.getInt(t++));
				departamento.setNombre(rs.getString(t++));				
				listaDepartamentos.add(departamento);
			}
		
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los departamentos ", e);
			throw new Exception("Error SQL al tratar de leer  los departamentos ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  departamentos ", e);
			throw new Exception("Error al tratar de leer los departamentos : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao departamentos !");

		}
		return listaDepartamentos;
	}

}
