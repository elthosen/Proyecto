package edu.uniajc.mapper;

import edu.uniajc.model.DetalleFactura;
import edu.uniajc.model.Factura;
import edu.uniajc.dto.DetalleFacturaDTO;
import edu.uniajc.dto.FacturaDTO;

public interface IFacturaMapper {

	public FacturaDTO facturaToFacturaDTO(Factura entity) throws Exception;
	public Factura facturaDTOToFactura(FacturaDTO entityDTO) throws Exception;
	public DetalleFacturaDTO detalleFacturaToDetalleFacturaDTO(DetalleFactura entity) throws Exception;
	public DetalleFactura detalleFacturaDTOToDetalleFactura(DetalleFacturaDTO entityDTO) throws Exception;
}
