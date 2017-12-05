package edu.uniajc.dao;

import java.math.BigInteger;
import java.sql.ResultSet;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.uniajc.dataaccess.api.HibernateDaoImpl;
import edu.uniajc.model.Factura;

@Repository("FacturaDao")
@Scope("singleton")
public class FacturaDao extends HibernateDaoImpl<Factura, Integer> implements IFacturaDao  {

	private static final Logger log = LoggerFactory.getLogger(FacturaDao.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IFacturaDao getFromApplicationContext(ApplicationContext ctx) {
        return (IFacturaDao) ctx.getBean("FacturaDao");
    }
	
	@Override
	public Factura saveFactura(Factura entity) throws Exception {
		log.debug("saving Factura instance");
		try {
			String query = "INSERT INTO factura(fecha, id_tercero, id_cliente) "
					+ "VALUES(:fecha, :id_tercero, :id_cliente)";
			Query q = (Query) sessionFactory.getCurrentSession().createSQLQuery(query);
			q.setParameter("fecha", entity.getFecha());
			q.setParameter("id_tercero", entity.getTercero().getCodigo());
			q.setParameter("id_cliente", entity.getCliente().getCodigo());
			q.executeUpdate();
			String querySecuencia = "select currval('factura_codigo_seq')";
			Query qSecuen = (Query) sessionFactory.getCurrentSession().createSQLQuery(querySecuencia);
			BigInteger valor = (BigInteger) qSecuen.uniqueResult();
			entity.setCodigo(valor.intValue());
			return entity;
		} catch (Exception e) {
			log.error("save Factura failed", e);
            throw e; 
		}
		
	}

}
