package edu.uniajc.logic;

import java.math.BigInteger;
import java.util.ArrayList;
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
import edu.uniajc.dto.ClienteDTO;
import edu.uniajc.exceptions.ZMessManager;
import edu.uniajc.exceptions.ZMessManager.NullEntityExcepcion;
import edu.uniajc.mapper.IClienteMapper;
import edu.uniajc.model.Cliente;


@Service
@Scope("singleton")
public class ClienteLogic implements IClienteLogic {

private static final Logger log = LoggerFactory.getLogger(ClienteLogic.class);
	
	@Autowired
	private IClienteMapper clienteMapper;
		
	@Autowired
	private IClienteDao clienteDao;
		
	@Autowired
	private Validator validator;
	
	public void validateCliente(Cliente entity) throws Exception{
		try {
			Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(entity);
			if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Cliente> constraintViolation : constraintViolations) {
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
	public Cliente getClienteById(Integer id) throws Exception {
		try {
			Cliente entity = clienteDao.findById(id);
				
			return entity;
		} catch (Exception e) {
			log.error("save Cliente failed", e);
            throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<ClienteDTO> findAll() throws Exception {
		List<Cliente> entity = clienteDao.findAll();

		List<ClienteDTO> entityDTO = new ArrayList<>();

		for (Cliente entityTemp : entity) {
			ClienteDTO entityDTO2 = clienteMapper.clienteToClienteDTO(entityTemp);
			entityDTO.add(entityDTO2);
		}
		return entityDTO;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int save(Cliente entity) throws Exception {
		log.debug("saving Cliente instance");
		try {
			if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Factura");
            }
			
			validateCliente(entity);
			return clienteDao.saveCliente(entity);
		} catch (Exception e) {
			log.error("save Cliente failed", e);
            throw e;
		}
		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(Cliente entity) throws Exception {
		log.debug("update Cliente instance");
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Cliente");
			}

			validateCliente(entity);
			clienteDao.saveOrUpdate(entity, true);

			log.debug("update Cliente successful");
		} catch (Exception e) {
			log.error("update Cliente failed", e);
			throw e;
		} finally {
		}		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Cliente entity) throws Exception {
		log.debug("delete Cliente instance");
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Cliente");
			}

			validateCliente(entity);

			clienteDao.delete(clienteDao.merge(entity));

			log.debug("update Factura successful");
		} catch (Exception e) {
			log.error("update Factura failed", e);
			throw e;
		} finally {
		}
	}

	}
