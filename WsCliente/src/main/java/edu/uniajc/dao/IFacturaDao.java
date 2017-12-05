package edu.uniajc.dao;

import edu.uniajc.dataaccess.api.Dao;
import edu.uniajc.model.Factura;

public interface IFacturaDao extends Dao<Factura, Integer> {

	public Factura saveFactura(Factura entity) throws Exception;
}
