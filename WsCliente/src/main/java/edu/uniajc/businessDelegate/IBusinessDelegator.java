package edu.uniajc.businessDelegate;

import java.util.List;

import edu.uniajc.dto.ClienteDTO;
import edu.uniajc.model.Cliente;

public interface IBusinessDelegator {

	public Cliente getClienteById(Integer id) throws Exception;
	public List<ClienteDTO> findAll() throws Exception;
	public int save(Cliente entity) throws Exception;
	public void update(Cliente entity) throws Exception;
	public void delete(Cliente entity) throws Exception;
	
}
