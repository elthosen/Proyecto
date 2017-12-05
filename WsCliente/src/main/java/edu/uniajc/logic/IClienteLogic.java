package edu.uniajc.logic;

import java.util.List;

import edu.uniajc.model.Cliente;
import edu.uniajc.dto.ClienteDTO;


public interface IClienteLogic {
	
	public Cliente getClienteById(Integer id) throws Exception;
	public List<ClienteDTO> findAll() throws Exception;
	public int save(Cliente entity) throws Exception;
	public void update(Cliente entity) throws Exception;
	public void delete(Cliente entity) throws Exception;
	
}
