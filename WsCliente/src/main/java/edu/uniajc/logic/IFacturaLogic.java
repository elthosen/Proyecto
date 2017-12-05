package edu.uniajc.logic;

import java.util.List;

import edu.uniajc.model.Cliente;
import edu.uniajc.model.DetalleFactura;
import edu.uniajc.model.Factura;
import edu.uniajc.model.Producto;
import edu.uniajc.model.Tercero;
import edu.uniajc.dto.DetalleFacturaDTO;
import edu.uniajc.dto.FacturaDTO;

public interface IFacturaLogic {

	public Factura getFacturaById(Integer id) throws Exception;
	public List<FacturaDTO> findAll() throws Exception;
	public Factura save(Factura entity) throws Exception;
	public void update(Factura entity) throws Exception;
	public void delete(Factura entity) throws Exception;
	public Cliente getClienteById(Integer id) throws Exception;
	public Tercero getTerceroById(Integer id) throws Exception;
	public Producto getProductoById(Integer id) throws Exception;
	public void saveDetafac(List<DetalleFactura> entityList) throws Exception;
	public List<DetalleFacturaDTO> finAllByIdDetaFact(Integer id) throws Exception;
	
}
