package edu.uniajc.mapper;

import org.hibernate.jpa.internal.enhance.EnhancingClassTransformerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.uniajc.businessDelegate.IBusinessDelegator;
import edu.uniajc.dto.DetalleFacturaDTO;
import edu.uniajc.dto.FacturaDTO;
import edu.uniajc.model.Cliente;
import edu.uniajc.model.DetalleFactura;
import edu.uniajc.model.Factura;
import edu.uniajc.model.Tercero;

@Component
@Scope("singleton")
public class FacturaMapper implements IFacturaMapper{

	@Autowired
	private IBusinessDelegator businessDelegator;
	
	@Transactional(readOnly = true)
	public FacturaDTO facturaToFacturaDTO(Factura entity) throws Exception {
		try {
			
			FacturaDTO entityDTO = new FacturaDTO();
			
			entityDTO.setCodigo(entity.getCodigo());
			
			entityDTO.setFecha(entity.getFecha()!=null
					? entity.getFecha():null);
			
			if (entity.getCliente() != null) {
				entityDTO.setIdCliente(entity.getCliente().getCodigo());				
				entityDTO.setNombreCompletoCliente(entity.getCliente().getNombre() + " " + entity.getCliente().getApellido());
			}
			
			if (entity.getTercero()!=null) {
				entityDTO.setIdTercero(entity.getTercero().getCodigo());
				entityDTO.setNombreCompletoTercero(entity.getTercero().getNombre() + " " + entity.getTercero().getApellido());
			}
			
			return entityDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Factura facturaDTOToFactura(FacturaDTO entityDTO) throws Exception {
		try {			
			Factura entity = new Factura();
			
			entity.setCodigo(entityDTO.getCodigo());
			entity.setFecha(entityDTO.getFecha()!=null
					? entityDTO.getFecha():null);
			Cliente entityCliente = businessDelegator.getClienteById(entityDTO.getCliente().getCodigo());
			if (entityCliente != null) {
				entity.setCliente(entityCliente);
			}
			Tercero entityTercero = null;
			if (entityTercero != null) {
				entity.setTercero(entityTercero);
			}
			
			return entity;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DetalleFacturaDTO detalleFacturaToDetalleFacturaDTO(DetalleFactura entity) throws Exception {
		try {
			DetalleFacturaDTO entityDTO = new DetalleFacturaDTO();
			
			entityDTO.setCodigo(entity.getCodigo());
			entityDTO.setCantidad(entity.getCantidad()!=null
					? entity.getCantidad():null);
			if (entity.getFactura() != null) {
				entityDTO.setIdFactura(entity.getFactura().getCodigo());
			}
			
			if (entity.getProducto() != null) {
				entityDTO.setIdProducto(entity.getProducto().getCodigo());
				entityDTO.setDescProducto(entity.getProducto().getDescripcion());
			}
			entityDTO.setPrecioProducto(entity.getPrecioTotal()!=null
					? entity.getPrecioTotal():null);
			return entityDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DetalleFactura detalleFacturaDTOToDetalleFactura(DetalleFacturaDTO entityDTO) throws Exception {
		try {
			DetalleFactura entity = new DetalleFactura();
			
			entity.setCodigo(entityDTO.getCodigo());
			entity.setCantidad(entityDTO.getCantidad()!=null
					? entityDTO.getCantidad():null);
			entity.setFactura(entityDTO.getFactura()!=null
					? entityDTO.getFactura():null);
			entity.setProducto(entityDTO.getProducto()!=null
					? entityDTO.getProducto():null);
			return entity;
		} catch (Exception e) {
			throw e;
		}
	}

}
