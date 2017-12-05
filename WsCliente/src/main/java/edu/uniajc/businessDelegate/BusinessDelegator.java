package edu.uniajc.businessDelegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uniajc.dto.ClienteDTO;
import edu.uniajc.logic.ClienteLogic;
import edu.uniajc.model.Cliente;

@Component
@Scope("singleton")
public class BusinessDelegator implements IBusinessDelegator {

	@Autowired
	private ClienteLogic clienteLogic;
	
	@Override
	public Cliente getClienteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteLogic.getClienteById(id);
	}

	@Override
	public List<ClienteDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteLogic.findAll();
	}

	@Override
	public int save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteLogic.save(entity);
	}

	@Override
	public void update(Cliente entity) throws Exception {
		clienteLogic.update(entity);
		
	}

	@Override
	public void delete(Cliente entity) throws Exception {
		clienteLogic.delete(entity);
		
	}

	
}
