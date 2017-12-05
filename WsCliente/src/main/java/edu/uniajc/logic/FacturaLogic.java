package edu.uniajc.logic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import edu.uniajc.dao.IClienteDao;
import edu.uniajc.dao.IDetalleFacturaDao;
import edu.uniajc.dao.IFacturaDao;
import edu.uniajc.dao.IProductoDao;
import edu.uniajc.dao.ITerceroDao;
import edu.uniajc.dto.DetalleFacturaDTO;
import edu.uniajc.dto.FacturaDTO;
import edu.uniajc.exceptions.ZMessManager;
import edu.uniajc.mapper.IFacturaMapper;
import edu.uniajc.model.Cliente;
import edu.uniajc.model.DetalleFactura;
import edu.uniajc.model.Factura;
import edu.uniajc.model.Producto;
import edu.uniajc.model.Tercero;

@Service
@Scope("singleton")
public class FacturaLogic implements IFacturaLogic {

	private static final Logger log = LoggerFactory.getLogger(FacturaLogic.class);
	
	@Autowired
	private IFacturaMapper facturaMapper;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private ITerceroDao terceroDao;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IDetalleFacturaDao detalleFacturaDao;
	
	public void validateFactura(Factura entity) throws Exception{
		try {
			Set<ConstraintViolation<Factura>> constraintViolations = validator.validate(entity);
			if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Factura> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Factura getFacturaById(Integer id) throws Exception {
		try {
			Factura entity = facturaDao.findById(id);
				
			return entity;
		} catch (Exception e) {
			log.error("save Factura failed", e);
            throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<FacturaDTO> findAll() throws Exception {
		List<Factura> entity = facturaDao.findAll();

		List<FacturaDTO> entityDTO = new ArrayList<>();

		for (Factura entityTemp : entity) {
			FacturaDTO entityDTO2 = facturaMapper.facturaToFacturaDTO(entityTemp);
			entityDTO.add(entityDTO2);
		}
		return entityDTO;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Factura save(Factura entity) throws Exception {
		log.debug("saving Factura instance");
		try {
			if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Factura");
            }
			
			validateFactura(entity);
			return facturaDao.saveFactura(entity);
		} catch (Exception e) {
			log.error("save Factura failed", e);
            throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(Factura entity) throws Exception {
		log.debug("update Factura instance");
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Factura");
			}

			validateFactura(entity);
			facturaDao.saveOrUpdate(entity, true);

			log.debug("update Factura successful");
		} catch (Exception e) {
			log.error("update Factura failed", e);
			throw e;
		} finally {
		}		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Factura entity) throws Exception {
		log.debug("delete Factura instance");
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Factura");
			}

			validateFactura(entity);
			detalleFacturaDao.deleteDetalleFactura(entity.getCodigo());
			facturaDao.delete(facturaDao.merge(entity));

			log.debug("update Factura successful");
		} catch (Exception e) {
			log.error("update Factura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Cliente getClienteById(Integer id) throws Exception {
		try {
			Cliente entity = clienteDao.findById(id);
			
			return entity;
					
		} catch (Exception e) {
			log.error("save classParameters failed", e);
            throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Tercero getTerceroById(Integer id) throws Exception {
		try {
			Tercero entity = terceroDao.findById(id);
			return entity;
		} catch (Exception e) {
			log.error("save classParameters failed", e);
            throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Producto getProductoById(Integer id) throws Exception {
		try {
			Producto entity = productoDao.findById(id);
			return entity;
		} catch (Exception e) {
			log.error("save Producto failed", e);
            throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveDetafac(List<DetalleFactura> entityList) throws Exception {
		log.debug("saving DetalleFactura instance");
		double precioTotal;
		try {
			for (DetalleFactura detalleFactura : entityList) {
				precioTotal = (double) (detalleFactura.getCantidad() * detalleFactura.getProducto().getPrecio());
				detalleFactura.setPrecioTotal(precioTotal);
				System.out.println("Dato: " + detalleFactura.toString());
				detalleFacturaDao.saveDetaFact(detalleFactura);
			}
		} catch (Exception e) {
			log.error("save DetalleFactura failed", e);
            throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<DetalleFacturaDTO> finAllByIdDetaFact(Integer id) throws Exception {
		List<DetalleFactura> entity = detalleFacturaDao.queryDetalleFactura(id);

		List<DetalleFacturaDTO> entityDTO = new ArrayList<>();

		for (DetalleFactura entityTemp : entity) {
			DetalleFacturaDTO entityDTO2 = facturaMapper.detalleFacturaToDetalleFacturaDTO(entityTemp);
			entityDTO.add(entityDTO2);
		}
		return entityDTO;
	}

}
