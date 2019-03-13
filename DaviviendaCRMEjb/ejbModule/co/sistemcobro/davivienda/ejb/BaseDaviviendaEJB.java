package co.sistemcobro.davivienda.ejb;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 
 * @author Fabio Alexander Orjuela Diaz
 * 
 */

public class BaseDaviviendaEJB {

	@Resource(mappedName = "dc_davivienda")
	protected DataSource dc_davivienda;

	@Resource(mappedName = "dg_davivienda")
	protected DataSource dg_davivienda;

	@Resource(mappedName = "dc_altitude")
	protected DataSource dc_altitude;

	@Resource(mappedName = "dg_altitude")
	protected DataSource dg_altitude;

	@Resource(mappedName = "dc_hermes")
	protected DataSource dc_hermes;

	@Resource(mappedName = "dg_hermes")
	protected DataSource dg_hermes;
	
}
