package edu.uniajc.dao;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.uniajc.dataaccess.api.HibernateDaoImpl;
import edu.uniajc.model.Tercero;

@Repository("TerceroDao")
@Scope("singleton")
public class TerceroDao extends HibernateDaoImpl<Tercero, Integer> implements ITerceroDao  {

	private static final Logger log = LoggerFactory.getLogger(TerceroDao.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ITerceroDao getFromApplicationContext(ApplicationContext ctx) {
        return (ITerceroDao) ctx.getBean("TerceroDao");    }

}
