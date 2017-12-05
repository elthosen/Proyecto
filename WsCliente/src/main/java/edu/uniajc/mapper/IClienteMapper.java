package edu.uniajc.mapper;

import edu.uniajc.model.Cliente;
import edu.uniajc.dto.ClienteDTO;

public interface IClienteMapper {
	
	public ClienteDTO clienteToClienteDTO(Cliente entity) throws Exception;
	public Cliente clienteDTOToCliente(ClienteDTO entityDTO) throws Exception;

}
