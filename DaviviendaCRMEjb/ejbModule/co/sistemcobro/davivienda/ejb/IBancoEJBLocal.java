package co.sistemcobro.davivienda.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.faces.model.SelectItem;

@Local
public interface IBancoEJBLocal {

	public List<SelectItem> buscarBancos() throws Exception;
}
