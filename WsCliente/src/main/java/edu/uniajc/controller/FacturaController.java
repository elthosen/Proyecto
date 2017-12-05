package edu.uniajc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.uniajc.businessDelegate.IBusinessDelegator;
import edu.uniajc.dto.DetalleFacturaDTO;
import edu.uniajc.dto.FacturaDTO;
import edu.uniajc.mapper.IFacturaMapper;
import edu.uniajc.model.DetalleFactura;
import edu.uniajc.model.Factura;
import edu.uniajc.model.Producto;

@RestController
@RequestMapping
public class FacturaController {

	private static final Logger log = LoggerFactory.getLogger(FacturaController.class);
/*
	@Autowired
	private IBusinessDelegator businessDelegator;

	@Autowired
	private IFacturaMapper facturaMapper;

	private List<DetalleFacturaDTO> listaDetalle = new ArrayList<>();

	@DeleteMapping(value = "/detaFacturas/parametro/{id}")
	public void deleteDetaFacturas(@PathVariable("id") Integer identificador) throws Exception {
		try {
			for (int i = 0; i < listaDetalle.size(); i++) {
				if (i == identificador) {
					listaDetalle.remove(i);
				}
			}
			// Se obtiene el tamaño del array despues de borrar
			int[] contador = new int[listaDetalle.size()];
			for (int j = 0; j < contador.length; j++) {
				// Si es un array de 7 numeros y se borra el 5 vuelve y asigna los indices al
				// array
				listaDetalle.get(j).setIdentificador(j);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping(value = "/detaFacturas/parametro")
	public void AddDetaFactura(@RequestBody DetalleFacturaDTO entityDTO) throws Exception {

		try {
			Producto entityProducto = businessDelegator.getProductoById(entityDTO.getProducto().getCodigo());
			
			listaDetalle.add(new DetalleFacturaDTO(listaDetalle.size()));
			entityDTO.setIdentificador(listaDetalle.size()-1);
			entityDTO.setProducto(entityProducto);
			listaDetalle.set(listaDetalle.size()-1, entityDTO);	
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping(value = "/facturas")
	public void save(@RequestBody FacturaDTO entityDTO) throws Exception {

		List<DetalleFactura> entityDetaFac = new ArrayList<>();
		try {
			Factura entity = facturaMapper.facturaDTOToFactura(entityDTO);
			Factura entityFinal = businessDelegator.save(entity);
			for (int i = 0; i < listaDetalle.size(); i++) {
				listaDetalle.get(i).setFactura(entityFinal);				
			}
			
			
			for (DetalleFacturaDTO entityDTOTemp : listaDetalle) {
				DetalleFactura entityTemp2 = facturaMapper.detalleFacturaDTOToDetalleFactura(entityDTOTemp);
				entityDetaFac.add(entityTemp2);
			}
			businessDelegator.saveDetaFact(entityDetaFac);
			listaDetalle.clear();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@GetMapping(value = "/facturas/{id}")
	public FacturaDTO getFacturaById(@PathVariable("id") Integer id) throws Exception {
		try {
			Factura entity = businessDelegator.getFacturaById(id);

			FacturaDTO entityDTO = facturaMapper.facturaToFacturaDTO(entity);

			return entityDTO;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@GetMapping(value = "/facturas")
	public List<FacturaDTO> getDataAll() throws Exception {
		try {
			return businessDelegator.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@PutMapping(value = "/facturas")
	public void update(@RequestBody FacturaDTO entityDTO) throws Exception {
		try {
			Factura entity = facturaMapper.facturaDTOToFactura(entityDTO);

			businessDelegator.update(entity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@DeleteMapping(value = "/facturas/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		try {
			Factura entity = businessDelegator.getFacturaById(id);
			businessDelegator.delete(entity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@GetMapping(value = "/detaFacturas/parametro/{id}")
	public List<DetalleFacturaDTO> getDataAllDetaFac(@PathVariable("id") Integer id) throws Exception {
		try {
			return businessDelegator.finAllByIdDetaFact(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}*/
}
