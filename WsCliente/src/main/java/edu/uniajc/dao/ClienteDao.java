package edu.uniajc.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.uniajc.dataaccess.api.HibernateDaoImpl;
import edu.uniajc.model.Cliente;

@Repository("FacturaDao")
@Scope("singleton")
public class ClienteDao extends HibernateDaoImpl<Cliente, Integer> implements IClienteDao {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteDao.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IClienteDao getFromApplicationContext(ApplicationContext ctx) {
        return (IClienteDao) ctx.getBean("ClienteDao");
    }
	
	@Override
	public int saveCliente(Cliente entity) throws Exception {
		log.debug("saving Cliente instance");
		try {
			String query = "INSERT INTO cliente(nombre, apellido, direccion, email) "
					+ "VALUES(:nombre, :apellido, :direccion, :email)";
			Query q = (Query) sessionFactory.getCurrentSession().createSQLQuery(query);
			q.setParameter("nombre", entity.getNombre());
			q.setParameter("apellido", entity.getApellido());
			q.setParameter("direccion", entity.getDireccion());
			q.setParameter("email", entity.getEmail());
			q.executeUpdate();
			String querySecuencia = "select currval('cliente_codigo_seq')";
			Query qSecuen = (Query) sessionFactory.getCurrentSession().createSQLQuery(querySecuencia);
			BigInteger valor = (BigInteger) qSecuen.uniqueResult();
			return valor.intValue();
		} catch (Exception e) {
			log.error("save Cliente failed", e);
            throw e; 
		}
		
	}
	
	@Override
	public Cliente searchCliente(Cliente entity) throws Exception {
		log.debug("searching Cliente instance");
		Cliente cliente = new Cliente();
		try {
			String query = "SELECT codigo, nombre, apellido, direccion, email FROM cliente "
					+ "WHERE codigo= :cod";
			Query q = (Query) sessionFactory.getCurrentSession().createSQLQuery(query);
			q.setParameter("cod", entity.getCodigo());
			//q.setInteger("cod", entity.getCodigo());
			//q.list();
			cliente = (Cliente) q.uniqueResult();
			return cliente;
			
		} catch (Exception e) {
			log.error("save Factura failed", e);
			throw e; 
		}
	}
		
		@Override
		public ArrayList<Cliente> allCliente() throws Exception {
			log.debug("searching Cliente instance");
			try {
				ArrayList<Cliente> list;
				String query = "SELECT codigo, nombre, apellido, direccion, email FROM cliente ";
						
				Query q = (Query) sessionFactory.getCurrentSession().createSQLQuery(query);
				
				q.executeUpdate();
				list=(ArrayList<Cliente>)q.list();
				return list;
			} catch (Exception e) {
				log.error("save Factura failed", e);
	            throw e; 
			}
	}
}
