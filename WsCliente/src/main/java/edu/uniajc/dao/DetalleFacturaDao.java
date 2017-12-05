package edu.uniajc.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.uniajc.dataaccess.api.HibernateDaoImpl;
import edu.uniajc.model.DetalleFactura;

@Repository("DetalleFacturaDao")
@Scope("singleton")
public class DetalleFacturaDao extends HibernateDaoImpl<DetalleFactura, Integer> implements IDetalleFacturaDao  {

	private static final Logger log = LoggerFactory.getLogger(DetalleFacturaDao.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IFacturaDao getFromApplicationContext(ApplicationContext ctx) {
        return (IFacturaDao) ctx.getBean("FacturaDao");
    }
	
	@Override
	public void saveDetaFact(DetalleFactura entity) throws Exception {
		log.debug("saving DetalleFactura instance");
		try {
			String query = "INSERT INTO public.detalle_factura (id_producto, cantidad, precio_total, id_factura) "
					+ "VALUES(:id_producto, :cantidad, :precio_total, :id_factura)";
			Query q = (Query) sessionFactory.getCurrentSession().createSQLQuery(query);
			q.setParameter("id_producto", entity.getProducto().getCodigo());
			q.setParameter("cantidad", entity.getCantidad());
			q.setParameter("precio_total", entity.getPrecioTotal());
			q.setParameter("id_factura", entity.getFactura().getCodigo());
			q.executeUpdate();
		} catch (Exception e) {
			log.error("save DetalleFactura failed", e);
            throw e; 
		}
		
	}

	@Override
	public List<DetalleFactura> queryDetalleFactura(Integer id) throws Exception {
		log.debug("query DetalleFactura instance");
		try {
			String query = "FROM "+ DetalleFactura.class.getName() + " WHERE id_factura = :id";
			Query q = sessionFactory.getCurrentSession().createQuery(query);
			q.setParameter("id", id);
			List<DetalleFactura> entityList = q.list();
			
			return entityList;
		} catch (Exception e) {
			log.error("query DetalleFactura failed", e);
            throw e; 
		}
	}

	@Override
	public void deleteDetalleFactura(Integer id) throws Exception {
		log.debug("query DetalleFactura instance");
		try {
			String query = "DELETE FROM "+ DetalleFactura.class.getName() + " WHERE id_factura = :id";
			Query q = sessionFactory.getCurrentSession().createQuery(query);
			q.setParameter("id", id);
			q.executeUpdate();
			
		} catch (Exception e) {
			log.error("query DetalleFactura failed", e);
            throw e; 
		}
	}

}
