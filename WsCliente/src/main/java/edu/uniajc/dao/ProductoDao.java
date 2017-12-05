package edu.uniajc.dao;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.uniajc.dataaccess.api.HibernateDaoImpl;
import edu.uniajc.model.Cliente;
import edu.uniajc.model.Producto;

@Repository("ProductoDao")
@Scope("singleton")
public class ProductoDao extends HibernateDaoImpl<Producto, Integer> implements IProductoDao  {

	private static final Logger log = LoggerFactory.getLogger(ProductoDao.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IProductoDao getFromApplicationContext(ApplicationContext ctx) {
        return (IProductoDao) ctx.getBean("ProductoDao");    }

}
