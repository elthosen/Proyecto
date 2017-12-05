package edu.uniajc.controller;
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
import edu.uniajc.dto.ClienteDTO;
import edu.uniajc.mapper.IClienteMapper;
import edu.uniajc.model.Cliente;



@RestController
@RequestMapping
public class ClienteController {
private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private IBusinessDelegator businessDelegator;
	
	@Autowired
	private IClienteMapper clienteMapper;
	
	@GetMapping(value = "/clientes")
	public List<ClienteDTO> getDataAll() throws Exception {
		try {
			return businessDelegator.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@PostMapping(value = "/clientes")
	public void save(@RequestBody ClienteDTO entityDTO) throws Exception {

		try {
			Cliente entity = clienteMapper.clienteDTOToCliente(entityDTO);
			int id_cliente = businessDelegator.save(entity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@PutMapping(value = "/clientes")
	public void update(@RequestBody ClienteDTO entityDTO) throws Exception{
		try {
			Cliente entity = clienteMapper.clienteDTOToCliente(entityDTO);
			
			businessDelegator.update(entity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@DeleteMapping(value = "/clientes/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception{
		try {
			Cliente entity = businessDelegator.getClienteById(id);
			businessDelegator.delete(entity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            throw e;
		}
	}
	
	@GetMapping(value = "/clientes/{id}")
	public Cliente getClienteById(@PathVariable("id") Integer id) throws Exception{
		try {
			Cliente entity = businessDelegator.getClienteById(id);
			//FacturaDTO entityDTO = facturaMapper.facturaToFacturaDTO(entity);
			return entity;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            throw e;
		}
	}

}
