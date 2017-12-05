package edu.uniajc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.uniajc.businessDelegate.IBusinessDelegator;
import edu.uniajc.dto.ClienteDTO;
import edu.uniajc.model.Cliente;
import edu.uniajc.model.Factura;
import edu.uniajc.model.Tercero;

@Component
@Scope("singleton")
public class ClienteMapper implements IClienteMapper {

	@Autowired
	private IBusinessDelegator businessDelegator;

	@Transactional(readOnly = true)
	public ClienteDTO clienteToClienteDTO(Cliente entity) throws Exception {
		try {

			ClienteDTO entityDTO = new ClienteDTO();

			entityDTO.setCodigo(entity.getCodigo());
			entityDTO.setNombre(entity.getNombre());
			entityDTO.setApellido(entity.getApellido());
			entityDTO.setDireccion(entity.getDireccion());
			entityDTO.setEmail(entity.getEmail());

			return entityDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Cliente clienteDTOToCliente(ClienteDTO entityDTO) throws Exception {
		try {
			Cliente entity = new Cliente();

			entity.setCodigo(entityDTO.getCodigo());
			entityDTO.setNombre(entity.getNombre());
			entityDTO.setApellido(entity.getApellido());
			entityDTO.setDireccion(entity.getDireccion());
			entityDTO.setEmail(entity.getEmail());

			return entity;
		} catch (Exception e) {
			throw e;
		}
	}

}
