package edu.uniajc.dao;

import java.util.List;

import edu.uniajc.dataaccess.api.Dao;
import edu.uniajc.model.DetalleFactura;

public interface IDetalleFacturaDao extends Dao<DetalleFactura, Integer> {

	public void saveDetaFact(DetalleFactura entityList) throws Exception;

	public List<DetalleFactura> queryDetalleFactura(Integer id) throws Exception;
	
	public void deleteDetalleFactura(Integer id) throws Exception;
}
