package edu.uniajc.dao;

import java.util.ArrayList;

import edu.uniajc.dataaccess.api.Dao;
import edu.uniajc.model.Cliente;

public interface IClienteDao extends Dao<Cliente, Integer> {
	
	public int saveCliente(Cliente entity) throws Exception;
	public Cliente searchCliente(Cliente entity) throws Exception;
	public ArrayList<Cliente> allCliente() throws Exception;

}
